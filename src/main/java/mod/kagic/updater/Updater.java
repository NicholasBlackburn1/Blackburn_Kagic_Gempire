package mod.kagic.updater;

import mod.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class Updater {
	public static boolean UPDATED = false;
	public VersionChecker NEW_VERSION = null;
	public Minecraft CURRENT_VERSION = null;
	public EntityPlayer PLAYER = null;

	public Updater(EntityPlayer player) {
		if (!Updater.UPDATED) {
			this.NEW_VERSION = new VersionChecker();
			this.CURRENT_VERSION = Minecraft.getMinecraft();
			this.PLAYER = player;

			if (!this.NEW_VERSION.errored) {
				if (this.NEW_VERSION.MINECRAFT_VERSION.equals(this.CURRENT_VERSION.getVersion())) {
					if (!this.NEW_VERSION.MOD_VERSION.equals(KAGIC.VERSION)) {
						this.PLAYER.sendMessage(new TextComponentString("�c" + new TextComponentTranslation("command.kagic.new_version_available").getUnformattedComponentText()));
						this.PLAYER.sendMessage(new TextComponentString("�c" + new TextComponentTranslation("command.kagic.new_version_adds", this.NEW_VERSION.MOD_VERSION).getUnformattedComponentText()));
						this.PLAYER.sendMessage(new TextComponentString(this.NEW_VERSION.CHANGELOG.replaceAll("\n", "\n")));
						this.PLAYER.sendMessage(ITextComponent.Serializer.jsonToComponent("[{\"text\":\"�a�n" + new TextComponentTranslation("command.kagic.click_here_to_download").getUnformattedComponentText() + "\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"" + this.NEW_VERSION.UPDATE_URL + "\"}}]"));
					}
				}
			}
			Updater.UPDATED = true;
		}
	}
}
