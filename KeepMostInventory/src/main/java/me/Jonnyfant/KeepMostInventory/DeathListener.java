package me.Jonnyfant.KeepMostInventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

import static org.bukkit.enchantments.Enchantment.BINDING_CURSE;
import static org.bukkit.enchantments.Enchantment.VANISHING_CURSE;

public class DeathListener implements Listener {
    FileConfiguration config;

    public DeathListener(FileConfiguration c) {
        config=c;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {


        int xpPercent = config.getInt("% XP retained");
        if (xpPercent < 0) {
            xpPercent=0;
        } else if (xpPercent > 100) {
            xpPercent=100;
        }

        if (config.getBoolean("Enabled")) {

            Player p = e.getEntity();

            Boolean chat = config.getBoolean("Send Death Message");
            Boolean curse = config.getBoolean("Handle Curses properly");
            if (e.getKeepInventory()) {
                if(chat) {
                    p.sendMessage(ChatColor.RED + "You have lost the following items:");
                }
                boolean flagNothing = true;


                Inventory inventory = p.getInventory();
                //ArrayList<Material> itemsToKeep = new ArrayList();
                List<String>itemsToKeep = config.getStringList("Items to keep");

                //Getting rid of stuff

                //XP
                p.setExp(p.getExp() / 100*xpPercent);
                p.setLevel(p.getLevel() / 100*xpPercent);
                //p.setTotalExperience(p.getTotalExperience()/100*xpPercent);



                //items
                int pos = 0;
                for (ItemStack itemStack : inventory.getContents()) {
                    boolean keepThisStack = false;
                    if (itemStack != null && pos < 36) {
                        if(curse)
                        {
                            if(itemStack.containsEnchantment(VANISHING_CURSE))
                            {
                                inventory.remove(itemStack);
                            }
                        }
                        for (int i = 0; i < itemsToKeep.size(); i++) {
                            String temp = String.valueOf(itemStack.getType());
                            if (itemStack.getType().name().equals(itemsToKeep.get(i))) {
                                keepThisStack = true;
                                break;
                            }
                        }
                        if (!keepThisStack) {
                            flagNothing = false;
                            inventory.remove(itemStack);
                            p.getWorld().dropItemNaturally(p.getLocation(), itemStack);
                            if (chat) {
                                p.sendMessage(ChatColor.RED + (itemStack.getAmount() + " " + itemStack.getType().name()));
                            }
                        }
                    }
                    pos++;
                }
                if(curse) {
                    PlayerInventory playerInventory = p.getInventory();
                    ItemStack[] armor = playerInventory.getArmorContents();
                    for(int i=0;i<armor.length;i++)
                    {
                        if(armor[i].containsEnchantment(VANISHING_CURSE))
                        {
                            armor[i]=new ItemStack(Material.AIR);
                            p.sendMessage(ChatColor.RED + (armor[i].getAmount() + " " + armor[i].getType().name() + " was destroyed by Curse of Vanishing."));
                        }
                        else
                        {
                            if(armor[i].containsEnchantment(BINDING_CURSE))
                            {
                                armor[i]=new ItemStack(Material.AIR);
                                flagNothing = false;
                                p.getWorld().dropItemNaturally(p.getLocation(), armor[i]);
                                if (chat) {
                                    p.sendMessage(ChatColor.RED + (armor[i].getAmount() + " " + armor[i].getType().name()));
                                }
                            }
                        }
                    }
                    playerInventory.setArmorContents(armor);

                }
                if (flagNothing&&chat) {
                    p.sendMessage(ChatColor.GREEN + "Nothing");
                }
            }
        }
    }
}