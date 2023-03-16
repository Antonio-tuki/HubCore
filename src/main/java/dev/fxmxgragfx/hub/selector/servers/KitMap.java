package dev.fxmxgragfx.hub.selector.servers;

import com.google.common.collect.Lists;
import dev.cougar.core.util.menu.Button;
import dev.fxmxgragfx.hub.HubCore;
import dev.fxmxgragfx.hub.utils.CC;
import dev.fxmxgragfx.hub.utils.ServerUtil;
import me.joeleoli.portal.shared.queue.Queue;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class KitMap extends Button {

    public String getName(Player player) {
        return CC.translate("&a&lKitMap");
    }


    public List<String> getDescription(Player player) {
        Queue queue = Queue.getByPlayer(player.getUniqueId());
        List<String> lore = Lists.newArrayList();
        lore.add(CC.translate(""));
        lore.add(CC.translate("&7• &dMap Kit: &fProt 1, Sharp 1"));
        lore.add(CC.translate("&7• &dFaction Size: &f15"));
        lore.add(CC.translate("&7• &dPlayers: &f" +  HubCore.getInstance().getServerHandler().getServers().get(ServerUtil.ServerType.KitMap)));
        if (queue != null) {
            lore.add(CC.translate(""));
            lore.add(CC.translate("&cQueued for"));
            lore.add(CC.translate("&b" + queue.getName()));
            lore.add(CC.translate("&bPosition:&f #"  + queue.getPosition(player.getUniqueId()) + " of "  + Math.round(queue.getPlayers().size())));
        }
        lore.add(CC.translate(""));
        lore.add(CC.translate("&c&oOffline"));
        return lore;
    }

    public void clicked(Player player, int i, ClickType clickType) {
        if (clickType.isRightClick() || clickType.isLeftClick()) {
            player.getPlayer().performCommand("joinqueue KitMap");
            player.closeInventory();

        }
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemStack(Material.BOW);
    }
}
