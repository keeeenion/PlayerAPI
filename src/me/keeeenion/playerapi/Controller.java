package me.keeeenion.playerapi;

import java.io.File;

import me.keeeenion.playerapi.methods.CreateConf;
import me.keeeenion.playerapi.methods.EditConf;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Controller implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		File playerFile = new File(PlayerAPI.mainFolder + File.separator + e.getPlayer().getUniqueId() + ".yml");
		if (!playerFile.exists()) {
			if (PlayerAPI.createConfigs == false) return;
			CreateConf.create(e.getPlayer());
			Bukkit.getServer().getLogger().info(PlayerAPI.pluginPrefix + "Created config for player: " + e.getPlayer().getName().toString());
		} else {
			CreateConf.update(e.getPlayer());
			EditConf.set(e.getPlayer(), "Player.Online", Boolean.valueOf(true));
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		CreateConf.update(e.getPlayer());
		EditConf.set(e.getPlayer(), "Player.Online", Boolean.valueOf(false));
	}
}