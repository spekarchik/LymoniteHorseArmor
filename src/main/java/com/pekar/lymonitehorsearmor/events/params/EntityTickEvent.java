package com.pekar.lymonitehorsearmor.events.params;

import net.minecraft.world.entity.Entity;

public class EntityTickEvent
{
    public static class Post
    {
        private final Entity entity;

        public Post(Entity entity)
        {
            this.entity = entity;
        }

        public Entity getEntity()
        {
            return entity;
        }
    }
}
