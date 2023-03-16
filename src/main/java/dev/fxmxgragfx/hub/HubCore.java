package dev.fxmxgragfx.hub;

import dev.cougar.core.Core;
import dev.fxmxgragfx.hub.listener.ChatListener;
import dev.fxmxgragfx.hub.listener.EnderbuttListener;
import dev.fxmxgragfx.hub.listener.PlayerListener;
import dev.fxmxgragfx.hub.listener.ServerItemListener;
import dev.fxmxgragfx.hub.scoreboard.ScoreConfiguration;
import dev.fxmxgragfx.hub.tablist.TablistGetter;
import dev.fxmxgragfx.hub.tablist.TablistManager;
import dev.fxmxgragfx.hub.utils.CC;
import dev.fxmxgragfx.hub.utils.ServerUtil;
import lombok.Getter;
import mx.fxmxgragfx.api.command.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class HubCore extends JavaPlugin {

    @Getter
    private static HubCore instance;
    @Getter
    private ServerUtil serverHandler;

    public void onEnable() {
        //registerBungeeCount();
        this.serverHandler = new ServerUtil(this);

        // Listerner Setup
        setupListerner();
        Bukkit.getConsoleSender().sendMessage(CC.translate("&aListerners charge correctly."));
        //

        // Scoreboard Setup
        Core.getInstance().scoreboardEngine.setConfiguration(ScoreConfiguration.create());
        Bukkit.getConsoleSender().sendMessage(CC.translate("&aScoreboard charge correctly."));
        //

        // Commands Setup
        CommandHandler commandHandler = new CommandHandler();
        commandHandler.load();
        commandHandler.registerAll(this);
        Bukkit.getConsoleSender().sendMessage(CC.translate("&aCommands charge correctly."));
        //

        // Tablist Setup
        new TablistManager(this, new TablistGetter(), 500L);
        Bukkit.getConsoleSender().sendMessage(CC.translate("&aTablist charge correctly."));
        //

        new BukkitRunnable() {
            public void run() {
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gamerule doMobSpawning false");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gamerule commandBlockOutput false");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gamerule logAdminCommands false");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gamerule mobGriefing false");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gamerule doDaylightCycle false");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gamerule sendCommandFeedback false");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "difficulty peaceful");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "time set day");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "timings off");
            }
        }.runTaskLater(this, 300L);
        Bukkit.getConsoleSender().sendMessage(CC.translate("&aHubCore has been enabled."));
        instance = this;
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(CC.translate("&cHubCore has been disabled."));
    }

    public void setupListerner() {
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new ServerItemListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new EnderbuttListener(), this);
    }

}

