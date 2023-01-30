package me.SkyeeYas.MinecraftTurrets.Utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import me.SkyeeYas.MinecraftTurrets.Events.PlayerInteract;
import me.SkyeeYas.MinecraftTurrets.Events.PlayerPlaceTurret;

public class EventLoader {
	
	public static void LoadEvents() {
		
		Plugin plugin = Bukkit.getPluginManager().getPlugin("MinecraftTurrets");
		
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerPlaceTurret(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteract(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryUtil(), plugin);
		
	}
	
}
