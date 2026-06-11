package com.pekar.lymonitehorsearmor.events;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class AnimalEvents implements IEventHandler
{
    private final IAnimalManager animalManager = AnimalManager.instance();

    @SubscribeEvent
    public void onLivingHurtEvent(LivingIncomingDamageEvent event)
    {
        var entity = event.getEntity();
        var animal = animalManager.getAnimalByUUID(entity.getUUID());
        if (animal == null) return;

        for (var armor : animal.getArmorTypesUsed())
        {
            armor.onLivingHurtEvent(event);
        }
    }

    @SubscribeEvent
    public void onLivingDamageEvent(LivingDamageEvent.Pre event)
    {
        var entity = event.getEntity();
        IAnimal animal = animalManager.getAnimalByUUID(entity.getUUID());
        if (animal == null) return;

        for (var armor : animal.getArmorTypesUsed())
        {
            armor.onLivingDamageEvent(event);
        }
    }

    @SubscribeEvent
    public void onArmorHurtEvent(ArmorHurtEvent event)
    {
        var entity = event.getEntity();
        var animal = animalManager.getAnimalByUUID(entity.getUUID());
        if (animal == null) return;

        for (var armor : animal.getArmorTypesUsed())
        {
            armor.onArmorHurtEvent(event);
        }
    }
}
