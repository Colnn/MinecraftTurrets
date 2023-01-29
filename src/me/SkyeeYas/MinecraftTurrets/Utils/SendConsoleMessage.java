package me.SkyeeYas.MinecraftTurrets.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class SendConsoleMessage {
	
	public static void sendMessage(String msg) {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[PaintingSelector] " + ChatColor.WHITE + msg);
	}
	
}
