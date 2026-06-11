package com.pekar.lymonitehorsearmor.events.params;

import net.minecraft.world.entity.animal.Animal;

public class AnimalTameEvent
{
    private final Animal entity;

    public AnimalTameEvent(Animal entity)
    {
        this.entity = entity;
    }

    public Animal getEntity()
    {
        return entity;
    }
}
