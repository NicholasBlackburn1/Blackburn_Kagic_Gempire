package mod.kagic.items;

import mod.kagic.init.ModCreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemExtendedReachWeapon extends ItemSword implements IExtendedReachWeapon {

	private float reach;

	public ItemExtendedReachWeapon(ToolMaterial material, String registryName,float reach) {
		super(material);
		this.reach = reach;
		setUnlocalizedName(registryName);
		
	}


	@Override
	public float getReach() {
		return reach;
	}
}