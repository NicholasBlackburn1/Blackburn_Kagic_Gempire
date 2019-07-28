package mod.kagic.entity.vehicles;

import mod.kagic.entity.EntityLaser;
import mod.kagic.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class EntityRoamingEye extends EntityLiving {
	private static final DataParameter<Boolean> HOVERING = EntityDataManager.<Boolean>createKey(EntityRoamingEye.class, DataSerializers.BOOLEAN);
	public EntityRoamingEye(World worldIn) {
		super(worldIn);
		this.setSize(4.0F, 6.0F);
		this.setEntityInvulnerable(true);
		this.setAlwaysRenderNameTag(false);
		this.isImmuneToFire = true;
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
		this.dataManager.register(EntityRoamingEye.HOVERING, false);
	}
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("hovering", this.isHovering());
	}
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.dataManager.set(EntityRoamingEye.HOVERING, compound.getBoolean("hovering"));
	}
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		if (!this.world.isRemote) {
			if (this.isBeingRidden() && this.getControllingPassenger() != null && this.getControllingPassenger().equals(player) && hand == EnumHand.MAIN_HAND) {
				this.toggleHovering();
				if (this.isHovering()) {
					player.sendMessage(new TextComponentTranslation("command.kagic.hovering"));
				} else {
					player.sendMessage(new TextComponentTranslation("command.kagic.not_hovering"));
				}
			} else if (!this.isBeingRidden() && player.getHeldItem(hand).getItem() == ModItems.GEM_STAFF) {
				this.dropItem(ModItems.ROAMING_EYE, 1);
				this.setDead();
			} else {
				player.rotationYaw = this.rotationYaw;
				player.rotationPitch = this.rotationPitch;
				player.startRiding(this);
			}
			return true;
		}
		return super.processInteract(player, hand);
	}
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (!this.world.isRemote && this.isBeingRidden() && source.getTrueSource() != null && source.getTrueSource().equals(this.getControllingPassenger())) {
			Entity passenger = source.getTrueSource();
			Vec3d vec3d = passenger.getLook(1.0F);
			double x = passenger.posX - (passenger.posX + vec3d.x * 1.711111111111D);
			double y = passenger.posY - (passenger.posY + vec3d.y * 1.711111111111D);
			double z = passenger.posZ - (passenger.posZ + vec3d.z * 1.711111111111D);
			EntityLaser laser = new EntityLaser(this.world, (EntityLivingBase) passenger, -x, -y, -z, 8);
			laser.posX = passenger.posX + vec3d.x * 8.0D;
			laser.posY = passenger.posY + vec3d.y * 1.0D;
			laser.posZ = passenger.posZ + vec3d.z * 8.0D;
			this.world.spawnEntity(laser);
		}
		return false;
	}
	@Override
	public void fall(float distance, float damageMultiplier) {
		return;
	}
	@Override
	public void updatePassenger(Entity passenger) {
		super.updatePassenger(passenger);
		passenger.setPosition(this.posX, this.posY + 2.0F, this.posZ);
		passenger.extinguish();
		if (passenger instanceof EntityLivingBase) {
			EntityLivingBase rider = (EntityLivingBase) passenger;
			if (this.ticksExisted % 20 == 0) {
				rider.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 100, 5));
			}
		}
	}
	@Override
	public boolean shouldDismountInWater(Entity rider) {
		return false;
	}
	@Override
	protected float getWaterSlowDown() {
		return 1.0F;
	}
	@Override
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}
	@Override
	protected boolean canFitPassenger(Entity passenger) {
		return this.getPassengers().isEmpty();
	}
	@Override
	public boolean canBeSteered() {
		return true;
	}
	@Override
	public void travel(float strafe, float up, float forward) {
		Entity entity = this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
		if (this.isBeingRidden() && this.canBeSteered()) {
			this.rotationYaw = entity.rotationYaw;
			this.prevRotationYaw = this.rotationYaw;
			this.rotationPitch = entity.rotationPitch * 0.5F;
			this.renderYawOffset = this.rotationYaw;
			this.rotationYawHead = this.rotationYaw;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			forward = ((EntityLivingBase) entity).moveForward * 2;
			strafe = ((EntityLivingBase) entity).moveStrafing * 6;
			if (this.canPassengerSteer()) {
				if (this.isHovering() || this.onGround) {
					super.travel(strafe, up, 0.0F);
					this.moveRelative(strafe, 0.0F, 0.0F, 0.0F);
				} else {
					super.travel(strafe, up, 0.5F);
					this.moveRelative(strafe, up, 0.5F, 0.1F);
				}
				this.motionY = forward / 6;
				this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			} else {
				this.motionX = 0.0D;
				this.motionY = 0.0D;
				this.motionZ = 0.0D;
			}
		} else {
			super.travel(strafe, up, forward);
		}
	}
	public void toggleHovering() {
		this.dataManager.set(EntityRoamingEye.HOVERING, !this.dataManager.get(EntityRoamingEye.HOVERING));
	}
	public boolean isHovering() {
		return this.dataManager.get(EntityRoamingEye.HOVERING);
	}
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}
	@Override
	public boolean canDespawn() {
		return false;
	}
}
