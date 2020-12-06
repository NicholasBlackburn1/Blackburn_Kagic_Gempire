package mod.kagic.crafting;

import mod.kagic.init.ModItems;
import mod.kagic.items.ItemGem;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RepairGemsRecipes implements IRecipe {
	public ItemStack getPotion() {
		ItemStack healthPotion = new ItemStack(Items.POTIONITEM.setContainerItem(Items.GLASS_BOTTLE));
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Potion", "strong_healing");
		healthPotion.setTagCompound(nbt);
		return healthPotion;
	}
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory) {
		ItemStack gem = ItemStack.EMPTY;
		boolean heal = false;
		for (int slot = 0; slot < inventory.getInventoryStackLimit(); ++slot) {
			if (inventory.getStackInSlot(slot).getItem() instanceof ItemGem) {
				gem = inventory.getStackInSlot(slot);
			}
			if (inventory.getStackInSlot(slot).isItemEqual(this.getPotion())) {
				heal = true;
			}
		}
		ItemStack result = new ItemStack(ModItems.GEM_TABLE.get(gem.getItem()));
		result.setTagCompound(gem.getTagCompound());
		ItemGem gemItem = (ItemGem) gem.getItem();
		if (heal && gemItem.isCracked || !heal && !gemItem.isCracked) {
			return result;
		}
		return ItemStack.EMPTY;
	}
	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		for (int y = 0; y < inv.getHeight(); ++y) {
			for (int x = 0; x < inv.getWidth(); ++x) {
				ItemStack itemstack = inv.getStackInRowAndColumn(x, y);
				if (!itemstack.isEmpty()) {
					if (itemstack.getItem() instanceof ItemGem) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public int getRecipeSize() {
		return 2;
	}
	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY;
	}
	@Override
	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
		NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);
		for (int i = 0; i < nonnulllist.size(); ++i) {
			ItemStack itemstack = inv.getStackInSlot(i);
			nonnulllist.set(i, net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack));
		}
		return nonnulllist;
	}
	@Override
	public IRecipe setRegistryName(ResourceLocation name) {
		return this;
	}
	@Override
	public ResourceLocation getRegistryName() {
		return new ResourceLocation("ndbkagic:repair_gems");
	}
	@Override
	public Class<IRecipe> getRegistryType() {
		return IRecipe.class;
	}
	@Override
	public boolean canFit(int width, int height) {
		return true;
	}
}