package me.Jonnyfant.KeepMostInventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class DeathListener implements Listener {
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        if(e.getKeepInventory())
        {
            String lostItemsMessage = "You have lost the following items:";
            Player p = e.getEntity();
            Inventory inventory = p.getInventory();
            ArrayList<Material> itemsToKeep = new ArrayList();
            //ARMOR
            //HELMET
            itemsToKeep.add(Material.LEATHER_HELMET);
            itemsToKeep.add(Material.CHAINMAIL_HELMET);
            itemsToKeep.add(Material.IRON_HELMET);
            itemsToKeep.add(Material.GOLDEN_HELMET);
            itemsToKeep.add(Material.DIAMOND_HELMET);
            itemsToKeep.add(Material.NETHERITE_HELMET);
            itemsToKeep.add(Material.TURTLE_HELMET);
            //CHEST
            itemsToKeep.add(Material.LEATHER_CHESTPLATE);
            itemsToKeep.add(Material.CHAINMAIL_CHESTPLATE);
            itemsToKeep.add(Material.IRON_CHESTPLATE);
            itemsToKeep.add(Material.GOLDEN_CHESTPLATE);
            itemsToKeep.add(Material.DIAMOND_CHESTPLATE);
            itemsToKeep.add(Material.NETHERITE_CHESTPLATE);
            itemsToKeep.add(Material.ELYTRA);
            //PANTS
            itemsToKeep.add(Material.LEATHER_LEGGINGS);
            itemsToKeep.add(Material.CHAINMAIL_LEGGINGS);
            itemsToKeep.add(Material.IRON_LEGGINGS);
            itemsToKeep.add(Material.GOLDEN_LEGGINGS);
            itemsToKeep.add(Material.DIAMOND_LEGGINGS);
            itemsToKeep.add(Material.NETHERITE_LEGGINGS);
            //Boots
            itemsToKeep.add(Material.LEATHER_BOOTS);
            itemsToKeep.add(Material.CHAINMAIL_BOOTS);
            itemsToKeep.add(Material.IRON_BOOTS);
            itemsToKeep.add(Material.GOLDEN_BOOTS);
            itemsToKeep.add(Material.DIAMOND_BOOTS);
            itemsToKeep.add(Material.NETHERITE_BOOTS);
            //TOOLS
            //HOE
            itemsToKeep.add(Material.WOODEN_HOE);
            itemsToKeep.add(Material.STONE_HOE);
            itemsToKeep.add(Material.IRON_HOE);
            itemsToKeep.add(Material.GOLDEN_HOE);
            itemsToKeep.add(Material.DIAMOND_HOE);
            itemsToKeep.add(Material.NETHERITE_HOE);
            //AXE
            itemsToKeep.add(Material.WOODEN_AXE);
            itemsToKeep.add(Material.STONE_AXE);
            itemsToKeep.add(Material.IRON_AXE);
            itemsToKeep.add(Material.GOLDEN_AXE);
            itemsToKeep.add(Material.DIAMOND_AXE);
            itemsToKeep.add(Material.NETHERITE_AXE);
            //PICKAXE
            itemsToKeep.add(Material.WOODEN_PICKAXE);
            itemsToKeep.add(Material.STONE_PICKAXE);
            itemsToKeep.add(Material.IRON_PICKAXE);
            itemsToKeep.add(Material.GOLDEN_PICKAXE);
            itemsToKeep.add(Material.DIAMOND_PICKAXE);
            itemsToKeep.add(Material.NETHERITE_PICKAXE);
            //SHOVEL
            itemsToKeep.add(Material.WOODEN_SHOVEL);
            itemsToKeep.add(Material.STONE_SHOVEL);
            itemsToKeep.add(Material.IRON_SHOVEL);
            itemsToKeep.add(Material.GOLDEN_SHOVEL);
            itemsToKeep.add(Material.DIAMOND_SHOVEL);
            itemsToKeep.add(Material.NETHERITE_SHOVEL);
            //RANDOM TOOL
            itemsToKeep.add(Material.FISHING_ROD);
            itemsToKeep.add(Material.FLINT_AND_STEEL);
            itemsToKeep.add(Material.SHEARS);
            itemsToKeep.add(Material.SHULKER_BOX);

            //Getting rid of stuff
            p.setTotalExperience(p.getTotalExperience()/4);
            for(ItemStack itemStack:inventory.getContents())
            {
                boolean keepThisStack = false;
                for(int i = 0; i<itemsToKeep.size();i++)
                {
                    if(itemStack.getType().equals(itemsToKeep.get(i)))
                    {
                        keepThisStack=true;
                        break;
                    }
                }
                if(!keepThisStack)
                {
                    inventory.remove(itemStack);
                    p.getWorld().dropItemNaturally(p.getLocation(),itemStack);
                    lostItemsMessage+="\n";
                    lostItemsMessage+=itemStack.getAmount();
                    lostItemsMessage+="\t";
                    lostItemsMessage+=itemStack.getType().name();
                }
            }
            p.sendMessage(lostItemsMessage);
        }
    }
}
