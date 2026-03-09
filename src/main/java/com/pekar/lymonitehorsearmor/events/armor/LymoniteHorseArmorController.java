package com.pekar.lymonitehorsearmor.events.armor;

import com.pekar.lymonitehorsearmor.armor.AnimalArmorType;
import com.pekar.lymonitehorsearmor.armor.ArmorRegistry;
import com.pekar.lymonitehorsearmor.armor.ModAnimalArmor;
import com.pekar.lymonitehorsearmor.armor.ModArmor;
import com.pekar.lymonitehorsearmor.events.animal.IAnimal;
import com.pekar.lymonitehorsearmor.events.effect.HealthBoostAnimalPermanentArmorEffect;
import com.pekar.lymonitehorsearmor.events.effect.base.IPermanentArmorEffect;
import com.pekar.lymonitehorsearmor.events.mob.IMob;
import net.minecraft.world.entity.EquipmentSlot;
import net.neoforged.neoforge.event.entity.EntityTravelToDimensionEvent;
import net.neoforged.neoforge.event.entity.living.*;

public class LymoniteHorseArmorController extends AnimalArmor
{
    private final IPermanentArmorEffect healthBoostEffect;

    public LymoniteHorseArmorController(IAnimal animal)
    {
        super(animal, AnimalArmorType.LYMONITE_HORSE);

        healthBoostEffect = new HealthBoostAnimalPermanentArmorEffect(animal, this, 1);
        healthBoostEffect.setupAnimal().setupAvailability(this::isArmorPutOn);
    }

    private boolean isArmorPutOn(IMob mob, IAnimalArmor armor)
    {
        var entity = mob.getEntity();
        var slotItem = entity.getItemBySlot(EquipmentSlot.BODY);
        return !slotItem.isEmpty() && slotItem.getItem() instanceof ModAnimalArmor modArmor && modArmor.getArmorType() == armor.getArmorType();
    }

    @Override
    public void onLivingHurtEvent(LivingIncomingDamageEvent event)
    {
        var damageSource = event.getSource();
        var armor = animal.getAnimalEntity().getBodyArmorItem();
        if (!(armor.getItem() instanceof ModArmor modArmor)) return;

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
    }

    @Override
    public void onLivingEquipmentChangeEvent(LivingEquipmentChangeEvent event)
    {
        healthBoostEffect.updateAvailability();
        healthBoostEffect.updateActivity();
    }

    @Override
    public void onLivingJumpEvent(LivingEvent.LivingJumpEvent event)
    {

    }

    @Override
    public void onLivingFallEvent(LivingFallEvent event)
    {

    }

    @Override
    public void onEntityTravelToDimensionEvent(EntityTravelToDimensionEvent event)
    {

    }

    @Override
    public void onBeingInLava()
    {

    }

    @Override
    public void onBeingInWater()
    {
    }

    @Override
    public void onBeingUnderRain()
    {
        clearFreeze();
    }

    @Override
    public void onBeingInNormalEnvironment()
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

    @Override
    public void onEffectAddedEvent(MobEffectEvent.Added event)
    {
    }
}
