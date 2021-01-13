package mod.kagic.networking;

import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

public final class NetworkHandler {

	//TODO split this into separate GUI handlers for separate mods. Also rename to something that says it's guihandler

	public static final String CHANNELNAME = "AWCORE";
	public static final NetworkHandler INSTANCE = new NetworkHandler();

	//public static final int PACKET_TEST = 0;//unused id
	private static final int PACKET_GUI = 1;
	public static final int PACKET_STRUCTURE = 2;
	private static final int PACKET_ITEM_KEY_INTERFACE = 3;
	private static final int PACKET_ENTITY = 5;
	private static final int PACKET_RESEARCH_INIT = 6;
	private static final int PACKET_RESEARCH_ADD = 7;
	private static final int PACKET_RESEARCH_START = 8;
	//public static final int PACKET_STRUCTURE_IMAGE_LIST = 9;//unused
	//public static final int PACKET_STRUCTURE_IMAGE_DATA = 10;//unused
	public static final int PACKET_STRUCTURE_REMOVE = 11;
	public static final int PACKET_NPC_COMMAND = 12;
	public static final int PACKET_FACTION_UPDATE = 13;
	private static final int PACKET_BLOCK_EVENT = 14;

	public static final int PACKET_AIM_UPDATE = 15;
	public static final int PACKET_AMMO_SELECT = 16;
	public static final int PACKET_AMMO_UPDATE = 17;
	public static final int PACKET_FIRE_UPDATE = 18;
	public static final int PACKET_PACK_COMMAND = 19;
	public static final int PACKET_SINGLE_AMMO_UPDATE = 20;
	public static final int PACKET_TURRET_ANGLES_UPDATE = 21;
	public static final int PACKET_UPGRADE_UPDATE = 22;
	public static final int PACKET_VEHICLE_INPUT = 23;
	public static final int PACKET_VEHICLE_MOVE = 24;

	private static final int PACKET_JEI_TRANSFER_RECIPE = 25;

	private static final int PACKET_MANUAL_RELOAD = 26;

	public static final int PACKET_EXTENDED_REACH_ATTACK = 27;

	public static final int PACKET_STRUCTURE_MAP = 28;
	public static final int PACKET_STRUCTURE_ENTRY = 29;

	public static final int PACKET_SOUND_BLOCK_PLAYER_SPEC_VALUES = 30;

	public static final int PACKET_TEAM_MEMBERSHIP_UPDATE = 31;
	public static final int PACKET_TEAM_STANDINGS_UPDATE = 32;
	public static final int PACKET_TEAM_STANDING_UPDATE = 33;

	public static final int PACKET_HIGHLIGHT_BLOCK = 34;
	public static final int PACKET_SHOW_BBS = 35;
	public static final int PACKET_ITEM_MOUSE_SCROLL = 36;

