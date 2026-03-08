package com.pekar.lymonitehorsearmor.events.animal;

import com.pekar.lymonitehorsearmor.events.armor.IAnimalArmor;
import com.pekar.lymonitehorsearmor.events.mob.IMob;
import net.minecraft.world.entity.animal.Animal;

public interface IAnimal extends IMob
{
    Iterable<IAnimalArmor> getArmorTypesUsed();

    Animal getAnimalEntity();
    IAnimalArmor getArmor();
    void updateArmorUsed();
}
