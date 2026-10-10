package com.pekar.lymonitehorsearmor.events;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import com.pekar.lymonitehorsearmor.events.params.EntityTickEvent;
import net.minecraft.world.entity.animal.Animal;

public class TickEvents implements IEventHandler
{
    public void onLivingTick(EntityTickEvent.Post event)
    {
        if (!(event.getEntity() instanceof Animal animalEntity)) return;
        if (animalEntity.level().isClientSide()) return;

        IAnimal animal = AnimalManager.instance().getAnimalByUUID(animalEntity.getUUID());
        if (animal == null) return;

        for (var armor : animal.getArmorTypesUsed())
        {
            armor.onBeingInArmor();
        }
    }
}
