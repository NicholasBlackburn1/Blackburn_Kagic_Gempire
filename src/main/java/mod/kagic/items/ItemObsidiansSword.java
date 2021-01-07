package mod.kagic.items;

import mod.kagic.advancements.ModTriggers;
import mod.kagic.init.KAGIC;
import mod.kagic.init.ModCreativeTabs;
import mod.kagic.networking.KTPacketHandler;
import mod.kagic.networking.PadDataRequestMessage;
import mod.kagic.tileentity.TileEntityGalaxyPadCore;
import mod.kagic.tileentity.TileEntityWarpPadCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemObsidiansSword extends ItemSword{
	
	public ItemObsidiansSword() {
		super(ToolMaterial.DIAMOND);
		this.setUnlocalizedName("obsidians_sword");
		this.setCreativeTab(ModCreativeTabs.CREATIVE_TAB_OTHER);
		this.setMaxStackSize(1);
	}
	
	
}
