package me.keeeenion.playerstats.listeners;

import me.keeeenion.playerstats.methods.EditConf;
import me.keeeenion.playerstats.methods.GetConf;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerKillsDeaths implements Listener {
	
	@EventHandler
	public void onPlayerDeathByPlayer(PlayerDeathEvent e) {
		if (!(e.getEntity().getLastDamageCause().getEntityType() == EntityType.PLAYER)) return;
		Player killed = e.getEntity();
		Player killer = killed.getKiller();
		addDeath(killed, "Stats.Deaths.Players." + killer.getName().toString());
		addKill(killer, "Stats.Kills.Players." + killed.getName().toString());
	}
	
	@EventHandler
	public void onEntityDeathByPlayer(EntityDeathEvent e) {
		LivingEntity killed = e.getEntity();
		if (!(killed.getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK)) return;
		addKill((Player) killed.getLastDamageCause().getEntity(), "Stats.Kills.Mobs" + killed.getCustomName().toString());
	}
	
	public void addDeath(Player p, String path) {
		int deaths = GetConf.integer(p, path);
		deaths++;
		EditConf.set(p, path, deaths);
	}
	
	public void addKill(Player p, String path) {
		int kills = GetConf.integer(p, path);
		kills++;
		EditConf.set(p, path, kills);
	}
}
