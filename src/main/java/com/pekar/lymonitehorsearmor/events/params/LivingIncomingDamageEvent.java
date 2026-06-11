package com.pekar.lymonitehorsearmor.events.params;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public class LivingIncomingDamageEvent
{
    private final LivingEntity entity;
    private final DamageSource source;
    private final float amount;
    private boolean canceled;

    public LivingIncomingDamageEvent(LivingEntity entity, DamageSource source, float amount)
    {
        this.entity = entity;
        this.source = source;
        this.amount = amount;
    }

    public LivingEntity getEntity()
    {
        return entity;
    }

    public DamageSource getSource()
    {
        return source;
    }

    public float getAmount()
    {
        return amount;
    }

    public boolean isCanceled()
    {
        return canceled;
    }

    public void setCanceled(boolean canceled)
    {
        this.canceled = canceled;
    }
}