	public static final int GUI_CRAFTING = 0;
	public static final int GUI_SCANNER = 1;
	public static final int GUI_BUILDER = 2;
	public static final int GUI_NPC_INVENTORY = 4;
	public static final int GUI_WORKSITE_INVENTORY_SIDE_ADJUST = 5;
	public static final int GUI_NPC_TRADE_ORDER = 6;
	public static final int GUI_SPAWNER_ADVANCED = 7;
	public static final int GUI_SPAWNER_ADVANCED_BLOCK = 8;
	public static final int GUI_SPAWNER_ADVANCED_INVENTORY = 9;
	public static final int GUI_SPAWNER_ADVANCED_BLOCK_INVENTORY = 10;
	public static final int GUI_GATE_CONTROL = 11;
	public static final int GUI_RESEARCH_STATION = 12;
	public static final int GUI_DRAFTING_STATION = 13;
	public static final int GUI_WORKSITE_ANIMAL_CONTROL = 14;
	public static final int GUI_WORKSITE_AUTO_CRAFT = 15;
	public static final int GUI_WORKSITE_FISH_CONTROL = 16;
	public static final int GUI_MAILBOX_INVENTORY = 17;
	public static final int GUI_WAREHOUSE_CONTROL = 18;
	public static final int GUI_WAREHOUSE_STORAGE = 19;
	public static final int GUI_WAREHOUSE_STOCK = 20;
	public static final int GUI_WAREHOUSE_OUTPUT = 21;
	public static final int GUI_WAREHOUSE_CRAFTING = 22;
	public static final int GUI_CHUNK_LOADER_DELUXE = 23;
	public static final int GUI_WORKSITE_QUARRY = 24;
	public static final int GUI_WORKSITE_TREE_FARM = 25;
	public static final int GUI_WORKSITE_ANIMAL_FARM = 26;
	public static final int GUI_WORKSITE_CROP_FARM = 27;
	public static final int GUI_WORKSITE_FISH_FARM = 29;
	public static final int GUI_WORKSITE_QUARRY_BOUNDS = 30;
	public static final int GUI_STIRLING_GENERATOR = 31;
	public static final int GUI_WAREHOUSE_STOCK_LINKER = 32;
	public static final int GUI_NPC_WORK_ORDER = 34;
	public static final int GUI_NPC_UPKEEP_ORDER = 35;
	public static final int GUI_NPC_COMBAT_ORDER = 36;
	public static final int GUI_NPC_ROUTING_ORDER = 37;
	public static final int GUI_NPC_FACTION_TRADE_SETUP = 39;
	public static final int GUI_BACKPACK = 40;
	public static final int GUI_NPC_TOWN_HALL = 41;
	public static final int GUI_NPC_FACTION_TRADE_VIEW = 42;
	public static final int GUI_NPC_BARD = 43;
	public static final int GUI_NPC_CREATIVE = 44;
	public static final int GUI_RESEARCH_BOOK = 45;
	public static final int GUI_WORKSITE_BOUNDS = 46;
	public static final int GUI_NPC_PLAYER_OWNED_TRADE = 47;
	public static final int GUI_SOUND_BLOCK = 48;
	public static final int GUI_NPC_FACTION_BARD = 49;

	public static final int GUI_VEHICLE_AMMO_SELECTION = 50;
	public static final int GUI_VEHICLE_INVENTORY = 51;
	public static final int GUI_VEHICLE_STATS = 52;

	public static final int GUI_WORKSITE_FRUIT_FARM = 53;

	public static final int GUI_TOWN_BUILDER = 54;
	public static final int GUI_LOOT_CHEST_PLACER = 55;
	public static final int GUI_MANUAL = 56;
	public static final int GUI_INFO_TOOL = 57;

	public static final int GUI_GATE_CONTROL_CREATIVE = 58;

	public static final int GUI_LOOT_BASKET = 59;
	public static final int GUI_STAKE = 60;
	public static final int GUI_STATUE = 61;
	public static final int GUI_NPC_FACTION_SPELLCASTER_WIZARDRY = 62;

	private FMLEventChannel channel;


	public final void registerNetwork() {
		channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(CHANNELNAME);
		channel.register(new PacketHandler());
		PacketBase.registerPacketType(PACKET_EXTENDED_REACH_ATTACK, PacketExtendedReachAttack.class, PacketExtendedReachAttack::new);
	
		
	}

	public static void sendToServer(PacketBase pkt) {
		INSTANCE.channel.sendToServer(pkt.getFMLPacket());
	}

	public static void sendToPlayer(EntityPlayerMP player, PacketBase pkt) {
		INSTANCE.channel.sendTo(pkt.getFMLPacket(), player);
	}

	public static void sendToAllPlayers(PacketBase pkt) {
		//noinspection ConstantConditions
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER && FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList() != null) {
			INSTANCE.channel.sendToAll(pkt.getFMLPacket());
		}
	}

	public static void sendToAllTracking(Entity e, PacketBase pkt) {
		WorldServer server = (WorldServer) e.world;
		server.getEntityTracker().sendToTracking(e, pkt.getFMLPacket());
	}

	/*
	 * @param world (must be instanceof be WorldServer)
     * @param cx    chunkX
     * @param cz    chunkZ
     * @param pkt   the packet
     */

	public static void sendToAllTrackingChunk(World world, int cx, int cz, PacketBase pkt) {
		WorldServer server = (WorldServer) world;
		for (EntityPlayer p : server.playerEntities) {
			if (server.getPlayerChunkMap().isPlayerWatchingChunk((EntityPlayerMP) p, cx, cz)) {
				sendToPlayer((EntityPlayerMP) p, pkt);
			}
		}
	}
}