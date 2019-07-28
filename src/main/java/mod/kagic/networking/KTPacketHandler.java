package mod.kagic.networking;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class KTPacketHandler {
	private static int packetID = 0;
	public static SimpleNetworkWrapper INSTANCE = null;

	public static int nextID() {
		return KTPacketHandler.packetID++;
	}

	public static void registerMessages(String channelName) {
		KTPacketHandler.INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
		KTPacketHandler.registerMessages();
	}

	public static void registerMessages() {
		KTPacketHandler.INSTANCE.registerMessage(TENameMessage.TENameMessageHandler.class, TENameMessage.class, KTPacketHandler.nextID(), Side.SERVER);
		KTPacketHandler.INSTANCE.registerMessage(PadDataRequestMessage.PadDataRequestMessageHandler.class, PadDataRequestMessage.class, KTPacketHandler.nextID(), Side.SERVER);
		KTPacketHandler.INSTANCE.registerMessage(PadDataMessage.PadDataMessageHandler.class, PadDataMessage.class, KTPacketHandler.nextID(), Side.CLIENT);
		KTPacketHandler.INSTANCE.registerMessage(WarpSignalMessage.WarpSignalMessageHandler.class, WarpSignalMessage.class, KTPacketHandler.nextID(), Side.SERVER);
		KTPacketHandler.INSTANCE.registerMessage(EntityTeleportMessage.EntityTeleportMessageHandler.class, EntityTeleportMessage.class, KTPacketHandler.nextID(), Side.CLIENT);
		KTPacketHandler.INSTANCE.registerMessage(GalaxySignalMessage.GalaxySignalMessageHandler.class, GalaxySignalMessage.class, KTPacketHandler.nextID(), Side.SERVER);
	}
}
