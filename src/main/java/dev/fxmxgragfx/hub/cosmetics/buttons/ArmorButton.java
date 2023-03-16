package dev.fxmxgragfx.hub.cosmetics.buttons;

import com.google.common.collect.Lists;
import dev.cougar.core.util.menu.Button;
import dev.fxmxgragfx.hub.cosmetics.ArmorMenu;
import dev.fxmxgragfx.hub.utils.CC;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ArmorButton extends Button {

    public String getName(Player player) {
        return CC.translate("&c&lArmors");
    }

    public List<String> getDescription(Player player) {
        List<String> lore = Lists.newArrayList();
        lore.add(CC.translate(""));
        lore.add(CC.translate("&7Change your armor design"));
        lore.add(CC.translate(""));
        lore.add(CC.translate("&eClick to view Armor Designs."));
        return lore;
    }

    public void clicked(Player player, int i, ClickType clickType) {
        if (clickType.isRightClick() || clickType.isLeftClick()) {
            new ArmorMenu().openMenu(player);
        }
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemStack(Material.LEATHER_CHESTPLATE);
    }
}
