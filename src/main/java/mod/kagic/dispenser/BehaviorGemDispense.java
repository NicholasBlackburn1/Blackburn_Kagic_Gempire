package mod.kagic.dispenser;

import mod.kagic.items.ItemGem;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.init.Bootstrap.BehaviorDispenseOptional;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BehaviorGemDispense extends BehaviorDispenseOptional {
	
	public BehaviorGemDispense() {
	}
	
	@Override
	protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
		World world = source.getWorld();
		EnumFacing direction = source.getBlockState().getValue(BlockDispenser.FACING);
		BlockPos spawnPos;
		if (direction == EnumFacing.DOWN) {
			spawnPos = source.getBlockPos().down(4);
		} else if (direction == EnumFacing.UP) {
			spawnPos = source.getBlockPos();
		} else {
			spawnPos = source.getBlockPos().down().offset(direction);
		}

		ItemGem gem = (ItemGem) stack.getItem();
		this.successful = gem.spawnGem(world, null, spawnPos, stack);
		ItemStack shrunk = stack.copy();
		shrunk.shrink(1);
		return shrunk;
	}
}
