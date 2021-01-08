package mod.kagic.init;

import java.util.HashMap;

import mod.kagic.items.ItemActiveGemBase;
import mod.kagic.items.ItemActiveGemShard;
import mod.kagic.items.ItemAutonomyContract;
import mod.kagic.items.ItemBagelSandwitch;
import mod.kagic.items.ItemCommanderStaff;
import mod.kagic.items.ItemGem;
import mod.kagic.items.ItemGemStaff;
import mod.kagic.items.ItemInactiveGemBase;
import mod.kagic.items.ItemJointContract;
import mod.kagic.items.ItemLiberationContract;
import mod.kagic.items.ItemObsidiansSword;
import mod.kagic.items.ItemPeaceTreaty;
import mod.kagic.items.ItemTimeGlass;
import mod.kagic.items.ItemTransferContract;
import mod.kagic.items.ItemVehicle;
import mod.kagic.items.ItemWarDeclaration;
import mod.kagic.items.ItemWarpWhistle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
	public static final HashMap<ItemGem, ItemGem> GEM_TABLE = new HashMap<ItemGem, ItemGem>();
	
	public static final ItemActiveGemShard ACTIVATED_GEM_SHARD = new ItemActiveGemShard();
	public static final ItemActiveGemBase ACTIVATED_GEM_BASE = new ItemActiveGemBase();
	public static final ItemInactiveGemBase INACTIVE_GEM_BASE = new ItemInactiveGemBase();
	public static final ItemTransferContract TRANSFER_CONTRACT = new ItemTransferContract();
	public static final ItemJointContract JOINT_CONTRACT = new ItemJointContract();
	public static final ItemLiberationContract LIBERATION_CONTRACT = new ItemLiberationContract();
	public static final ItemAutonomyContract AUTONOMY_CONTRACT = new ItemAutonomyContract();
	public static final ItemWarDeclaration WAR_DECLARATION = new ItemWarDeclaration();
	public static final ItemPeaceTreaty PEACE_TREATY = new ItemPeaceTreaty();
	public static final ItemGemStaff GEM_STAFF = new ItemGemStaff();
	public static final ItemCommanderStaff COMMANDER_STAFF = new ItemCommanderStaff();
	public static final ItemVehicle ROAMING_EYE = new ItemVehicle("roaming_eye");
	public static final Item LASER_BEAM = new Item().setUnlocalizedName("laser_beam");
	public static final ItemWarpWhistle WARP_WHISTLE = new ItemWarpWhistle();
	public static final ItemFood STRAWBERRY_SLICE = (ItemFood) new ItemFood(2, 0.3F, false).setUnlocalizedName("strawberry_slice").setCreativeTab(ModCreativeTabs.CREATIVE_TAB_OTHER);
	public static final ItemSeeds STRAWBERRY_SEEDS = (ItemSeeds) new ItemSeeds(ModBlocks.GIANT_STRAWBERRY_STEM, Blocks.FARMLAND).setUnlocalizedName("strawberry_seeds").setCreativeTab(ModCreativeTabs.CREATIVE_TAB_OTHER);
	public static final ItemTimeGlass TIME_GLASS = new ItemTimeGlass();

	public static final ItemGem RUBY_GEM = new ItemGem("ruby");
	public static final ItemGem WHITE_PEARL_GEM = new ItemGem("pearl_0");
	public static final ItemGem ORANGE_PEARL_GEM = new ItemGem("pearl_1");
	public static final ItemGem MAGENTA_PEARL_GEM = new ItemGem("pearl_2");
	public static final ItemGem LIGHT_BLUE_PEARL_GEM = new ItemGem("pearl_3");
	public static final ItemGem YELLOW_PEARL_GEM = new ItemGem("pearl_4");
	public static final ItemGem LIME_PEARL_GEM = new ItemGem("pearl_5");
	public static final ItemGem PINK_PEARL_GEM = new ItemGem("pearl_6");
	public static final ItemGem GRAY_PEARL_GEM = new ItemGem("pearl_7");
	public static final ItemGem LIGHT_GRAY_PEARL_GEM = new ItemGem("pearl_8");
	public static final ItemGem CYAN_PEARL_GEM = new ItemGem("pearl_9");
	public static final ItemGem PURPLE_PEARL_GEM = new ItemGem("pearl_10");
	public static final ItemGem BLUE_PEARL_GEM = new ItemGem("pearl_11");
	public static final ItemGem BROWN_PEARL_GEM = new ItemGem("pearl_12");
	public static final ItemGem GREEN_PEARL_GEM = new ItemGem("pearl_13");
	public static final ItemGem RED_PEARL_GEM = new ItemGem("pearl_14");
	public static final ItemGem BLACK_PEARL_GEM = new ItemGem("pearl_15");
	public static final ItemGem PEARL_GEM = new ItemGem("pearl");
	public static final ItemGem BISMUTH_GEM = new ItemGem("bismuth");
	public static final ItemGem PERIDOT_GEM = new ItemGem("peridot");
	public static final ItemGem JASPER_GEM = new ItemGem("jasper");
	public static final ItemGem NOREENA_JASPER_GEM = new ItemGem("jasper_0");
	public static final ItemGem OCEAN_JASPER_GEM = new ItemGem("jasper_1");
	public static final ItemGem BIGGS_JASPER_GEM = new ItemGem("jasper_2");
	public static final ItemGem GREEN_JASPER_GEM = new ItemGem("jasper_3");
	public static final ItemGem BRUNEAU_JASPER_GEM = new ItemGem("jasper_4");
	public static final ItemGem PURPLE_JASPER_GEM = new ItemGem("jasper_5");
	public static final ItemGem FLAME_JASPER_GEM = new ItemGem("jasper_6");
	public static final ItemGem PICTURE_JASPER_GEM = new ItemGem("jasper_7");
	public static final ItemGem CANDY_CANE_JASPER_GEM = new ItemGem("jasper_8");
	public static final ItemGem AMETHYST_GEM = new ItemGem("amethyst");
	public static final ItemGem ROSE_QUARTZ_GEM = new ItemGem("rose_quartz");
	public static final ItemGem LAPIS_LAZULI_GEM = new ItemGem("lapis_lazuli");
	public static final ItemGem CARNELIAN_GEM = new ItemGem("carnelian");
	public static final ItemGem WHITE_AGATE_GEM = new ItemGem("agate_0");
	public static final ItemGem ORANGE_AGATE_GEM = new ItemGem("agate_1");
	public static final ItemGem MAGENTA_AGATE_GEM = new ItemGem("agate_2");
	public static final ItemGem LIGHT_BLUE_AGATE_GEM = new ItemGem("agate_3");
	public static final ItemGem YELLOW_AGATE_GEM = new ItemGem("agate_4");
	public static final ItemGem LIME_AGATE_GEM = new ItemGem("agate_5");
	public static final ItemGem PINK_AGATE_GEM = new ItemGem("agate_6");
	public static final ItemGem GRAY_AGATE_GEM = new ItemGem("agate_7");
	public static final ItemGem LIGHT_GRAY_AGATE_GEM = new ItemGem("agate_8");
	public static final ItemGem CYAN_AGATE_GEM = new ItemGem("agate_9");
	public static final ItemGem PURPLE_AGATE_GEM = new ItemGem("agate_10");
	public static final ItemGem BLUE_AGATE_GEM = new ItemGem("agate_11");
	public static final ItemGem BROWN_AGATE_GEM = new ItemGem("agate_12");
	public static final ItemGem GREEN_AGATE_GEM = new ItemGem("agate_13");
	public static final ItemGem RED_AGATE_GEM = new ItemGem("agate_14");
	public static final ItemGem BLACK_AGATE_GEM = new ItemGem("agate_15");
	public static final ItemGem HOLLY_BLUE_AGATE_GEM = new ItemGem("agate_16");
	public static final ItemGem AGATE_GEM = new ItemGem("agate");
	public static final ItemGem AQUAMARINE_GEM = new ItemGem("aquamarine");
	public static final ItemGem HESSONITE_GEM = new ItemGem("hessonite");
	public static final ItemGem WHITE_SAPPHIRE_GEM = new ItemGem("sapphire_0");
	public static final ItemGem ORANGE_SAPPHIRE_GEM = new ItemGem("sapphire_1");
	public static final ItemGem YELLOW_SAPPHIRE_GEM = new ItemGem("sapphire_4");
	public static final ItemGem PINK_SAPPHIRE_GEM = new ItemGem("sapphire_6");
	public static final ItemGem PURPLE_SAPPHIRE_GEM = new ItemGem("sapphire_10");
	public static final ItemGem BLUE_SAPPHIRE_GEM = new ItemGem("sapphire_11");
	public static final ItemGem GREEN_SAPPHIRE_GEM = new ItemGem("sapphire_13");
	public static final ItemGem BLACK_SAPPHIRE_GEM = new ItemGem("sapphire_15");
	public static final ItemGem PADPARADSCHA_GEM = new ItemGem("sapphire_16");
	public static final ItemGem SAPPHIRE_GEM = new ItemGem("sapphire");
	
	public static final ItemGem TOPAZ_GEM = new ItemGem("topaz");
	public static final ItemGem BLUE_TOPAZ_GEM = new ItemGem("topaz_1");

	public static final ItemGem CITRINE_GEM = new ItemGem("citrine");
	public static final ItemGem AMETRINE_GEM = new ItemGem("citrine_1");


	public static final ItemGem EMERALD_GEM = new ItemGem("emerald");
	public static final ItemGem CRACKED_EMERALD_GEM = new ItemGem("emerald",true);

	public static final ItemGem WHITE_ZIRCON_GEM = new ItemGem("zircon_0");
	public static final ItemGem ORANGE_ZIRCON_GEM = new ItemGem("zircon_1");
	public static final ItemGem MAGENTA_ZIRCON_GEM = new ItemGem("zircon_2");
	public static final ItemGem LIGHT_BLUE_ZIRCON_GEM = new ItemGem("zircon_3");
	public static final ItemGem YELLOW_ZIRCON_GEM = new ItemGem("zircon_4");
	public static final ItemGem LIME_ZIRCON_GEM = new ItemGem("zircon_5");
	public static final ItemGem PINK_ZIRCON_GEM = new ItemGem("zircon_6");
	public static final ItemGem GRAY_ZIRCON_GEM = new ItemGem("zircon_7");
	public static final ItemGem LIGHT_GRAY_ZIRCON_GEM = new ItemGem("zircon_8");
	public static final ItemGem CYAN_ZIRCON_GEM = new ItemGem("zircon_9");
	public static final ItemGem PURPLE_ZIRCON_GEM = new ItemGem("zircon_10");
	public static final ItemGem BLUE_ZIRCON_GEM = new ItemGem("zircon_11");
	public static final ItemGem BROWN_ZIRCON_GEM = new ItemGem("zircon_12");
	public static final ItemGem GREEN_ZIRCON_GEM = new ItemGem("zircon_13");
	public static final ItemGem RED_ZIRCON_GEM = new ItemGem("zircon_14");
	public static final ItemGem BLACK_ZIRCON_GEM = new ItemGem("zircon_15");
	public static final ItemGem ZIRCON_GEM = new ItemGem("zircon");

	public static final ItemGem RUTILE_GEM = new ItemGem("rutile");
	public static final ItemGem TWIN_RUTILE_GEM = new ItemGem("rutile_1");
	
	public static final ItemGem YELLOW_DIAMOND_GEM = new ItemGem("yellow_diamond");
	public static final ItemGem BLUE_DIAMOND_GEM = new ItemGem("blue_diamond");
	
	public static final ItemGem CRACKED_RUBY_GEM = new ItemGem("ruby", true);
	public static final ItemGem CRACKED_WHITE_PEARL_GEM = new ItemGem("pearl_0", true);
	public static final ItemGem CRACKED_ORANGE_PEARL_GEM = new ItemGem("pearl_1", true);
	public static final ItemGem CRACKED_MAGENTA_PEARL_GEM = new ItemGem("pearl_2", true);
	public static final ItemGem CRACKED_LIGHT_BLUE_PEARL_GEM = new ItemGem("pearl_3", true);
	public static final ItemGem CRACKED_YELLOW_PEARL_GEM = new ItemGem("pearl_4", true);
	public static final ItemGem CRACKED_LIME_PEARL_GEM = new ItemGem("pearl_5", true);
	public static final ItemGem CRACKED_PINK_PEARL_GEM = new ItemGem("pearl_6", true);
	public static final ItemGem CRACKED_GRAY_PEARL_GEM = new ItemGem("pearl_7", true);
	public static final ItemGem CRACKED_LIGHT_GRAY_PEARL_GEM = new ItemGem("pearl_8", true);
	public static final ItemGem CRACKED_CYAN_PEARL_GEM = new ItemGem("pearl_9", true);
	public static final ItemGem CRACKED_PURPLE_PEARL_GEM = new ItemGem("pearl_10", true);
	public static final ItemGem CRACKED_BLUE_PEARL_GEM = new ItemGem("pearl_11", true);
	public static final ItemGem CRACKED_BROWN_PEARL_GEM = new ItemGem("pearl_12", true);
	public static final ItemGem CRACKED_GREEN_PEARL_GEM = new ItemGem("pearl_13", true);
	public static final ItemGem CRACKED_RED_PEARL_GEM = new ItemGem("pearl_14", true);
	public static final ItemGem CRACKED_BLACK_PEARL_GEM = new ItemGem("pearl_15", true);
	public static final ItemGem CRACKED_PEARL_GEM = new ItemGem("pearl", true);
	public static final ItemGem CRACKED_BISMUTH_GEM = new ItemGem("bismuth", true);
	public static final ItemGem CRACKED_PERIDOT_GEM = new ItemGem("peridot", true);
	public static final ItemGem CRACKED_JASPER_GEM = new ItemGem("jasper", true);
	public static final ItemGem CRACKED_NOREENA_JASPER_GEM = new ItemGem("jasper_0", true);
	public static final ItemGem CRACKED_OCEAN_JASPER_GEM = new ItemGem("jasper_1", true);
	public static final ItemGem CRACKED_BIGGS_JASPER_GEM = new ItemGem("jasper_2", true);
	public static final ItemGem CRACKED_GREEN_JASPER_GEM = new ItemGem("jasper_3", true);
	public static final ItemGem CRACKED_BRUNEAU_JASPER_GEM = new ItemGem("jasper_4", true);
	public static final ItemGem CRACKED_PURPLE_JASPER_GEM = new ItemGem("jasper_5", true);
	public static final ItemGem CRACKED_FLAME_JASPER_GEM = new ItemGem("jasper_6", true);
	public static final ItemGem CRACKED_PICTURE_JASPER_GEM = new ItemGem("jasper_7", true);
	public static final ItemGem CRACKED_CANDY_CANE_JASPER_GEM = new ItemGem("jasper_8", true);
	public static final ItemGem CRACKED_AMETHYST_GEM = new ItemGem("amethyst", true);
	public static final ItemGem CRACKED_ROSE_QUARTZ_GEM = new ItemGem("rose_quartz", true);
	public static final ItemGem CRACKED_LAPIS_LAZULI_GEM = new ItemGem("lapis_lazuli", true);
	public static final ItemGem CRACKED_CARNELIAN_GEM = new ItemGem("carnelian", true);
	public static final ItemGem CRACKED_WHITE_AGATE_GEM = new ItemGem("agate_0", true);
	public static final ItemGem CRACKED_ORANGE_AGATE_GEM = new ItemGem("agate_1", true);
	public static final ItemGem CRACKED_MAGENTA_AGATE_GEM = new ItemGem("agate_2", true);
	public static final ItemGem CRACKED_LIGHT_BLUE_AGATE_GEM = new ItemGem("agate_3", true);
	public static final ItemGem CRACKED_YELLOW_AGATE_GEM = new ItemGem("agate_4", true);
	public static final ItemGem CRACKED_LIME_AGATE_GEM = new ItemGem("agate_5", true);
	public static final ItemGem CRACKED_PINK_AGATE_GEM = new ItemGem("agate_6", true);
	public static final ItemGem CRACKED_GRAY_AGATE_GEM = new ItemGem("agate_7", true);
	public static final ItemGem CRACKED_LIGHT_GRAY_AGATE_GEM = new ItemGem("agate_8", true);
	public static final ItemGem CRACKED_CYAN_AGATE_GEM = new ItemGem("agate_9", true);
	public static final ItemGem CRACKED_PURPLE_AGATE_GEM = new ItemGem("agate_10", true);
	public static final ItemGem CRACKED_BLUE_AGATE_GEM = new ItemGem("agate_11", true);
	public static final ItemGem CRACKED_BROWN_AGATE_GEM = new ItemGem("agate_12", true);
	public static final ItemGem CRACKED_GREEN_AGATE_GEM = new ItemGem("agate_13", true);
	public static final ItemGem CRACKED_RED_AGATE_GEM = new ItemGem("agate_14", true);
	public static final ItemGem CRACKED_BLACK_AGATE_GEM = new ItemGem("agate_15", true);
	public static final ItemGem CRACKED_HOLLY_BLUE_AGATE_GEM = new ItemGem("agate_16", true);
	public static final ItemGem CRACKED_AGATE_GEM = new ItemGem("agate", true);
	public static final ItemGem CRACKED_AQUAMARINE_GEM = new ItemGem("aquamarine", true);
	public static final ItemGem CRACKED_HESSONITE_GEM = new ItemGem("hessonite", true);

	public static final ItemGem CRACKED_WHITE_SAPPHIRE_GEM = new ItemGem("sapphire_0", true);
	public static final ItemGem CRACKED_ORANGE_SAPPHIRE_GEM = new ItemGem("sapphire_1", true);
	public static final ItemGem CRACKED_YELLOW_SAPPHIRE_GEM = new ItemGem("sapphire_4", true);
	public static final ItemGem CRACKED_PINK_SAPPHIRE_GEM = new ItemGem("sapphire_6", true);
	public static final ItemGem CRACKED_PURPLE_SAPPHIRE_GEM = new ItemGem("sapphire_10", true);
	public static final ItemGem CRACKED_BLUE_SAPPHIRE_GEM = new ItemGem("sapphire_11", true);
	public static final ItemGem CRACKED_GREEN_SAPPHIRE_GEM = new ItemGem("sapphire_13", true);
	public static final ItemGem CRACKED_BLACK_SAPPHIRE_GEM = new ItemGem("sapphire_15", true);
	public static final ItemGem CRACKED_PADPARADSCHA_GEM = new ItemGem("sapphire_16", true);
	public static final ItemGem CRACKED_SAPPHIRE_GEM = new ItemGem("sapphire", true);
	
	public static final ItemGem CRACKED_TOPAZ_GEM = new ItemGem("topaz", true);
	public static final ItemGem CRACKED_BLUE_TOPAZ_GEM = new ItemGem("topaz_1", true);

	public static final ItemGem CRACKED_CITRINE_GEM = new ItemGem("citrine", true);
	public static final ItemGem CRACKED_AMETRINE_GEM = new ItemGem("citrine_1", true);
	
	public static final ItemGem CRACKED_WHITE_ZIRCON_GEM = new ItemGem("zircon_0", true);
	public static final ItemGem CRACKED_ORANGE_ZIRCON_GEM = new ItemGem("zircon_1", true);
	public static final ItemGem CRACKED_MAGENTA_ZIRCON_GEM = new ItemGem("zircon_2", true);
	public static final ItemGem CRACKED_LIGHT_BLUE_ZIRCON_GEM = new ItemGem("zircon_3", true);
	public static final ItemGem CRACKED_YELLOW_ZIRCON_GEM = new ItemGem("zircon_4", true);
	public static final ItemGem CRACKED_LIME_ZIRCON_GEM = new ItemGem("zircon_5", true);
	public static final ItemGem CRACKED_PINK_ZIRCON_GEM = new ItemGem("zircon_6", true);
	public static final ItemGem CRACKED_GRAY_ZIRCON_GEM = new ItemGem("zircon_7", true);
	public static final ItemGem CRACKED_LIGHT_GRAY_ZIRCON_GEM = new ItemGem("zircon_8", true);
	public static final ItemGem CRACKED_CYAN_ZIRCON_GEM = new ItemGem("zircon_9", true);
	public static final ItemGem CRACKED_PURPLE_ZIRCON_GEM = new ItemGem("zircon_10", true);
	public static final ItemGem CRACKED_BLUE_ZIRCON_GEM = new ItemGem("zircon_11", true);
	public static final ItemGem CRACKED_BROWN_ZIRCON_GEM = new ItemGem("zircon_12", true);
	public static final ItemGem CRACKED_GREEN_ZIRCON_GEM = new ItemGem("zircon_13", true);
	public static final ItemGem CRACKED_RED_ZIRCON_GEM = new ItemGem("zircon_14", true);
	public static final ItemGem CRACKED_BLACK_ZIRCON_GEM = new ItemGem("zircon_15", true);
	public static final ItemGem CRACKED_ZIRCON_GEM = new ItemGem("zircon", true);

	public static final ItemGem CRACKED_RUTILE_GEM = new ItemGem("rutile", true);
	public static final ItemGem CRACKED_TWIN_RUTILE_GEM = new ItemGem("rutile_1", true);
	
	public static final ItemGem CRACKED_YELLOW_DIAMOND_GEM = new ItemGem("yellow_diamond", true);
	public static final ItemGem CRACKED_BLUE_DIAMOND_GEM = new ItemGem("blue_diamond", true);

	public static final ItemGem HANDBODY_GEM = new ItemGem("handbody", false);
	public static final ItemGem CRACKED_HANDBODY_GEM = new ItemGem("handbody", true);
	public static final ItemGem FOOTARM_GEM = new ItemGem("footarm", false);
	public static final ItemGem CRACKED_FOOTARM_GEM = new ItemGem("footarm", true);
	public static final ItemGem MOUTHTORSO_GEM = new ItemGem("mouthtorso", false);
	public static final ItemGem CRACKED_MOUTHTORSO_GEM = new ItemGem("mouthtorso", true);

	public static final ItemGem CORRUPTED_AMETHYST_GEM = new ItemGem("corrupted_amatista");
	public static final ItemGem CRACKED_CORRUPTED_AMETHYST_GEM = new ItemGem("corrupted_amatista", true);
	public static final ItemGem CORRUPTED_CARNELIAN_GEM = new ItemGem("corrupted_cornalina");
	public static final ItemGem CRACKED_CORRUPTED_CARNELIAN_GEM = new ItemGem("corrupted_cornalina", true);
	public static final ItemGem CORRUPTED_JASPER_GEM = new ItemGem("corrupted_jasper");
	public static final ItemGem CORRUPTED_NOREENA_JASPER_GEM = new ItemGem("corrupted_jasper_0");
	public static final ItemGem CORRUPTED_OCEAN_JASPER_GEM = new ItemGem("corrupted_jasper_1");
	public static final ItemGem CORRUPTED_BIGGS_JASPER_GEM = new ItemGem("corrupted_jasper_2");
	public static final ItemGem CORRUPTED_GREEN_JASPER_GEM = new ItemGem("corrupted_jasper_3");
	public static final ItemGem CORRUPTED_BRUNEAU_JASPER_GEM = new ItemGem("corrupted_jasper_4");
	public static final ItemGem CORRUPTED_PURPLE_JASPER_GEM = new ItemGem("corrupted_jasper_5");
	public static final ItemGem CORRUPTED_FLAME_JASPER_GEM = new ItemGem("corrupted_jasper_6");
	public static final ItemGem CORRUPTED_PICTURE_JASPER_GEM = new ItemGem("corrupted_jasper_7");
	public static final ItemGem CRACKED_CORRUPTED_JASPER_GEM = new ItemGem("corrupted_jasper", true);
	public static final ItemGem CRACKED_CORRUPTED_NOREENA_JASPER_GEM = new ItemGem("corrupted_jasper_0", true);
	public static final ItemGem CRACKED_CORRUPTED_OCEAN_JASPER_GEM = new ItemGem("corrupted_jasper_1", true);
	public static final ItemGem CRACKED_CORRUPTED_BIGGS_JASPER_GEM = new ItemGem("corrupted_jasper_2", true);
	public static final ItemGem CRACKED_CORRUPTED_GREEN_JASPER_GEM = new ItemGem("corrupted_jasper_3", true);
	public static final ItemGem CRACKED_CORRUPTED_BRUNEAU_JASPER_GEM = new ItemGem("corrupted_jasper_4", true);
	public static final ItemGem CRACKED_CORRUPTED_PURPLE_JASPER_GEM = new ItemGem("corrupted_jasper_5", true);
	public static final ItemGem CRACKED_CORRUPTED_FLAME_JASPER_GEM = new ItemGem("corrupted_jasper_6", true);
	public static final ItemGem CRACKED_CORRUPTED_PICTURE_JASPER_GEM = new ItemGem("corrupted_jasper_7", true);
	public static final ItemGem CORRUPTED_MOISSANITE_GEM = new ItemGem("corrupted_moissanita");
	public static final ItemGem CRACKED_CORRUPTED_MOISSANITE_GEM = new ItemGem("corrupted_moissanita", true);
	public static final ItemGem CORRUPTED_ROSE_QUARTZ_GEM = new ItemGem("corrupted_cuarzo_rosa");
	public static final ItemGem CRACKED_CORRUPTED_ROSE_QUARTZ_GEM = new ItemGem("corrupted_cuarzo_rosa", true);
	public static final ItemGem CORRUPTED_TONGUE_MONSTER_GEM = new ItemGem("tongue_monster");
	public static final ItemGem CRACKED_CORRUPTED_TONGUE_MONSTER_GEM = new ItemGem("tongue_monster", true);
	public static final ItemGem CORRUPTED_BLUE_WATER_BEAR_GEM = new ItemGem("water_bear_0");
	public static final ItemGem CRACKED_CORRUPTED_BLUE_WATER_BEAR_GEM = new ItemGem("water_bear_0", true);
	public static final ItemGem CORRUPTED_GREEN_WATER_BEAR_GEM = new ItemGem("water_bear_1");
	public static final ItemGem CRACKED_CORRUPTED_GREEN_WATER_BEAR_GEM = new ItemGem("water_bear_1", true);
	public static final ItemGem CORRUPTED_WATERMELON_TOURMALINE_GEM = new ItemGem("corrupted_watermelon_tourmaline");
	public static final ItemGem CRACKED_CORRUPTED_WATERMELON_TOURMALINE_GEM = new ItemGem("corrupted_watermelon_tourmaline", true);
	

	// Start of Defining Weapons  
	public static final ItemObsidiansSword OBSIDIANS_SWORD = new ItemObsidiansSword();

	// Start of Defining Food items
	public static final ItemBagelSandwitch BAGEL_SANDWITCH = new ItemBagelSandwitch(64, 1000, false);
	public static void registerItems(RegistryEvent.Register<Item> event) {
		// Registers Weapon Items here
		ModItems.registerItemndb(OBSIDIANS_SWORD, event);

		// Register food here 
		ModItems.registerItemndb(BAGEL_SANDWITCH, event);
		
		// Registers The Gem Items
		ModItems.registerGem(ModItems.RUBY_GEM, ModItems.CRACKED_RUBY_GEM, event);
		ModItems.registerGem(ModItems.WHITE_PEARL_GEM, ModItems.CRACKED_WHITE_PEARL_GEM, event);
		ModItems.registerGem(ModItems.ORANGE_PEARL_GEM, ModItems.CRACKED_ORANGE_PEARL_GEM, event);
		ModItems.registerGem(ModItems.MAGENTA_PEARL_GEM, ModItems.CRACKED_MAGENTA_PEARL_GEM, event);
		ModItems.registerGem(ModItems.LIGHT_BLUE_PEARL_GEM, ModItems.CRACKED_LIGHT_BLUE_PEARL_GEM, event);
		ModItems.registerGem(ModItems.YELLOW_PEARL_GEM, ModItems.CRACKED_YELLOW_PEARL_GEM, event);
		ModItems.registerGem(ModItems.LIME_PEARL_GEM, ModItems.CRACKED_LIME_PEARL_GEM, event);
		ModItems.registerGem(ModItems.PINK_PEARL_GEM, ModItems.CRACKED_PINK_PEARL_GEM, event);
		ModItems.registerGem(ModItems.GRAY_PEARL_GEM, ModItems.CRACKED_GRAY_PEARL_GEM, event);
		ModItems.registerGem(ModItems.LIGHT_GRAY_PEARL_GEM, ModItems.CRACKED_LIGHT_GRAY_PEARL_GEM, event);
		ModItems.registerGem(ModItems.CYAN_PEARL_GEM, ModItems.CRACKED_CYAN_PEARL_GEM, event);
		ModItems.registerGem(ModItems.PURPLE_PEARL_GEM, ModItems.CRACKED_PURPLE_PEARL_GEM, event);
		ModItems.registerGem(ModItems.BLUE_PEARL_GEM, ModItems.CRACKED_BLUE_PEARL_GEM, event);
		ModItems.registerGem(ModItems.BROWN_PEARL_GEM, ModItems.CRACKED_BROWN_PEARL_GEM, event);
		ModItems.registerGem(ModItems.GREEN_PEARL_GEM, ModItems.CRACKED_GREEN_PEARL_GEM, event);
		ModItems.registerGem(ModItems.RED_PEARL_GEM, ModItems.CRACKED_RED_PEARL_GEM, event);
		ModItems.registerGem(ModItems.BLACK_PEARL_GEM, ModItems.CRACKED_BLACK_PEARL_GEM, event);
		ModItems.registerGem(ModItems.PEARL_GEM, ModItems.CRACKED_PEARL_GEM, event);
		ModItems.registerGem(ModItems.BISMUTH_GEM, ModItems.CRACKED_BISMUTH_GEM, event);
		ModItems.registerGem(ModItems.PERIDOT_GEM, ModItems.CRACKED_PERIDOT_GEM, event);
		ModItems.registerGem(ModItems.JASPER_GEM, ModItems.CRACKED_JASPER_GEM, event);
		ModItems.registerGem(ModItems.NOREENA_JASPER_GEM, ModItems.CRACKED_NOREENA_JASPER_GEM, event);
		ModItems.registerGem(ModItems.OCEAN_JASPER_GEM, ModItems.CRACKED_OCEAN_JASPER_GEM, event);
		ModItems.registerGem(ModItems.BIGGS_JASPER_GEM, ModItems.CRACKED_BIGGS_JASPER_GEM, event);
		ModItems.registerGem(ModItems.GREEN_JASPER_GEM, ModItems.CRACKED_GREEN_JASPER_GEM, event);
		ModItems.registerGem(ModItems.BRUNEAU_JASPER_GEM, ModItems.CRACKED_BRUNEAU_JASPER_GEM, event);
		ModItems.registerGem(ModItems.PURPLE_JASPER_GEM, ModItems.CRACKED_PURPLE_JASPER_GEM, event);
		ModItems.registerGem(ModItems.FLAME_JASPER_GEM, ModItems.CRACKED_FLAME_JASPER_GEM, event);
		ModItems.registerGem(ModItems.PICTURE_JASPER_GEM, ModItems.CRACKED_PICTURE_JASPER_GEM, event);
		ModItems.registerGem(ModItems.CANDY_CANE_JASPER_GEM, ModItems.CRACKED_CANDY_CANE_JASPER_GEM, event);
		ModItems.registerGem(ModItems.AMETHYST_GEM, ModItems.CRACKED_AMETHYST_GEM, event);
		ModItems.registerGem(ModItems.ROSE_QUARTZ_GEM, ModItems.CRACKED_ROSE_QUARTZ_GEM, event);
		ModItems.registerGem(ModItems.LAPIS_LAZULI_GEM, ModItems.CRACKED_LAPIS_LAZULI_GEM, event);
		ModItems.registerGem(ModItems.CARNELIAN_GEM, ModItems.CRACKED_CARNELIAN_GEM, event);
		ModItems.registerGem(ModItems.WHITE_AGATE_GEM, ModItems.CRACKED_WHITE_AGATE_GEM, event);
		ModItems.registerGem(ModItems.ORANGE_AGATE_GEM, ModItems.CRACKED_ORANGE_AGATE_GEM, event);
		ModItems.registerGem(ModItems.MAGENTA_AGATE_GEM, ModItems.CRACKED_MAGENTA_AGATE_GEM, event);
		ModItems.registerGem(ModItems.LIGHT_BLUE_AGATE_GEM, ModItems.CRACKED_LIGHT_BLUE_AGATE_GEM, event);
		ModItems.registerGem(ModItems.YELLOW_AGATE_GEM, ModItems.CRACKED_YELLOW_AGATE_GEM, event);
		ModItems.registerGem(ModItems.LIME_AGATE_GEM, ModItems.CRACKED_LIME_AGATE_GEM, event);
		ModItems.registerGem(ModItems.PINK_AGATE_GEM, ModItems.CRACKED_PINK_AGATE_GEM, event);
		ModItems.registerGem(ModItems.GRAY_AGATE_GEM, ModItems.CRACKED_GRAY_AGATE_GEM, event);
		ModItems.registerGem(ModItems.LIGHT_GRAY_AGATE_GEM, ModItems.CRACKED_LIGHT_GRAY_AGATE_GEM, event);
		ModItems.registerGem(ModItems.CYAN_AGATE_GEM, ModItems.CRACKED_CYAN_AGATE_GEM, event);
		ModItems.registerGem(ModItems.PURPLE_AGATE_GEM, ModItems.CRACKED_PURPLE_AGATE_GEM, event);
		ModItems.registerGem(ModItems.BLUE_AGATE_GEM, ModItems.CRACKED_BLUE_AGATE_GEM, event);
		ModItems.registerGem(ModItems.BROWN_AGATE_GEM, ModItems.CRACKED_BROWN_AGATE_GEM, event);
		ModItems.registerGem(ModItems.GREEN_AGATE_GEM, ModItems.CRACKED_GREEN_AGATE_GEM, event);
		ModItems.registerGem(ModItems.RED_AGATE_GEM, ModItems.CRACKED_RED_AGATE_GEM, event);
		ModItems.registerGem(ModItems.BLACK_AGATE_GEM, ModItems.CRACKED_BLACK_AGATE_GEM, event);
		ModItems.registerGem(ModItems.HOLLY_BLUE_AGATE_GEM, ModItems.CRACKED_HOLLY_BLUE_AGATE_GEM, event);
		ModItems.registerGem(ModItems.AGATE_GEM, ModItems.CRACKED_AGATE_GEM, event);
		ModItems.registerGem(ModItems.AQUAMARINE_GEM, ModItems.CRACKED_AQUAMARINE_GEM, event);
		ModItems.registerGem(ModItems.HESSONITE_GEM, ModItems.CRACKED_HESSONITE_GEM, event);

		ModItems.registerGem(ModItems.SAPPHIRE_GEM, ModItems.CRACKED_SAPPHIRE_GEM, event);
		ModItems.registerGem(ModItems.WHITE_SAPPHIRE_GEM, ModItems.CRACKED_WHITE_SAPPHIRE_GEM, event);
		ModItems.registerGem(ModItems.ORANGE_SAPPHIRE_GEM, ModItems.CRACKED_ORANGE_SAPPHIRE_GEM, event);
		ModItems.registerGem(ModItems.YELLOW_SAPPHIRE_GEM, ModItems.CRACKED_YELLOW_SAPPHIRE_GEM, event);
		ModItems.registerGem(ModItems.PINK_SAPPHIRE_GEM, ModItems.CRACKED_PINK_SAPPHIRE_GEM, event);
		ModItems.registerGem(ModItems.PURPLE_SAPPHIRE_GEM, ModItems.CRACKED_PURPLE_SAPPHIRE_GEM, event);
		ModItems.registerGem(ModItems.BLUE_SAPPHIRE_GEM, ModItems.CRACKED_BLUE_SAPPHIRE_GEM, event);
		ModItems.registerGem(ModItems.GREEN_SAPPHIRE_GEM, ModItems.CRACKED_GREEN_SAPPHIRE_GEM, event);
		ModItems.registerGem(ModItems.BLACK_SAPPHIRE_GEM, ModItems.CRACKED_BLACK_SAPPHIRE_GEM, event);
		ModItems.registerGem(ModItems.PADPARADSCHA_GEM, ModItems.CRACKED_PADPARADSCHA_GEM, event);

		ModItems.registerGem(ModItems.TOPAZ_GEM, ModItems.CRACKED_TOPAZ_GEM, event);
		ModItems.registerGem(ModItems.BLUE_TOPAZ_GEM, ModItems.CRACKED_BLUE_TOPAZ_GEM, event);

		//Emerald Registers
		ModItems.registerGem(ModItems.EMERALD_GEM, ModItems.CRACKED_EMERALD_GEM, event);
	

		// registerGem(CITRINE_GEM, CRACKED_CITRINE_GEM,
		// event);
		// registerGem(AMETRINE_GEM, CRACKED_AMETRINE_GEM,
		// event);

		ModItems.registerGem(ModItems.WHITE_ZIRCON_GEM, ModItems.CRACKED_WHITE_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.ORANGE_ZIRCON_GEM, ModItems.CRACKED_ORANGE_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.MAGENTA_ZIRCON_GEM, ModItems.CRACKED_MAGENTA_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.LIGHT_BLUE_ZIRCON_GEM, ModItems.CRACKED_LIGHT_BLUE_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.YELLOW_ZIRCON_GEM, ModItems.CRACKED_YELLOW_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.LIME_ZIRCON_GEM, ModItems.CRACKED_LIME_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.PINK_ZIRCON_GEM, ModItems.CRACKED_PINK_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.GRAY_ZIRCON_GEM, ModItems.CRACKED_GRAY_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.LIGHT_GRAY_ZIRCON_GEM, ModItems.CRACKED_LIGHT_GRAY_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.CYAN_ZIRCON_GEM, ModItems.CRACKED_CYAN_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.PURPLE_ZIRCON_GEM, ModItems.CRACKED_PURPLE_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.BLUE_ZIRCON_GEM, ModItems.CRACKED_BLUE_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.BROWN_ZIRCON_GEM, ModItems.CRACKED_BROWN_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.GREEN_ZIRCON_GEM, ModItems.CRACKED_GREEN_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.RED_ZIRCON_GEM, ModItems.CRACKED_RED_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.BLACK_ZIRCON_GEM, ModItems.CRACKED_BLACK_ZIRCON_GEM, event);
		ModItems.registerGem(ModItems.ZIRCON_GEM, ModItems.CRACKED_ZIRCON_GEM, event);

		ModItems.registerGem(ModItems.RUTILE_GEM, ModItems.CRACKED_RUTILE_GEM, event);
		ModItems.registerGem(ModItems.TWIN_RUTILE_GEM, ModItems.CRACKED_TWIN_RUTILE_GEM, event);
		
		ModItems.registerGem(ModItems.YELLOW_DIAMOND_GEM, ModItems.CRACKED_YELLOW_DIAMOND_GEM, event);
		ModItems.registerGem(ModItems.BLUE_DIAMOND_GEM, ModItems.CRACKED_BLUE_DIAMOND_GEM, event);

		ModItems.registerGem(ModItems.HANDBODY_GEM, ModItems.CRACKED_HANDBODY_GEM, event);
		ModItems.registerGem(ModItems.FOOTARM_GEM, ModItems.CRACKED_FOOTARM_GEM, event);
		ModItems.registerGem(ModItems.MOUTHTORSO_GEM, ModItems.CRACKED_MOUTHTORSO_GEM, event);
		
		ModItems.registerGem(ModItems.CORRUPTED_AMETHYST_GEM, ModItems.CRACKED_CORRUPTED_AMETHYST_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_CARNELIAN_GEM, ModItems.CRACKED_CORRUPTED_CARNELIAN_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_JASPER_GEM, ModItems.CRACKED_CORRUPTED_JASPER_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_NOREENA_JASPER_GEM, ModItems.CRACKED_CORRUPTED_NOREENA_JASPER_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_OCEAN_JASPER_GEM, ModItems.CRACKED_CORRUPTED_OCEAN_JASPER_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_BIGGS_JASPER_GEM, ModItems.CRACKED_CORRUPTED_BIGGS_JASPER_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_GREEN_JASPER_GEM, ModItems.CRACKED_CORRUPTED_GREEN_JASPER_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_BRUNEAU_JASPER_GEM, ModItems.CRACKED_CORRUPTED_BRUNEAU_JASPER_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_PURPLE_JASPER_GEM, ModItems.CRACKED_CORRUPTED_PURPLE_JASPER_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_FLAME_JASPER_GEM, ModItems.CRACKED_CORRUPTED_FLAME_JASPER_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_PICTURE_JASPER_GEM, ModItems.CRACKED_CORRUPTED_PICTURE_JASPER_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_MOISSANITE_GEM, ModItems.CRACKED_CORRUPTED_MOISSANITE_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_ROSE_QUARTZ_GEM, ModItems.CRACKED_CORRUPTED_ROSE_QUARTZ_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_TONGUE_MONSTER_GEM, ModItems.CRACKED_CORRUPTED_TONGUE_MONSTER_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_BLUE_WATER_BEAR_GEM, ModItems.CRACKED_CORRUPTED_BLUE_WATER_BEAR_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_GREEN_WATER_BEAR_GEM, ModItems.CRACKED_CORRUPTED_GREEN_WATER_BEAR_GEM, event);
		ModItems.registerGem(ModItems.CORRUPTED_WATERMELON_TOURMALINE_GEM, ModItems.CRACKED_CORRUPTED_WATERMELON_TOURMALINE_GEM, event);
		
		ModItems.registerItem(ModItems.ACTIVATED_GEM_SHARD, event);
		ModItems.registerItem(ModItems.ACTIVATED_GEM_BASE, event);
		ModItems.registerItem(ModItems.INACTIVE_GEM_BASE, event);
		ModItems.registerItem(ModItems.TRANSFER_CONTRACT, event);
		ModItems.registerItem(ModItems.JOINT_CONTRACT, event);
		ModItems.registerItem(ModItems.LIBERATION_CONTRACT, event);
		ModItems.registerItem(ModItems.AUTONOMY_CONTRACT, event);
		ModItems.registerItem(ModItems.WAR_DECLARATION, event);
		ModItems.registerItem(ModItems.PEACE_TREATY, event);
		ModItems.registerItem(ModItems.GEM_STAFF, event);
		ModItems.registerItem(ModItems.COMMANDER_STAFF, event);
		ModItems.registerItem(ModItems.ROAMING_EYE, event);
		ModItems.registerItem(ModItems.LASER_BEAM, event);
		ModItems.registerItem(ModItems.WARP_WHISTLE, event);
		ModItems.registerItem(ModItems.STRAWBERRY_SLICE, event, "cropGiantStrawberry");
		OreDictionary.registerOre("cropStrawberry", ModItems.STRAWBERRY_SLICE);
		ModItems.registerItem(ModItems.STRAWBERRY_SEEDS, event, "seedGiantStrawberry");
		ModItems.registerItem(ModItems.TIME_GLASS, event);
		
	}
	public static void registerGem(ItemGem normal, ItemGem broken, RegistryEvent.Register<Item> event) {
		ModItems.GEM_TABLE.put(normal, broken);
		ModItems.GEM_TABLE.put(broken, normal);
		ModItems.registerItem(normal, event);
		ModItems.registerItem(broken, event);
	}
	public static void registerExternalGem(ItemGem normal, ItemGem broken, String prefix, RegistryEvent.Register<Item> event) {
		ModItems.GEM_TABLE.put(normal, broken);
		ModItems.GEM_TABLE.put(broken, normal);
		ModItems.registerExternalItem(normal, prefix, event);
		ModItems.registerExternalItem(broken, prefix, event);
	}

	public static void registerItem(Item item, RegistryEvent.Register<Item> event) {
		ModItems.registerItem(item, event, "");
	}

	// My custom item loading / register
	public static void registerItemndb(Item item, RegistryEvent.Register<Item> event) {
		ModItems.registerItemndb(item, event, "");
	}

	
	public static void registerItem(Item item, RegistryEvent.Register<Item> event, String oredictName) {
		// GameRegistry.register(item, new
		// ResourceLocation("kagic:" +
		// item.getUnlocalizedName().replaceFirst("item\\.|tile\\.",
		// "")));
		item.setRegistryName(new ResourceLocation("kagic:" + item.getUnlocalizedName().replaceFirst("item\\.|tile\\.", "")));
		event.getRegistry().register(item);

		if (!oredictName.isEmpty()) {
			OreDictionary.registerOre(oredictName, item);
		}
	
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}

	public static void registerItemndb(Item item, RegistryEvent.Register<Item> event, String oredictName) {
		// GameRegistry.register(item, new
		// ResourceLocation("kagic:" +
		// item.getUnlocalizedName().replaceFirst("item\\.|tile\\.",
		// "")));
		item.setRegistryName(new ResourceLocation("ndbkagic:" + item.getUnlocalizedName().replaceFirst("item\\.|tile\\.", "")));
		event.getRegistry().register(item);

		if (!oredictName.isEmpty()) {
			OreDictionary.registerOre(oredictName, item);
		}
	
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}

	public static void registerExternalItem(Item item, String prefix, RegistryEvent.Register<Item> event) {
		ModItems.registerExternalItem(item, prefix, event, "");
	}

	public static void registerExternalItem(Item item, String prefix, RegistryEvent.Register<Item> event, String oredictName) {
		// GameRegistry.register(item, new
		// ResourceLocation(prefix + ":" +
		// item.getUnlocalizedName().replaceFirst("item\\.|tile\\.",
		// "")));
		item.setRegistryName(new ResourceLocation(prefix + ":" + item.getUnlocalizedName().replaceFirst("item\\.|tile\\.", "")));
		event.getRegistry().register(item);

		if (!oredictName.isEmpty()) {
			OreDictionary.registerOre(oredictName, item);
		}
		
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
		
	}
}
