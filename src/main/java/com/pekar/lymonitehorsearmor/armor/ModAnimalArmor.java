package com.pekar.lymonitehorsearmor.armor;

import com.pekar.lymonitehorsearmor.tooltip.ITooltipProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public abstract class ModAnimalArmor extends AnimalArmorItem implements IModArmor, ITooltipProvider
{
    protected final int maxDamage;
    protected final ModArmorMaterial material;
    protected final AnimalArmorType armorType;

    public ModAnimalArmor(ModArmorMaterial material, AnimalArmorType armorType, AnimalArmorItem.BodyType bodyType, Properties properties)
    {
        super(material.getMaterial(), bodyType, false, properties.stacksTo(1));
        this.maxDamage = ArmorItem.Type.BODY.getDurability(material.getDurabilityMultiplier());
        this.material = material;
        this.armorType = armorType;
    }

    public AnimalArmorType getArmorType()
    {
        return armorType;
    }

    @Override
    public ModArmorMaterial getArmorMaterial()
    {
        return material;
    }

    @Override
    public boolean isBroken(ItemStack stack)
    {
        return false;
    }

    @Override
    public int getMaxDamage()
    {
        return 0;
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer)
    {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> component, TooltipFlag flag)
    {
        ITooltipProvider.appendHoverText(this, stack, context, component, flag);
    }
}
