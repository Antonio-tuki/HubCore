package dev.fxmxgragfx.hub.listener;

import dev.fxmxgragfx.hub.selector.ServerItem;
import dev.fxmxgragfx.hub.utils.CC;
import dev.fxmxgragfx.hub.utils.ItemStackUtil;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.spigotmc.event.entity.EntityDismountEvent;


public class EnderbuttListener implements Listener {

    @EventHandler
    public void onPearl(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        if (action == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null && event.getItem().isSimilar(ItemStackUtil.createItem(Material.ENDER_PEARL, 1, CC.translate("&9&l» &5Ender Butt &9&l«")))) {
                event.setCancelled(true);
                if (player.isInsideVehicle()) {
                    player.getVehicle().remove();
                }
                event.setUseItemInHand(org.bukkit.event.Event.Result.DENY);
                event.setUseInteractedBlock(org.bukkit.event.Event.Result.DENY);
                EnderPearl pearl = player.launchProjectile(EnderPearl.class);
                pearl.setPassenger(player);
                pearl.setVelocity(player.getLocation().getDirection().normalize().multiply(3F));
                player.getWorld().playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                player.spigot().setCollidesWithEntities(false);
                player.getInventory().clear();
                event.getPlayer().getInventory().setItem(0, ItemStackUtil.createItem(Material.COMPASS, 1, CC.translate("&9&l» &eServer Selector &9&l«")));
                event.getPlayer().getInventory().setItem(7, ServerItem.HIDEPLAYERS.getItemStack());
                event.getPlayer().getInventory().setItem(4, ItemStackUtil.createItem(Material.NETHER_STAR, 1, CC.translate("&9&l» &dCosmetics &9&l«")));
                event.getPlayer().getInventory().setItem(8, ItemStackUtil.createItem(Material.ENDER_PEARL, 1, CC.translate("&9&l» &5Ender Butt &9&l«")));
                player.updateInventory();
            }
        }
    }
    @EventHandler
    public void onDismount(EntityDismountEvent event) {
        event.getDismounted().remove();
    }
}
