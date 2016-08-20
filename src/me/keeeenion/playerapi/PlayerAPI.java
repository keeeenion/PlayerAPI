package me.keeeenion.playerapi;

import java.io.File;

import me.keeeenion.playerapi.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerAPI extends JavaPlugin {

	// Constraints
	
	public static String MAIN_FOLDER = "plugins/PlayerAPI";
	public static String PLUGIN_PREFIX = "[PlayerAPI] ";
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new Controller(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(), this);

		//TICKS GO HERE
		
    	File playersDir = new File(PlayerAPI.MAIN_FOLDER);
		if (playersDir.exists()) {
			Bukkit.getServer().getLogger().info(PlayerAPI.PLUGIN_PREFIX + "There are " + playersDir.listFiles().length + " player configs.");
		} else {
			Bukkit.getServer().getLogger().info(PlayerAPI.PLUGIN_PREFIX + "There are no player configs..yet");
		}
	}
}
