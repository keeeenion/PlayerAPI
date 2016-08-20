package me.keeeenion.playerapi.methods;

import org.bukkit.metadata.MetadataValue;

public class Metadata{

    public String Path;
    public MetadataValue Value;
    public int Time;

    public Metadata(String path, MetadataValue value, int time) {
        this.Path = path;
        this.Value = value;
        this.Time = time;
    }

    public String getPath() { return this.Path; }

    public MetadataValue getValue() { return this.Value; }

    public int getTime() { return this.Time; }

}
