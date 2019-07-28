package mod.kagic.entity.pepo;

import mod.kagic.entity.EntityPepo;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityCactus extends EntityPepo {
	public EntityCactus(World worldIn) {
		super(new ItemStack(Blocks.CACTUS), worldIn);
	}
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.getTrueSource() != null) {
			source.getTrueSource().attackEntityFrom(DamageSource.CACTUS, 1.0F);
		}
		return super.attackEntityFrom(source, amount);
	}
}
