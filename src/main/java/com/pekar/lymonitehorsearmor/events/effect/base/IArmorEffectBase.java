package com.pekar.lymonitehorsearmor.events.effect.base;

public interface IArmorEffectBase
{
    State getState();
    void updateActivity();
    void updateAvailability();
    void updateSwitchState();
}
