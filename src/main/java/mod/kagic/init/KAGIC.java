package mod.kagic.init;

import java.util.Calendar;

import org.apache.logging.log4j.Logger;

import mod.kagic.chunk.KAGICChunkCallback;
import mod.kagic.client.gui.KTGUIProxy;
import mod.kagic.command.CommandDestroyGem;
import mod.kagic.command.CommandMeteorRuby;
import mod.kagic.command.CommandScanGems;
import mod.kagic.command.CommandSpawnGems;
import mod.kagic.crafting.KAGICSmeltingRecipes;
import mod.kagic.dispenser.DispenserBehaviors;
import mod.kagic.entity.gem.fusion.FusionSpawnHandler;
import mod.kagic.networking.KTPacketHandler;
import mod.kagic.proxies.CommonProxy;
import mod.kagic.server.SpaceStuff;
import mod.kagic.util.GemPlayerLoot;
import mod.kagic.world.CorruptedGemSpawner;
import mod.kagic.world.Fogger;
import mod.kagic.world.GenEventCanceller;
import mod.kagic.world.KAGICWorldGenerator;
import mod.kagic.world.structure.LootTables;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = KAGIC.MODID, version = KAGIC.VERSION, acceptedMinecraftVersions = KAGIC.MCVERSION)
public class KAGIC {
	public static final String MODID = "kagic";
	public static final String VERSION = "@version";
	public static final String MCVERSION = "@mcversion";
	public static final boolean DEVELOPER = true;
	
	public static Logger logger;
	
	@Instance
	public static KAGIC instance;
	public static SpaceStuff spaceStuff;
	public static KAGICWorldGenerator worldGen;
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@SidedProxy(clientSide = "mod.kagic.proxies.ClientProxy", serverSide = "mod.kagic.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		KAGIC.logger = e.getModLog();
		//ModBiomes.register();
		ModDimensions.register();
		KAGICSmeltingRecipes.register();
		KTPacketHandler.registerMessages(KAGIC.MODID);
		ForgeChunkManager.setForcedChunkLoadingCallback(KAGIC.instance, new KAGICChunkCallback());
		LootTables.register();
		KAGIC.worldGen = new KAGICWorldGenerator();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		ModEntities.register();
		ModEvents.register();
		ModTileEntities.register();
		NetworkRegistry.INSTANCE.registerGuiHandler(KAGIC.instance, new KTGUIProxy());
		if (e.getSide() == Side.CLIENT) {
			ModTESRs.register();
			MinecraftForge.EVENT_BUS.register(new Fogger());
		}
		GameRegistry.registerWorldGenerator(KAGIC.worldGen, 50);
		GenEventCanceller genCanceller = new GenEventCanceller();
		MinecraftForge.EVENT_BUS.register(genCanceller);
		MinecraftForge.TERRAIN_GEN_BUS.register(genCanceller);
		MinecraftForge.EVENT_BUS.register(new FusionSpawnHandler());
		MinecraftForge.EVENT_BUS.register(new CorruptedGemSpawner());
		MinecraftForge.EVENT_BUS.register(new OreDictListener());
		MinecraftForge.EVENT_BUS.register(new GemPlayerLoot());
		DispenserBehaviors.register();
		KAGIC.proxy.registerBlockColors();
	}
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent e) {
		/*
		 * if (FMLCommonHandler.instance().getSide() ==
		 * Side.SERVER) { try { ModMetrics.sendMetrics(); }
		 * catch (Exception x) { x.printStackTrace(); } }
		 */
		e.registerServerCommand(new CommandDestroyGem());
		e.registerServerCommand(new CommandMeteorRuby());
		e.registerServerCommand(new CommandSpawnGems());
		e.registerServerCommand(new CommandScanGems());
	}
	
	// Used for debugging
	public void chatInfoMessage(String message) {
		if (KAGIC.DEVELOPER) {
			
			KAGIC.logger.info(message);
			
		}
	}
	
	public static boolean isDayToday(int month, int day) {
		boolean sameMonth = Calendar.getInstance().get(Calendar.MONTH) == month - 1;
		boolean sameDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == day;
		return sameMonth && sameDay;
	}
	
	public static boolean isFireworksDay() {
		return KAGIC.isDayToday(1, 1) || KAGIC.isDayToday(3, 21) || KAGIC.isDayToday(7, 4);
	}
	
	public static boolean isHalloween() {
		for (int day = 25; day <= 31; ++day) {
			if (KAGIC.isDayToday(10, day)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isAprilFools() {
		return KAGIC.isDayToday(4, 1);
	}
	
	public static boolean isChristmas() {
		for (int day = 24; day <= 31; ++day) {
			if (KAGIC.isDayToday(12, day)) {
				return true;
			}
		}
		for (int day = 1; day <= 5; ++day) {
			if (KAGIC.isDayToday(1, day)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isBirthday() {
		return KAGIC.isDayToday(1, 17) || KAGIC.isDayToday(10, 24) || KAGIC.isDayToday(10, 22) || KAGIC.isDayToday(12, 06);
	}
	
	public static boolean isBirthdayTomorrow() {
		return KAGIC.isDayToday(1, 16) || KAGIC.isDayToday(10, 23) || KAGIC.isDayToday(10, 21);
	}
}