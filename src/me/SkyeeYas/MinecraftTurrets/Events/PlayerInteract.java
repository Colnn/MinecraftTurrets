package me.SkyeeYas.MinecraftTurrets.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import me.SkyeeYas.MinecraftTurrets.Utils.InventoryUtil;
import me.SkyeeYas.MinecraftTurrets.Utils.YmlFile;

public class PlayerInteract implements Listener{
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		int length = YmlFile.getFileLength();
		if(e.getHand() == EquipmentSlot.HAND) return;
		for (int i = 1; i <= length; i++) {
			Location location = new Location(Bukkit.getWorld(YmlFile.readFile("turrets." + i + ".world").toString()), (double) YmlFile.readFile("turrets." + i + ".x"), (double) YmlFile.readFile("turrets." + i + ".y"), (double) YmlFile.readFile("turrets." + i + ".z"));
			if(e.getClickedBlock().getLocation().equals(location)) {
				InventoryUtil.openInventory(e.getPlayer(), i);
				return;
			}
		}
	}

}
