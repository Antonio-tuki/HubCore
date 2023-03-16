package dev.fxmxgragfx.hub.scoreboard;

import dev.fxmxgragfx.hub.utils.CC;
import mx.fxmxgragfx.api.scoreboard.ScoreboardConfiguration;
import mx.fxmxgragfx.api.scoreboard.TitleGetter;
import org.bukkit.Bukkit;


public class ScoreConfiguration {

    public static ScoreboardConfiguration create() {
        return (new ScoreboardConfiguration(new TitleGetter(CC.translate("&b&lTrainingPvP &7┃ &r" + Bukkit.getServer().getServerName())), new ScoreboardHub()));
    }

}
