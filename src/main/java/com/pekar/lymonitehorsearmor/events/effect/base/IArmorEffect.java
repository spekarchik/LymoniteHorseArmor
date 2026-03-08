package com.pekar.lymonitehorsearmor.events.effect.base;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import com.pekar.lymonitehorsearmor.events.armor.IAnimalArmor;

public interface IArmorEffect extends IArmorEffectBase
{
    boolean isActive();
    boolean isAnotherActive();
    boolean isAnyActive();
    boolean isAvailable();
    boolean isInfinite();
    void forceRemove();
    void onActivated();
    void onDeactivated();

    IArmorEffectSetup<IArmorEffectWithOptions<IAnimal, IAnimalArmor>, IAnimal, IAnimalArmor> setupAnimal();
    <E extends IArmorEffectWithOptions<IAnimal, IAnimalArmor>> IArmorEffectSetup<IArmorEffectWithOptions<IAnimal, IAnimalArmor>, IAnimal, IAnimalArmor> setupAnimal(E effect);
}
