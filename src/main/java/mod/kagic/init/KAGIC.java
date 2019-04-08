package mod.kagic.init;

import java.io.InputStream;
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
import mod.kagic.entity.EntityCrystalSkills;
import mod.kagic.entity.gem.fusion.FusionSpawnHandler;
import mod.kagic.networking.KTPacketHandler;
import mod.kagic.proxies.CommonProxy;
import mod.kagic.server.SpaceStuff;
import mod.kagic.skills.SkillBase;
import mod.kagic.skills.pack.AlignGems;
import mod.kagic.skills.pack.BreedLivestock;
import mod.kagic.skills.pack.BuildBox;
import mod.kagic.skills.pack.BuildBridge;
import mod.kagic.skills.pack.BuildRamp;
import mod.kagic.skills.pack.BuildStairs;
import mod.kagic.skills.pack.BuildTower;
import mod.kagic.skills.pack.BuildWall;
import mod.kagic.skills.pack.CollectLiquids;
import mod.kagic.skills.pack.Come;
import mod.kagic.skills.pack.CutDownTrees;
import mod.kagic.skills.pack.Defend;
import mod.kagic.skills.pack.DumpChestsBismuth;
import mod.kagic.skills.pack.DumpChestsLapis;
import mod.kagic.skills.pack.DumpChestsPearl;
import mod.kagic.skills.pack.DumpChestsPeridot;
import mod.kagic.skills.pack.FetchChestsBismuth;
import mod.kagic.skills.pack.FetchChestsPearl;
import mod.kagic.skills.pack.Follow;
import mod.kagic.skills.pack.FuseTopaz;
import mod.kagic.skills.pack.GetFacet;
import mod.kagic.skills.pack.GetHealth;
import mod.kagic.skills.pack.GetSkills;
import mod.kagic.skills.pack.Harvest;
import mod.kagic.skills.pack.HarvestAndReplant;
import mod.kagic.skills.pack.HarvestAndReplantNetherWart;
import mod.kagic.skills.pack.HarvestCacti;
import mod.kagic.skills.pack.HarvestMelons;
import mod.kagic.skills.pack.HarvestNetherWart;
import mod.kagic.skills.pack.HarvestPumpkins;
import mod.kagic.skills.pack.HarvestReeds;
import mod.kagic.skills.pack.KillOtherEntities;
import mod.kagic.skills.pack.Look;
import mod.kagic.skills.pack.MilkCows;
import mod.kagic.skills.pack.Mine;
import mod.kagic.skills.pack.MowGrass;
import mod.kagic.skills.pack.PickFlowers;
import mod.kagic.skills.pack.PlantSaplingsBismuth;
import mod.kagic.skills.pack.PlantSaplingsPearl;
import mod.kagic.skills.pack.PlantSaplingsPeridot;
import mod.kagic.skills.pack.SingSong;
import mod.kagic.skills.pack.Stop;
import mod.kagic.skills.pack.TameCats;
import mod.kagic.skills.pack.TameDogs;
import mod.kagic.skills.pack.TameHorses;
import mod.kagic.skills.pack.TameParrots;
import mod.kagic.skills.pack.TellFuture;
import mod.kagic.skills.pack.TellFutureGarnet;
import mod.kagic.skills.pack.TellReport;
import mod.kagic.skills.pack.UnfuseTopaz;
import mod.kagic.skills.pack.Warp;
import mod.kagic.util.GemPlayerLoot;
import mod.kagic.world.CorruptedGemSpawner;
import mod.kagic.world.Fogger;
import mod.kagic.world.GenEventCanceller;
import mod.kagic.world.KAGICWorldGenerator;
import mod.kagic.world.structure.LootTables;
import net.minecraft.crash.CrashReport;
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
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

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
    
    public static SentenceModel sentModel;
    public static SentenceDetectorME sentDetector;
    public static POSModel posModel;
    public static POSTaggerME posTagger;

    static {
    	FluidRegistry.enableUniversalBucket();
    }
    
    @SidedProxy(clientSide = "mod.kagic.proxies.ClientProxy", serverSide = "mod.kagic.proxies.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	logger = e.getModLog();
        //ModBiomes.register();
        //ModDimensions.register();
        KAGICSmeltingRecipes.register();
		KTPacketHandler.registerMessages(KAGIC.MODID);
		ForgeChunkManager.setForcedChunkLoadingCallback(instance, new KAGICChunkCallback());
		LootTables.register();
		KAGIC.worldGen = new KAGICWorldGenerator();
		try {
    		InputStream input = null;
    		input = this.getClass().getClassLoader().getResourceAsStream("assets/kagic/lang/processing/en-sent.bin");
    		KAGIC.sentModel = new SentenceModel(input);
    		KAGIC.sentDetector = new SentenceDetectorME(KAGIC.sentModel);
    		input = this.getClass().getClassLoader().getResourceAsStream("assets/kagic/lang/processing/en-pos-perceptron.bin");
    		KAGIC.posModel = new POSModel(input);
    		KAGIC.posTagger = new POSTaggerME(KAGIC.posModel);
    	}
    	catch (Exception ex) {
    		CrashReport.makeCrashReport(ex, "Something went wrong loading OpenNLP.");
    	}
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	ModEntities.register();
    	ModEvents.register();
    	ModTileEntities.register();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new KTGUIProxy());
		if (e.getSide() == Side.CLIENT) {
			ModTESRs.register();
			MinecraftForge.EVENT_BUS.register(new Fogger());
		}
		GameRegistry.registerWorldGenerator(worldGen, 50);
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
    public void postInit(FMLPostInitializationEvent e) {
    	ModEntities.registerGemYields();
		KAGIC.addSkill(AlignGems.class);
    	KAGIC.addSkill(BreedLivestock.class);
    	KAGIC.addSkill(BuildBox.class);
		KAGIC.addSkill(BuildBridge.class);
		KAGIC.addSkill(BuildStairs.class);
		KAGIC.addSkill(BuildTower.class);
		KAGIC.addSkill(BuildWall.class);
		KAGIC.addSkill(BuildRamp.class);
		KAGIC.addSkill(CollectLiquids.class);
		KAGIC.addSkill(Come.class);
		KAGIC.addSkill(CutDownTrees.class);
		KAGIC.addSkill(Defend.class);
		KAGIC.addSkill(DumpChestsBismuth.class);
		KAGIC.addSkill(DumpChestsLapis.class);
		KAGIC.addSkill(DumpChestsPearl.class);
		KAGIC.addSkill(DumpChestsPeridot.class);
		KAGIC.addSkill(FetchChestsBismuth.class);
		KAGIC.addSkill(FetchChestsPearl.class);
		KAGIC.addSkill(Follow.class);
		KAGIC.addSkill(FuseTopaz.class);
		KAGIC.addSkill(GetFacet.class);
		KAGIC.addSkill(GetHealth.class);
		KAGIC.addSkill(GetSkills.class);
		KAGIC.addSkill(Harvest.class);
		KAGIC.addSkill(HarvestAndReplant.class);
		KAGIC.addSkill(HarvestAndReplantNetherWart.class);
		KAGIC.addSkill(HarvestCacti.class);
		KAGIC.addSkill(HarvestMelons.class);
		KAGIC.addSkill(HarvestNetherWart.class);
		KAGIC.addSkill(HarvestPumpkins.class);
		KAGIC.addSkill(HarvestReeds.class);
		KAGIC.addSkill(KillOtherEntities.class);
		KAGIC.addSkill(Look.class);
		KAGIC.addSkill(MilkCows.class);
		KAGIC.addSkill(Mine.class);
		KAGIC.addSkill(MowGrass.class);
		KAGIC.addSkill(PickFlowers.class);
		KAGIC.addSkill(PlantSaplingsBismuth.class);
		KAGIC.addSkill(PlantSaplingsPearl.class);
		KAGIC.addSkill(PlantSaplingsPeridot.class);
		KAGIC.addSkill(SingSong.class);
		KAGIC.addSkill(Stop.class);
		KAGIC.addSkill(TameCats.class);
		KAGIC.addSkill(TameDogs.class);
		KAGIC.addSkill(TameHorses.class);
		KAGIC.addSkill(TameParrots.class);
		KAGIC.addSkill(TellFuture.class);
		KAGIC.addSkill(TellFutureGarnet.class);
		KAGIC.addSkill(TellReport.class);
		KAGIC.addSkill(UnfuseTopaz.class);
		KAGIC.addSkill(Warp.class);
    }
    
    @EventHandler
	public void serverStarting(FMLServerStartingEvent e) {
    	/*if (FMLCommonHandler.instance().getSide() == Side.SERVER) {
	    	try {
	    		ModMetrics.sendMetrics();
	    	}
	    	catch (Exception x) {
	    		x.printStackTrace();
	    	}
    	}*/
    	e.registerServerCommand(new CommandDestroyGem());
    	e.registerServerCommand(new CommandMeteorRuby());
		e.registerServerCommand(new CommandSpawnGems());
		e.registerServerCommand(new CommandScanGems());
	}
    
    //Used for debugging
	public void chatInfoMessage(String message) {
		if (DEVELOPER /*&& FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER*/) {
			PlayerList list = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList();
			logger.info(message);
			list.sendMessage(new TextComponentString(message));
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
    	return KAGIC.isDayToday(1, 17) || KAGIC.isDayToday(10, 24) || KAGIC.isDayToday(10, 22);
    }

    public static boolean isBirthdayTomorrow() {
    	return KAGIC.isDayToday(1, 16) || KAGIC.isDayToday(10, 23) || KAGIC.isDayToday(10, 21);
    }
	public static void addSkill(Class<? extends SkillBase> skillToAdd) {
		EntityCrystalSkills.SKILLS.add(skillToAdd);
	}
}