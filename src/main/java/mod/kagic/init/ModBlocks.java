package mod.kagic.init;

import mod.kagic.blocks.BlockCrystalGemStatue;
import mod.kagic.blocks.BlockDrainedGravel;
import mod.kagic.blocks.BlockGalaxyPadCore;
import mod.kagic.blocks.BlockGemDrill;
import mod.kagic.blocks.BlockGemSeed;
import mod.kagic.blocks.BlockGiantStrawberry;
import mod.kagic.blocks.BlockGiantStrawberryStem;
import mod.kagic.blocks.BlockIncubator;
import mod.kagic.blocks.BlockInjector;
import mod.kagic.blocks.BlockMoonBlessedStone;
import mod.kagic.blocks.BlockMoonGoddessStatue;
import mod.kagic.blocks.BlockPinkSandstone;
import mod.kagic.blocks.BlockPinkSandstoneDoubleSlab;
import mod.kagic.blocks.BlockPinkSandstoneSlab;
import mod.kagic.blocks.BlockPinkSandstoneStairs;
import mod.kagic.blocks.BlockRockMelt;
import mod.kagic.blocks.BlockRoseTears;
import mod.kagic.blocks.BlockVarying;
import mod.kagic.blocks.BlockWarpPadCore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;

/**
 * this class is for Registering blocks for the mod 
 * 
 */
public class ModBlocks {
	public static final Material DRAINED = new Material(MapColor.PURPLE) {
		@Override
		public EnumPushReaction getMobilityFlag() {
			return EnumPushReaction.BLOCK;
		}

		@Override
		public boolean isToolNotRequired() {
			return false;
		}
	};

	public static final BlockGemSeed GEM_SEED = new BlockGemSeed();
	public static final ItemBlock GEM_SEED_BLOCK = new ItemBlock(ModBlocks.GEM_SEED);
	public static final BlockGemDrill GEM_DRILL = new BlockGemDrill();

	public static final BlockInjector INJECTOR = new BlockInjector(false, false);
	public static final BlockInjector EQUIPPED_INJECTOR = new BlockInjector(true, false);
	public static final BlockInjector ANALOG_INJECTOR = new BlockInjector(false, true);
	public static final BlockInjector EQUIPPED_ANALOG_INJECTOR = new BlockInjector(true, true);
	public static final BlockIncubator INCUBATOR = new BlockIncubator();

	public static final BlockVarying DRAINED_BLOCK = new BlockVarying("drained_block", 1, 40, 1);
	public static final BlockVarying DRAINED_BLOCK_2 = new BlockVarying("drained_block_2", 1, 40, 1);
	public static final BlockVarying DRAINED_BANDS = new BlockVarying("drained_bands", 1, 40, 1);
	public static final BlockVarying SMOOTH_CARBONITE = new BlockVarying("smooth_carbonite", 2, 80, 1);

	public static final BlockVarying CHISELED_CARBONITE = new BlockVarying("chiseled_carbonite", 2, 80, 1);
	public static final BlockDrainedGravel DRAINED_GRAVEL = new BlockDrainedGravel("drained_gravel");
	public static final BlockRockMelt ROCK_MELT = new BlockRockMelt(true);
	public static final BlockRockMelt RUTILE_TRAIL = new BlockRockMelt(false);

	public static final BlockWarpPadCore WARP_PAD_CORE = new BlockWarpPadCore();
	public static final BlockGalaxyPadCore GALAXY_PAD_CORE = new BlockGalaxyPadCore();

	public static final BlockPinkSandstone PINK_SANDSTONE = new BlockPinkSandstone();
	public static final BlockPinkSandstoneStairs PINK_SANDSTONE_STAIRS = new BlockPinkSandstoneStairs("pink_sandstone_stairs");
	public static final BlockPinkSandstoneStairs WAVY_PINK_SANDSTONE_STAIRS = new BlockPinkSandstoneStairs("wavy_pink_sandstone_stairs");
	public static final BlockPinkSandstoneSlab PINK_SANDSTONE_SLAB = new BlockPinkSandstoneSlab();
	public static final BlockPinkSandstoneDoubleSlab PINK_SANDSTONE_DOUBLE_SLAB = new BlockPinkSandstoneDoubleSlab();
	public static final BlockGiantStrawberry GIANT_STRAWBERRY = new BlockGiantStrawberry();

