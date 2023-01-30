package me.SkyeeYas.MinecraftTurrets;

import org.bukkit.plugin.java.JavaPlugin;

import me.SkyeeYas.MinecraftTurrets.Commands.MinecraftTurrets;
import me.SkyeeYas.MinecraftTurrets.Utils.EventLoader;
import me.SkyeeYas.MinecraftTurrets.Utils.YmlFile;

public class Main extends JavaPlugin {
	@Override 
	public void onEnable() {
//		new UpdateChecker(this, 107625).getVersion(version -> {
//            if (this.getDescription().getVersion().equals(version)) {
//                SendConsoleMessage.sendMessage("Plugin is up to date");
//            } else {
//            	SendConsoleMessage.sendMessage("New version is available!");
//            	SendConsoleMessage.sendMessage("Download here: https://github.com/Colnn/PaintingSelector/releases/latest/");
//            }
//        });
		YmlFile.checkFiles();
		EventLoader.LoadEvents();
		this.getCommand("minecraftturrets").setExecutor(new MinecraftTurrets());
	}
	
	@Override 
	public void onDisable() {
		
	}
}
