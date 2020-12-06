package mod.kagic.proxies;

import java.util.LinkedHashMap;

import mod.kagic.blocks.BlockPinkSandstone;
import mod.kagic.client.gui.GUIGalaxyPadSelection;
import mod.kagic.client.gui.GUIWarpPadSelection;
import mod.kagic.client.model.FluidModelMapper;
import mod.kagic.init.ModBlocks;
import mod.kagic.worlddata.GalaxyPadLocation;
import mod.kagic.worlddata.WarpPadDataEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	@Override
	public void registerStateMappers() {
		ModelLoader.setCustomStateMapper(ModBlocks.PINK_SANDSTONE, new StateMap.Builder().withName(BlockPinkSandstone.TYPE).build());
		ModelLoader.setCustomStateMapper(ModBlocks.ROSE_TEARS, new FluidModelMapper(ModBlocks.FLUID_ROSE_TEARS));
	}
	
	@Override
	public void registerBlockColors() {
		final IBlockColor strawberryColor = (state, blockAccess, pos, tint) -> {
			if (blockAccess != null && pos != null) {
				return BiomeColorHelper.getFoliageColorAtPos(blockAccess, pos);
			}
			return ColorizerFoliage.getFoliageColor(0.5, 1);
		};

		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(strawberryColor, ModBlocks.GIANT_STRAWBERRY_STEM);
	}

	/*
	 * @SubscribeEvent public static void
	 * registerItems(RegistryEvent.Register<Item> event) {
	 * ModelLoader.registerItemVariants(Item.
	 * getItemFromBlock(ModBlocks.PINK_SANDSTONE), new
	 * ResourceLocation("ndbkagic:pink_sandstone"), new
	 * ResourceLocation("ndbkagic:chiseled_pink_sandstone"),
	 * new ResourceLocation("ndbkagic:smooth_pink_sandstone"));
	 * }
	 */
	
	@Override
	public void openWarpPadSelectionGUI(LinkedHashMap<BlockPos, WarpPadDataEntry> padData, int x, int y, int z) {
		Minecraft.getMinecraft().displayGuiScreen(new GUIWarpPadSelection(padData, x, y, z));
	}
	
	@Override
	public void openGalaxyPadSelectionGUI(LinkedHashMap<GalaxyPadLocation, WarpPadDataEntry> padData, int x, int y, int z) {
		Minecraft.getMinecraft().displayGuiScreen(new GUIGalaxyPadSelection(padData, x, y, z));
	}
}
