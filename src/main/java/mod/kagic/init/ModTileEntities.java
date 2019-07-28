package mod.kagic.init;

import mod.kagic.tileentity.TileEntityGalaxyPadCore;
import mod.kagic.tileentity.TileEntityIncubator;
import mod.kagic.tileentity.TileEntityMoonGoddessStatue;
import mod.kagic.tileentity.TileEntityWarpPadCore;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
	public static void register() {
		GameRegistry.registerTileEntity(TileEntityIncubator.class, "kagic:incubator");
		GameRegistry.registerTileEntity(TileEntityWarpPadCore.class, "kagic:warp_pad_core");
		GameRegistry.registerTileEntity(TileEntityGalaxyPadCore.class, "kagic:galaxy_pad_core");
		GameRegistry.registerTileEntity(TileEntityMoonGoddessStatue.class, "kagic:moon_goddess_statue");
	}
}
