package mod.kagic.init;

import mod.kagic.tileentity.TileEntityMoonGoddessBeaconRender;
import mod.kagic.tileentity.TileEntityMoonGoddessStatue;
import mod.kagic.tileentity.TileEntityWarpPadCore;
import mod.kagic.tileentity.WarpRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ModTESRs {
	public static void register() {
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWarpPadCore.class, new WarpRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMoonGoddessStatue.class, new TileEntityMoonGoddessBeaconRender());
	}
}
