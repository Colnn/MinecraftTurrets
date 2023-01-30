package me.SkyeeYas.MinecraftTurrets.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.SkyeeYas.MinecraftTurrets.Utils.InventoryUtil;

public class MinecraftTurrets implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			InventoryUtil.openInventory(p, 1);
		}
		
		return true;
	}
	
}
