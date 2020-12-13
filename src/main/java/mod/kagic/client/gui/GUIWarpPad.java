package mod.kagic.client.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import mod.kagic.init.KAGIC;
import mod.kagic.networking.KTPacketHandler;
import mod.kagic.networking.TENameMessage;
import mod.kagic.tileentity.TileEntityWarpPadCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;

public class GUIWarpPad extends GuiScreen {
	private final TileEntityWarpPadCore tilePad;
	private GuiTextField nameTextField;
	private GuiButton doneButton;

	GUIWarpPad(TileEntityWarpPadCore tePad) {
		KAGIC.instance.logger.info("Created WarpPad GUI!");
		this.tilePad = tePad;
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void updateScreen() {
		this.nameTextField.updateCursorCounter();
	}

	@Override
	public void initGui() {
		this.buttonList.clear();
		Keyboard.enableRepeatEvents(true);
		this.nameTextField = new GuiTextField(2, this.fontRenderer, this.width / 2 - 100, this.height / 2 - 10, 200, 20);
		this.nameTextField.setMaxStringLength(256);
		this.nameTextField.setText(this.tilePad.name);
		this.nameTextField.setFocused(true);
		this.doneButton = this.addButton(new GuiButton(0, this.width / 2 - 100, this.height / 2 + 30, I18n.format("gui.done", new Object[0])));
	}

	@Override
	public void onGuiClosed() {
		KTPacketHandler.INSTANCE.sendToServer(new TENameMessage(this.nameTextField.getText(), this.tilePad.getPos().getX(), this.tilePad.getPos().getY(), this.tilePad.getPos().getZ()));
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.enabled) {
			if (button.id == 0) {
				Minecraft.getMinecraft().player.closeScreen();
			}
		}
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if (keyCode == 1) { // ESC key
			Minecraft.getMinecraft().player.closeScreen();
		} else {
			this.nameTextField.textboxKeyTyped(typedChar, keyCode);
		}
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		this.nameTextField.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		this.drawTexturedModalRect(0, 0, 1920, 1080, this.width, this.height);
		this.nameTextField.drawTextBox();
		this.drawCenteredString(this.fontRenderer, "Enter Warp Pad Name", this.width / 2, this.height / 2 - 30, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
