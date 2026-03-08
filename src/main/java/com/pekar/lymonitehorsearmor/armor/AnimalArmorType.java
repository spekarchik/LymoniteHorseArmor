package com.pekar.lymonitehorsearmor.armor;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import com.pekar.lymonitehorsearmor.events.armor.IAnimalArmor;
import com.pekar.lymonitehorsearmor.events.armor.LymoniteHorseArmorController;

import java.util.function.Function;

public enum AnimalArmorType
{
    LYMONITE_HORSE(LymoniteHorseArmorController::new),
    OTHER(a -> {throw new UnsupportedOperationException();});

    private final Function<IAnimal, ? extends IAnimalArmor> armorBehaviorFactory;

    AnimalArmorType(Function<IAnimal, ? extends IAnimalArmor> armorBehaviorFactory)
    {
        this.armorBehaviorFactory = armorBehaviorFactory;
    }

    public IAnimalArmor createController(IAnimal animal)
    {
        return armorBehaviorFactory.apply(animal);
    }
}
