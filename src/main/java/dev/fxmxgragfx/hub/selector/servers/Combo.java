package dev.fxmxgragfx.hub.selector.servers;

import com.google.common.collect.Lists;
import dev.cougar.core.util.menu.Button;
import dev.fxmxgragfx.hub.utils.CC;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Combo extends Button {

    public String getName(Player player) {
        return CC.translate("&e&lCombo");
    }


    public List<String> getDescription(Player player) {
        List<String> lore = Lists.newArrayList();
        lore.add(CC.translate("&cComing soon..."));
        return lore;
    }


    public void clicked(Player player, int i, ClickType clickType) {
        if (clickType.isRightClick() || clickType.isLeftClick()) {
            player.getPlayer().performCommand("joinqueue Combo");
            player.closeInventory();

        }
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemStack(Material.GOLDEN_APPLE);
    }
}
