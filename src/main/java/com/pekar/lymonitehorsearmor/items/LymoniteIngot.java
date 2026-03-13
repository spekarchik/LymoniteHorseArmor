package com.pekar.lymonitehorsearmor.items;

import com.pekar.lymonitehorsearmor.tooltip.ITooltip;
import com.pekar.lymonitehorsearmor.tooltip.ITooltipProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class LymoniteIngot extends ModItem implements ITooltipProvider
{
    public LymoniteIngot(Properties properties)
    {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag)
    {
        ITooltipProvider.appendHoverText(this, stack, context, tooltipDisplay, tooltipAdder, flag);
    }

    @Override
    public void addTooltip(ItemStack stack, TooltipContext context, ITooltip tooltip, TooltipFlag flag)
    {
        tooltip.addLine(getDescriptionId(), 1).asNotice().apply();
    }
}
