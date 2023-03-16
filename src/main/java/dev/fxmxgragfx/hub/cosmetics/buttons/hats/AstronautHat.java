package dev.fxmxgragfx.hub.cosmetics.buttons.hats;

import com.google.common.collect.Lists;
import dev.cougar.core.util.menu.Button;
import dev.fxmxgragfx.hub.utils.CC;
import dev.fxmxgragfx.hub.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class AstronautHat extends Button {


    public String getName(Player player) {
        return CC.translate("&d&lAstronaut Hat");
    }

    public List<String> getDescription(Player player) {
        List<String> lore = Lists.newArrayList();
        lore.add(CC.translate(""));
        lore.add(CC.translate("&7Change your hat design"));
        lore.add(CC.translate(""));
        lore.add(CC.translate("&eClick to select the hat"));
        return lore;
    }


    public Material getMaterial(Player player) {

        return null;
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(Material.GLASS, 1).name(CC.translate( "&d&lAstronaut Hat")).build();
    }

    @EventHandler
    public void clicked(Player player, int i, ClickType clickType) {
        if (player.hasPermission("hub.astronauthat")) {
            if (clickType.isRightClick() || clickType.isLeftClick()) {
                ItemStack helmet = new ItemBuilder(Material.GLASS, 1).name(CC.translate( "&d&lAstronaut Hat")).build();
                player.getInventory().setHelmet(helmet);
                player.closeInventory();
            }
        } else {
            player.closeInventory();
            player.sendMessage(CC.translate("&cYou don't have Rank! Purchase it at store.cougar.rip"));
        }
    }
}