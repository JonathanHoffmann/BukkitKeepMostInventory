package me.Jonnyfant.KeepMostInventory;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class KeepMostInventory extends JavaPlugin {
    @Override
    public void onEnable() {
        loadConfig();
        getServer().getPluginManager().registerEvents(new DeathListener(getConfig()),this);
    }

    public void loadConfig() {
        getConfig().options().header("Please be careful when editing items that players keep when dying. Copy the names from this list of internal IDs: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html");
        getConfig().addDefault("Enabled", true);
        getConfig().addDefault("Handle Curses properly", true);
        getConfig().addDefault("% XP retained", 25);
        getConfig().addDefault("Send Death Message", true);
        getConfig().addDefault("Items to keep", generateItemsToKeep());
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public List<String> generateItemsToKeep()
    {
        List<String> out = new ArrayList<String>() {
        };
        //ARMOR
        //HELMET
        out.add("LEATHER_HELMET");
        out.add("CHAINMAIL_HELMET");
        out.add("IRON_HELMET");
        out.add("GOLDEN_HELMET");
        out.add("DIAMOND_HELMET");
        out.add("NETHERITE_HELMET");
        out.add("TURTLE_HELMET");
        //CHEST
        out.add("LEATHER_CHESTPLATE");
        out.add("CHAINMAIL_CHESTPLATE");
        out.add("IRON_CHESTPLATE");
        out.add("GOLDEN_CHESTPLATE");
        out.add("DIAMOND_CHESTPLATE");
        out.add("NETHERITE_CHESTPLATE");
        out.add("ELYTRA");
        //PANTS
        out.add("LEATHER_LEGGINGS");
        out.add("CHAINMAIL_LEGGINGS");
        out.add("IRON_LEGGINGS");
        out.add("GOLDEN_LEGGINGS");
        out.add("DIAMOND_LEGGINGS");
        out.add("NETHERITE_LEGGINGS");
        //Boots
        out.add("LEATHER_BOOTS");
        out.add("CHAINMAIL_BOOTS");
        out.add("IRON_BOOTS");
        out.add("GOLDEN_BOOTS");
        out.add("DIAMOND_BOOTS");
        out.add("NETHERITE_BOOTS");
        //TOOLS
        //HOE
        out.add("WOODEN_HOE");
        out.add("STONE_HOE");
        out.add("IRON_HOE");
        out.add("GOLDEN_HOE");
        out.add("DIAMOND_HOE");
        out.add("NETHERITE_HOE");
        //AXE
        out.add("WOODEN_AXE");
        out.add("STONE_AXE");
        out.add("IRON_AXE");
        out.add("GOLDEN_AXE");
        out.add("DIAMOND_AXE");
        out.add("NETHERITE_AXE");
        //PICKAXE
        out.add("WOODEN_PICKAXE");
        out.add("STONE_PICKAXE");
        out.add("IRON_PICKAXE");
        out.add("GOLDEN_PICKAXE");
        out.add("DIAMOND_PICKAXE");
        out.add("NETHERITE_PICKAXE");
        //SHOVEL
        out.add("WOODEN_SHOVEL");
        out.add("STONE_SHOVEL");
        out.add("IRON_SHOVEL");
        out.add("GOLDEN_SHOVEL");
        out.add("DIAMOND_SHOVEL");
        out.add("NETHERITE_SHOVEL");
        //SWORD
        out.add("WOODEN_SWORD");
        out.add("STONE_SWORD");
        out.add("IRON_SWORD");
        out.add("GOLDEN_SWORD");
        out.add("DIAMOND_SWORD");
        out.add("NETHERITE_SWORD");
        //RANDOM TOOL
        out.add("FISHING_ROD");
        out.add("FLINT_AND_STEEL");
        out.add("SHEARS");
        out.add("SHIELD");
        out.add("CARROT_ON_A_STICK");
        out.add("BOW");
        out.add("CROSSBOW");
        out.add("WARPED_FUNGUS_ON_A_STICK");
        out.add("TRIDENT");
        //ShulkerBoxes
        out.add("SHULKER_BOX");
        out.add("WHITE_SHULKER_BOX");
        out.add("LIGHT_GRAY_SHULKER_BOX");
        out.add("GRAY_SHULKER_BOX");
        out.add("BLACK_SHULKER_BOX");
        out.add("BROWN_SHULKER_BOX");
        out.add("RED_SHULKER_BOX");
        out.add("ORANGE_SHULKER_BOX");
        out.add("YELLOW_SHULKER_BOX");
        out.add("LIME_SHULKER_BOX");
        out.add("GREEN_SHULKER_BOX");
        out.add("CYAN_SHULKER_BOX");
        out.add("LIGHT_BLUE_SHULKER_BOX");
        out.add("BLUE_SHULKER_BOX");
        out.add("PURPLE_SHULKER_BOX");
        out.add("MAGENTA_SHULKER_BOX");
        out.add("PINK_SHULKER_BOX");
        return out;
    }
}
