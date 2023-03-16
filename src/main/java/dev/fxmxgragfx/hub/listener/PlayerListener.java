package dev.fxmxgragfx.hub.listener;

import dev.fxmxgragfx.hub.HubCore;
import dev.fxmxgragfx.hub.cosmetics.CosmeticsCache;
import dev.fxmxgragfx.hub.cosmetics.CosmeticsMenu;
import dev.fxmxgragfx.hub.selector.ServerItem;
import dev.fxmxgragfx.hub.selector.ServerSelectorMenu;
import dev.fxmxgragfx.hub.utils.CC;
import dev.fxmxgragfx.hub.utils.ItemStackUtil;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class PlayerListener implements Listener {
    private static final String[] CLEAR_MESSAGE = new String[101];

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        event.getPlayer().setMaxHealth(20.0);
        event.getPlayer().setFoodLevel(20);
        event.getPlayer().setHealth(20.0);
        event.getPlayer().setGameMode(GameMode.ADVENTURE);
        event.getPlayer().getInventory().clear();
        event.getPlayer().setWalkSpeed(0.4f);
        event.getPlayer().sendMessage(CLEAR_MESSAGE);
        event.getPlayer().sendMessage(CC.translate("&7&m----------------------------------------"));
        event.getPlayer().sendMessage(CC.translate("&fWelcome to the &b&lTrainingPvP Network"));
        event.getPlayer().sendMessage(CC.translate(""));
        event.getPlayer().sendMessage(CC.translate("&f&l✦ &b&lTwitter: &awww.twitter.com/TrainingPvP_"));
        event.getPlayer().sendMessage(CC.translate("&f&l✦ &b&lTeamspeak: &ats.trainingpvp.club"));
        event.getPlayer().sendMessage(CC.translate("&f&l✦ &b&lWebsite: &awww.trainingpvp.club"));
        event.getPlayer().sendMessage(CC.translate("&f&l✦ &b&lStore: &astore.trainingpvp.club"));
        event.getPlayer().sendMessage(CC.translate(""));
        event.getPlayer().sendMessage(CC.translate("&7&m----------------------------------------"));
        event.getPlayer().teleport(event.getPlayer().getLocation().getWorld().getSpawnLocation());
        event.getPlayer().getInventory().setItem(0, ItemStackUtil.createItem(Material.COMPASS, 1, CC.translate("&9&l» &eServer Selector &9&l«")));
        event.getPlayer().getInventory().setItem(7, ServerItem.HIDEPLAYERS.getItemStack());
        event.getPlayer().getInventory().setItem(4, ItemStackUtil.createItem(Material.NETHER_STAR, 1, CC.translate("&9&l» &dCosmetics &9&l«")));
        event.getPlayer().getInventory().setItem(8, ItemStackUtil.createItem(Material.ENDER_PEARL, 1, CC.translate("&9&l» &5Ender Butt &9&l«")));
        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.CAT_MEOW, 20.0F, 20.0F);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        if(CosmeticsCache.set.containsKey(event.getPlayer())) {
            Bukkit.getScheduler().cancelTask(CosmeticsCache.set.get(event.getPlayer()));
        }
    }

    @EventHandler
    public void onServerSelector(PlayerInteractEvent event) {
        Action action = event.getAction();
        if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
            if(event.getPlayer().getItemInHand().getType() == Material.AIR) return;
            ItemStack itemStack = event.getItem();
            if (itemStack.getType().equals(Material.COMPASS)) {
                new ServerSelectorMenu().openMenu(event.getPlayer());
            }
        }
    }

    @EventHandler
    public void onCosmetics(PlayerInteractEvent event) {
        Action action = event.getAction();
        if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
            if(event.getPlayer().getItemInHand().getType() == Material.AIR) return;
            ItemStack itemStack = event.getItem();
            if (itemStack.getType().equals(Material.NETHER_STAR)) {
                new CosmeticsMenu().openMenu(event.getPlayer());
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player)
            event.setCancelled(true);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        String[] lines = event.getLines();
        for (int i = 0; i < lines.length; i++)
            event.setLine(i, CC.translate(lines[i]));
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        event.setCancelled(true);
    }


    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onMove(PlayerMoveEvent event) {
        if (event.getPlayer().getGameMode() != GameMode.CREATIVE && event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)
            event.getPlayer().setAllowFlight(true);
    }

    @EventHandler
    public void onFly(PlayerToggleFlightEvent e) {
        Player player = e.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) return;
        e.setCancelled(true);
        player.setAllowFlight(false);
        player.setFlying(false);
        player.setVelocity(player.getLocation().getDirection().multiply(2).setY(1));
        player.setMetadata("crouchjump", new FixedMetadataValue(HubCore.getInstance(), "crouchjump"));
        player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
        Bukkit.getScheduler().runTaskLaterAsynchronously(HubCore.getInstance(), () -> player.removeMetadata("crouchjump", HubCore.getInstance()), 40L);
        player.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 20);
        player.playSound(player.getLocation(), Sound.FIREWORK_BLAST, 20.0F, 0.0952381F);
        player.playSound(player.getLocation(), Sound.EXPLODE, 1.0F, 2.0F);
        player.playSound(player.getLocation(), Sound.WITHER_SHOOT, 1.0F, 2.0F);
        player.playSound(player.getLocation(), Sound.BLAZE_HIT, 1.0F, 1.0F);
    }

    @EventHandler
    public void togglesneak(PlayerToggleSneakEvent e) {
        Player player = e.getPlayer();
        if (player.getLocation().subtract(0.0D, 0.1D, 0.0D).getBlock().getType() != Material.AIR) {
            player.removeMetadata("crouchjump", HubCore.getInstance());
            return;
        }
        if (player.hasMetadata("crouchjump")) {
            player.removeMetadata("crouchjump", HubCore.getInstance());
            player.setVelocity(player.getLocation().getDirection().multiply(10));
            player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
            player.playSound(player.getLocation(), Sound.WITHER_HURT, 10.5F, 8.5F);
            player.playSound(player.getLocation(), Sound.ZOMBIE_WOODBREAK, 5.0F, 2.0F);
            player.playSound(player.getLocation(), Sound.BAT_IDLE, 4.5F, 3.5F);
        }
    }

    @EventHandler
    public void onBreakblock(BlockBreakEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }
    @EventHandler
    public void onPopDamager(EntityDamageByEntityEvent event) {
        Player player;
        if (event.getDamager() == null || event.getDamager() instanceof org.bukkit.craftbukkit.v1_7_R4.entity.CraftEnderPearl || event.getDamager() instanceof EnderPearl) {
            player = null;
        } else {
            player = (Player)event.getDamager();
        }
        Player damaged = (Player)event.getEntity();
        if (damaged != null && player != null &&
                event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            player.hidePlayer(damaged);
            player.sendMessage(CC.translate(  "&bPop!"));
            player.playSound(player.getLocation(), Sound.BLAZE_HIT, 0.5F, 0.5F);
        }
        event.setCancelled(true);
    }
}
