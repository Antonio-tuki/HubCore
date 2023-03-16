package dev.fxmxgragfx.hub.tablist;


import dev.fxmxgragfx.hub.HubCore;
import dev.fxmxgragfx.hub.utils.CC;
import dev.fxmxgragfx.hub.utils.ServerUtil;
import net.minecraft.util.com.google.common.collect.HashBasedTable;
import net.minecraft.util.com.google.common.collect.Table;
import org.bukkit.entity.Player;



public class TablistGetter implements TablistInterfaze {


    @Override
    public String getHeader(Player player) {
        return CC.translate("");
    }

    @Override
    public String getFooter(Player player) {
        return CC.translate("");
    }

    @Override
    public Table<Integer, Integer, String> getEntries(Player player) {
        Table<Integer, Integer, String> entries = HashBasedTable.create();

        // Server List
        entries.put(0, 4, CC.translate("&6&lKitMap &7(" + HubCore.getInstance().getServerHandler().getServers().get(ServerUtil.ServerType.KitMap) + ")"));
        entries.put(0, 5, CC.translate("&7Kit: P1, S1"));
        entries.put(0, 6, CC.translate("&7Teams: 15 Man"));
        entries.put(1, 4, CC.translate("&6&lPractice &7(" + HubCore.getInstance().getServerHandler().getServers().get(ServerUtil.ServerType.Practice) + ")"));
        entries.put(1, 5, CC.translate("&7For best ping:"));
        entries.put(1, 6, CC.translate("&7trainingpvp.club"));
        entries.put(2, 4, CC.translate("&6&lCombo &7(" + HubCore.getInstance().getServerHandler().getServers().get(ServerUtil.ServerType.Masters) + ")"));
        // Server List

        // Info Server
        entries.put(0 , 15, CC.translate("&6&lTeamspeak"));
        entries.put(0 , 16 , CC.translate("&7ts.trainingpvp.club"));
        entries.put(1 , 15, CC.translate("&6&lDiscord"));
        entries.put(1 , 16 , CC.translate("&7discord.trainingpvp.club"));
        entries.put(2 , 15, CC.translate("&6&lStore"));
        entries.put(2 , 16 , CC.translate("&7store.trainingpvp.club"));
        // Info Server

        // 1.8 Info
        entries.put(3 , 8 , CC.translate("&c&lWarning!"));
        entries.put( 3, 9, CC.translate("&7Please use 1.7 for"));
        entries.put(3, 10 , CC.translate("&7the optimal gaming"));
        entries.put(3, 11, CC.translate("&7experience!"));
        //

        entries.put(1, 0, CC.translate("&b&lTrainingpvp Network"));
        entries.put(1, 1, CC.translate("&bOnline: &7" + HubCore.getInstance().getServerHandler().getServers().get(ServerUtil.ServerType.GLOBAL)));
        return entries;
    }

}