package mod.kagic.command;

import java.util.List;

import mod.kagic.entity.EntityGem;
import mod.kagic.util.ShatterDamage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.server.MinecraftServer;

public class CommandDestroyGem extends CommandBase {
	@Override
	public String getName() {
		return "degem";
	}
	@Override
	public String getUsage(ICommandSender sender) {
		return "/degem [filter] [radius]";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender.getCommandSenderEntity() instanceof EntityLivingBase) {
			int radius = 11;
			String filter = "all";
			if (args.length > 1) {
				radius = Integer.parseInt(args[1]);
			}
			if (args.length > 0) {
				filter = args[0];
			}
			List<EntityGem> list = sender.getCommandSenderEntity().world.<EntityGem>getEntitiesWithinAABB(EntityGem.class, sender.getCommandSenderEntity().getEntityBoundingBox().grow(radius, radius, radius));
			for (EntityGem gem : list) {
				boolean destroy = false;
				if (filter == "all") {
					destroy = true;
				} else if (filter == "mine") {
					destroy = gem.isOwnedBy((EntityLivingBase) sender.getCommandSenderEntity());
				} else if (filter == "other") {
					destroy = !gem.isOwnedBy((EntityLivingBase) sender.getCommandSenderEntity());
				} else if (filter == "tamed") {
					destroy = gem.isTamed();
				} else if (filter == "wild") {
					destroy = !gem.isTamed();
				} else if (filter == "rebel") {
					destroy = gem.isTraitor() || gem.getServitude() == EntityGem.SERVE_REBELLION;
				} else if (filter == "diamond") {
					destroy = gem.getServitude() > EntityGem.SERVE_HUMAN;
				}
				if (destroy) {
					EntityLightningBolt lightningBolt = new EntityLightningBolt(sender.getEntityWorld(), gem.posX, gem.posY, gem.posZ, true);
					sender.getEntityWorld().addWeatherEffect(lightningBolt);
					gem.attackEntityFrom(new ShatterDamage(), gem.getHealth());
				}
			}
		}
	}
}
