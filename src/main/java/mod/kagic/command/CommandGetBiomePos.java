package mod.kagic.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.biome.Biome;

/**
 * This command will return Biome Spawn pos
 */
public class CommandGetBiomePos extends CommandBase {

    @Override
    public String getName() {
        
        return "getBiomes";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/getBiomes";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
      
        sender.sendMessage(new TextComponentString("Crystal Gems are here.. get biome command tets"));

    }
    
}
