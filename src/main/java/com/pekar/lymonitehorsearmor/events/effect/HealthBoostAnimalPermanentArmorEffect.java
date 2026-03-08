package com.pekar.lymonitehorsearmor.events.effect;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import com.pekar.lymonitehorsearmor.events.armor.IAnimalArmor;
import com.pekar.lymonitehorsearmor.events.effect.base.PermanentAnimalArmorEffect;
import net.minecraft.world.effect.MobEffects;

public class HealthBoostAnimalPermanentArmorEffect extends PermanentAnimalArmorEffect
{
    public HealthBoostAnimalPermanentArmorEffect(IAnimal animal, IAnimalArmor armor, int amplifier)
    {
        super(animal, armor, MobEffects.HEALTH_BOOST, amplifier);
    }
}
