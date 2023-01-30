package me.SkyeeYas.MinecraftTurrets.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import me.SkyeeYas.MinecraftTurrets.Main;

public class SendConsoleMessage {
	
	public static void sendMessage(String msg) {
		Plugin plugin = Main.getPlugin(Main.class);
		String name = plugin.getDescription().getName();
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[" + name + "] " + ChatColor.WHITE + msg);
	}
	
}
