package dev.fxmxgragfx.hub.scoreboard;

import cc.fyre.venom.Venom;
import dev.fxmxgragfx.hub.HubCore;
import dev.fxmxgragfx.hub.utils.CC;
import dev.fxmxgragfx.hub.utils.ServerUtil;
import me.joeleoli.portal.shared.queue.Queue;
import mx.fxmxgragfx.api.scoreboard.ScoreGetter;
import net.minecraft.server.v1_7_R4.MinecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.util.LinkedList;

public class ScoreboardHub implements ScoreGetter {

    private static DecimalFormat readableFileSizeFormatter = new DecimalFormat("#,##0.#");

    public void getScores(LinkedList<String> scores, Player player) {
        Queue queue = Queue.getByPlayer(player.getUniqueId());
        scores.add(CC.translate("&7&m--------------------"));
        scores.add(CC.translate("&bOnline:"));
        scores.add(CC.translate("" + Venom.instance.api.getGrantHandler().findBestRank(player.getUniqueId()).getColor() + HubCore.getInstance().getServerHandler().getServers().get(ServerUtil.ServerType.GLOBAL)));
        scores.add(CC.translate(""));
        scores.add(CC.translate("&bRank:"));
        scores.add(CC.translate("&r" + Venom.instance.api.getGrantHandler().findBestRank(player.getUniqueId()).getColor() + Venom.instance.api.getGrantHandler().findBestRank(player.getUniqueId()).getDisplayName()));
        if (queue != null) {
            scores.add("");
            scores.add(CC.translate("&cQueued for"));
            scores.add(CC.translate("&b"+queue.getName()));
            scores.add(CC.translate("&bPosition:&f #"  + queue.getPosition(player.getUniqueId()) + " of "  + Math.round(queue.getPlayers().size())));
        }
        if(player.isOp()) {
            scores.add(CC.translate(""));
            scores.add(CC.translate(ChatColor.GOLD + "Full tick: " + formatTickTime((MinecraftServer.getServer()).lastTickTime) + " ms" + " (" + Thread.getAllStackTraces().keySet().parallelStream().filter(Thread::isAlive).count() + "/" + Thread.getAllStackTraces().keySet().parallelStream().count() + Thread.getAllStackTraces().keySet().parallelStream().filter(Thread::isDaemon).count() + ")"));
        }
        scores.add(CC.translate(""));
        scores.add(CC.translate("&btrainingpvp.club"));
        scores.add(CC.translate("&c&7&m--------------------"));

    }

    private static String format(double tps) {
        return String.valueOf(String.valueOf(((tps > 18.0D) ? ChatColor.GREEN : ((tps > 16.0D) ? ChatColor.YELLOW : ChatColor.RED)).toString())) + ((tps > 20.0D) ? "*" : "") + Math.min(Math.round(tps * 100.0D) / 100.0D, 20.0D);
    }

    private static String formatTickTime(double time) {
        return String.valueOf(String.valueOf(((time < 40.0D) ? ChatColor.GREEN : ((time < 60.0D) ? ChatColor.YELLOW : ChatColor.RED)).toString())) + (Math.round(time * 10.0D) / 10.0D);
    }

    private static String readableFileSize(long size) {
        if (size <= 0L)
            return "0";
        String[] units = { "B", "kB", "MB", "GB", "TB" };
        int digitGroups = (int)(Math.log10(size) / Math.log10(1024.0D));
        return String.valueOf(String.valueOf(String.valueOf(readableFileSizeFormatter.format(size / Math.pow(1024.0D, digitGroups))))) + ' ' + units[digitGroups];
    }
}
