package mod.kagic.items;

import java.util.Random;
import java.util.function.Function;

import javax.swing.plaf.TreeUI;

import mod.kagic.advancements.ModTriggers;
import mod.kagic.entity.EntityGem;
import mod.kagic.init.KAGIC;
import mod.kagic.init.ModCreativeTabs;
import mod.kagic.init.ModItems;
import mod.kagic.networking.KTPacketHandler;
import mod.kagic.networking.PadDataRequestMessage;
import mod.kagic.tileentity.TileEntityGalaxyPadCore;
import mod.kagic.tileentity.TileEntityWarpPadCore;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRejuvenator extends ItemSword {

    private Random rand;
	public ItemRejuvenator() {
		super(ToolMaterial.DIAMOND);
		this.setUnlocalizedName("rejuvenator");
		this.setCreativeTab(ModCreativeTabs.CREATIVE_TAB_OTHER);
		this.setMaxStackSize(1);

	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.damageItem(1, attacker);
		target.setGlowing(true);
		target.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, target.posX, target.posY, target.posZ, 0.05D, 1.0D, 0.05D);
		if(target instanceof EntityGem){
			EntityGem gem = (EntityGem) target;

		}
		return true;
	
        }
	}

	
	






