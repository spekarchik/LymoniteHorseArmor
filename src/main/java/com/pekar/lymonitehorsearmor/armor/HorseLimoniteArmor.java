package com.pekar.lymonitehorsearmor.armor;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.equipment.ArmorType;

public class HorseLimoniteArmor extends ModHorseArmor
{
    protected HorseLimoniteArmor(ModArmorMaterial material, ArmorType equipmentSlot, Properties properties)
    {
        super(material, equipmentSlot, AnimalArmorType.LYMONITE_HORSE, properties.rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
}
