package me.keeeenion.playerapi.methods;

/**
 * Created by Keeeenion on 22.07.2016.
 */
public interface StatsValue {

    Object value();

    int asInt();

    float asFloat();

    double asDouble();

    long asLong();

    short asShort();

    byte asByte();

    boolean asBoolean();

    String asString();
}
