package com.pekar.lymonitehorsearmor.events.fabric;

import com.pekar.lymonitehorsearmor.events.AnimalEvents;
import com.pekar.lymonitehorsearmor.events.params.ArmorHurtEvent;
import com.pekar.lymonitehorsearmor.events.params.LivingDamageEvent;
import com.pekar.lymonitehorsearmor.events.params.LivingIncomingDamageEvent;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public final class FabricDamageEventHooks
{
    private static final AnimalEvents ANIMAL_EVENTS = new AnimalEvents();
    private static boolean initialized = false;

    private FabricDamageEventHooks()
    {}

    public static void init()
    {
        if (initialized) return;
        initialized = true;

        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) ->
        {
            var event = new LivingIncomingDamageEvent(entity, source, amount);
            ANIMAL_EVENTS.onLivingHurtEvent(event);
            return !event.isCanceled();
        });
    }

    public static float modifyDamage(LivingEntity entity, DamageSource source, float amount)
    {
        var event = new LivingDamageEvent.Pre(entity, source, amount);
        ANIMAL_EVENTS.onLivingDamageEvent(event);
        return event.getNewDamage();
    }

    public static float modifyArmorDamage(LivingEntity entity, EquipmentSlot slot, ItemStack stack, float damage)
    {
        var event = new ArmorHurtEvent(entity, slot, stack, damage);
        ANIMAL_EVENTS.onArmorHurtEvent(event);
        return event.getNewDamage(slot);
    }
}
