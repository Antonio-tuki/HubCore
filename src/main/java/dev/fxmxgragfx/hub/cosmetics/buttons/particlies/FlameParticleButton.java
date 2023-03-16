package dev.fxmxgragfx.hub.cosmetics.buttons.particlies;

import com.google.common.collect.Lists;
import dev.cougar.core.util.menu.Button;
import dev.fxmxgragfx.hub.HubCore;
import dev.fxmxgragfx.hub.cosmetics.CosmeticsCache;
import dev.fxmxgragfx.hub.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class FlameParticleButton extends Button {

    public String getName(Player player) {
        return CC.translate("&6&lFlame Particle");
    }

    public List<String> getDescription(Player player) {
        List<String> lore = Lists.newArrayList();
        lore.add(CC.translate(""));
        lore.add(CC.translate("&eClick to select the Particle"));
        return lore;
    }

    public void clicked(Player player, int d, ClickType clickType) {
        if (clickType.isRightClick() || clickType.isLeftClick()) {
            if (player.hasPermission("hub.flameparticle")) {
                if(CosmeticsCache.set.containsKey(player)) {
                    Bukkit.getScheduler().cancelTask(CosmeticsCache.set.get(player));
                    CosmeticsCache.set.replace(player,Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(HubCore.getInstance(), () -> ParticleEffect.FLAME.display(10, 15, 0, 0, 0, player.getLocation().add(0, 2, 0), 10), 0, 0L));
                } else {
                    CosmeticsCache.set.put(player, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(HubCore.getInstance(), () -> ParticleEffect.FLAME.display(10, 15, 0, 0, 0, player.getLocation().add(0, 2, 0), 10), 0, 0L));
                }
                player.closeInventory();
                player.playSound(player.getPlayer().getLocation(), Sound.FIRE, 20.0F, 20.0F);
            } else {
                player.closeInventory();
                player.sendMessage(CC.translate("&cYou don't have Rank! Purchase it at store.cougar.rip"));
            }
        }
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemStack(Material.BLAZE_POWDER);
    }
}