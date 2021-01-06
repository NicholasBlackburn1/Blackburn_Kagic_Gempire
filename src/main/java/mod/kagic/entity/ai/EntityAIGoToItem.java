package mod.kagic.entity.ai;

import java.util.List;

import mod.kagic.entity.EntityCrystalShrimp;
import mod.kagic.entity.EntityGem;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityAIGoToItem extends EntityAIBase {
    private final EntityCrystalShrimp gem;
    private final double movementSpeed;
    private EntityItem item;
    private World world;
    public EntityAIGoToItem(EntityCrystalShrimp entityIn, World world, double movementSpeedIn) {
		this.gem = entityIn;
		this.movementSpeed = movementSpeedIn;
        this.setMutexBits(3);
        this.world = world;
	}

	@Override
	public boolean shouldExecute() {
		List<EntityItem> list = this.gem.world.<EntityItem>getEntitiesWithinAABB(EntityItem.class, this.gem.getEntityBoundingBox().grow(4.0D, 4.0D, 4.0D));
		double maxDistance = Double.MAX_VALUE;
		for (EntityItem item : list) {
			double newDistance = this.gem.getDistanceSq(item);
			if (newDistance <= maxDistance &&  this.gem.canEntityBeSeen(item) && !item.isDead && item.getItem().getItem() == Items.APPLE){
                if (this.world.isRemote){
                
                }
				maxDistance = newDistance;
                this.item = item;
                
                
			}
		}
		return this.item != null && !this.item.isDead && this.gem.canPickUpLoot();
	}

    //TODO: add eating particals

    @Override
	public boolean shouldContinueExecuting() {
		return this.item != null && !this.item.isDead && this.gem.canEntityBeSeen(this.item) && !this.gem.getNavigator().noPath();
	}

	@Override
	public void startExecuting() {
		this.gem.getLookHelper().setLookPositionWithEntity(this.item, 30.0F, 30.0F);
	}

	@Override
	public void resetTask() {
		this.gem.getNavigator().clearPath();
		this.item = null;
	}

	@Override
	public void updateTask() {
		if (this.gem.getDistanceSq(this.item) > 1F) {
			this.gem.getNavigator().tryMoveToEntityLiving(this.item, this.movementSpeed);
		}
    }
    
}