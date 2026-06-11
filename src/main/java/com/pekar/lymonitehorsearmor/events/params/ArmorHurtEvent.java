package com.pekar.lymonitehorsearmor.events.params;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.EnumMap;
import java.util.Map;

public class ArmorHurtEvent
{
    private final LivingEntity entity;
    private final Map<EquipmentSlot, ItemStack> armorItemStacks = new EnumMap<>(EquipmentSlot.class);
    private final Map<EquipmentSlot, Float> newDamage = new EnumMap<>(EquipmentSlot.class);

    public ArmorHurtEvent(LivingEntity entity, EquipmentSlot slot, ItemStack stack, float damage)
    {
        this.entity = entity;
        armorItemStacks.put(slot, stack);
        newDamage.put(slot, damage);
    }

    public LivingEntity getEntity()
    {
        return entity;
    }

    public ItemStack getArmorItemStack(EquipmentSlot slot)
    {
        return armorItemStacks.getOrDefault(slot, ItemStack.EMPTY);
    }

    public float getNewDamage(EquipmentSlot slot)
    {
        return newDamage.getOrDefault(slot, 0F);
    }

    public void setNewDamage(EquipmentSlot slot, float damage)
    {
        newDamage.put(slot, damage);
    }
}
