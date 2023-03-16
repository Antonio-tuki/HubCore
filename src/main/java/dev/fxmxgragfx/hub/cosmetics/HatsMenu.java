package dev.fxmxgragfx.hub.cosmetics;

import dev.cougar.core.util.menu.Button;
import dev.cougar.core.util.menu.Menu;
import dev.fxmxgragfx.hub.cosmetics.buttons.hats.*;
import dev.fxmxgragfx.hub.utils.CC;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class HatsMenu extends Menu {
    private static Button BLACK_GLASS_PANE;

    public String getTitle(Player player) {
        return CC.translate("Hats");
    }

    public void setUpdateAfterClick(boolean updateAfterClick) {
        setUpdateAfterClick(true);
    }

    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();
        buttons.put(10, new AstronautHat());
        buttons.put(12 , new SkullHat());
        buttons.put(14 , new ZombieHat());
        buttons.put(16, new CreeperHat());
        buttons.put(26, new ClearHatButton());
        return new HatsMenu().fillMapWithPanes(buttons);
    }

    public int size(Map<Integer, Button> buttons) {
        return 27;
    }

    private Map<Integer, Button> fillMapWithPanes(Map<Integer, Button> map) {
        for (int i = 0; i < 27; ++i) {
            map.putIfAbsent(i, BLACK_GLASS_PANE);
        }
        return map;
    }

    static {
        BLACK_GLASS_PANE = Button.placeholder(Material.STAINED_GLASS_PANE, (byte) 7, " ");
    }
}
