package me.keeeenion.playerapi;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 * Created by Keeeenion on 22.07.2016.
 */
public class Config {

    public String Plugin;
    public Player Player;
    public String Path;

    private File _file;
    FileConfiguration _cfg;

    protected Config(Player player, String path) {
        this.Plugin = "";
        this.Player = player;
        this.Path = path;

        _file = new File(PlayerAPI.MAIN_FOLDER + File.separator + this.Player.getUniqueId() + ".yml");
        _cfg = YamlConfiguration.loadConfiguration(_file);
    }

    public Config(Plugin plugin, Player player, String path) {
        this.Plugin = plugin.getName();
        this.Player = player;
        this.Path = path;

        _file = new File(PlayerAPI.MAIN_FOLDER + File.separator + this.Player.getUniqueId() + ".yml");
        _cfg = YamlConfiguration.loadConfiguration(_file);
    }

    public void set(Object value) {
        if (_file.exists()) {
            _cfg.set( this.Path, value);
            try {
                _cfg.save(_file);
            } catch (IOException e) {
                e.printStackTrace();
                Bukkit.getServer().getLogger().info(PlayerAPI.PLUGIN_PREFIX + "There was an error saving the config file");
            }
        }
    }

    // Get

    public Object asObject() {
        if (_file.exists()) { return _cfg.get(this.Path); }
        return null;
    }

    public Object asString() {
        if (_file.exists()) { return _cfg.getString(this.Path); }
        return null;
    }

    public Integer asInteger() {
        if (_file.exists()) { return _cfg.getInt(this.Path); }
        return null;
    }

    public boolean asBoolean() {
        if (_file.exists()) { return _cfg.getBoolean(this.Path); }
        return false;
    }

    public double asDouble() {
        if (_file.exists()) { return _cfg.getDouble(this.Path); }
        return 0.00;
    }

    // Get list

    /* public List<> asObjectList() {
        if (_file.exists()) { return _cfg.getList(this.Path); }
        return null;
    }

    public List<> asStringList() {
        if (_file.exists()) { return _cfg.getStringList(this.Path); }
        return null;
    }

    public List asIntegerList() {
        if (_file.exists()) { return _cfg.getIntegerList(this.Path); }
        return null;
    }

    public List<> asBooleanList() {
        if (_file.exists()) { return _cfg.getBooleanList(this.Path); }
        return false;
    }

    public List<Double> asDoubleList() {
        if (_file.exists()) { return _cfg.getDoubleList(this.Path); }
    } */

}
