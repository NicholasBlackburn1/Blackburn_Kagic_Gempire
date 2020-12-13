package mod.kagic.client.gui;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import mod.kagic.init.KAGIC;
import mod.kagic.tileentity.TileEntityWarpPadCore;
import mod.kagic.worlddata.WarpPadDataEntry;
import mod.kagic.worlddata.WorldDataWarpPad;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class GUIWarpPadSelection extends GuiScreen {
	private final TileEntityWarpPadCore tilePad;
	private Map<BlockPos, WarpPadDataEntry> padData = null;
	private SortedMap<Double, BlockPos> sortedPoses = new TreeMap<Double, BlockPos>();
	private GUIWarpPadList padList;
	private GuiButton buttonDone;
	protected String screenTitle = "Select Destination";

	public GUIWarpPadSelection(LinkedHashMap<BlockPos, WarpPadDataEntry> data, int x, int y, int z) {
		// KAGICTech.instance.chatInfoMessage("Getting Warp
		// Pad TE at " + x + ", " + y + ", " + z);
		this.tilePad = (TileEntityWarpPadCore) Minecraft.getMinecraft().world.getTileEntity(new BlockPos(x, y, z));
		this.padData = data;
		// KAGICTech.instance.chatInfoMessage("padData has
		// size of " + padData.size());
		this.sortedPoses = WorldDataWarpPad.getSortedPositions(this.padData, this.tilePad.getPos());
	}

	public WarpPadDataEntry getPadDataEntry(BlockPos pos) {
		if (this.padData.containsKey(pos)) {
			return this.padData.get(pos);
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
		this.padList = new GUIWarpPadList(this, this.tilePad.getPos(), this.sortedPoses, this.mc, this.width, this.height, 0, this.height, 50);
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
		ResourceLocation location = new ResourceLocation(KAGIC.MODID, "gui/Background/" + "background" + ".png");
		
		mc.renderEngine.bindTexture(location); 
		//this.drawGradientRect(0, 0, this.width, this.height);
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.padList.drawScreen(mouseX, mouseY, partialTicks);
		this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 10, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
