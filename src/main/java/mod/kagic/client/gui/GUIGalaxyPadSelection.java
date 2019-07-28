package mod.kagic.client.gui;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;

import mod.kagic.tileentity.TileEntityWarpPadCore;
import mod.kagic.worlddata.GalaxyPadLocation;
import mod.kagic.worlddata.WarpPadDataEntry;
import mod.kagic.worlddata.WorldDataGalaxyPad;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.math.BlockPos;

public class GUIGalaxyPadSelection extends GuiScreen {
	private final TileEntityWarpPadCore tilePad;
	private Map<GalaxyPadLocation, WarpPadDataEntry> padData = null;
	private SortedMap<Double, GalaxyPadLocation> sortedPoses;
	private GUIGalaxyPadList padList;
	private GuiButton buttonDone;
	protected String screenTitle = "Select Destination";

	public GUIGalaxyPadSelection(LinkedHashMap<GalaxyPadLocation, WarpPadDataEntry> data, int x, int y, int z) {
		// KAGICTech.instance.chatInfoMessage("Getting Warp
		// Pad TE at " + x + ", " + y + ", " + z);
		this.tilePad = (TileEntityWarpPadCore) Minecraft.getMinecraft().world.getTileEntity(new BlockPos(x, y, z));
		this.padData = data;
		// KAGICTech.instance.chatInfoMessage("padData has
		// size of " + padData.size());
		this.sortedPoses = WorldDataGalaxyPad.getSortedPositions(this.padData, this.tilePad.getPos());
	}

	public WarpPadDataEntry getPadDataEntry(GalaxyPadLocation gLoc) {
		if (this.padData.containsKey(gLoc)) {
			return this.padData.get(gLoc);
		} else {
			return null;
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void updateScreen() {
	}
	
	@Override
	public void initGui() {
		this.padList = new GUIGalaxyPadList(this, this.tilePad.getPos(), this.sortedPoses, this.mc, this.width, this.height, 0, this.height, 50);
		this.buttonDone = this.addButton(new GuiButton(618, this.width / 2 - 75, this.height - 25, 150, 20, I18n.format("gui.cancel", new Object[0])));
	}

	@Override
	public void onGuiClosed() {

	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 618) {
			Minecraft.getMinecraft().player.closeScreen();
		} else {
			this.padList.actionPerformed(button);
			super.actionPerformed(button);
		}
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if (keyCode == 1) { // ESC key
			Minecraft.getMinecraft().player.closeScreen();
		}
	}

	@Override
	public void handleMouseInput() throws IOException {
		super.handleMouseInput();
		this.padList.handleMouseInput();
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (!this.padList.mouseClicked(mouseX, mouseY, mouseButton)) {
			super.mouseClicked(mouseX, mouseY, mouseButton);
		}
	}
	
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		if (!this.padList.mouseReleased(mouseX, mouseY, state)) {
			super.mouseReleased(mouseX, mouseY, state);
		}
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.padList.drawScreen(mouseX, mouseY, partialTicks);
		this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 10, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
