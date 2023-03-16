package dev.fxmxgragfx.hub.listener;

import cc.fyre.venom.Venom;
import dev.fxmxgragfx.hub.utils.CC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    public void onChat(AsyncPlayerChatEvent event) {
        event.setFormat(CC.translate(Venom.instance.api.getGrantHandler().findBestRank(event.getPlayer().getUniqueId()).getPrefix() + Venom.instance.api.getGrantHandler().findBestRank(event.getPlayer().getUniqueId()).getColor() + event.getPlayer().getName() + "&7: &f" + event.getMessage()));
    }
}
