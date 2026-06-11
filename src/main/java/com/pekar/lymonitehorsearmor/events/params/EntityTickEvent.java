package com.pekar.lymonitehorsearmor.events.params;

import net.minecraft.world.entity.Entity;

public class EntityTickEvent
{
    private final Entity entity;

    public EntityTickEvent(Entity entity)
    {
        this.entity = entity;
    }

    public Entity getEntity()
    {
        return entity;
    }

    public static class Post extends EntityTickEvent
    {
        public Post(Entity entity)
        {
            super(entity);
        }
    }
}
