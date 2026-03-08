package com.pekar.lymonitehorsearmor.events.effect.base;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import com.pekar.lymonitehorsearmor.events.armor.IAnimalArmor;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;

public class PermanentAnimalArmorEffect extends PermanentArmorEffect<IAnimal, IAnimalArmor>
{
    protected PermanentAnimalArmorEffect(IAnimal mob, IAnimalArmor armor, Holder<MobEffect> effectType, int defaultAmplifier)
    {
        super(mob, armor, effectType, defaultAmplifier);
    }
}
