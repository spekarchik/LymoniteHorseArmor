package com.pekar.lymonitehorsearmor.armor;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class HorseLimoniteArmor extends ModHorseArmor
{
    protected HorseLimoniteArmor(ModArmorMaterial material, Properties properties)
    {
        super(material, AnimalArmorType.LYMONITE_HORSE, properties.rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
}
