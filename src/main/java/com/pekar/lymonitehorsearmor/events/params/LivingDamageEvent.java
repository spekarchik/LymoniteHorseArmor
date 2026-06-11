package com.pekar.lymonitehorsearmor.events.params;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public class LivingDamageEvent
{
    public static class Pre
    {
        private final LivingEntity entity;
        private final DamageSource source;
        private float newDamage;

        public Pre(LivingEntity entity, DamageSource source, float newDamage)
        {
            this.entity = entity;
            this.source = source;
            this.newDamage = newDamage;
        }

        public LivingEntity getEntity()
        {
            return entity;
        }

        public DamageSource getSource()
        {
            return source;
        }

        public float getNewDamage()
        {
            return newDamage;
        }

        public void setNewDamage(float newDamage)
        {
            this.newDamage = newDamage;
        }
    }
}
