package me.keeeenion.playerstats.methods;

import java.io.File;
import java.io.IOException;

import me.keeeenion.playerstats.Main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CreateConf {
	
	public static void create(Player player) {
		File playersDir = new File(Main.mainFolder);
		if (!playersDir.exists()) {
			playersDir.mkdir();
		}
		File playerFile = new File(Main.mainFolder + File.separator + player.getUniqueId() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
		if (!playerFile.exists()) {
			try {
				playerFile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().info(Main.pluginPrefix + "There was an error saving" + player + " 's config file");
				e.printStackTrace();
			}
			config.set("Player.Online", Boolean.valueOf(player.isOnline()));
			config.set("Player.Current Name", player.getDisplayName());
			config.set("Player.UUID", player.getUniqueId().toString());
			config.set("Player.OP", Boolean.valueOf(player.isOp()));
			config.set("Player.First played", Long.valueOf(player.getFirstPlayed()));
			config.set("Player.Last played", Long.valueOf(player.getLastPlayed()));
			config.set("Player.Banned", Boolean.valueOf(player.isBanned()));
			config.set("Player.Whitelisted", Boolean.valueOf(player.isWhitelisted()));
			config.set("Stats.Time played", Integer.valueOf(0));
			config.set("Stats.Kills.Players", null);
			config.set("Stats.Kills.Mobs", null);
			config.set("Stats.Deaths.Players", null);
			config.set("Stats.Deaths.Mobs", null);
			try {
				config.save(playerFile);
			} catch (IOException e) {
				e.printStackTrace();
				Bukkit.getServer().getLogger().info(Main.pluginPrefix + "There was an error saving" + player + " 's config file");
			}
		}
	}
	
	public static void update(Player player) {
	    File playerFile = new File(Main.mainFolder + File.separator + player.getUniqueId() + ".yml");
	    FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
	    if (playerFile.exists()) {
	    	config.set("Player.OP", Boolean.valueOf(player.isOp()));
	    	config.set("Player.Last played", Long.valueOf(player.getLastPlayed()));
	    	config.set("Player.Banned", Boolean.valueOf(player.isBanned()));
	    	config.set("Player.Whitelisted", Boolean.valueOf(player.isWhitelisted()));
	    	try {
	    		config.save(playerFile);
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    		Bukkit.getServer().getLogger().info(Main.pluginPrefix + "There was an error saving config file");
	    	}
	    }
	}
	
	public static long Date(long date) {
		return date;
	}
}
