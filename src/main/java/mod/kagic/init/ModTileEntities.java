package mod.kagic.init;

import mod.kagic.tileentity.TileEntityGalaxyPadCore;
import mod.kagic.tileentity.TileEntityIncubator;
import mod.kagic.tileentity.TileEntityMoonGoddessStatue;
import mod.kagic.tileentity.TileEntityWarpPadCore;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
	public static void register() {
		GameRegistry.registerTileEntity(TileEntityIncubator.class, "ndbkagic:incubator");
		GameRegistry.registerTileEntity(TileEntityWarpPadCore.class, "ndbkagic:warp_pad_core");
		GameRegistry.registerTileEntity(TileEntityGalaxyPadCore.class, "ndbkagic:galaxy_pad_core");
		GameRegistry.registerTileEntity(TileEntityMoonGoddessStatue.class, "ndbkagic:moon_goddess_statue");
	}
}
