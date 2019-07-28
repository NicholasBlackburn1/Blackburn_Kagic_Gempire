package mod.kagic.entity.ai;

import mod.kagic.entity.gem.EntityLapisLazuli;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAITillFarmland extends EntityAIMoveToBlock {
	private final EntityLapisLazuli gem;
	private final World world;
	private int delay = 0;
	public EntityAITillFarmland(EntityLapisLazuli gemIn, double speedIn) {
		super(gemIn, speedIn, 16);
		this.gem = gemIn;
		this.world = gemIn.world;
	}
	@Override
	public boolean shouldExecute() {
		if (this.gem.isFarmer()) {
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
		return super.shouldContinueExecuting() && this.gem.isFarmer() && !this.gem.getNavigator().noPath();
	}
	@Override
	public void startExecuting() {
		super.startExecuting();
	}
	@Override
	public void resetTask() {
		super.resetTask();
	}
	@Override
	public void updateTask() {
		super.updateTask();
		this.gem.getLookHelper().setLookPosition(this.destinationBlock.getX() + 0.5D, this.destinationBlock.getY() + 1, this.destinationBlock.getZ() + 0.5D, 10.0F, this.gem.getVerticalFaceSpeed());
		if (this.getIsAboveDestination()) {
			this.gem.world.setBlockState(this.destinationBlock, Blocks.FARMLAND.getDefaultState().withProperty(BlockFarmland.MOISTURE, 7));
			this.world.playSound(null, this.gem.getPosition(), SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
		}
	}

	@Override
	protected boolean shouldMoveTo(World world, BlockPos pos) {
		Block block = world.getBlockState(pos).getBlock();
		if ((block == Blocks.DIRT || block == Blocks.GRASS) && this.hasWater(world, pos)) {
			return true;
		}
		return false;
	}
	private boolean hasWater(World worldIn, BlockPos pos) {
		for (BlockPos.MutableBlockPos blockpos$mutableblockpos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
			if (worldIn.getBlockState(blockpos$mutableblockpos).getMaterial() == Material.WATER) {
				return worldIn.isAirBlock(pos.up());
			}
		}
		return false;
	}
}