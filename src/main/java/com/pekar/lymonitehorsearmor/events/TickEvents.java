package com.pekar.lymonitehorsearmor.events;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class TickEvents implements IEventHandler
{
    @SubscribeEvent
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
            if (animalEntity.isInWater())
                armor.onBeingInWater();
            else if (animalEntity.isInWaterOrRain())
                armor.onBeingUnderRain();
            else if (animalEntity.isInLava())
                armor.onBeingInLava();
            else
                armor.onBeingInNormalEnvironment();
        }
    }
}
