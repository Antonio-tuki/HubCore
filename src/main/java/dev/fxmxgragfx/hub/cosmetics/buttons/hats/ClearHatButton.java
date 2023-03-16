package dev.fxmxgragfx.hub.cosmetics.buttons.hats;

import com.google.common.collect.Lists;
import dev.cougar.core.util.menu.Button;
import dev.fxmxgragfx.hub.utils.CC;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ClearHatButton extends Button {

    public String getName(Player player) {
        return CC.translate("&c&lClear your hat");
    }

    public List<String> getDescription(Player player) {
        List<String> lore = Lists.newArrayList();
        lore.add(CC.translate(""));
        lore.add(CC.translate("&7Change your hat design"));
        lore.add(CC.translate(""));
        lore.add(CC.translate("&eClick to select the hat"));
        return lore;
    }

    @EventHandler
    public void clicked(Player player, int i, ClickType clickType) {
        if (clickType.isRightClick() || clickType.isLeftClick()) {
            player.getInventory().setHelmet(null);
            player.closeInventory();
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

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemStack(Material.BED);
    }
}
