package me.SkyeeYas.MinecraftTurrets.Utils;

import java.util.Arrays;

import org.bukkit.Art;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryUtil implements Listener {
	
	private static Inventory inv;
	
	public static void initializeTurretInv(int Level, int turret, Inventory inv) {
		Level += 1;
		inv.setItem(11, createGuiItem(Material.PAPER, ChatColor.GRAY + "Settings"));
		inv.setItem(15, createGuiItem(Material.DIAMOND, ChatColor.DARK_PURPLE + "Upgrade to:" + ChatColor.GRAY + " Level " + Level, "" + turret, "Price: 2 diamonds"));
	}
	
	protected static ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }
	
	// You can open the inventory with this
    public static void openInventory(final HumanEntity ent, int turret) {
    	String type = YmlFile.readFile("turrets." + turret + ".type").toString();
    	int level = (int) YmlFile.readFile("turrets." + turret + ".upgradelevel");
    	inv = Bukkit.createInventory(null, 27, "Turret Menu");
    	initializeTurretInv(level, turret, inv);
        ent.openInventory(inv);
    }

    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {

        final ItemStack clickedItem = e.getCurrentItem();
        final Player p = (Player) e.getWhoClicked();
        
        ItemStack item = new ItemStack(Material.DIAMOND);
        ItemStack removeItem = new ItemStack(Material.DIAMOND, 5);
        
        
        if(clickedItem.equals(inv.getItem(15))) {
        	if(p.getInventory().containsAtLeast(item, 5)) {
            	p.getInventory().removeItem(removeItem);
            	int turret = clickedItem.getItemMeta().getLore().get(0).get;
            	int level = (int) YmlFile.readFile("turrets." + clickedItem.getItemMeta().getLore().get(0).toString() + ".upgradelevel") + 1;
            	YmlFile.writeFile("turrets." + turret + ".upgradelevel", "" + level);
            	e.getInventory().clear();
            	p.sendMessage(turret);
            	openInventory(p, turret);
            } else {
            	p.sendMessage("Noh.");
            }
        	e.setCancelled(true);
        }
    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
          e.setCancelled(true);
        }
    }
	
}
