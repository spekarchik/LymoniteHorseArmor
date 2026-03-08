package com.pekar.lymonitehorsearmor.events.effect.base;

public interface ISwitcher
{
    boolean isOn();

    void trySwitchTo(boolean switchOn);
    void trySwitch();
    void trySwitchOn();
    void trySwitchOff();
}
