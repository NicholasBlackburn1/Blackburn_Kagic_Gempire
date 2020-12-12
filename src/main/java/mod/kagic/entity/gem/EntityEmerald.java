package mod.kagic.entity.gem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Predicate;

import mod.kagic.entity.EntityGem;
import mod.kagic.entity.ai.EntityAIAlignGems;
import mod.kagic.entity.ai.EntityAICommandGems;
import mod.kagic.entity.ai.EntityAIFollowDiamond;
import mod.kagic.entity.ai.EntityAIProtectionFuse;
import mod.kagic.entity.ai.EntityAIScareMobs;
import mod.kagic.entity.ai.EntityAIStandGuard;
import mod.kagic.entity.gem.fusion.EntityMalachite;
import mod.kagic.init.KAGIC;
import mod.kagic.init.ModItems;
import mod.kagic.init.ModSounds;
import mod.kagic.util.Colors;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.fixes.EntityId;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityEmerald extends EntityQuartzSoldier implements IAnimals {
	public static final HashMap<IBlockState, Double> Emerald_YIELDS = new HashMap<IBlockState, Double>();
	public static final double Emerald_DEFECTIVITY_MULTIPLIER = 1;
	public static final double Emerald_DEPTH_THRESHOLD = 128;
	public static final HashMap<Integer, ResourceLocation> Emerald_HAIR_STYLES = new HashMap<Integer, ResourceLocation>();
	private static final DataParameter<Boolean> CHARGED = EntityDataManager.<Boolean>createKey(EntityEmerald.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> MARK_1_COLOR = EntityDataManager.<Integer>createKey(EntityEmerald.class,
			DataSerializers.VARINT);
	private static final DataParameter<Integer> MARK_1 = EntityDataManager.<Integer>createKey(EntityEmerald.class,
			DataSerializers.VARINT);
	private static final DataParameter<Integer> MARK_2_COLOR = EntityDataManager.<Integer>createKey(EntityEmerald.class,
			DataSerializers.VARINT);
	private static final DataParameter<Integer> MARK_2 = EntityDataManager.<Integer>createKey(EntityEmerald.class,
			DataSerializers.VARINT);
	private int charge_ticks = 0;
	private int hit_count = 0;
	private int regenTicks = 0;

	private static final int NUM_HAIRSTYLES = 5;
	private static final Map<Integer, Integer> MARK1S = new LinkedHashMap<Integer, Integer>();
	static {
		EntityEmerald.MARK1S.put(0, 6);
		EntityEmerald.MARK1S.put(1, 1);
		EntityEmerald.MARK1S.put(2, 1);
		EntityEmerald.MARK1S.put(3, 1);
		EntityEmerald.MARK1S.put(4, 1);
		EntityEmerald.MARK1S.put(5, 1);
		EntityEmerald.MARK1S.put(6, 1);
		EntityEmerald.MARK1S.put(7, 1);
		EntityEmerald.MARK1S.put(8, 1);
	}

	private static final Map<Integer, Integer> MARK2S = new LinkedHashMap<Integer, Integer>();
	static {
		EntityEmerald.MARK2S.put(0, 0);
		EntityEmerald.MARK2S.put(1, 1);
		EntityEmerald.MARK2S.put(2, 1);
		EntityEmerald.MARK2S.put(3, 0);
		EntityEmerald.MARK2S.put(4, 1);
		EntityEmerald.MARK2S.put(5, 0);
		EntityEmerald.MARK2S.put(6, 1);
		EntityEmerald.MARK2S.put(7, 1);
		EntityEmerald.MARK2S.put(8, 2);
	}

	private static final Map<Integer, ArrayList<Integer>> SKIN_COLORS = new LinkedHashMap<Integer, ArrayList<Integer>>();
	static {
		ArrayList<Integer> normal = new ArrayList<Integer>();
		normal.add(0xFFD69D);
		normal.add(0xFC9C6F);
		normal.add(0xFA8669);
		normal.add(0xFFA351);
		normal.add(0xF58059);
		normal.add(0xE8745B);
		EntityEmerald.SKIN_COLORS.put(0, normal);

	}

	private static final Map<Integer, ArrayList<Integer>> HAIR_COLORS = new LinkedHashMap<Integer, ArrayList<Integer>>();
	static {
		ArrayList<Integer> normal = new ArrayList<Integer>();
		normal.add(0xFEFFEC);
		normal.add(0xFFFCE8);
		normal.add(0xFFF0D4);
		normal.add(0xFDE7D9);
		normal.add(0xFFD69D);
		EntityEmerald.HAIR_COLORS.put(0, normal);

		ArrayList<Integer> ocean = new ArrayList<Integer>();
		ocean.add(0xFaF9Fc);
		EntityEmerald.HAIR_COLORS.put(1, ocean);

	}

	private static final Map<Integer, ArrayList<Integer>> MARK_1_COLORS = new LinkedHashMap<Integer, ArrayList<Integer>>();
	static {
		ArrayList<Integer> normal = new ArrayList<Integer>();
		normal.add(0xF58059);
		normal.add(0xED4A3C);
		normal.add(0xF62F46);
		normal.add(0xF1162C);
		normal.add(0xD01729);
		normal.add(0xAC0522);
		EntityEmerald.MARK_1_COLORS.put(0, normal);

		
	}

	private static final Map<Integer, ArrayList<Integer>> MARK_2_COLORS = new LinkedHashMap<Integer, ArrayList<Integer>>();
	static {
		ArrayList<Integer> normal = new ArrayList<Integer>();
		normal.add(0);
		EntityEmerald.MARK_2_COLORS.put(0, normal);
	}

	public EntityEmerald(World worldIn) {
		super(worldIn);

		// Define valid gem cuts and placements
		this.setCutPlacement(GemCuts.CABOCHON, GemPlacements.BACK_OF_HEAD);
		this.setCutPlacement(GemCuts.CABOCHON, GemPlacements.FOREHEAD);
		this.setCutPlacement(GemCuts.CABOCHON, GemPlacements.LEFT_EYE);
		this.setCutPlacement(GemCuts.CABOCHON, GemPlacements.RIGHT_EYE);
		this.setCutPlacement(GemCuts.TINY, GemPlacements.NOSE);
		this.setCutPlacement(GemCuts.CABOCHON, GemPlacements.LEFT_CHEEK);
		this.setCutPlacement(GemCuts.CABOCHON, GemPlacements.RIGHT_CHEEK);
		this.setCutPlacement(GemCuts.CABOCHON, GemPlacements.BACK);
		this.setCutPlacement(GemCuts.CABOCHON, GemPlacements.CHEST);
		this.setCutPlacement(GemCuts.CABOCHON, GemPlacements.BELLY);

		this.setCutPlacement(GemCuts.FACETED, GemPlacements.BACK_OF_HEAD);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.FOREHEAD);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_EYE);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_EYE);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_CHEEK);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_CHEEK);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.BACK);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.CHEST);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.BELLY);


		/*
		* TODO: Add fusion when i create a custom Fusion Mob
		* this.tasks.addTask(3, new EntityAIProtectionFuse(this, EntityBlueDiamond.class, EntityMalachite.class, 16D));
		* Apply entity AI.
		*  Allows Emerald To move 
		* attacks mobs 
		* Follow's the Diamonds/ Fusions 
		* Scares Mobs With her fiears Glare
		*/

		this.tasks.addTask(1, new EntityAIFollowDiamond(this, 10.0D));
		this.tasks.addTask(1, new EntityAICommandGems(this, 30.6D));

		this.tasks.addTask(2, new EntityAICommandGems(this, 32.0D));
		this.tasks.addTask(2, new EntityAIAlignGems(this, 100.0D));

		this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
		this.tasks.addTask(3, new EntityAIOpenDoor(this, true));

		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityMob.class, 16.0F));

		this.tasks.addTask(6, new EntityAIStandGuard(this, 0.2D));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		

		this.tasks.addTask(1, new EntityAIAvoidEntity<EntityCreeper>(this, EntityCreeper.class, new Predicate<EntityCreeper>() {
			@Override
			public boolean apply(EntityCreeper input) {
				return input.getCreeperState() == 1;
			}
		}, 6.0F, 1.0D, 1.2D));
		
		this.tasks.addTask(1, new EntityAIAvoidEntity<EntityZombie>(this, EntityZombie.class, new Predicate<EntityZombie>() {

			@Override
			public boolean apply(EntityZombie input) {
				return true;
			}
		}, 6.0F, 1.0D, 1.2D));
		


		// Apply entity attributes.

		// Weak Hit damage but, Its Aristocratic so damage is weak but then they can command other gems
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.1D);

		this.droppedGemItem = ModItems.EMERALD_GEM;
		this.droppedCrackedGemItem = ModItems.CRACKED_EMERALD_GEM;
		this.droppedCrackedGemItem = ModItems.CRACKED_EMERALD_GEM;

		// Register entity data.
		this.dataManager.register(EntityEmerald.CHARGED, false);
		this.dataManager.register(EntityEmerald.MARK_1_COLOR, 0);
		this.dataManager.register(EntityEmerald.MARK_1, 0);
		this.dataManager.register(EntityEmerald.MARK_2_COLOR, 0);
		this.dataManager.register(EntityEmerald.MARK_2, 0);
		this.setServitude(EntityGem.SERVE_BLUE_DIAMOND);
	}

	@Override
	protected int generateGemColor() {
		switch (this.getSpecial()) {
			case 1:
				return 0xFFD69D;
			
			default:
				return 0xFF3F01;
		}
	}

	@Override
	public void convertGems(int placement) {
		this.setGemCut(GemCuts.DIAMOND.id);
		switch (placement) {
			case 0:
				this.setGemPlacement(GemPlacements.NOSE.id);
				break;
			case 1:
				this.setGemPlacement(GemPlacements.CHEST.id);
				break;
		}
	}

	/*********************************************************
	 * Methods related to entity loading. *
	 *********************************************************/
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		compound.setBoolean("charged", this.dataManager.get(EntityEmerald.CHARGED).booleanValue());
		compound.setInteger("charge_ticks", this.charge_ticks);
		compound.setInteger("hit_count", this.hit_count);
		compound.setInteger("mark1color", this.getMark1Color());
		compound.setInteger("mark1", this.getMark1());
		compound.setInteger("mark2color", this.getMark2Color());
		compound.setInteger("mark2", this.getMark2());
		super.writeEntityToNBT(compound);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		this.dataManager.set(EntityEmerald.CHARGED, compound.getBoolean("charged"));
		this.charge_ticks = compound.getInteger("charge_ticks");
		this.hit_count = compound.getInteger("hit_count");

		if (compound.hasKey("mark1color")) {
			this.setMark1Color(compound.getInteger("mark1color"));
		} else {
			this.setMark1Color(this.generateMark1Color());
		}
		if (compound.hasKey("mark1")) {
			this.setMark1(compound.getInteger("mark1"));
		} else {
			this.setMark1(this.generateMark1());
		}

		if (compound.hasKey("mark2color")) {
			this.setMark2Color(compound.getInteger("mark2color"));
		} else {
			this.setMark2Color(this.generateMark2Color());
		}
		if (compound.hasKey("mark2")) {
			this.setMark2(compound.getInteger("mark2"));
		} else {
			this.setMark2(this.generateMark2());
		}
		super.readEntityFromNBT(compound);
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		
		int special = this.rand.nextInt(8);
		int biomeSpecial = 0;
		Biome biome = this.world.getBiome(this.getPosition());
		if (BiomeDictionary.hasType(biome, Type.MESA)) {
			biomeSpecial = 0;
		} else if (BiomeDictionary.hasType(biome, Type.HILLS)) {
			biomeSpecial = 1;
		
		}
		special = KAGIC.isChristmas() ? 8 : this.rand.nextFloat() < 0.9 ? biomeSpecial : special;
		this.itemDataToGemData(special);
		return super.onInitialSpawn(difficulty, livingdata);
	}

	@Override
	public void itemDataToGemData(int data) {
		if (data == 0) {
			this.nativeColor = 1;
		} else if (data == 1) {
			this.nativeColor = 9;
		}
		this.setCustomNameTag(new TextComponentTranslation(String.format("entity.kagic.emerald.name"))
				.getUnformattedComponentText());
		this.setSpecial(data);
		this.setMark1(this.generateMark1());
		this.setMark1Color(this.generateMark1Color());
		this.setUniformColor(this.nativeColor);
		this.setGemColor(this.generateGemColor());
		this.setSkinColor(this.generateSkinColor());
		if (this.hasSecondMarking()) {
			this.setMark2(this.generateMark2());
			this.setMark2Color(this.generateMark2Color());
		}
	}

	@Override
	public void setNewCutPlacement() {
		GemCuts cut;
		if (this.isPrimary()) {
			cut = GemCuts.TINY;
		} else {
			cut = this.getSpecial() == 0 ? GemCuts.CABOCHON : GemCuts.FACETED;
		}

		ArrayList<GemPlacements> placements = this.cutPlacements.get(cut);
		int placementIndex = this.rand.nextInt(placements.size());
		GemPlacements placement = placements.get(placementIndex);

		this.setGemCut(cut.id);
		this.setGemPlacement(placement.id);
	}

	/*********************************************************
	 * Methods related to entity interaction. *
	 *********************************************************/
	@Override
	public boolean alternateInteract(EntityPlayer player) {
		super.alternateInteract(player);
		KAGIC.instance.chatInfoMessage("Special is " + this.getSpecial());
		KAGIC.instance.chatInfoMessage("mark1Color is " + this.getMark1Color());
		KAGIC.instance.chatInfoMessage("mark1 is " + this.getMark1());
		KAGIC.instance.chatInfoMessage("mark2Color is " + this.getMark2Color());
		KAGIC.instance.chatInfoMessage("mark2 is " + this.getMark2());
		return false;
	}

	public boolean isCharged() {
		return this.dataManager.get(EntityEmerald.CHARGED);
	}

	public void setCharged(boolean charged) {
		this.dataManager.set(EntityEmerald.CHARGED, charged);
	}

	public String getSpecialSkin() {
		switch (this.getSpecial()) {
			case 0:
				return "";
			case 1:
				return "ocean_";
			case 2:
				return "biggs_";
			case 3:
				return "green_";
			case 4:
				return "bruneau_";
			case 5:
				return "purple_";
			case 6:
				return "flame_";
			case 7:
				return "picture_";
			case 8:
				return "candy_cane_";
		}
		return null;
	}

	@Override
	public int getSpecial() {
		return this.dataManager.get(EntityGem.SPECIAL);
	}

	@Override
	public void whenDefective() {
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.0D);
		this.setSize(0.63F, 2.3F);
	}

	/*********************************************************
	 * Methods related to entity combat. *
	 *********************************************************/
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (!this.world.isRemote) {
			this.charge_ticks += 20;
			this.hit_count += 1;
			if (this.isCharged()) {
				AxisAlignedBB axisalignedbb = new AxisAlignedBB(this.posX, this.posY, this.posZ, this.posX + 1,
						this.posY + 1, this.posZ + 1).grow(8.0, this.world.getHeight(), 8.0);
				List<EntityLivingBase> list = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class,
						axisalignedbb);
				for (EntityLivingBase entity : list) {
					if (!this.isOwner(entity)) {
						boolean shouldAttack = true;
						if (entity instanceof EntityGem) {
							EntityGem gem = (EntityGem) entity;
							if (this.getServitude() == gem.getServitude()) {
								if (this.getServitude() == EntityGem.SERVE_HUMAN && this.getOwner() != null) {
									shouldAttack = !this.isOwnerId(gem.getOwnerId());
								} else {
									shouldAttack = false;
								}
							}
						}
						if (shouldAttack) {
							if (entity.attackEntityFrom(DamageSource.causeMobDamage(this), 7 + this.rand.nextInt(15))) {
								entity.motionY += 0.9D;
								this.applyEnchantments(this, entity);
							}
						}
					}
				}
				if (this.getServitude() == EntityGem.SERVE_HUMAN) {
					
				}
				 
			} else {
				if (entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 10 + this.rand.nextInt(15))) {
					entityIn.motionY += 0.4D;
					this.applyEnchantments(this, entityIn);
				}
			}
		}
		return super.attackEntityAsMob(entityIn);
	}

	/*********************************************************
	 * Methods related to entity living. *
	 *********************************************************/
	@Override
	public void onLivingUpdate() {
		if (!this.isInWater() || !this.isAirBorne) {
			this.regenTicks += 1;
		}
		if (this.hit_count > 12) {
			this.charge_ticks -= 1;
			this.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 80));
			this.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 80));
			this.setCharged(true);

			if (this.charge_ticks < 1) {
				this.hit_count = 0;
				this.setCharged(false);
			}
		}
		if (this.regenTicks > 200 && !(this.isDead || this.getHealth() <= 0.0F)
				&& this.getHealth() < this.getMaxHealth()) {
			this.heal(1.0F);
			this.regenTicks = 0;
			
		}
		this.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 80));
		super.onLivingUpdate();
	}

	/*********************************************************
	 * Methods related to entity death. *
	 *********************************************************/
	@Override
	public void onDeath(DamageSource cause) {
		switch (this.getSpecial()) {
			case 0:
				if (this.isPrimary()) {
					this.droppedGemItem = ModItems.EMERALD_GEM;
					this.droppedCrackedGemItem = ModItems.CRACKED_EMERALD_GEM;
				}
				break;
			
			default:
				this.droppedGemItem = ModItems.EMERALD_GEM;
				this.droppedCrackedGemItem = ModItems.CRACKED_EMERALD_GEM;
				break;
		}
		super.onDeath(cause);
	}

	/*********************************************************
	 * Methods related to entity sounds. *
	 *********************************************************/
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return ModSounds.BLUE_DIAMOND_HURT;
	}

	@Override
	protected SoundEvent getObeySound() {
		return ModSounds.ROSE_QUARTZ_OBEY;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSounds.YELLOW_DIAMOND_DEATH;
	}

	/*********************************************************
	 * Methods related to entity rendering. *
	 *********************************************************/
	@Override
	protected int generateSkinColor() {
		return Colors.arbiLerp(EntityEmerald.SKIN_COLORS.get(this.getSpecial()));
	}

	@Override
	protected int generateHairStyle() {
		return this.rand.nextInt(EntityEmerald.NUM_HAIRSTYLES);
	}

	@Override
	protected int generateHairColor() {
		return Colors.arbiLerp(EntityEmerald.HAIR_COLORS.get(this.getSpecial()));
	}

	@Override
	public boolean hasUniformVariant(GemPlacements placement) {
		switch (placement) {
			case BELLY:
				return true;
			default:
				return false;
		}
	}

	@Override
	public boolean hasCape() {
		return true;
	}

	@Override
	public boolean hasHairVariant(GemPlacements placement) {
		switch (placement) {
			case FOREHEAD:
				return true;
			default:
				return false;
		}
	}

	public boolean hasSecondMarking() {
		switch (this.getSpecial()) {
			case 0:
				return false;
			case 1:
				return true;
			case 2:
				return true;
			case 3:
				return false;
			case 4:
				return true;
			case 5:
				return false;
			case 6:
				return true;
			case 7:
				return true;
			case 8:
				return true;
			default:
				return false;
		}
	}

	protected int generateMark1Color() {
		return Colors.arbiLerp(EntityEmerald.MARK_1_COLORS.get(this.getSpecial()));
	}

	protected int generateMark1() {
		return this.rand.nextInt(EntityEmerald.MARK1S.get(this.getSpecial()));
	}

	protected int generateMark2Color() {
		return Colors.arbiLerp(EntityEmerald.MARK_2_COLORS.get(this.getSpecial()));
	}

	protected int generateMark2() {
		if (this.hasSecondMarking()) {
			return this.rand.nextInt(EntityEmerald.MARK2S.get(this.getSpecial()));
		} else {
			return 0;
		}
	}

	public int getMark1Color() {
		return this.dataManager.get(EntityEmerald.MARK_1_COLOR);
	}

	public void setMark1Color(int mark1Color) {
		this.dataManager.set(EntityEmerald.MARK_1_COLOR, mark1Color);
	}

	public int getMark1() {
		return this.dataManager.get(EntityEmerald.MARK_1);
	}

	public void setMark1(int mark1) {
		this.dataManager.set(EntityEmerald.MARK_1, mark1);
	}

	public int getMark2Color() {
		return this.dataManager.get(EntityEmerald.MARK_2_COLOR);
	}

	public void setMark2Color(int mark2Color) {
		this.dataManager.set(EntityEmerald.MARK_2_COLOR, mark2Color);
	}

	public int getMark2() {
		return this.dataManager.get(EntityEmerald.MARK_2);
	}

	public void setMark2(int mark2) {
		this.dataManager.set(EntityEmerald.MARK_2, mark2);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return this.isCharged() ? 15728880 : super.getBrightnessForRender();
	}
	@Override
	public float getBrightness() {
		return this.isCharged() ? 1.0F : super.getBrightness();
	}
}