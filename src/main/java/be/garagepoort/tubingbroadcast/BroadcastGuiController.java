package be.garagepoort.tubingbroadcast;

import be.garagepoort.mcioc.configuration.ConfigProperty;
import be.garagepoort.mcioc.tubinggui.GuiAction;
import be.garagepoort.mcioc.tubinggui.GuiController;
import be.garagepoort.mcioc.tubinggui.GuiParam;
import be.garagepoort.mcioc.tubinggui.templates.GuiTemplate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

import static be.garagepoort.mcioc.tubinggui.templates.GuiTemplate.template;
import static org.bukkit.ChatColor.translateAlternateColorCodes;

@GuiController
public class BroadcastGuiController {

    @ConfigProperty("tubing-example.broadcast-messages")
    private List<String> predefinedMessages;
    @ConfigProperty("tubing-example.broadcast-prefix")
    private String broadcastPrefix;

    @GuiAction("broadcast/message-select")
    public GuiTemplate viewMessageSelect() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("messages", predefinedMessages);
        return template("gui/broadcast/message-select.ftl", params);
    }

    @GuiAction("broadcast/send-message")
    public void sendMessage(Player player, @GuiParam("message") String message) {
        String coloredMessage = translateAlternateColorCodes('&', broadcastPrefix + message);
        Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(coloredMessage));
    }
}
