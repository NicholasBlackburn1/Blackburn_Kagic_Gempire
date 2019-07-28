package mod.kagic.items;

import java.util.List;

import mod.kagic.entity.EntityGem;
import mod.kagic.init.ModCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemStaff extends Item {
	public ItemGemStaff() {
		super();
		this.setUnlocalizedName("gem_staff");
		this.setCreativeTab(ModCreativeTabs.CREATIVE_TAB_OTHER);
		this.setMaxStackSize(1);
	}
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		super.onCreated(stack, worldIn, playerIn);
		// playerIn.addStat(ModAchievements.GEM_COMMANDER);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		if (!worldIn.isRemote) {
			List<EntityGem> list = playerIn.world.<EntityGem>getEntitiesWithinAABB(EntityGem.class, playerIn.getEntityBoundingBox().grow(24.0D, 8.0D, 24.0D));
			for (EntityGem gem : list) {
				gem.setRevengeTarget(null);
				gem.setAttackTarget(null);
				gem.isPeaceful = true;
			}
			
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
		}
		playerIn.swingArm(hand);
		return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}
}
