package dev.fxmxgragfx.hub.utils;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class CC {

    public static String translate(String in) {
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', in);
    }

    public static List<String> translate(List<String> in) {
        return in.stream().map(CC::translate).collect(Collectors.toList());
    }

    public static void player(Player player, String in) {
        player.sendMessage(translate(in));
    }
}

