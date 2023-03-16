package dev.fxmxgragfx.hub.tablist;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UpdateTablistTask implements Runnable
{
    Tablist tablist;

    @Override
    public void run() {
        this.send();
    }

    @SuppressWarnings("deprecation")
    public void send() {
        final TablistManager manager = TablistManager.INSTANCE;
        if (manager != null) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                tablist = manager.getTablist(player);
                if (tablist != null) {
                    tablist.hideRealPlayers().update();
                }
            }
        }
    }
}
