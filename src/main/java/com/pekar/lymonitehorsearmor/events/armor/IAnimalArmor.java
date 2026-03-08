package com.pekar.lymonitehorsearmor.events.armor;

import com.pekar.lymonitehorsearmor.armor.AnimalArmorType;

public interface IAnimalArmor extends IArmor, IAnimalArmorEvents
{
    AnimalArmorType getArmorType();
}
