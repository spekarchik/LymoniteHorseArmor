package com.pekar.lymonitehorsearmor.events.armor;

import com.pekar.lymonitehorsearmor.events.params.ArmorHurtEvent;
import com.pekar.lymonitehorsearmor.events.params.LivingDamageEvent;
import com.pekar.lymonitehorsearmor.events.params.LivingEquipmentChangeEvent;
import com.pekar.lymonitehorsearmor.events.params.LivingIncomingDamageEvent;

public interface IAnimalArmorEvents
{
    void onArmorHurtEvent(ArmorHurtEvent event);
    void onLivingHurtEvent(LivingIncomingDamageEvent event);
    void onLivingDamageEvent(LivingDamageEvent.Pre event);
    void onLivingEquipmentChangeEvent(LivingEquipmentChangeEvent event);
    void onBeingInArmor();
}
