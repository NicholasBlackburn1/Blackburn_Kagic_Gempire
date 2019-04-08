package mod.kagic.skills.pack;

import java.util.ArrayList;
import java.util.Arrays;

import mod.kagic.entity.EntityCrystalSkills;
import mod.kagic.linguistics.LinguisticsHelper;
import mod.kagic.skills.SkillBase;
import net.minecraft.entity.player.EntityPlayer;

public class Stop extends SkillBase {
	public Stop() {
		this.can(RunWith.EVERYTHING);
		this.priority(Priority.CORE);
		this.task(false);
	}
	@Override
	public boolean speak(EntityCrystalSkills gem, EntityPlayer player, String message) {
		ArrayList<String> WORDS = new ArrayList<String>(Arrays.asList(new String[] { "halt", "stop", "rest", "quit", "freeze" }));
		String[] tokens = LinguisticsHelper.getTokens(message);
		for (String token : tokens) {
			if (WORDS.contains(token)) {
				for (SkillBase skill : gem.skills.values()) {
					if (skill.canBeStopped) {
						skill.isAllowedToRun = false;
					}
				}
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean triggered(EntityCrystalSkills gem) {
		this.readyForRemoval = true;
		return false;
	}
	@Override
	public String toString() {
		return "stopping";
	}
}
