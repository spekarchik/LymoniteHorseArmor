package com.pekar.lymonitehorsearmor.events.armor;

import com.pekar.lymonitehorsearmor.armor.AnimalArmorType;
import com.pekar.lymonitehorsearmor.armor.ArmorRegistry;
import com.pekar.lymonitehorsearmor.armor.ModAnimalArmor;
import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import com.pekar.lymonitehorsearmor.events.effect.HealthBoostAnimalPermanentArmorEffect;
import com.pekar.lymonitehorsearmor.events.effect.base.IPermanentArmorEffect;
import net.minecraft.world.damagesource.DamageTypes;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class LymoniteHorseArmorController extends AnimalArmor
{
    private final IPermanentArmorEffect healthBoostEffect;

    public LymoniteHorseArmorController(IAnimal animal)
    {
        super(animal, AnimalArmorType.LYMONITE_HORSE);

        healthBoostEffect = new HealthBoostAnimalPermanentArmorEffect(animal, this, 1);
        healthBoostEffect.setupAnimal().setupAvailability(this::isArmorPutOn);
    }

    @Override
    public void onLivingHurtEvent(LivingIncomingDamageEvent event)
    {
        var damageSource = event.getSource();
        var armor = animal.getAnimalEntity().getBodyArmorItem();
        if (!(armor.getItem() instanceof ModAnimalArmor modArmor)) return;

        if (armor.is(ArmorRegistry.HORSE_LYMONITE_ARMOR))
        {
            if (isFreezeDamage(damageSource))
            {
                event.setCanceled(true);
            }
            else if (isPlantThornsDamage(damageSource))
            {
                event.setCanceled(true);
            }
        }
    }

    @Override
    public void onLivingDamageEvent(LivingDamageEvent.Pre event)
    {
        var damageSource = event.getSource();
        if (damageSource.is(DamageTypes.FALL))
        {
            var newDamage = event.getNewDamage() * 0.5F;
            event.setNewDamage(newDamage);
        }
    }

    @Override
    public void onLivingEquipmentChangeEvent(LivingEquipmentChangeEvent event)
    {
        healthBoostEffect.updateAvailability();
        healthBoostEffect.updateActivity();
    }

    @Override
    public void onBeingInArmor()
    {
        clearFreeze();
    }

    private void clearFreeze()
    {
        if (isArmorPutOn(animal, this) && animal.getEntity().isFreezing())
        {
            var entity = animal.getEntity();
            var ticksFrozen = entity.getTicksFrozen();
            entity.setTicksFrozen(Math.max(0, ticksFrozen - 4));
        }
    }
}
