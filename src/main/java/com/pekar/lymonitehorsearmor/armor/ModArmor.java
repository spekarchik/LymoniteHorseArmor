package com.pekar.lymonitehorsearmor.armor;

import com.pekar.lymonitehorsearmor.tooltip.ITooltipProvider;
import com.pekar.lymonitehorsearmor.utils.Utils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.List;
import java.util.function.Consumer;

public abstract class ModArmor extends Item implements ITooltipProvider
{
    protected final ArmorType armorSlotType;
    protected final int maxDamage;
    protected final ModArmorMaterial material;
    protected final Utils utils = new Utils();

    public ModArmor(ModArmorMaterial material, ArmorType armorSlotType, Properties properties)
    {
        super(material.isFireResistant() ? properties.fireResistant() : properties);
        this.armorSlotType = armorSlotType;
        this.maxDamage = armorSlotType.getDurability(material.getDurabilityMultiplier());
        this.material = material;
    }

    public ModArmorMaterial getArmorMaterial()
    {
        return material;
    }

    public ArmorType getArmorSlotType()
    {
        return armorSlotType;
    }

    public int getDefense()
    {
        return getArmorMaterial().getMaterial().defense().get(getArmorSlotType());
    }

    public String getArmorFamilyName()
    {
        return material.getMaterialName() + "_armor";
    }

    public boolean isBroken(ItemStack stack)
    {
        return stack.getMaxDamage() - stack.getDamageValue() <= 1;
    }

    public int getMaxDamage()
    {
        return components().getOrDefault(DataComponents.MAX_DAMAGE, maxDamage);
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer)
    {
        return stack.is(Items.LEATHER_BOOTS);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
    {
        ITooltipProvider.appendHoverText(this, stack, context, tooltipComponents, tooltipFlag);
    }
}
