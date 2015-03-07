package me.keeeenion.playerstats;

import java.io.File;

import me.keeeenion.playerstats.listeners.PlayerKillsDeaths;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static String mainFolder = "plugins/PlayerStats";
	public static String pluginPrefix = "[PlayerStats] ";
	static boolean createConfigs = true;
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new Controller(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerKillsDeaths(), this);
		
    	File playersDir = new File(Main.mainFolder);
		if (playersDir.exists()) {
			int filecount = playersDir.listFiles().length;
			Bukkit.getServer().getLogger().info(Main.pluginPrefix + "There are " + filecount + " user configs.");
		} else {
			Bukkit.getServer().getLogger().info(Main.pluginPrefix + "There are yet no user configs.");
		}
	}
}