	public static final BlockGiantStrawberryStem GIANT_STRAWBERRY_STEM = new BlockGiantStrawberryStem(ModBlocks.GIANT_STRAWBERRY);
	public static final BlockMoonGoddessStatue MOON_GODDESS_STATUE = new BlockMoonGoddessStatue();
	public static final BlockMoonBlessedStone MOON_BLESSED_STONE = new BlockMoonBlessedStone("moon_blessed_stone");

	public static final Fluid FLUID_ROSE_TEARS = new Fluid("rose_tears", new ResourceLocation("kagic:blocks/rose_tears_still"), new ResourceLocation("kagic:blocks/rose_tears_flowing"));
	public static BlockRoseTears ROSE_TEARS;

	public static BlockCrystalGemStatue crystalGemStatue = new BlockCrystalGemStatue();

	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		
		ModBlocks.registerBlock(ModBlocks.GEM_SEED, new ResourceLocation("kagic:gem_seed"), event);
		ModBlocks.registerBlock(ModBlocks.GEM_DRILL, new ResourceLocation("kagic:gem_drill"), event);
		ModBlocks.registerBlock(ModBlocks.INJECTOR, new ResourceLocation("kagic:injector"), event);
		ModBlocks.registerBlock(ModBlocks.EQUIPPED_INJECTOR, new ResourceLocation("kagic:equipped_injector"), event);
		ModBlocks.registerBlock(ModBlocks.ANALOG_INJECTOR, new ResourceLocation("kagic:analog_injector"), event);
		ModBlocks.registerBlock(ModBlocks.EQUIPPED_ANALOG_INJECTOR, new ResourceLocation("kagic:equipped_analog_injector"), event);
		ModBlocks.registerBlock(ModBlocks.INCUBATOR, new ResourceLocation("kagic:incubator"), event);
		ModBlocks.registerBlock(ModBlocks.DRAINED_BLOCK, new ResourceLocation("kagic:drained_block"), event);
		ModBlocks.registerBlock(ModBlocks.DRAINED_BLOCK_2, new ResourceLocation("kagic:drained_block_2"), event);
		ModBlocks.registerBlock(ModBlocks.DRAINED_BANDS, new ResourceLocation("kagic:drained_bands"), event);
		ModBlocks.registerBlock(ModBlocks.SMOOTH_CARBONITE, new ResourceLocation("kagic:smooth_carbonite"), event);
		ModBlocks.registerBlock(ModBlocks.CHISELED_CARBONITE, new ResourceLocation("kagic:chiseled_carbonite"), event);
		ModBlocks.registerBlock(ModBlocks.DRAINED_GRAVEL, new ResourceLocation("kagic:drained_gravel"), event);
		ModBlocks.registerBlock(ModBlocks.ROCK_MELT, new ResourceLocation("kagic:rock_melt"), event);
		ModBlocks.registerBlock(ModBlocks.RUTILE_TRAIL, new ResourceLocation("kagic:rutile_trail"), event);
		ModBlocks.registerBlock(ModBlocks.WARP_PAD_CORE, new ResourceLocation("kagic:warp_pad_core"), event);
		ModBlocks.registerBlock(ModBlocks.GALAXY_PAD_CORE, new ResourceLocation("kagic:galaxy_pad_core"), event);
		ModBlocks.registerBlock(ModBlocks.PINK_SANDSTONE, new ResourceLocation("kagic:pink_sandstone"), event);
		ModBlocks.registerBlock(ModBlocks.PINK_SANDSTONE_STAIRS, new ResourceLocation("kagic:pink_sandstone_stairs"), event);
		ModBlocks.registerBlock(ModBlocks.WAVY_PINK_SANDSTONE_STAIRS, new ResourceLocation("kagic:wavy_pink_sandstone_stairs"), event);
		ModBlocks.registerBlock(ModBlocks.PINK_SANDSTONE_SLAB, new ResourceLocation("kagic:pink_sandstone_slab"), event);
		ModBlocks.registerBlock(ModBlocks.PINK_SANDSTONE_DOUBLE_SLAB, new ResourceLocation("kagic:pink_sandstone_double_slab"), event);
		ModBlocks.registerBlock(ModBlocks.GIANT_STRAWBERRY, new ResourceLocation("kagic:giant_strawberry_block"), event);
		ModBlocks.registerBlock(ModBlocks.GIANT_STRAWBERRY_STEM, new ResourceLocation("kagic:giant_strawberry_stem"), event);
		ModBlocks.registerBlock(ModBlocks.MOON_GODDESS_STATUE, new ResourceLocation("kagic:moon_goddess_statue"), event);
		ModBlocks.registerBlock(ModBlocks.MOON_BLESSED_STONE, new ResourceLocation("kagic:moon_blessed_stone"), event);

