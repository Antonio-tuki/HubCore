package dev.fxmxgragfx.hub.selector;


import dev.cougar.core.util.item.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public enum ServerItem {

    SHOWPLAYERS("Show Players"), HIDEPLAYERS("Hide Players");

    public String getName() {
        return name;
    }

    private final String name;

    ServerItem(String name) {
        this.name = name;
    }


    public void getInteraction(Player player) {
        switch (this) {
            case HIDEPLAYERS:
                Bukkit.getServer().getOnlinePlayers().forEach(player::hidePlayer);
                player.sendMessage(ChatColor.LIGHT_PURPLE + "You toggled player visibility off!");
                break;
            case SHOWPLAYERS:
                Bukkit.getServer().getOnlinePlayers().forEach(player::showPlayer);
                player.sendMessage(ChatColor.AQUA + "You toggled player visibility on!");
                break;
        }
    }

    public ItemStack getItemStack() {
        switch (this) {
            case SHOWPLAYERS:

                ItemBuilder showPlayers = new ItemBuilder(Material.LEVER);
                showPlayers.name("&9&l» &aShow Players &9&l«");
                return showPlayers.build();
            case HIDEPLAYERS:
                ItemBuilder hidePlayers = new ItemBuilder(Material.REDSTONE_TORCH_ON);
                hidePlayers.name("&9&l» &7Hide Players &9&l«");
                return hidePlayers.build();
            default:
                return new ItemStack(Material.AIR, 1);
        }
    }
}