package mod.kagic.entity.gem.fusion;

import java.util.ArrayList;
import java.util.List;

import mod.kagic.entity.EntityFusionGem;
import mod.kagic.entity.EntityGem;
import mod.kagic.entity.gem.EntityJasper;
import mod.kagic.init.ModSounds;
import mod.kagic.util.Colors;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityMalachite extends EntityFusionGem {
	private static final List<Integer> SKIN_COLORS = new ArrayList<Integer>();
	static {
		EntityMalachite.SKIN_COLORS.add(0x00FFC5); // Noreena
		EntityMalachite.SKIN_COLORS.add(0x00FECE); // Ocean
		EntityMalachite.SKIN_COLORS.add(0x085338); // Biggs
		EntityMalachite.SKIN_COLORS.add(0x1CFFD1); // Green
		EntityMalachite.SKIN_COLORS.add(0x1EFFA4); // Bruneau
		EntityMalachite.SKIN_COLORS.add(0x00FECE); // Purple
		EntityMalachite.SKIN_COLORS.add(0x1EFFA4); // Flame
		EntityMalachite.SKIN_COLORS.add(0x085338); // Picture
		EntityMalachite.SKIN_COLORS.add(0xF9FFFE); // Candy
													// cane
	}

	private static final int HAIR_COLOR_BEGIN = 0xECFDE8;
	private static final int HAIR_COLOR_END = 0xECFDE8;

	private static final DataParameter<Integer> MARK_COLOR = EntityDataManager.<Integer>createKey(EntityJasper.class, DataSerializers.VARINT);
	private static final List<Integer> MARK_COLORS = new ArrayList<Integer>();
	static {
		EntityMalachite.MARK_COLORS.add(0x00735E); // Noreena
		EntityMalachite.MARK_COLORS.add(0x00605F); // Ocean
		EntityMalachite.MARK_COLORS.add(0x043624); // Biggs
		EntityMalachite.MARK_COLORS.add(0x0B8060); // Green
		EntityMalachite.MARK_COLORS.add(0x0B8146); // Bruneau
		EntityMalachite.MARK_COLORS.add(0x00605F); // Purple
		EntityMalachite.MARK_COLORS.add(0x0B8146); // Flame
		EntityMalachite.MARK_COLORS.add(0x043624); // Picture
		EntityMalachite.MARK_COLORS.add(0xB02E26); // Candy
													// cane
	}

	private static final int NUM_HAIRSTYLES = 1;
	
	private int jasperType;

	public EntityMalachite(World world) {
		super(world);
		this.setSize(1.9F, 8.3F);

		// Apply entity attributes.
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(500.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(25D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(2.0D);
		
		this.dataManager.register(EntityMalachite.MARK_COLOR, 0);
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		this.setSpecial(0);
		this.setMarkColor(this.generateMarkColor());
		return super.onInitialSpawn(difficulty, livingdata);
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
			if (gem instanceof EntityJasper) {
				this.jasperType = gem.getSpecial();
			}
			return super.addGem(gem);
		}
	}
	
	// =========================================================================
	// === Methods for entity NBTing
	// ===========================================
	// =========================================================================

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound comp) {
		comp.setInteger("markColor", this.getMarkColor());
		comp.setInteger("jasperType", this.jasperType);
		return super.writeToNBT(comp);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound comp) {
		super.readFromNBT(comp);
		this.setMarkColor(comp.getInteger("markColor"));
		this.jasperType = comp.getInteger("jasperType");
	}

	/*********************************************************
	 * Methods related to entity living. *
	 *********************************************************/
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		/*
		 * if (this.inWater) { this.motionX *= 2F;
		 * this.motionZ *= 2F; }
		 */
	}
	
	/*********************************************************
	 * Methods related to entity rendering. *
	 *********************************************************/
	@Override
	protected int generateGemColor() {
		return 0x36C16E;
	}
	
	@Override
	public int getSpecial() {
		return this.dataManager.get(EntityGem.SPECIAL);
	}
	
	@Override
	protected int generateSkinColor() {
		return EntityMalachite.SKIN_COLORS.get(this.jasperType);
	}
	
	@Override
	protected int generateHairColor() {
		ArrayList<Integer> hairColors = new ArrayList<Integer>();
		hairColors.add(EntityMalachite.HAIR_COLOR_BEGIN);
		hairColors.add(EntityMalachite.HAIR_COLOR_END);
		return Colors.arbiLerp(hairColors);
	}
	
	protected int generateMarkColor() {
		return EntityMalachite.MARK_COLORS.get(this.jasperType);
	}

	public void setMarkColor(int markColor) {
		this.dataManager.set(EntityMalachite.MARK_COLOR, markColor);
	}

	public int getMarkColor() {
		return this.dataManager.get(EntityMalachite.MARK_COLOR);
	}

	@Override
	public float getSizeFactor() {
		return super.getSizeFactor() + (1F - super.getSizeFactor()) / 1.25F;
	}

	@Override
	public void setAdjustedSize() {
		float sizeModifier = this.getPrimeCount() - this.getDefectiveCount();
		this.setSize(1.9F + sizeModifier * 0.125F, 8.3F + sizeModifier * 0.75F);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(500.0D + sizeModifier * 50D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(25D + sizeModifier * 2.5D);
	}
	
	/*********************************************************
	 * Methods related to sounds. *
	 *********************************************************/
	@Override
	protected SoundEvent getDeathSound() {
		return ModSounds.MALACHITE_DEATH;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return ModSounds.MALACHITE_HURT;
	}

	@Override
	protected SoundEvent getObeySound() {
		return ModSounds.MALACHITE_OBEY;
	}
}