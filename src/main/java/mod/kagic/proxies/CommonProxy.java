package mod.kagic.proxies;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import mod.kagic.advancements.ModTriggers;
import mod.kagic.crafting.RepairGemsRecipes;
import mod.kagic.init.KAGIC;
import mod.kagic.init.ModBiomes;
import mod.kagic.init.ModBlocks;
import mod.kagic.init.ModEnchantments;
import mod.kagic.init.ModItems;
import mod.kagic.init.ModSounds;
import mod.kagic.worlddata.GalaxyPadLocation;
import mod.kagic.worlddata.WarpPadDataEntry;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {

	

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		ModBlocks.registerBlocks(event);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		ModBlocks.registerBlockItems(event);
		ModItems.registerItems(event);
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		ModSounds.registerSounds(event);
	}

	@SubscribeEvent
	public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
		ModEnchantments.registerEnchantments(event);
	}

	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		
		ModBiomes.register(event);
	}

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		final IForgeRegistry<IRecipe> registry = ForgeRegistries.RECIPES;
		registry.register(new RepairGemsRecipes());
	}

	public void registerStateMappers() {
		
	}

	public void registerBlockColors() {

	}

	@SubscribeEvent
	public static void changeConfigs(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(KAGIC.MODID)) {
			ConfigManager.sync(KAGIC.MODID, Config.Type.INSTANCE);
		}
	}

	public void openWarpPadSelectionGUI(LinkedHashMap<BlockPos, WarpPadDataEntry> padData, int x, int y, int z) {
		
	}
	
	public void openGalaxyPadSelectionGUI(LinkedHashMap<GalaxyPadLocation, WarpPadDataEntry> padData, int x, int y, int z) {
		
	}
}
