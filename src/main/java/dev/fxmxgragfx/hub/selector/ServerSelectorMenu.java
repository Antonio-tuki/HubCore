package dev.fxmxgragfx.hub.selector;

import dev.cougar.core.util.menu.Button;
import dev.cougar.core.util.menu.Menu;
import dev.fxmxgragfx.hub.selector.servers.Combo;
import dev.fxmxgragfx.hub.selector.servers.KitMap;
import dev.fxmxgragfx.hub.selector.servers.Practice;
import dev.fxmxgragfx.hub.utils.CC;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class ServerSelectorMenu extends Menu {

    private static final Button BLACK_GLASS_PANE;

    public String getTitle(Player player) {
        return CC.translate("&8Select a server to join");
    }

    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();
        buttons.put(10, new Practice());
        buttons.put(13, new KitMap());
        buttons.put(16, new Combo());
        return new ServerSelectorMenu().fillMapWithPanes(buttons);
    }

    public int size() {
        return 26;
    }

    private Map<Integer, Button> fillMapWithPanes(Map<Integer, Button> map) {
        for (int i = 0; i < 26; ++i) {
            map.putIfAbsent(i, BLACK_GLASS_PANE);
        }
        return map;
    }

    static {
        BLACK_GLASS_PANE = Button.placeholder(Material.STAINED_GLASS_PANE, (byte) 7, " ");
    }
}
