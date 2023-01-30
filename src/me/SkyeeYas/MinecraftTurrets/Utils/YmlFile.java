package me.SkyeeYas.MinecraftTurrets.Utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.SkyeeYas.MinecraftTurrets.Main;

public class YmlFile {
	   
    Main plugin = Main.getPlugin(Main.class);
   
    public void fileCheck(Player player){
   
	     String playerName = player.getName();
	     String playerUuid = player.getUniqueId().toString();
	     File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("MySqlStats").getDataFolder(), File.separator + "PlayerDatabase");
	     File f = new File(userdata, File.separator + playerUuid + ".yml");
	     FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
	
	     if (!f.exists()) {
	         try {
	
	             playerData.createSection("Data");
	             playerData.set("Data.Name", playerName);
	             playerData.set("Data.UUID", playerUuid);
	           
	             playerData.createSection("Stats");
	             playerData.set("Stats.Level", 1);
	             playerData.set("Stats.XP", 0);
	           
	             playerData.save(f);
	         } catch (IOException exception) {
	
	             exception.printStackTrace();
	         }
	     }
    }
    
    public static void checkFiles() {
    	File folder = new File(Bukkit.getServer().getPluginManager().getPlugin("MinecraftTurrets").getDataFolder(), File.separator);
    	File f = new File(folder, "turrets.yml");
    	FileConfiguration turretsData = YamlConfiguration.loadConfiguration(f);
    	if(!f.exists()) {
    		try {
    			turretsData.set("currentid", 0);
    			turretsData.createSection("turrets");
				turretsData.save(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	} else {
    		return;
    	}
    }
    
    public static void writeFileToTurret(Location location, String type) {
    	File folder = new File(Bukkit.getServer().getPluginManager().getPlugin("MinecraftTurrets").getDataFolder(), File.separator);
    	File f = new File(folder, "turrets.yml");
    	FileConfiguration turretsData = YamlConfiguration.loadConfiguration(f);
    	try {
    		int id = turretsData.getInt("currentid") + 1;
        	turretsData.set("currentid", id);
        	turretsData.set("turrets." + id + ".x", location.getX());
        	turretsData.set("turrets." + id + ".y", location.getY());
        	turretsData.set("turrets." + id + ".z", location.getZ());
        	turretsData.set("turrets." + id + ".world", location.getWorld().getName());
        	turretsData.set("turrets." + id + ".type", type);
        	turretsData.set("turrets." + id + ".upgradelevel", 1);
			turretsData.save(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void writeFile(String path, Object data) {
    	File folder = new File(Bukkit.getServer().getPluginManager().getPlugin("MinecraftTurrets").getDataFolder(), File.separator);
    	File f = new File(folder, "turrets.yml");
    	FileConfiguration turretsData = YamlConfiguration.loadConfiguration(f);
    	
    	turretsData.set(path, data);
    }
    
    public static int getFileLength() {
    	File folder = new File(Bukkit.getServer().getPluginManager().getPlugin("MinecraftTurrets").getDataFolder(), File.separator);
    	File f = new File(folder, "turrets.yml");
    	FileConfiguration turretsData = YamlConfiguration.loadConfiguration(f);
    	return turretsData.getInt("currentid");
    }
    
    public static Object readFile(String path) {
    	File folder = new File(Bukkit.getServer().getPluginManager().getPlugin("MinecraftTurrets").getDataFolder(), File.separator);
    	File f = new File(folder, "turrets.yml");
    	FileConfiguration turretsData = YamlConfiguration.loadConfiguration(f);
    	
    	Object result = turretsData.get(path);
    	
		return result;
    }
    
}
