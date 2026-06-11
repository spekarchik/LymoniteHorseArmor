package com.pekar.lymonitehorsearmor.events.armor;

import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public interface IAnimalArmorEvents
{
    void onArmorHurtEvent(ArmorHurtEvent event);
    void onLivingHurtEvent(LivingIncomingDamageEvent event);
    void onLivingDamageEvent(LivingDamageEvent.Pre event);
    void onLivingEquipmentChangeEvent(LivingEquipmentChangeEvent event);
    void onBeingInArmor();
}
