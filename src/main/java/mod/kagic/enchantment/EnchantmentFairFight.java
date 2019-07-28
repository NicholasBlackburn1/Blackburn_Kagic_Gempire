package mod.kagic.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class EnchantmentFairFight extends Enchantment {
	public EnchantmentFairFight() {
		super(Rarity.UNCOMMON, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET});
		this.setRegistryName(new ResourceLocation("kagic:fair_fight"));
		this.setName("fair_fight.name");
	}
	@Override
	public boolean isAllowedOnBooks() {
		return true;
	}
	@Override
	public boolean isTreasureEnchantment() {
		return true;
	}
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 1 + (enchantmentLevel - 1) * 10;
	}
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel) + 15;
	}
	@Override
	public int getMaxLevel() {
		return 1;
	}
}
