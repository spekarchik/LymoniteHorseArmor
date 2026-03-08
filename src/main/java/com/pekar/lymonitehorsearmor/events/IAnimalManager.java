package com.pekar.lymonitehorsearmor.events;

import com.pekar.lymonitehorsearmor.events.animal.IAnimal;

import java.util.UUID;

public interface IAnimalManager
{
    IAnimal getAnimalByUUID(UUID uuid);
}
