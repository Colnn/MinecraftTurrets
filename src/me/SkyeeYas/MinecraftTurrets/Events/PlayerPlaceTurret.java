package me.SkyeeYas.MinecraftTurrets.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import me.SkyeeYas.MinecraftTurrets.Utils.YmlFile;

public class PlayerPlaceTurret implements Listener {
	
	@EventHandler
	public void onPlayerPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		ItemStack i = e.getItemInHand();
		Location location = e.getBlockPlaced().getLocation();
		if(i.getType() == Material.IRON_BLOCK) {
//			String type = i.getItemMeta().getLore().get(0).toLowerCase();
			String type = "laser";
			YmlFile.writeFileToTurret(location, type);
			location.add(0, 1, 0);
			if(type == "laser") {
				location.getBlock().setType(Material.LIGHTNING_ROD);
			}
		}
	}
	
}
