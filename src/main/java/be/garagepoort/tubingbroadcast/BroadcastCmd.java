package be.garagepoort.tubingbroadcast;

import be.garagepoort.mcioc.IocCommandHandler;
import be.garagepoort.mcioc.tubinggui.GuiActionService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@IocCommandHandler("broadcast")
public class BroadcastCmd implements CommandExecutor {

    private final GuiActionService guiActionService;

    public BroadcastCmd(GuiActionService guiActionService) {
        this.guiActionService = guiActionService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("&CThe broadcast command can only be executed by a player.");
            return false;
        }
        guiActionService.executeAction((Player) sender, "broadcast/message-select");
        return true;
    }
}
