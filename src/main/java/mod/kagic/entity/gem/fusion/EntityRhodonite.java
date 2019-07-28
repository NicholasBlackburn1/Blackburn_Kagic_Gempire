package mod.kagic.entity.gem.fusion;

import java.util.ArrayList;

import mod.kagic.entity.EntityFusionGem;
import mod.kagic.entity.EntityGem;
import mod.kagic.init.ModSounds;
import mod.kagic.util.Colors;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRhodonite extends EntityFusionGem {
	private static final int SKIN_COLOR_BEGIN = 0xD35990;
	private static final int SKIN_COLOR_END = 0xD35990;
	
	private static final int HAIR_COLOR_BEGIN = 0x724476;
	private static final int HAIR_COLOR_END = 0x724476;
	
	private static final int NUM_HAIRSTYLES = 1;
	
	public EntityRhodonite(World world) {
		super(world);
		this.setSize(0.7F, 2.1F);
		this.isImmuneToFire = true;
		
		// Apply entity attributes.
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(2.0D);
	}
	
	// =========================================================================
	// === Methods for managing
	// fusion==========================================
	// =========================================================================

	@Override
	public boolean addGem(EntityGem gem) {
		if (this.getFusionCount() >= 2) {
			return false;
		} else {
			return super.addGem(gem);
		}
	}
	
	/*********************************************************
	 * Methods related to rendering. *
	 *********************************************************/
	@Override
	protected int generateGemColor() {
		return 0x785D91;
	}
	
	@Override
	protected int generateSkinColor() {
		ArrayList<Integer> skinColors = new ArrayList<Integer>();
		skinColors.add(EntityRhodonite.SKIN_COLOR_BEGIN);
		skinColors.add(EntityRhodonite.SKIN_COLOR_END);
		return Colors.arbiLerp(skinColors);
	}

	@Override
	protected int generateHairStyle() {
		return this.rand.nextInt(EntityRhodonite.NUM_HAIRSTYLES);
	}

	@Override
	protected int generateHairColor() {
		ArrayList<Integer> hairColors = new ArrayList<Integer>();
		hairColors.add(EntityRhodonite.HAIR_COLOR_BEGIN);
		hairColors.add(EntityRhodonite.HAIR_COLOR_END);
		return Colors.arbiLerp(hairColors);
	}

	@Override
	public float getSizeFactor() {
		return super.getSizeFactor() + (1F - super.getSizeFactor()) / 2;
	}

	@Override
	public void setAdjustedSize() {
		float sizeModifier = this.getPrimeCount() - this.getDefectiveCount();
		this.setSize(.7F, 2.1F + sizeModifier * 0.75F);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.getMaxHealth() + sizeModifier * 50D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D + sizeModifier * 2.5D);
	}
	
	/*********************************************************
	 * Methods related to sounds. *
	 *********************************************************/
	@Override
	protected SoundEvent getDeathSound() {
		return ModSounds.RHODONITE_DEATH;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return ModSounds.RHODONITE_HURT;
	}

	@Override
	protected SoundEvent getObeySound() {
		return ModSounds.RHODONITE_OBEY;
	}
}