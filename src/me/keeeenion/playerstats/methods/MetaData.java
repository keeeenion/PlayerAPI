package me.keeeenion.playerstats.methods;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class MetaData {
	
	private static Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("PlayerCore");
	
	public static void set(Player player, String path, Object value) {
		player.setMetadata(path, new FixedMetadataValue(plugin, value));
	}
	  
	public Object get(Player player, String path) {
	    return ((MetadataValue)player.getMetadata(path).get(0)).asString();
	}
	  
	public boolean has(Player player, String path) {
		return player.hasMetadata(path);
	}
}
