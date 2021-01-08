package mod.kagic.items;

import mod.kagic.init.ModCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBagelSandwitch extends ItemFood{

    public ItemBagelSandwitch(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setUnlocalizedName("bagel_sandwitch");
		this.setCreativeTab(ModCreativeTabs.CREATIVE_TAB_OTHER);
		this.setMaxStackSize(64);
    };
        
    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
      if(!worldIn.isRemote){
          player.addPotionEffect(new PotionEffect(Potion.getPotionById(5),2222,222));
      }
    }
}