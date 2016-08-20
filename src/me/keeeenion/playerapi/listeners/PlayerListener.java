package me.keeeenion.playerapi.listeners;

import me.keeeenion.playerapi.PlayerAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

/**
 * Created by Keeeenion on 22.07.2016.
 */

public class PlayerListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e) {

        //Add to the database

        public static void createDefault(Player player) {
            File playersDir = new File(PlayerAPI.mainFolder);
            if (!playersDir.exists()) {
                playersDir.mkdir();
            }
            File playerFile = new File(PlayerAPI.mainFolder + File.separator + player.getUniqueId() + ".yml");
            FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
            if (!playerFile.exists()) {
                try {
                    playerFile.createNewFile();
                } catch (IOException e) {
                    Bukkit.getServer().getLogger().info(PlayerAPI.pluginPrefix + "There was an error saving" + player + " 's config file");
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
                    Bukkit.getServer().getLogger().info(PlayerAPI.pluginPrefix + "There was an error saving" + player + " 's config file");
                }
            }
        }

        //Add metadata to player
    }
}
