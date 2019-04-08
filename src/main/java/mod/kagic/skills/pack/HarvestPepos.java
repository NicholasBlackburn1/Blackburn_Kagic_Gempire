package mod.kagic.skills.pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mod.kagic.entity.EntityGem;
import mod.kagic.entity.gem.EntityPearl;
import mod.kagic.entity.gem.EntityPeridot;
import mod.kagic.skills.Speak;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;

public class HarvestPepos extends Speak<EntityGem> {
	private BlockPos harvestLocation = null;
	private int goal = 0;
	private int amountBeforeGoal = 0;
	private int lastBlockBreak = 0;
	private boolean cut = false;
	public HarvestPepos() {
		this.TRIGGER_VERBS = new ArrayList<String>(Arrays.asList(new String[] {
			"collect",
			"plant",
			"pull",
			"get",
			"cut"
		}));
		this.canBeStopped = true;
		this.killsOnEnd = true;
		this.can(RunWith.RESTING);
		this.task(true);
	}
	@Override
	public boolean triggered(EntityGem gem) {
		boolean previous = this.isAllowedToRun;
		if (previous) {
			if (!this.collectedNumbers.isEmpty()) {
				try {
					this.goal = Integer.parseInt(this.collectedNumbers.get(0));
				}
				catch (Exception ex) {
					this.goal = 0;
				}
			}
		}
		return previous;
	}
	@Override
	public boolean proceed(EntityGem gem) {
		boolean hasPearl = gem instanceof EntityPearl || gem instanceof EntityPeridot;
		if (this.harvestLocation != null && this.amountBeforeGoal <= this.goal) {
			if (!hasPearl) {
				List<EntityPearl> list = gem.world.<EntityPearl>getEntitiesWithinAABB(EntityPearl.class, gem.getEntityBoundingBox().grow(8.0D, 4.0D, 8.0D));
				for (EntityPearl entity : list) {
					if (entity.isOwnedBySamePeople(gem)) {
						hasPearl = true;
					}
		        }
			}
			return hasPearl && !this.cut;
		}
		return false;
	}
	@Override
	public void init(EntityGem gem) {
		ArrayList<BlockPos> plants = new ArrayList<BlockPos>();
		this.harvestLocation = null;
		for (int x = -16; x < 16; ++x) {
			for (int y = -8; y < 8; ++y) {
				for (int z = -16; z < 16; ++z) {
					IBlockState state = gem.world.getBlockState(gem.getPosition().add(x, y, z));
					if (this.isCorrectPlant(state)) {
						plants.add(gem.getPosition().add(x, y, z));
					}
				}
			}
		}
		double minDistance = Double.MAX_VALUE;
		for (int i = 0; i < plants.size(); ++i) {
			double distance = gem.getDistanceSqToCenter(plants.get(i));
			if (distance < minDistance) {
				this.harvestLocation = plants.get(i);
				minDistance = distance;
			}
		}
	}
	@Override
	public void run(EntityGem gem) {
		if (this.harvestLocation != null) {
			gem.lookAt(this.harvestLocation);
			if (gem.getDistanceSqToCenter(this.harvestLocation) < 5) {
				if (this.lastBlockBreak > 20) {
					boolean success = false;
					success = gem.breakBlock(this.harvestLocation);
					this.cut = success;
					if (success) {
						if (this.goal > 0) {
							++this.amountBeforeGoal;
						}
						if (this.amountBeforeGoal <= this.goal) {
							this.harvestLocation = null;
							this.cut = false;
							this.init(gem);
						}
					}
					this.lastBlockBreak = 0;
				}
				++this.lastBlockBreak;
			}
			else {
				gem.tryToMoveTo(this.harvestLocation);
			}
		}
	}
	@Override
	public void reset(EntityGem gem) {
		this.harvestLocation = null;
		this.amountBeforeGoal = 0;
		this.goal = 0;
		this.cut = false;
	}
	public boolean isCorrectPlant(IBlockState state) {
		return false;
	}
	@Override
	public String toString() {
		return "harvesting " + this.selectedNoun;
	}
}
