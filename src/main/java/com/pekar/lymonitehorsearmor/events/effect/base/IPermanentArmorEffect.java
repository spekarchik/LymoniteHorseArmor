package com.pekar.lymonitehorsearmor.events.effect.base;

public interface IPermanentArmorEffect extends IArmorEffect
{
    void tryActivate();
    void tryActivate(int amplifier);
    void updateActivity(int amplifier);
}
