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

public class Practice extends Button {

    public String getName(Player player) {
        return CC.translate("&a&lPractice");
    }

    public List<String> getDescription(Player player) {
        Queue queue = Queue.getByPlayer(player.getUniqueId());
        List<String> lore = Lists.newArrayList();
        lore.add(CC.translate(""));
        lore.add(CC.translate("&7• &dQueue: &fRanked and Unranked"));
        lore.add(CC.translate("&7• &dDuels:&f 1v1s, 2v2s, 3v3s"));
        lore.add(CC.translate("&7• &dTeam Fight:&f HCF"));
        lore.add(CC.translate("&7• &dPlayers: &f" +  HubCore.getInstance().getServerHandler().getServers().get(ServerUtil.ServerType.Practice)));
        if (queue != null) {
            lore.add(CC.translate(""));
            lore.add(CC.translate("&cQueued for"));
            lore.add(CC.translate("&b" + queue.getName()));
            lore.add(CC.translate("&bPosition:&f #"  + queue.getPosition(player.getUniqueId()) + " of "  + Math.round(queue.getPlayers().size())));
        }
        lore.add(CC.translate(""));
        lore.add(CC.translate("&7&oClick to join the queue"));
        return lore;
    }

    public void clicked(Player player, int i, ClickType clickType) {
        if (clickType.isRightClick() || clickType.isLeftClick()) {
            player.getPlayer().performCommand("joinqueue Practice");
            player.closeInventory();

        }
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemStack(Material.FISHING_ROD);
    }
}
