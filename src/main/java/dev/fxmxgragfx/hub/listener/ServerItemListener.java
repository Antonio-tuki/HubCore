package dev.fxmxgragfx.hub.listener;

import dev.fxmxgragfx.hub.selector.ServerItem;
import dev.fxmxgragfx.hub.utils.DateTimeFormats;
import net.minecraft.util.gnu.trove.map.TObjectLongMap;
import net.minecraft.util.gnu.trove.map.hash.TObjectLongHashMap;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.TimeUnit;

public class ServerItemListener implements Listener {

    public static TObjectLongMap playerCooldowns = new TObjectLongHashMap();
    private static final long MINUTE = TimeUnit.MINUTES.toMillis(1L);
    private static final long HOUR = TimeUnit.HOURS.toMillis(1L);
    private static final long MULTI_HOUR = TimeUnit.HOURS.toMillis(10);

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
            if(event.getPlayer().getItemInHand().getType() == Material.AIR) return;
            ItemStack itemStack = event.getItem();
            if (itemStack.getType().equals(Material.LEVER)) {
                long timestamp = playerCooldowns.get(player);
                long millis = System.currentTimeMillis();
                long remaining = timestamp == playerCooldowns.getNoEntryValue() ? -1L : (timestamp - millis);
                if (remaining > 0L) {
                    player.sendMessage(ChatColor.RED + "Please wait " + getRemaining(remaining, true) + " to toggle player visibility!");
                    event.setCancelled(true);
                    return;
                }
                player.getInventory().setItem(7, ServerItem.HIDEPLAYERS.getItemStack());
                ServerItem.SHOWPLAYERS.getInteraction(player);
                playerCooldowns.put(player, millis + TimeUnit.SECONDS.toMillis(5L));

            } else if (itemStack.getType().equals(Material.REDSTONE_TORCH_ON)) {
                long timestamp = playerCooldowns.get(player);
                long millis = System.currentTimeMillis();
                long remaining = timestamp == playerCooldowns.getNoEntryValue() ? -1L : (timestamp - millis);
                if (remaining > 0L) {
                    player.sendMessage(ChatColor.RED + "Please wait " + getRemaining(remaining, true) + " to toggle player visibility!");
                    event.setCancelled(true);
                    return;
                }
                player.getInventory().setItem(7, ServerItem.SHOWPLAYERS.getItemStack());
                ServerItem.HIDEPLAYERS.getInteraction(player);
                playerCooldowns.put(player, millis + TimeUnit.SECONDS.toMillis(5L));
            }
        }
    }


    public static String getRemaining(long millis, boolean milliseconds) {
        return getRemaining(millis, milliseconds, true);
    }

    public static String getRemaining(long duration, boolean milliseconds, boolean trail) {
        if ((milliseconds) && (duration < MINUTE)) {
            return ((trail ? DateTimeFormats.REMAINING_SECONDS_TRAILING : DateTimeFormats.REMAINING_SECONDS).get()).format(duration * 0.001D) + 's';
        }
        return DurationFormatUtils.formatDuration(duration, (duration >= HOUR ? (duration >= MULTI_HOUR ? "H" : "") + "H:" : "") + "mm:ss");
    }
}
