package mod.kagic.command;

import mod.kagic.exeptions.StevenUniverseExeption;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.crash.CrashReport;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.biome.Biome;
import mod.kagic.exeptions.StevenUniverseExeption;
/**
 * This command will return Biome Spawn pos
 */
public class CommandTestCrash extends CommandBase {

    @Override
    public String getName() {
        
        return "makeCrash";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/makeCrash";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
      
        sender.sendMessage(new TextComponentString("Muhhahaha Time to take over world!!!!! Where Are the Crystal Gems? Try to stope me "));
        CrashReport.makeCrashReport(new StevenUniverseExeption("From CrystalGems"),"We are the Crystal Gems.... We'll always save the day And if you think we can't, We'll always find a way. That's why the people of this world Believe in Garnet, Amethyst, and Pearl and Steven! - Nicholas Blackburn A Big Steven Universe Fan... 2020");

    }
    
}
