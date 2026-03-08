package com.pekar.lymonitehorsearmor.events.effect.base;

public interface ISwitchingArmorEffect extends IArmorEffect, ISwitcher
{
    void trySwitch(int amplifier);
    void trySwitchOn(int amplifier);
    void updateActivity(int amplifier);
}
