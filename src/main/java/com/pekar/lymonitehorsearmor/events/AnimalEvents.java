package com.pekar.lymonitehorsearmor.events;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import com.pekar.lymonitehorsearmor.events.params.ArmorHurtEvent;
import com.pekar.lymonitehorsearmor.events.params.LivingDamageEvent;
import com.pekar.lymonitehorsearmor.events.params.LivingIncomingDamageEvent;

public class AnimalEvents implements IEventHandler
{
    private final IAnimalManager animalManager = AnimalManager.instance();

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
