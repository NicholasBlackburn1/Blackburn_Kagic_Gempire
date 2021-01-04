package mod.kagic.entity;

import mod.kagic.entity.ai.EntityAISlagEatGems;
import mod.kagic.entity.ai.EntityAISlagHateLight;
import mod.kagic.init.ModEntities;
import mod.kagic.init.ModSounds;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

//TODO: Need to make Texture Working on it && Grabbing pos of Mob
public class EntityCrystalShrimp extends EntityMob implements IMob {
    public int compatIndex = 0;
    public EntityCrystalShrimp(World worldIn) {
        
        super(worldIn);
       
        this.setSize(2.5F, 2.3F);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 0.6D));
        
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityGem>(this, EntityGem.class, true));
        this.compatIndex = worldIn.rand.nextInt(10);

        
    }
    
	
	
	@Override
	protected void updateAITasks() {
		super.updateAITasks();
		
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
	//TODO: add Advancement here
	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
		
				this.dropItem(Item.getItemById(3), (int) 0.0F);
		
		}
		super.onDeath(cause);
	}
	@Override
	public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
	
	}
	@Override
	public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		
	}
	@Override
	protected SoundEvent getAmbientSound() {
		return ModSounds.TONGUE_MONSTER_DEATH;
	}
}

