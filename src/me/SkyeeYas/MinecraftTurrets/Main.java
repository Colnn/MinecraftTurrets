package me.SkyeeYas.MinecraftTurrets;

import org.bukkit.plugin.java.JavaPlugin;

import me.SkyeeYas.MinecraftTurrets.Utils.EventLoader;

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
		EventLoader.LoadEvents();
	}
	
	@Override 
	public void onDisable() {
		
	}
}