		ModBlocks.registerFluid(ModBlocks.FLUID_ROSE_TEARS);
		ModBlocks.ROSE_TEARS = new BlockRoseTears(ModBlocks.FLUID_ROSE_TEARS, Material.WATER);
		ModBlocks.registerBlock(ModBlocks.ROSE_TEARS, new ResourceLocation("kagic:rose_tears"), event);
		KAGIC.proxy.registerStateMappers();
		// KAGIC.proxy.registerBlockColors();
	}
	// Registers block
	public static void registerBlock(Block block, ResourceLocation location, RegistryEvent.Register<Block> event) {
		block.setRegistryName(location);
		event.getRegistry().register(block);
	}
	

	// registers fluid
	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
	//Registers Block Item
	public static void registerBlockItems(RegistryEvent.Register<Item> event) {
		
		ModBlocks.registerBlockItem(ModBlocks.GEM_SEED, new ResourceLocation("kagic:gem_seed"), event);
		ModBlocks.registerBlockItem(ModBlocks.GEM_DRILL, new ResourceLocation("kagic:gem_drill"), event);
		ModBlocks.registerBlockItem(ModBlocks.INJECTOR, new ResourceLocation("kagic:injector"), event);
		ModBlocks.registerBlockItem(ModBlocks.EQUIPPED_INJECTOR, new ResourceLocation("kagic:equipped_injector"), event);
		ModBlocks.registerBlockItem(ModBlocks.ANALOG_INJECTOR, new ResourceLocation("kagic:analog_injector"), event);
		ModBlocks.registerBlockItem(ModBlocks.EQUIPPED_ANALOG_INJECTOR, new ResourceLocation("kagic:equipped_analog_injector"), event);
		ModBlocks.registerBlockItem(ModBlocks.INCUBATOR, new ResourceLocation("kagic:incubator"), event);
		ModBlocks.registerBlockItem(ModBlocks.DRAINED_BLOCK, new ResourceLocation("kagic:drained_block"), event, "stoneDrained");
		ModBlocks.registerBlockItem(ModBlocks.DRAINED_BLOCK_2, new ResourceLocation("kagic:drained_block_2"), event, "stoneDrained");
		ModBlocks.registerBlockItem(ModBlocks.DRAINED_BANDS, new ResourceLocation("kagic:drained_bands"), event, "stoneDrained");
		ModBlocks.registerBlockItem(ModBlocks.SMOOTH_CARBONITE, new ResourceLocation("kagic:smooth_carbonite"), event);
		ModBlocks.registerBlockItem(ModBlocks.DRAINED_GRAVEL, new ResourceLocation("kagic:drained_gravel"), event, "gravelDrained");
		ModBlocks.registerBlockItem(ModBlocks.CHISELED_CARBONITE, new ResourceLocation("kagic:chiseled_carbonite"), event);
		ModBlocks.registerBlockItem(ModBlocks.ROCK_MELT, new ResourceLocation("kagic:rock_melt"), event);
		ModBlocks.registerBlockItem(ModBlocks.RUTILE_TRAIL, new ResourceLocation("kagic:rutile_trail"), event);
		ModBlocks.registerBlockItem(ModBlocks.WARP_PAD_CORE, new ResourceLocation("kagic:warp_pad_core"), event);
		ModBlocks.registerBlockItem(ModBlocks.GALAXY_PAD_CORE, new ResourceLocation("kagic:galaxy_pad_core"), event);
		ModBlocks.registerPinkSandstoneItems(event);
		ModBlocks.registerBlockItem(ModBlocks.PINK_SANDSTONE_STAIRS, new ResourceLocation("kagic:pink_sandstone_stairs"), event);
		ModBlocks.registerBlockItem(ModBlocks.WAVY_PINK_SANDSTONE_STAIRS, new ResourceLocation("kagic:wavy_pink_sandstone_stairs"), event);
		ModBlocks.registerBlockItemSlab(ModBlocks.PINK_SANDSTONE_SLAB, ModBlocks.PINK_SANDSTONE_DOUBLE_SLAB, new ResourceLocation("kagic:pink_sandstone_slab"), event);
		ModBlocks.registerBlockItem(ModBlocks.GIANT_STRAWBERRY, new ResourceLocation("kagic:giant_strawberry_block"), event, "blockGiantStrawberry");
		ModBlocks.registerBlockItem(ModBlocks.MOON_GODDESS_STATUE, new ResourceLocation("kagic:moon_goddess_statue"), event);
		ModBlocks.registerBlockItem(ModBlocks.MOON_BLESSED_STONE, new ResourceLocation("kagic:moon_blessed_stone"), event);
	}

	public static void registerBlockItem(Block block, ResourceLocation location, RegistryEvent.Register<Item> event) {
		ModBlocks.registerBlockItem(block, location, event, "");
	}

	public static void registerBlockItem(Block block, ResourceLocation location, RegistryEvent.Register<Item> event, String oredictName) {
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(location);
		event.getRegistry().register(item);
		
		if (!oredictName.isEmpty()) {
			OreDictionary.registerOre(oredictName, item);
		}
		
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}

	public static void registerBlockItemSlab(BlockSlab singleSlab, BlockSlab doubleSlab, ResourceLocation location, RegistryEvent.Register<Item> event) {
		ItemSlab item = new ItemSlab(singleSlab, singleSlab, doubleSlab);
		item.setRegistryName(location);
		event.getRegistry().register(item);
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
	
	public static void registerPinkSandstoneItems(RegistryEvent.Register<Item> event) {
		ItemMultiTexture item = (ItemMultiTexture) new ItemMultiTexture(ModBlocks.PINK_SANDSTONE, ModBlocks.PINK_SANDSTONE, new ItemMultiTexture.Mapper() {
			@Override
			public String apply(ItemStack p_apply_1_) {
				return BlockPinkSandstone.EnumType.byMetadata(p_apply_1_.getMetadata()).getUnlocalizedName();
			}
		}).setUnlocalizedName(ModBlocks.PINK_SANDSTONE.getUnlocalizedName());
		item.setRegistryName(new ResourceLocation("kagic:pink_sandstone"));
		event.getRegistry().register(item);
		OreDictionary.registerOre("sandstone", item);
		OreDictionary.registerOre("sandstone", new ItemStack(item, 1, 1));
		OreDictionary.registerOre("sandstone", new ItemStack(item, 1, 2));
		OreDictionary.registerOre("sandstone", new ItemStack(item, 1, 3));
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation("kagic:pink_sandstone", "inventory"));
			ModelLoader.setCustomModelResourceLocation(item, 1, new ModelResourceLocation("kagic:chiseled_pink_sandstone", "inventory"));
			ModelLoader.setCustomModelResourceLocation(item, 2, new ModelResourceLocation("kagic:smooth_pink_sandstone", "inventory"));
			ModelLoader.setCustomModelResourceLocation(item, 3, new ModelResourceLocation("kagic:wavy_pink_sandstone", "inventory"));
		}
	}
	
}
