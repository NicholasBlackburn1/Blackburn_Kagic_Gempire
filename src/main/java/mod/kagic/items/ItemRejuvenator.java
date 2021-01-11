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
import net.minecraft.scoreboard.Team;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRejuvenator extends ItemSword {

    private Random rand = new Random();
	public ItemRejuvenator() {
		super(ToolMaterial.WOOD);
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
		for (int i = 0; i < 7; ++i) {
			double d0 = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			target.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, target.posX + this.rand.nextFloat() * target.width * 2.0F - target.width, target.posY + 0.5D + this.rand.nextFloat() * target.height, target.posZ + this.rand.nextFloat() * target.width * 2.0F - target.width, d0, d1, d2, new int[0]);
		}
		if(target instanceof EntityGem){
			EntityGem gem = (EntityGem) target;

			// Handles fusion 
			if(gem.isFusion()){
				gem.unfuse();
				}
			
			gem.setHealth(-10);
			stack = new ItemStack(gem.droppedGemItem);
			stack.setItemDamage(500);
			gem.entityDropItem(stack, 1);
			gem.spawnedGems.remove(gem);
			

			if(attacker instanceof EntityPlayerMP){
				EntityPlayerMP player = (EntityPlayerMP) attacker;
				player.sendStatusMessage(new TextComponentString("§e Tip: The Rejuvenator Factory Resets Gems. §c(Takes about 5 mins to respawn)"), true); 
				ModTriggers.Rejuvination.trigger(player);
			}
		
			
		}
		return true;
	
        }
	}

	
	






