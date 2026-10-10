package com.pekar.lymonitehorsearmor.events;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class TickEvents implements IEventHandler
{
    @SubscribeEvent
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
