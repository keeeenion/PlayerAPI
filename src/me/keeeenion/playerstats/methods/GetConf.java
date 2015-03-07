package me.keeeenion.playerstats.methods;

import java.io.File;
import java.util.List;

import me.keeeenion.playerstats.Main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class GetConf {
	
	//BASIC//
	
	public static int integer(Player player, String path) {
		File playerFile = new File(Main.mainFolder + File.separator + player.getUniqueId() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
		if (!playerFile.exists()) {
			return 0;
		} else {
			return config.getInt(path);
		}
	}
	
	public static int string(Player player, String path) {
		File playerFile = new File(Main.mainFolder + File.separator + player.getUniqueId() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
		if (!playerFile.exists()) {
			return 0;
		} else {
			return config.getInt(path);
		}
	}
	
	public static int floats(Player player, String path) {
		File playerFile = new File(Main.mainFolder + File.separator + player.getUniqueId() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
		if (!playerFile.exists()) {
			return 0;
		} else {
			return config.getInt(path);
		}
	}
	
	//LISTS//
	
	public static List<Integer> listInteger(Player player, String path) {
	    File playerFile = new File(Main.mainFolder + File.separator + player.getUniqueId() + ".yml");
	    FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
	    if (!playerFile.exists()) {
	    	return null;
	    } else {
	    	return config.getIntegerList(path);
	    }
	}
	
	public static List<String> listString(Player player, String path) {
	    File playerFile = new File(Main.mainFolder + File.separator + player.getUniqueId() + ".yml");
	    FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
	    if (!playerFile.exists()) {
	    	return null;
	    } else {
	    	return config.getStringList(path);
	    }
	}
	
	public static List<Float> listFloat(Player player, String path) {
	    File playerFile = new File(Main.mainFolder + File.separator + player.getUniqueId() + ".yml");
	    FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
	    if (!playerFile.exists()) {
	    	return null;
	    } else {
	    	return config.getFloatList(path);
	    }
	}
}
