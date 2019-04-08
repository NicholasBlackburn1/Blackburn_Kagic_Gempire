package mod.kagic.blocks;

import mod.kagic.init.ModBlocks;
import mod.kagic.init.ModCreativeTabs;
import net.minecraft.block.Block;

public class BlockVarying extends Block {
	public BlockVarying(String unlocalizedName, int resistance, int hardness, int level) {
		super(ModBlocks.DRAINED);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(ModCreativeTabs.CREATIVE_TAB_OTHER);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setHarvestLevel("pickaxe", level);
	}
}
