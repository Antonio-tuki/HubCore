package dev.fxmxgragfx.hub.cosmetics.buttons;

import com.google.common.collect.Lists;
import dev.cougar.core.util.menu.Button;
import dev.fxmxgragfx.hub.cosmetics.ParticliesMenu;
import dev.fxmxgragfx.hub.utils.CC;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ParticlesButton extends Button {

    public String getName(Player player) {
        return CC.translate("&2&lParticles");
    }

    public List<String> getDescription(Player player) {
        List<String> lore = Lists.newArrayList();
        lore.add(CC.translate(""));
        lore.add(CC.translate("&7Alot of different particles"));
        lore.add(CC.translate("&7are spawning around you."));
        lore.add(CC.translate(""));
        lore.add(CC.translate("&eClick to view list of Particles."));

        return lore;
    }

    public void clicked(Player player, int i, ClickType clickType) {
        if (clickType.isRightClick() || clickType.isLeftClick()) {
            new ParticliesMenu().openMenu(player);
        }
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemStack(Material.NETHER_STAR);
    }
}
