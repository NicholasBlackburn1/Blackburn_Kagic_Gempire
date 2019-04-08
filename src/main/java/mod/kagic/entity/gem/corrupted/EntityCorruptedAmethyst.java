package mod.kagic.entity.gem.corrupted;

import java.util.ArrayList;

import mod.kagic.entity.EntityCorruptedGem;
import mod.kagic.entity.gem.EntityAmethyst;
import mod.kagic.entity.gem.GemCuts;
import mod.kagic.entity.gem.GemPlacements;
import mod.kagic.init.ModItems;
import mod.kagic.init.ModSounds;
import mod.kagic.util.Colors;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCorruptedAmethyst extends EntityCorruptedGem {

	public EntityCorruptedAmethyst(World world) {
		super(world);
		this.setSize(1.9F, 2.8F);

		this.setCutPlacement(GemCuts.FACETED, GemPlacements.CHEST);

		// Apply entity attributes.
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(24.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
		
		this.droppedGemItem = ModItems.CORRUPTED_AMETHYST_GEM;
		this.droppedCrackedGemItem = ModItems.CRACKED_CORRUPTED_AMETHYST_GEM;
	}

	/*********************************************************
	 * Methods related to sounds.							*
	 *********************************************************/
	@Override
	protected SoundEvent getAmbientSound() {
		return ModSounds.CORRUPTED_QUARTZ_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return ModSounds.CORRUPTED_QUARTZ_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ModSounds.CORRUPTED_QUARTZ_DEATH;
	}

	/*********************************************************
	 * Methods related to rendering.						 *
	 *********************************************************/
	@Override
    protected int generateGemColor() {
    	return 0xDC64FD;
    }
	
	@Override
	protected int generateSkinColor() {
		return Colors.triLerp(EntityAmethyst.SKIN_COLOR_BEGIN, EntityAmethyst.SKIN_COLOR_MID, EntityAmethyst.SKIN_COLOR_END);
	}
	
	@Override
	protected int generateHairColor() {
		ArrayList<Integer> hairColors = new ArrayList<Integer>();
		hairColors.add(EntityAmethyst.HAIR_COLOR_BEGIN);
		hairColors.add(EntityAmethyst.HAIR_COLOR_MID_1);
		hairColors.add(EntityAmethyst.HAIR_COLOR_MID_2);
		hairColors.add(EntityAmethyst.HAIR_COLOR_MID_3);
		hairColors.add(EntityAmethyst.HAIR_COLOR_MID_4);
		hairColors.add(EntityAmethyst.HAIR_COLOR_MID_5);
		hairColors.add(EntityAmethyst.HAIR_COLOR_END);
		return Colors.arbiLerp(hairColors);
	}
}