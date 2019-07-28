package mod.kagic.blocks;

import java.util.Random;

import mod.kagic.util.injector.InjectorResult;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGemSeed extends Block {
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);
	public BlockGemSeed() {
		super(Material.ROCK, MapColor.RED);
		this.setUnlocalizedName("gem_seed");
		this.setResistance(1000.0F);
		this.setBlockUnbreakable();
		this.setTickRandomly(true);
		this.setLightLevel(9.0F);
	}

	/*********************************************************
	 * Methods related to block activation and interaction.
	 * *
	 *********************************************************/
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		super.randomTick(worldIn, pos, state, random);
		this.age(worldIn, pos, state, random);
	}
	public void age(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (worldIn.getBlockState(pos).getValue(BlockGemSeed.AGE) < 3) {
			worldIn.setBlockState(pos, state.cycleProperty(BlockGemSeed.AGE));
		} else {
			InjectorResult result = InjectorResult.create(worldIn, pos, true);
			result.generate(worldIn);
		}
	}

	/*********************************************************
	 * Methods related to block destruction and removal. *
	 *********************************************************/
	@Override
	public int quantityDropped(Random random) {
		return 0;
	}

	/*********************************************************
	 * Methods related to block states and aging. *
	 *********************************************************/
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, BlockGemSeed.AGE);
	}
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(BlockGemSeed.AGE, meta);
	}
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BlockGemSeed.AGE);
	}
	
	/*********************************************************
	 * Methods related to block rendering. *
	 *********************************************************/
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return true;
	}
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
}