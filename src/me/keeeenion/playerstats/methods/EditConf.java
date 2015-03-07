package me.keeeenion.playerstats.methods;

import java.io.File;
import java.io.IOException;
import java.util.List;

import me.keeeenion.playerstats.Main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class EditConf {
	
	//BASIC//
	
	public static void set(Player player, String path, Object value) {
		String playeruuid = player.getUniqueId().toString();
		File playerFile = new File(Main.mainFolder + File.separator + playeruuid + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
		if (!playerFile.exists()) {
			return;
		}
		config.set(path, value);
		try {
			config.save(playerFile);
		} catch (IOException e) {
			e.printStackTrace();
			Bukkit.getServer().getLogger().info(Main.pluginPrefix + "There was an error saving config file");
		}
	}
	
	//LISTS//
	
	public static void addList(Player player, String path, String value) {
	    File playerFile = new File(Main.mainFolder + File.separator + player.getUniqueId() + ".yml");
	    if (!playerFile.exists()) {
	    	return;
	    }
	    List<String> list = GetConf.listString(player, path);
	    list.add(value);
	    set(player, path, list);
	}
	
	public static void removeList(Player player, String path, String value) {
	    File playerFile = new File(Main.mainFolder + File.separator + player.getUniqueId() + ".yml");
	    if (!playerFile.exists()) {
	    	return;
	    }
	    List<String> list = GetConf.listString(player, path);
	    list.remove(value);
	    set(player, path, list);
	}
	
	public static void deleteList(Player player, String path, String value) {
	    File playerFile = new File(Main.mainFolder + File.separator + player.getUniqueId() + ".yml");
	    if (!playerFile.exists()) {
	    	return;
	    }
	    List<String> list = GetConf.listString(player, path);
	    list.remove(value);
	    set(player, path, list);
	}
}
