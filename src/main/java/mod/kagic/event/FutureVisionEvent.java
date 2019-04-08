package mod.kagic.event;

import mod.kagic.entity.gem.EntitySapphire;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;

public class FutureVisionEvent extends Event {
	public final EntitySapphire sapphire;
	public final EntityPlayer player;
	public FutureVisionEvent(EntitySapphire sapphire, EntityPlayer player) {
		this.sapphire = sapphire;
		this.player = player;
	}
	@Override
	public boolean isCancelable() {
		return true;
	}
}
