package dev.fxmxgragfx.hub.cosmetics.buttons.suit;

import com.google.common.collect.Lists;
import dev.cougar.core.util.menu.Button;
import dev.fxmxgragfx.hub.utils.CC;
import dev.fxmxgragfx.hub.utils.ItemBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MediaButton extends Button {

    public String getName(Player player) {
        return CC.translate("&d&lMedia Suit");
    }

    public List<String> getDescription(Player player) {
        List<String> lore = Lists.newArrayList();
        lore.add(CC.translate(""));
        lore.add(CC.translate("&7Change your armor design"));
        lore.add(CC.translate(""));
        lore.add(CC.translate("&eClick to select the Armor"));
        return lore;
    }


    public Material getMaterial(Player player) {
        return null;
    }

    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(Material.LEATHER_CHESTPLATE, 1).name(CC.translate( "&dMedia Suit")).color(convert("d")).build();
    }

    @EventHandler
    public void clicked(Player player, int i, ClickType clickType) {
        if (player.hasPermission("hub.mediasuit")) {
            if (clickType.isRightClick() || clickType.isLeftClick()) {
                ItemStack helmet = new ItemBuilder(Material.LEATHER_HELMET, 1).name(CC.translate( "&dMedia Suit")).color(convert("d")).build();
                ItemStack chestplate = new ItemBuilder(Material.LEATHER_CHESTPLATE, 1).name(CC.translate( "&dMedia Suit")).color(convert("d")).build();
                ItemStack leggings = new ItemBuilder(Material.LEATHER_LEGGINGS, 1).name(CC.translate( "&dMedia Suit")).color(convert("d")).build();
                ItemStack boots = new ItemBuilder(Material.LEATHER_BOOTS, 1).name(CC.translate( "&dMedia Suit")).color(convert("d")).build();
                player.getInventory().setLeggings(leggings);
                player.getInventory().setChestplate(chestplate);
                player.getInventory().setBoots(boots);
                player.getInventory().setHelmet(helmet);
                player.closeInventory();
            }
        } else {
            player.closeInventory();
            player.sendMessage(CC.translate("&cYou don't have Rank! Purchase it at store.cougar.rip"));
        }
    }

    public static Color convert(String colorString) {
        if (colorString.contains("0")) {
            return Color.BLACK;
        }
        if (colorString.contains("1")) {
            return Color.BLUE;
        }
        if (colorString.contains("2")) {
            return Color.GREEN;
        }
        if (colorString.contains("3")) {
            return Color.TEAL;
        }
        if (colorString.contains("4")) {
            return Color.RED;
        }
        if (colorString.contains("5")) {
            return Color.PURPLE;
        }
        if (colorString.contains("6")) {
            return Color.ORANGE;
        }
        if (colorString.contains("7")) {
            return Color.SILVER;
        }
        if (colorString.contains("8")) {
            return Color.GRAY;
        }
        if (colorString.contains("9")) {
            return Color.BLUE;
        }
        if (colorString.contains("a")) {
            return Color.LIME;
        }
        if (colorString.contains("e")) {
            return Color.YELLOW;
        }
        if (colorString.contains("b")) {
            return Color.AQUA;
        }
        if (colorString.contains("d")) {
            return Color.FUCHSIA;
        }
        if (colorString.contains("f")) {
            return Color.WHITE;
        }
        return Color.BLACK;
    }
}
