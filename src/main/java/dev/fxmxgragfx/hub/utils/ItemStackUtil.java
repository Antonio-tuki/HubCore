package dev.fxmxgragfx.hub.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemStackUtil {

    public static ItemStack[] LEATHER_ARMOR() {
        return new ItemStack[]{LEATHER_HELMET, LEATHER_CHESTPLATE, LEATHER_LEGGINGS, LEATHER_BOOTS};
    }

    public static ItemStack[] CHAINMAIL_ARMOR() {
        return new ItemStack[]{CHAINMAIL_HELMET, CHAINMAIL_CHESTPLATE, CHAINMAIL_LEGGINGS, CHAINMAIL_BOOTS};
    }

    public static ItemStack[] IRON_ARMOR() {
        return new ItemStack[]{IRON_HELMET, IRON_CHESTPLATE, IRON_LEGGINGS, IRON_BOOTS};
    }

    public static ItemStack[] GOLD_ARMOR() {
        return new ItemStack[]{GOLD_HELMET, GOLD_CHESTPLATE, GOLD_LEGGINGS, GOLD_BOOTS};
    }

    public static ItemStack[] DIAMOND_ARMOR() {
        return new ItemStack[]{DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_LEGGINGS, DIAMOND_BOOTS};
    }

    public static ItemStack[] ALL_ARMOR() {
        return new ItemStack[]{
                LEATHER_HELMET, LEATHER_CHESTPLATE, LEATHER_LEGGINGS, LEATHER_BOOTS, CHAINMAIL_HELMET, CHAINMAIL_CHESTPLATE, CHAINMAIL_LEGGINGS, CHAINMAIL_BOOTS, IRON_HELMET, IRON_CHESTPLATE,
                IRON_LEGGINGS, IRON_BOOTS, GOLD_HELMET, GOLD_CHESTPLATE, GOLD_LEGGINGS, GOLD_BOOTS, DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_LEGGINGS, DIAMOND_BOOTS};
    }

    public static ItemStack[] WOOD_WEAPONS() {
        return new ItemStack[]{WOOD_AXE, WOOD_SWORD};
    }

    public static ItemStack[] STONE_WEAPONS() {
        return new ItemStack[]{STONE_AXE, STONE_SWORD};
    }

    public static ItemStack[] IRON_WEAPONS() {
        return new ItemStack[]{IRON_AXE, IRON_SWORD};
    }

    public static ItemStack[] GOLD_WEAPONS() {
        return new ItemStack[]{GOLD_AXE, GOLD_SWORD};
    }

    public static ItemStack[] DIAMOND_WEAPONS() {
        return new ItemStack[]{DIAMOND_AXE, DIAMOND_SWORD};
    }

    public static ItemStack[] ALL_WEAPONS() {
        return new ItemStack[]{
                BOW, ARROW, WOOD_AXE, WOOD_SWORD, STONE_AXE, STONE_SWORD, IRON_AXE, IRON_SWORD, GOLD_AXE, GOLD_SWORD,
                DIAMOND_AXE, DIAMOND_SWORD, FISHING_ROD};
    }

    public static ItemStack[] ALL_FOOD() {
        return new ItemStack[]{
                APPLE, BAKED_POTATO, BREAD, COOKED_BEEF, COOKED_CHICKEN, COOKED_FISH, COOKIE, GRILLED_PORK, MELON, PUMPKIN_PIE,
                GOLDEN_CARROT, MUSHROOM_SOUP};
    }

    public static ItemStack createItem(Material material, String displayName, String... lore) {
        List<String> loreList = new ArrayList<>();
        Collections.addAll(loreList, lore);
        return createItem(material, 1, (short) 0, displayName, loreList);
    }

    public static ItemStack createItem(Material material, String displayName, List<String> lore) {
        return createItem(material, 1, (short) 0, displayName, lore);
    }

    public static ItemStack createItem(Material material, int amount) {
        return createItem(material, amount, null, null, null);
    }

    public static ItemStack createItem(Material material, short data) {
        return createItem(material, data, null, null, null);
    }

    public static ItemStack createItem(Material material, int amount, String displayName, String... lore) {
        List<String> loreList = new ArrayList<>();
        Collections.addAll(loreList, lore);
        return createItem(material, amount, (short) 0, displayName, loreList);
    }

    public static ItemStack createItem(Material material, int amount, String displayName, List<String> lore) {
        return createItem(material, amount, (short) 0, displayName, lore);
    }

    public static ItemStack createItem(Material material, short data, String displayName, String... lore) {
        List<String> loreList = new ArrayList<>();
        Collections.addAll(loreList, lore);
        return createItem(material, 1, data, displayName, loreList);
    }

    public static ItemStack createItem(Material material, short data, String displayName, List<String> lore) {
        return createItem(material, 1, data, displayName, lore);
    }

    public static ItemStack createItem(Material material, int amount, short data, String displayName, String... lore) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, lore);
        return createItem(material, amount, data, displayName, list);
    }

    public static ItemStack createItem(Material material, int amount, short data, String displayName, List<String> lore) {
        ItemStack item = new ItemStack(material, amount, data);
        ItemMeta itemMeta = item.getItemMeta();
        if (displayName != null)
            itemMeta.setDisplayName(displayName);
        if (lore != null)
            itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack setItemTitle(ItemStack item, String title) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(title);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack setLore(ItemStack item, String... lore) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, lore);
        return setLore(item, list);
    }

    public static ItemStack setLore(ItemStack item, List<String> lore) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack createGoldenHead() {
        return createGoldenHead(1);
    }

    public static ItemStack createGoldenHead(int amount) {
        ItemStack apple = new ItemStack(Material.GOLDEN_APPLE, amount);
        ItemMeta appleMeta = apple.getItemMeta();
        appleMeta.setDisplayName(ChatColor.GOLD + "Golden Head");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("Some say consuming the head of a");
        lore.add("fallen foe strengthens the blood");
        appleMeta.setLore(lore);
        apple.setItemMeta(appleMeta);
        return apple;
    }

    public static ItemStack createEnchantmentBook(Enchantment enchant, int level) {
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
        meta.addStoredEnchant(enchant, level, true);
        item.setItemMeta(meta);
        return item;
    }

    public static boolean equals(ItemStack item, ItemStack other) {
        return (item != null && other != null && item.getType() == other.getType() && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(other.getItemMeta().getDisplayName()) && item.getItemMeta().getLore().equals(other.getItemMeta().getLore()));
    }

    public static ItemStack addUnbreaking(ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static void addUnbreakingToArmor(Player player) {
        for (ItemStack itemStack : player.getInventory().getArmorContents()) {
            if (itemStack != null &&
                    itemStack.getType() != Material.AIR)
                addUnbreaking(itemStack);
        }
    }

    public static void addUnbreakingToWeapons(Player player) {
        for (ItemStack itemStack : player.getInventory().getContents()) {
            if (itemStack != null &&
                    itemStack.getType() != Material.AIR) {
                Material type = itemStack.getType();
                if (type == Material.WOOD_SWORD || type == Material.STONE_SWORD || type == Material.GOLD_SWORD || type == Material.IRON_SWORD || type == Material.DIAMOND_SWORD || type == Material.BOW)
                    addUnbreaking(itemStack);
            }
        }
    }

    public static ItemStack removeUnbreaking(ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.spigot().setUnbreakable(false);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static void removeUnbreakingFromArmor(Player player) {
        for (ItemStack itemStack : player.getInventory().getArmorContents()) {
            if (itemStack != null &&
                    itemStack.getType() != Material.AIR)
                removeUnbreaking(itemStack);
        }
    }

    public static void removeUnbreakingFromWeapons(Player player) {
        for (ItemStack itemStack : player.getInventory().getContents()) {
            if (itemStack != null &&
                    itemStack.getType() != Material.AIR) {
                Material type = itemStack.getType();
                if (type == Material.WOOD_SWORD || type == Material.STONE_SWORD || type == Material.GOLD_SWORD || type == Material.IRON_SWORD || type == Material.DIAMOND_SWORD || type == Material.BOW)
                    removeUnbreaking(itemStack);
            }
        }
    }

    public static ItemStack LEATHER_HELMET = new ItemStack(Material.LEATHER_HELMET);

    public static ItemStack LEATHER_CHESTPLATE = new ItemStack(Material.LEATHER_CHESTPLATE);

    public static ItemStack LEATHER_LEGGINGS = new ItemStack(Material.LEATHER_LEGGINGS);

    public static ItemStack LEATHER_BOOTS = new ItemStack(Material.LEATHER_BOOTS);

    public static ItemStack CHAINMAIL_HELMET = new ItemStack(Material.CHAINMAIL_HELMET);

    public static ItemStack CHAINMAIL_CHESTPLATE = new ItemStack(Material.CHAINMAIL_CHESTPLATE);

    public static ItemStack CHAINMAIL_LEGGINGS = new ItemStack(Material.CHAINMAIL_LEGGINGS);

    public static ItemStack CHAINMAIL_BOOTS = new ItemStack(Material.CHAINMAIL_BOOTS);

    public static ItemStack IRON_HELMET = new ItemStack(Material.IRON_HELMET);

    public static ItemStack IRON_CHESTPLATE = new ItemStack(Material.IRON_CHESTPLATE);

    public static ItemStack IRON_LEGGINGS = new ItemStack(Material.IRON_LEGGINGS);

    public static ItemStack IRON_BOOTS = new ItemStack(Material.IRON_BOOTS);

    public static ItemStack GOLD_HELMET = new ItemStack(Material.GOLD_HELMET);

    public static ItemStack GOLD_CHESTPLATE = new ItemStack(Material.GOLD_CHESTPLATE);

    public static ItemStack GOLD_LEGGINGS = new ItemStack(Material.GOLD_LEGGINGS);

    public static ItemStack GOLD_BOOTS = new ItemStack(Material.GOLD_BOOTS);

    public static ItemStack DIAMOND_HELMET = new ItemStack(Material.DIAMOND_HELMET);

    public static ItemStack DIAMOND_CHESTPLATE = new ItemStack(Material.DIAMOND_CHESTPLATE);

    public static ItemStack DIAMOND_LEGGINGS = new ItemStack(Material.DIAMOND_LEGGINGS);

    public static ItemStack DIAMOND_BOOTS = new ItemStack(Material.DIAMOND_BOOTS);

    public static ItemStack IRON_BARDING = new ItemStack(Material.IRON_BARDING);

    public static ItemStack GOLD_BARDING = new ItemStack(Material.GOLD_BARDING);

    public static ItemStack DIAMOND_BARDING = new ItemStack(Material.DIAMOND_BARDING);

    public static ItemStack SHIELD;

    public static ItemStack ELYTRA;

    public static ItemStack SPECTRAL_ARROW;

    public static ItemStack TIPPED_ARROW;

    public static ItemStack BOW = new ItemStack(Material.BOW);

    public static ItemStack ARROW = new ItemStack(Material.ARROW);

    public static ItemStack FISHING_ROD = new ItemStack(Material.FISHING_ROD);

    public static ItemStack WOOD_AXE = new ItemStack(Material.WOOD_AXE);

    public static ItemStack WOOD_SWORD = new ItemStack(Material.WOOD_SWORD);

    public static ItemStack STONE_AXE = new ItemStack(Material.STONE_AXE);

    public static ItemStack STONE_SWORD = new ItemStack(Material.STONE_SWORD);

    public static ItemStack IRON_AXE = new ItemStack(Material.IRON_AXE);

    public static ItemStack IRON_SWORD = new ItemStack(Material.IRON_SWORD);

    public static ItemStack GOLD_AXE = new ItemStack(Material.GOLD_AXE);

    public static ItemStack GOLD_SWORD = new ItemStack(Material.GOLD_SWORD);

    public static ItemStack DIAMOND_AXE = new ItemStack(Material.DIAMOND_AXE);

    public static ItemStack DIAMOND_SWORD = new ItemStack(Material.DIAMOND_SWORD);

    public static ItemStack COAL = new ItemStack(Material.COAL);

    public static ItemStack IRON_INGOT = new ItemStack(Material.IRON_INGOT);

    public static ItemStack GOLD_INGOT = new ItemStack(Material.GOLD_INGOT);

    public static ItemStack REDSTONE = new ItemStack(Material.REDSTONE);

    public static ItemStack DIAMOND = new ItemStack(Material.DIAMOND);

    public static ItemStack GLOWSTONE_DUST = new ItemStack(Material.GLOWSTONE_DUST);

    public static ItemStack ENDER_PEARL = new ItemStack(Material.ENDER_PEARL);

    public static ItemStack GOLDEN_APPLE = new ItemStack(Material.GOLDEN_APPLE);

    public static ItemStack GOD_APPLE = new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1);

    public static ItemStack MILK_BUCKET = new ItemStack(Material.MILK_BUCKET);

    public static ItemStack APPLE = new ItemStack(Material.APPLE);

    public static ItemStack BAKED_POTATO = new ItemStack(Material.BAKED_POTATO);

    public static ItemStack BREAD = new ItemStack(Material.BREAD);

    public static ItemStack COOKED_BEEF = new ItemStack(Material.COOKED_BEEF);

    public static ItemStack COOKED_CHICKEN = new ItemStack(Material.COOKED_CHICKEN);

    public static ItemStack COOKED_FISH = new ItemStack(Material.COOKED_FISH);

    public static ItemStack COOKIE = new ItemStack(Material.COOKIE);

    public static ItemStack GRILLED_PORK = new ItemStack(Material.GRILLED_PORK);

    public static ItemStack MELON = new ItemStack(Material.MELON);

    public static ItemStack PUMPKIN_PIE = new ItemStack(Material.PUMPKIN_PIE);

    public static ItemStack GOLDEN_CARROT = new ItemStack(Material.GOLDEN_CARROT);

    public static ItemStack MUSHROOM_SOUP = new ItemStack(Material.MUSHROOM_SOUP);

    public static ItemStack CAKE = new ItemStack(Material.CAKE);

    public static ItemStack EMPTY_ITEM = new ItemStack(Material.AIR);

    public static ItemStack SADDLE = new ItemStack(Material.SADDLE);

    public static ItemStack WEB = new ItemStack(Material.WEB);

    public static ItemStack FLINT_AND_STEEL = new ItemStack(Material.FLINT_AND_STEEL);

    public static ItemStack EXP_BOTTLE = new ItemStack(Material.EXP_BOTTLE);

    public static ItemStack SULPHUR = new ItemStack(Material.SULPHUR);

    public static ItemStack ANVIL = new ItemStack(Material.ANVIL);

    public static ItemStack POTION = new ItemStack(Material.POTION);

    public static ItemStack REGENERATION_POTION = new ItemStack(Material.POTION, 1, (short) 8193);

    public static ItemStack SWIFTNESS_POTION = new ItemStack(Material.POTION, 1, (short) 8194);

    public static ItemStack FIRE_RESISTANCE_POTION = new ItemStack(Material.POTION, 1, (short) 8227);

    public static ItemStack POISON_POTION = new ItemStack(Material.POTION, 1, (short) 8196);

    public static ItemStack HEALING_POTION = new ItemStack(Material.POTION, 1, (short) 8261);

    public static ItemStack NIGHT_VISION_POTION = new ItemStack(Material.POTION, 1, (short) 8230);

    public static ItemStack WEAKNESS_POTION = new ItemStack(Material.POTION, 1, (short) 8232);

    public static ItemStack STRENGTH_POTION = new ItemStack(Material.POTION, 1, (short) 8201);

    public static ItemStack LEAPING_POTION = new ItemStack(Material.POTION, 1, (short) 8202);

    public static ItemStack SLOWNESS_POTION = new ItemStack(Material.POTION, 1, (short) 8234);

    public static ItemStack HARMING_POTION = new ItemStack(Material.POTION, 1, (short) 8268);

    public static ItemStack WATER_BREATHING_POTION = new ItemStack(Material.POTION, 1, (short) 8237);

    public static ItemStack INVISIBILITY_POTION = new ItemStack(Material.POTION, 1, (short) 8238);

    public static ItemStack REGENERATION_POTION_II = new ItemStack(Material.POTION, 1, (short) 8225);

    public static ItemStack SWIFTNESS_POTION_II = new ItemStack(Material.POTION, 1, (short) 8226);

    public static ItemStack POISON_POTION_II = new ItemStack(Material.POTION, 1, (short) 8228);

    public static ItemStack HEALING_POTION_II = new ItemStack(Material.POTION, 1, (short) 8229);

    public static ItemStack STRENGTH_POTION_II = new ItemStack(Material.POTION, 1, (short) 8233);

    public static ItemStack LEAPING_POTION_II = new ItemStack(Material.POTION, 1, (short) 8235);

    public static ItemStack HARMING_POTION_II = new ItemStack(Material.POTION, 1, (short) 8236);

    public static ItemStack REGENERATION_POTION_EXT = new ItemStack(Material.POTION, 1, (short) 8257);

    public static ItemStack SWIFTNESS_POTION_EXT = new ItemStack(Material.POTION, 1, (short) 8258);

    public static ItemStack FIRE_RESISTANCE_POTION_EXT = new ItemStack(Material.POTION, 1, (short) 8259);

    public static ItemStack POISON_POTION_EXT = new ItemStack(Material.POTION, 1, (short) 8260);

    public static ItemStack NIGHT_VISION_POTION_EXT = new ItemStack(Material.POTION, 1, (short) 8262);

    public static ItemStack WEAKNESS_POTION_EXT = new ItemStack(Material.POTION, 1, (short) 8264);

    public static ItemStack STRENGTH_POTION_EXT = new ItemStack(Material.POTION, 1, (short) 8265);

    public static ItemStack SLOWNESS_POTION_EXT = new ItemStack(Material.POTION, 1, (short) 8266);

    public static ItemStack LEAPING_POTION_EXT = new ItemStack(Material.POTION, 1, (short) 8267);

    public static ItemStack WATER_BREATHING_POTION_EXT = new ItemStack(Material.POTION, 1, (short) 8269);

    public static ItemStack INVISIBILITY_POTION_EXT = new ItemStack(Material.POTION, 1, (short) 8270);

    public static ItemStack REGENERATION_POTION_II_EXT = new ItemStack(Material.POTION, 1, (short) 8289);

    public static ItemStack SWIFTNESS_POTION_II_EXT = new ItemStack(Material.POTION, 1, (short) 8290);

    public static ItemStack POISON_POTION_II_EXT = new ItemStack(Material.POTION, 1, (short) 8292);

    public static ItemStack STRENGTH_POTION_II_EXT = new ItemStack(Material.POTION, 1, (short) 8297);

    public static ItemStack REGENERATION_SPLASH = new ItemStack(Material.POTION, 1, (short) 16385);

    public static ItemStack SWIFTNESS_SPLASH = new ItemStack(Material.POTION, 1, (short) 16386);

    public static ItemStack FIRE_RESISTANCE_SPLASH = new ItemStack(Material.POTION, 1, (short) 16387);

    public static ItemStack POISON_SPLASH = new ItemStack(Material.POTION, 1, (short) 16388);

    public static ItemStack HEALING_SPLASH = new ItemStack(Material.POTION, 1, (short) 16453);

    public static ItemStack NIGHT_VISION_SPLASH = new ItemStack(Material.POTION, 1, (short) 16390);

    public static ItemStack WEAKNESS_SPLASH = new ItemStack(Material.POTION, 1, (short) 16392);

    public static ItemStack STRENGTH_SPLASH = new ItemStack(Material.POTION, 1, (short) 16393);

    public static ItemStack SLOWNESS_SPLASH = new ItemStack(Material.POTION, 1, (short) 16394);

    public static ItemStack HARMING_SPLASH = new ItemStack(Material.POTION, 1, (short) 16396);

    public static ItemStack BREATHING_SPLASH = new ItemStack(Material.POTION, 1, (short) 16397);

    public static ItemStack INVISIBILITY_SPLASH = new ItemStack(Material.POTION, 1, (short) 16398);

    public static ItemStack REGENERATION_SPLASH_II = new ItemStack(Material.POTION, 1, (short) 16417);

    public static ItemStack SWIFTNESS_SPLASH_II = new ItemStack(Material.POTION, 1, (short) 16418);

    public static ItemStack POISON_SPLASH_II = new ItemStack(Material.POTION, 1, (short) 16420);

    public static ItemStack HEALING_SPLASH_II = new ItemStack(Material.POTION, 1, (short) 16421);

    public static ItemStack STRENGTH_SPLASH_II = new ItemStack(Material.POTION, 1, (short) 16425);

    public static ItemStack LEAPING_SPLASH_II = new ItemStack(Material.POTION, 1, (short) 16427);

    public static ItemStack HARMING_SPLASH_II = new ItemStack(Material.POTION, 1, (short) 16428);

    public static ItemStack REGENERATION_SPLASH_EXT = new ItemStack(Material.POTION, 1, (short) 16449);

    public static ItemStack SWIFTNESS_SPLASH_EXT = new ItemStack(Material.POTION, 1, (short) 16450);

    public static ItemStack FIRE_RESISTANCE_SPLASH_EXT = new ItemStack(Material.POTION, 1, (short) 16451);

    public static ItemStack POISON_SPLASH_EXT = new ItemStack(Material.POTION, 1, (short) 16452);

    public static ItemStack NIGHT_VISION_SPLASH_EXT = new ItemStack(Material.POTION, 1, (short) 16454);

    public static ItemStack WEAKNESS_SPLASH_EXT = new ItemStack(Material.POTION, 1, (short) 16456);

    public static ItemStack STRENGTH_SPLASH_EXT = new ItemStack(Material.POTION, 1, (short) 16457);

    public static ItemStack SLOWNESS_SPLASH_EXT = new ItemStack(Material.POTION, 1, (short) 16458);

    public static ItemStack LEAPING_SPLASH_EXT = new ItemStack(Material.POTION, 1, (short) 16459);

    public static ItemStack BREATHING_SPLASH_EXT = new ItemStack(Material.POTION, 1, (short) 16461);

    public static ItemStack INVISIBILITY_SPLASH_EXT = new ItemStack(Material.POTION, 1, (short) 16481);

    public static ItemStack REGENERATION_SPLASH_II_EXT = new ItemStack(Material.POTION, 1, (short) 16482);

    public static ItemStack POISON_SPLASH_II_EXT = new ItemStack(Material.POTION, 1, (short) 16484);

    public static ItemStack STRENGTH_SPLASH_II_EXT = new ItemStack(Material.POTION, 1, (short) 16489);

    public static ItemStack POISON_LINGERING;
}

