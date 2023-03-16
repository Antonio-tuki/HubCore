package dev.fxmxgragfx.hub.cosmetics.buttons.suit;

import com.google.common.collect.Lists;
import dev.cougar.core.util.menu.Button;
import dev.fxmxgragfx.hub.utils.CC;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ClearArmorButton extends Button {

    public String getName(Player player) {
        return CC.translate("&c&lClear your suit");
    }

    public List<String> getDescription(Player player) {
        List<String> lore = Lists.newArrayList();
        lore.add(CC.translate(""));
        lore.add(CC.translate("&7Change your armor design"));
        lore.add(CC.translate(""));
        lore.add(CC.translate("&eClick to select the Armor"));
        return lore;
    }

    @EventHandler
    public void clicked(Player player, int i, ClickType clickType) {
        if (clickType.isRightClick() || clickType.isLeftClick()) {
            player.getInventory().setLeggings(null);
            player.getInventory().setChestplate(null);
            player.getInventory().setBoots(null);
            player.getInventory().setHelmet(null);
            player.closeInventory();
        }
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemStack(Material.BED);
    }
}
