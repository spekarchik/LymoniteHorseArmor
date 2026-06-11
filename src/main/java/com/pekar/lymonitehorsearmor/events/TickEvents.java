package com.pekar.lymonitehorsearmor.events;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import com.pekar.lymonitehorsearmor.events.params.EntityTickEvent;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;

public class TickEvents implements IEventHandler
{
    public void onLivingTick(EntityTickEvent.Post event)
    {
        if (!(event.getEntity() instanceof Animal animalEntity)) return;
        if (animalEntity.level().isClientSide()) return;

        boolean isTameAnimal = (animalEntity instanceof TamableAnimal tamable && tamable.isTame());
        boolean isTamedHorse = (animalEntity instanceof AbstractHorse horse && horse.isTamed());
        if (!isTameAnimal && !isTamedHorse) return;

        IAnimal animal = AnimalManager.instance().getAnimalByUUID(animalEntity.getUUID());
        if (animal == null) return;

        for (var armor : animal.getArmorTypesUsed())
        {
            armor.onBeingInArmor();
        }
    }
}
