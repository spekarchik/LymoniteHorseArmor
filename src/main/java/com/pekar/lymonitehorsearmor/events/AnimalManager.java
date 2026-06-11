package com.pekar.lymonitehorsearmor.events;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import com.pekar.lymonitehorsearmor.events.animal.ModAnimal;
import com.pekar.lymonitehorsearmor.events.armor.IAnimalArmor;
import com.pekar.lymonitehorsearmor.events.params.AnimalTameEvent;
import com.pekar.lymonitehorsearmor.events.params.EntityJoinLevelEvent;
import com.pekar.lymonitehorsearmor.events.params.EntityLeaveLevelEvent;
import com.pekar.lymonitehorsearmor.events.params.LivingEquipmentChangeEvent;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.equine.AbstractHorse;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AnimalManager implements IAnimalManager, IEventHandler
{
    private final Map<UUID, IAnimal> animals = new ConcurrentHashMap<>();
    private static final IAnimalManager instance;

    static
    {
        instance = new AnimalManager();
    }

    public static IAnimalManager instance()
    {
        return instance;
    }

    @Override
    public IAnimal getAnimalByUUID(UUID uuid)
    {
        return animals.get(uuid);
    }

    private void addAnimal(Animal entity)
    {
        IAnimal animal = new ModAnimal(entity);
        animals.put(animal.getEntity().getUUID(), animal);
        animal.updateArmorUsed();
    }

    public void onEntityJoinLevelEvent(EntityJoinLevelEvent event)
    {
        if (event.getLevel().isClientSide()) return;

        var entity = event.getEntity();

        boolean isTameAnimal = (entity instanceof TamableAnimal tamable && tamable.isTame());
        boolean isTamedHorse = (entity instanceof AbstractHorse horse && horse.isTamed());
        if (entity instanceof Animal animal && (isTameAnimal || isTamedHorse))
        {
            addAnimal(animal);
        }
    }

    public void onEntityTameEvent(AnimalTameEvent event)
    {
        if (event.getEntity().level().isClientSide()) return;

        var entity = event.getEntity();
        if (entity instanceof Animal animal)
        {
            addAnimal(animal);
        }
    }

    public void onEntityLeaveLevelEvent(EntityLeaveLevelEvent event)
    {
        if (event.getLevel().isClientSide()) return;

        var entity = event.getEntity();
        boolean isTameAnimal = (entity instanceof TamableAnimal tamable && tamable.isTame());
        boolean isTamedHorse = (entity instanceof AbstractHorse horse && horse.isWearingBodyArmor() && horse.isTamed());
        if (isTameAnimal || isTamedHorse)
        {
            animals.remove(entity.getUUID());
        }
    }

    public void onEquipmentChangeEvent(LivingEquipmentChangeEvent event)
    {
        var entity = event.getEntity();
        if (entity.level().isClientSide()) return;

        if (entity instanceof Animal)
        {
            IAnimal animal = animals.get(entity.getUUID());
            if (animal == null) return;

            var armorUsed = animal.getArmorTypesUsed();
            Set<IAnimalArmor> armorAffected = new HashSet<>((Collection<IAnimalArmor>) armorUsed);
            animal.updateArmorUsed();
            armorAffected.addAll((Collection<IAnimalArmor>) animal.getArmorTypesUsed());

            for (var armor : armorAffected)
            {
                armor.onLivingEquipmentChangeEvent(event);
            }
        }
    }
}
