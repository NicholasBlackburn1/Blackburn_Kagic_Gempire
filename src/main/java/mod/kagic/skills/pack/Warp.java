package mod.kagic.skills.pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

import mod.kagic.entity.EntityGem;
import mod.kagic.init.KAGIC;
import mod.kagic.skills.Speak;
import mod.kagic.tileentity.TileEntityGalaxyPadCore;
import mod.kagic.tileentity.TileEntityWarpPadCore;
import mod.kagic.worlddata.GalaxyPadLocation;
import mod.kagic.worlddata.WarpPadDataEntry;
import mod.kagic.worlddata.WorldDataGalaxyPad;
import mod.kagic.worlddata.WorldDataWarpPad;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;

public class Warp extends Speak<EntityGem> {
	public Warp() {
		this.TRIGGER_VERBS = new ArrayList<String>(Arrays.asList(new String[] { 
			"warp",
			"go"
		}));
		this.TRIGGER_NOUNS = new ArrayList<String>();
		this.can(RunWith.LOOKING);
		this.priority(Priority.LOW);
		this.task(false);
	}
	@Override
	public boolean proceed(EntityGem gem) {
		TileEntityWarpPadCore pad = TileEntityWarpPadCore.getEntityPad(gem);
		if (pad != null && pad.isValidPad() && !pad.isWarping()) {
			return true;
		}
		return false;
	}
	@Override
	public void init(EntityGem gem) {
		TileEntityWarpPadCore pad = TileEntityWarpPadCore.getEntityPad(gem);
		if (pad != null && pad.isValidPad() && !pad.isWarping()) {
			if (!pad.isValid()) {
				gem.feedback(this.commandingPlayer, new TextComponentTranslation("notify.kagic.padnotvalid").getUnformattedComponentText());
				return;
			}
			if (!pad.isClear()) {
				gem.feedback(this.commandingPlayer, new TextComponentTranslation("notify.kagic.padnotclear").getUnformattedComponentText());
				return;
			}
			if (this.entireMessage.toLowerCase().contains(pad.name.toLowerCase())) {
				gem.feedback(this.commandingPlayer, new TextComponentTranslation("notify.kagic.alreadyhere").getUnformattedComponentText());
				return;
			}
			
			if (pad instanceof TileEntityGalaxyPadCore) {
				Map<GalaxyPadLocation, WarpPadDataEntry> padData = WorldDataGalaxyPad.get(gem.world).getGalaxyPadData();
				SortedMap<Double, GalaxyPadLocation> sortedPoses = WorldDataGalaxyPad.getSortedPositions(padData, pad.getPos());
				Iterator<GalaxyPadLocation> it = sortedPoses.values().iterator();
				while (it.hasNext()) {
					GalaxyPadLocation dest = (GalaxyPadLocation) it.next();
					WarpPadDataEntry data = padData.get(dest);
					if (this.entireMessage.toLowerCase().contains(data.name.toLowerCase())) {
						if (!data.valid) {
							gem.feedback(this.commandingPlayer, new TextComponentTranslation("notify.kagic.destnotvalid").getUnformattedComponentText());
							return;
						}
						if (!data.clear) {
							gem.feedback(this.commandingPlayer, new TextComponentTranslation("notify.kagic.destnotclear").getUnformattedComponentText());
							return;
						}
						gem.feedback(this.commandingPlayer, new TextComponentTranslation("notify.kagic.warping", data.name).getUnformattedComponentText());
						gem.playObeySound();
						((TileEntityGalaxyPadCore) pad).beginWarp(dest);
						return;
					}
				}
			}
			else {
				Map<BlockPos, WarpPadDataEntry> padData = WorldDataWarpPad.get(gem.world).getWarpPadData();
				SortedMap<Double, BlockPos> sortedPoses = WorldDataWarpPad.getSortedPositions(padData, pad.getPos());
				Iterator<BlockPos> it = sortedPoses.values().iterator();
				while (it.hasNext()) {
					BlockPos pos = (BlockPos) it.next();
					WarpPadDataEntry data = padData.get(pos);
					if (this.entireMessage.toLowerCase().contains(data.name.toLowerCase())) {
						TileEntityWarpPadCore dest = (TileEntityWarpPadCore) gem.getEntityWorld().getTileEntity(pos);
						if (!dest.isValid()) {
							gem.feedback(this.commandingPlayer, new TextComponentTranslation("notify.kagic.destnotvalid").getUnformattedComponentText());
							return;
						}
						if (!dest.isClear()) {
							gem.feedback(this.commandingPlayer, new TextComponentTranslation("notify.kagic.destnotclear").getUnformattedComponentText());
							return;
						}
						gem.feedback(this.commandingPlayer, new TextComponentTranslation("notify.kagic.warping", data.name).getUnformattedComponentText());
						gem.playObeySound();
						pad.beginWarp(pos);
						return;
					}
				}
			}
			gem.feedback(this.commandingPlayer, new TextComponentTranslation("notify.kagic.nopad", "this").getUnformattedComponentText());
		}
	}
	@Override
	public String toString() {
		return "warping";
	}
}
