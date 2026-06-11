package com.pekar.lymonitehorsearmor.events.fabric;

import com.pekar.lymonitehorsearmor.events.AnimalManager;
import com.pekar.lymonitehorsearmor.events.TickEvents;
import com.pekar.lymonitehorsearmor.events.params.AnimalTameEvent;
import com.pekar.lymonitehorsearmor.events.params.EntityJoinLevelEvent;
import com.pekar.lymonitehorsearmor.events.params.EntityLeaveLevelEvent;
import com.pekar.lymonitehorsearmor.events.params.EntityTickEvent;
import com.pekar.lymonitehorsearmor.events.params.LivingEquipmentChangeEvent;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;

public final class FabricAnimalEventHooks
{
    private static final AnimalManager ANIMAL_MANAGER = (AnimalManager) AnimalManager.instance();
    private static final TickEvents TICK_EVENTS = new TickEvents();
    private static boolean initialized = false;

    private FabricAnimalEventHooks()
    {}

    public static void init()
    {
        if (initialized) return;
        initialized = true;

        ServerTickEvents.END_LEVEL_TICK.register(level ->
                level.getAllEntities().forEach(entity ->
                        TICK_EVENTS.onLivingTick(new EntityTickEvent.Post(entity))));
    }

    public static void onEntityJoinLevel(Entity entity)
    {
        ANIMAL_MANAGER.onEntityJoinLevelEvent(new EntityJoinLevelEvent(entity, entity.level()));

        if (entity instanceof Animal animal)
        {
            ANIMAL_MANAGER.onEquipmentChangeEvent(new LivingEquipmentChangeEvent(animal, EquipmentSlot.BODY, ItemStack.EMPTY, animal.getBodyArmorItem()));
        }
    }

    public static void onEntityLeaveLevel(Entity entity)
    {
        ANIMAL_MANAGER.onEntityLeaveLevelEvent(new EntityLeaveLevelEvent(entity, entity.level()));
    }

    public static void onAnimalTamed(Animal animal)
    {
        ANIMAL_MANAGER.onEntityTameEvent(new AnimalTameEvent(animal));
    }

    public static void onEquipmentChange(LivingEntity entity, EquipmentSlot slot, ItemStack oldStack, ItemStack newStack)
    {
        ANIMAL_MANAGER.onEquipmentChangeEvent(new LivingEquipmentChangeEvent(entity, slot, oldStack, newStack));
    }
}
