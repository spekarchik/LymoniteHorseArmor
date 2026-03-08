package com.pekar.lymonitehorsearmor.events.effect.base;

public enum State
{
    OFF,
    ON;

    public boolean isOff()
    {
        return this == OFF;
    }

    public boolean isOn()
    {
        return this == ON;
    }
}
