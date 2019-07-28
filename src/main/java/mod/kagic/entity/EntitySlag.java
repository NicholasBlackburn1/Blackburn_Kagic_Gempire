package mod.kagic.entity;

import mod.kagic.entity.ai.EntityAISlagEatGems;
import mod.kagic.entity.ai.EntityAISlagFuse;
import mod.kagic.entity.ai.EntityAISlagHateLight;
import mod.kagic.init.ModEntities;
import mod.kagic.init.ModItems;
import mod.kagic.init.ModSounds;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntitySlag extends EntityMob implements IMob {
	protected static final DataParameter<Integer> COUNT = EntityDataManager.<Integer>createKey(EntitySlag.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> VARIANT = EntityDataManager.<Integer>createKey(EntitySlag.class, DataSerializers.VARINT);
	private BossInfoServer healthBar = new BossInfoServer(new TextComponentTranslation("entity.kagic.slag.super"), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS);
	public int compatIndex = 0;
	public EntitySlag(World worldIn) {
		super(worldIn);
		this.setSize(0.4F, 0.3F);
		this.healthBar = new BossInfoServer(new TextComponentTranslation("entity.kagic.slag.super"), BossInfo.Color.values()[this.rand.nextInt(BossInfo.Color.values().length)], BossInfo.Overlay.PROGRESS);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAISlagFuse(this, 0.8F));
		this.tasks.addTask(2, new EntityAISlagHateLight(this, 1.2D, 8));
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(4, new EntityAISlagEatGems(this, 1.8D));
		this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 0.6D));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityGem>(this, EntityGem.class, true));
		this.dataManager.register(EntitySlag.COUNT, 1);
		this.dataManager.register(EntitySlag.VARIANT, 0);
		this.compatIndex = worldIn.rand.nextInt(4);
	}
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("count", this.dataManager.get(EntitySlag.COUNT));
		compound.setInteger("variant", this.dataManager.get(EntitySlag.VARIANT));
	}
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.dataManager.set(EntitySlag.VARIANT, compound.getInteger("variant"));
		this.setCount(compound.getInteger("count"));
	}
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		ChunkPos c = this.world.getChunkFromBlockCoords(this.getPosition()).getPos();
		this.setVariant(Math.abs((c.x + c.z) % ModEntities.MINERALS.size()));
		return super.onInitialSpawn(difficulty, livingdata);
	}
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.setSize(0.4F * this.getCount(), 0.3F * this.getCount());
	}
	@Override
	protected void updateAITasks() {
		super.updateAITasks();
		this.healthBar.setPercent(this.getHealth() / this.getMaxHealth());
	}
	public void setVariant(int variant) {
		this.dataManager.set(EntitySlag.VARIANT, variant);
	}
	public int getVariant() {
		return this.dataManager.get(EntitySlag.VARIANT);
	}
	public int getCount() {
		return this.dataManager.get(EntitySlag.COUNT);
	}
	public void setCount(int count) {
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D * count);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D * count);
		this.setSize(0.4F * count, 0.3F * count);
		this.dataManager.set(EntitySlag.COUNT, count);
	}
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}
	@Override
	public void fall(float distance, float damageMultiplier) {
		return;
	}
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (!this.world.isRemote && source == DamageSource.IN_WALL) {
			AxisAlignedBB bounds = this.getEntityBoundingBox();
			for (double x = bounds.minX; x < bounds.maxX; ++x) {
				for (double y = bounds.minY; y < bounds.maxY; ++y) {
					for (double z = bounds.minZ; z < bounds.maxZ; ++z) {
						if (this.world.getBlockState(new BlockPos(x, y, z)).getBlockHardness(this.world, new BlockPos(x, y, z)) > -1) {
							this.world.destroyBlock(new BlockPos(x, y, z), true);
						}
					}
				}
			}
			return false;
		}
		return super.attackEntityFrom(source, amount);
	}
	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			for (int i = 0; i < this.getCount(); ++i) {
				this.entityDropItem(new ItemStack(ModItems.ACTIVATED_GEM_SHARD), 0.0F);
			}
		}
		super.onDeath(cause);
	}
	@Override
	public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
		if (this.getCount() > 3) {
			this.healthBar.addPlayer(player);
		}
	}
	@Override
	public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		this.healthBar.removePlayer(player);
	}
	@Override
	protected SoundEvent getAmbientSound() {
		return ModSounds.SLAG_LIVING;
	}
	public boolean canFuse() {
		return this.getCount() < 10 && (this.getHealth() / this.getMaxHealth() <= 0.9 || this.getAttackTarget() != null || this.getRevengeTarget() != null);
	}
	public EntitySlag fuse(EntitySlag other) {
		int variant = 0;
		try {
			variant = Integer.parseInt(Integer.toString(this.getVariant()) + Integer.toString(other.getVariant()));
		} catch (Exception e) {
			return null;
		}
		EntitySlag newSlag = new EntitySlag(this.world);
		newSlag.setCount(this.getCount() + other.getCount());
		newSlag.setVariant(variant);
		newSlag.setHealth(newSlag.getMaxHealth());
		newSlag.setLocationAndAngles((this.posX + other.posX) / 2, (this.posY + other.posY) / 2, (this.posZ + other.posZ) / 2, (this.rotationYaw + other.rotationYaw) / 2, (this.rotationPitch + other.rotationPitch) / 2);
		return newSlag;
	}
}
