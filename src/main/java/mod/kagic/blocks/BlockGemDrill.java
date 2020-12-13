package mod.kagic.blocks;

import mod.kagic.advancements.ModTriggers;
import mod.kagic.init.ModCreativeTabs;
import mod.kagic.util.injector.Injector;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGemDrill extends Block {
	public BlockGemDrill() {
		super(Material.GLASS, MapColor.IRON);
		this.setUnlocalizedName("gem_drill");
		this.setCreativeTab(ModCreativeTabs.CREATIVE_TAB_OTHER);
	}
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		Injector.onGemDrillPlacement(worldIn, pos);
		
	}
	/*********************************************************
	 * Methods related to block rendering. *
	 *********************************************************/
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
}
