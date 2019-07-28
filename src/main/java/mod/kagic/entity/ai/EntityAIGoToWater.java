package mod.kagic.entity.ai;

import mod.kagic.entity.gem.EntityLapisLazuli;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAIGoToWater extends EntityAIMoveToBlock {
	private final EntityLapisLazuli gem;
	private final World world;
	private int delay = 0;
	public EntityAIGoToWater(EntityLapisLazuli gemIn, double speedIn) {
		super(gemIn, speedIn, 16);
		this.gem = gemIn;
		this.world = gemIn.world;
	}
	@Override
	public boolean shouldExecute() {
		if (this.gem.isAngler() && !this.gem.atWater) {
			if (this.delay > 20 + this.gem.getRNG().nextInt(20)) {
				this.runDelay = 0;
				return super.shouldExecute();
			} else {
				++this.delay;
			}
		}
		return false;
	}
	@Override
	public boolean shouldContinueExecuting() {
		return super.shouldContinueExecuting() && this.gem.isAngler() && !this.gem.atWater;
	}
	@Override
	public void startExecuting() {
		super.startExecuting();
	}
	@Override
	public void resetTask() {
		this.gem.atWater = false;
		super.resetTask();
	}
	@Override
	public void updateTask() {
		super.updateTask();
		this.gem.getLookHelper().setLookPosition(this.destinationBlock.getX() + 0.5D, this.destinationBlock.getY() + 1, this.destinationBlock.getZ() + 0.5D, 10.0F, this.gem.getVerticalFaceSpeed());
		if (this.gem.getDistanceSq(this.destinationBlock) < 8) {
			this.gem.atWater = true;
		} else {
			this.gem.atWater = false;
		}
	}
	@Override
	protected boolean shouldMoveTo(World world, BlockPos pos) {
		Block block = world.getBlockState(pos).getBlock();
		if (block == Blocks.WATER) {
			return true;
		}
		return false;
	}
}