package mod.kagic.items;

import java.util.function.Function;

import mod.kagic.advancements.ModTriggers;
import mod.kagic.init.KAGIC;
import mod.kagic.init.ModCreativeTabs;
import mod.kagic.init.ModItems;
import mod.kagic.networking.KTPacketHandler;
import mod.kagic.networking.PadDataRequestMessage;
import mod.kagic.tileentity.TileEntityGalaxyPadCore;
import mod.kagic.tileentity.TileEntityWarpPadCore;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelState;

public class ItemObsidiansSword extends Item {

	public ItemObsidiansSword() {
		super();
		this.setUnlocalizedName("obsidians_sword");
		this.setCreativeTab(ModCreativeTabs.CREATIVE_TAB_OTHER);
		this.setMaxStackSize(1);
	}


	
	





}
