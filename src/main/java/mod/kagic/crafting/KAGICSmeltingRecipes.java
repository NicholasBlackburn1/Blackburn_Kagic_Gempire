package mod.kagic.crafting;

import mod.kagic.init.ModBlocks;
import mod.kagic.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class KAGICSmeltingRecipes {
	public static void register() {
		GameRegistry.addSmelting(new ItemStack(ModItems.INACTIVE_GEM_BASE), new ItemStack(ModItems.ACTIVATED_GEM_BASE), 2000);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.DRAINED_BLOCK, 3), new ItemStack(ModBlocks.SMOOTH_CARBONITE), 0);
	}
}
