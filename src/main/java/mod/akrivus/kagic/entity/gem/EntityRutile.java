package mod.akrivus.kagic.entity.gem;

import java.util.HashMap;

import com.google.common.base.Predicate;

import mod.akrivus.kagic.entity.EntityGem;
import mod.akrivus.kagic.entity.ai.EntityAIFollowDiamond;
import mod.akrivus.kagic.entity.ai.EntityAIStandGuard;
import mod.akrivus.kagic.entity.ai.EntityAIStay;
import mod.akrivus.kagic.init.ModBlocks;
import mod.akrivus.kagic.init.ModItems;
import mod.akrivus.kagic.init.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRutile extends EntityGem {
	public static final HashMap<Block, Double> RUTILE_YIELDS = new HashMap<Block, Double>();
	public EntityRutile(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 1.9F);
		this.seePastDoors();
		
		// Apply entity AI.
		this.stayAI = new EntityAIStay(this);
		this.tasks.addTask(1, new EntityAIAvoidEntity<EntityCreeper>(this, EntityCreeper.class, new Predicate<EntityCreeper>() {
			public boolean apply(EntityCreeper input) {
				return ((EntityCreeper) input).getCreeperState() == 1;
			}
        }, 6.0F, 1.0D, 1.2D));
		this.tasks.addTask(1, new EntityAIFollowDiamond(this, 1.0D));
        this.tasks.addTask(3, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityMob.class, 16.0F));
        this.tasks.addTask(6, new EntityAIStandGuard(this, 0.6D));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        
        // Apply entity attributes.
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.droppedGemItem = ModItems.RUTILE_GEM;
		this.droppedCrackedGemItem = ModItems.CRACKED_RUTILE_GEM;
	}
	public boolean isCorrectGemPlacement() {
		switch (GemPlacements.values()[this.getGemPlacement()]) {
		case NOSE:
			return false;
		case LEFT_SHOULDER:
			return false;
		case RIGHT_SHOULDER:
			return false;
		case LEFT_HAND:
			return false;
		case RIGHT_HAND:
			return false;
		case LEFT_THIGH:
			return false;
		case RIGHT_THIGH:
			return false;
		case LEFT_KNEE:
			return false;
		case RIGHT_KNEE:
			return false;
		default:
			return true;
		}
	}
	public boolean isCorrectGemCut() {
    	switch (GemCuts.values()[this.getGemCut()]) {
    	case BISMUTH:
    		return false;
    	case PERIDOT:
    		return false;
    	default:
    		return true;
    	}
    }
	public float[] getGemColor() {
    	return new float[] { 174F / 255F, 29F / 255F, 72F / 255F };
    }
	public SoundEvent getAmbientSound() {
		return ModSounds.SAPPHIRE_LIVING;
	}
	public SoundEvent getHurtSound() {
		return ModSounds.SAPPHIRE_HURT;
	}
	public SoundEvent getObeySound() {
		return ModSounds.SAPPHIRE_OBEY;
	}
	public SoundEvent getDeathSound() {
		return ModSounds.SAPPHIRE_DEATH;
	}
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		return super.processInteract(player, hand);
    }
	public void onLivingUpdate() {
        if (this.isTamed() && !this.isSitting()) {	
	        if (this.world.isAirBlock(this.getPosition())) {
	            this.world.setBlockState(this.getPosition(), ModBlocks.RUTILE_TRAIL.getDefaultState());
	        }
		}
		super.onLivingUpdate();
	}
}
