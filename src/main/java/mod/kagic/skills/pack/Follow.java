package mod.kagic.skills.pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mod.kagic.entity.EntityCrystalSkills;
import mod.kagic.entity.EntityGem;
import mod.kagic.linguistics.LinguisticsHelper;
import mod.kagic.skills.Speak;
import net.minecraft.entity.EntityLivingBase;

public class Follow extends Speak<EntityGem> {
	private EntityLivingBase destination = null;
	public Follow() {
		this.TRIGGER_VERBS = new ArrayList<String>(Arrays.asList(new String[] { 
			"follow"
		}));
		this.TRIGGER_NOUNS = new ArrayList<String>();
		this.canBeStopped = true;
		this.can(RunWith.TARGETTING);
		this.priority(Priority.LOW);
		this.task(true);
	}
	@Override
	public boolean proceed(EntityGem gem) {
		return this.destination != null && !this.destination.isDead;
	}
	@Override
	public void init(EntityGem gem) {
		if (this.selectedNoun.equals("me")) {
			this.destination = gem.lastPlayerSpokenTo;
		}
		else {
			List<EntityLivingBase> entities = gem.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, gem.getEntityBoundingBox().grow(16.0D, 8.0D, 16.0D), null);
			if (!entities.isEmpty()) {
				double minDistance = Double.MAX_VALUE;
				for (EntityLivingBase entity : entities) {
					double distance = gem.getDistanceSq(entity);
					if (gem.getDistanceSq(entity) < minDistance && !gem.equals(entity)) {
						if (LinguisticsHelper.getDistance(entity.getName(), this.selectedNoun) < 3) {
							this.destination = entity;
							minDistance = distance;
						}
					}
				}
			}
		}
		gem.setSitting(this.destination, false);
	}
	@Override
	public void run(EntityGem gem) {
		if (this.destination != null) {
			if (!gem.isOwner(this.destination)) {
				gem.lookAt(this.destination);
				if (gem.getDistanceSq(this.destination) > 5) {
					gem.tryToMoveTo(this.destination.getPosition());	
				}
			}
		}
	}
	@Override
	public void reset(EntityGem gem) {
		gem.setSitting(this.destination, true);
		this.destination = null;
	}
	@Override
	public String toString() {
		return "following " + this.destination.getName();
	}
}
