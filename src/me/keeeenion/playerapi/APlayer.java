package me.keeeenion.playerapi;

import me.keeeenion.playerapi.methods.StatsValue;
import me.keeeenion.playerapi.utils.Database;
import org.bukkit.entity.Player;

/**
 * Created by Keeeenion on 22.07.2016.
 */

public abstract class APlayer implements Player {

    private Database _db = new Database();
    private Config _cfg;

    public APlayer() {

    }

    public boolean isNew() { this.hasPlayedBefore(); }

    public boolean isAdded() { _cfg }

    //Stats

    public class Stats {

        public String Path;

        public Stats(String path) {
            this.Path = path;
        }

        public void set() {

        }

        public StatsValue get() {
            return new StatsValue();
        }

    }

    // Metadata

    public class Metadata {

        public String Path;

        public Metadata(String path) {
            this.Path = path;
        }

    }

    public void setMetadata(Metadata md) {

        //Assign to player
        //Add to the timer
        //Add to the config

    }

    public void removeMetadata() {

    }

    public void hasMetadata() {  }
}
