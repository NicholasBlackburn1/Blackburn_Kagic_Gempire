package mod.kagic.dispenser;

import mod.kagic.init.ModItems;
import mod.kagic.items.ItemGem;
import net.minecraft.block.BlockDispenser;

public class DispenserBehaviors {
	public static BehaviorGemDispense GEMDISPENSE = new BehaviorGemDispense();
	
	public static void register() {
		for (ItemGem gem : ModItems.GEM_TABLE.values()) {
			BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(gem, DispenserBehaviors.GEMDISPENSE);
		}
	}
}
