package mod.kagic.entity.ai;

import java.util.List;

import mod.kagic.entity.EntityCrystalShrimp;
import mod.kagic.entity.EntityGem;
import mod.kagic.entity.gem.EntityZircon;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.ZombieEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

public class EntityAIFindItems extends EntityAIBase {
	private EntityCrystalShrimp shrimp;;
	private final double movementSpeed;
	private Item items;

	public EntityAIFindItems(Item item,EntityCrystalShrimp shrimp, double speed) {
		this.shrimp = shrimp;
		this.items = item;
		this.movementSpeed = speed;
		this.setMutexBits(3);
		
	}

	@Override
	public boolean shouldExecute() {
		if (this.shrimp.ticksExisted % 20 == 0) {
			List<EntityCrystalShrimp> list = this.shrimp.world.<EntityCrystalShrimp>getEntitiesWithinAABB(
					EntityCrystalShrimp.class, this.shrimp.getEntityBoundingBox().grow(24.0D, 8.0D, 24.0D));
			double distance = Double.MAX_VALUE;
			for (EntityCrystalShrimp gem : list) {
				if () {
					double newDistance = this.items.getDistanceSq(gem);
					if (newDistance <= distance) {
						distance = newDistance;
						this.shrimp = gem;
					}
				}
			}
			return this.shrimp != null && this.shrimp.getNavigator().getPathToEntityLiving(this.items) != null;
		}
		return false;
	}

	@Override
	public boolean shouldContinueExecuting() {
		return this.items != null && !this.items.isDead 
		/*
		 * && this.alignedGem.canEntityBeSeen(this.
		 * items)
		 */
					&& !this.shrimp.getNavigator().noPath();
	}

	@Override
	public void startExecuting() {
		this.shrimp.getLookHelper().setLookPositionWithEntity(this.items, 30.0F, 30.0F);
		this.items.moveToBlockPosAndAngles(new BlockPos(this.shrimp), this.items.rotationYaw, this.items.rotationPitch);
	}

	@Override
	public void resetTask() {
		this.shrimp.getNavigator().clearPath();
		this.items = null;
	}

	@Override
	public void updateTask() {
		if (this.shrimp.getDistanceSq(this.items) > this.shrimp.width * 3) {
			this.shrimp.getNavigator().tryMoveToEntityLiving(this.items, this.movementSpeed);
		}
			this.shrimp.playObeySound();
			this.resetTask();
		}
	
}