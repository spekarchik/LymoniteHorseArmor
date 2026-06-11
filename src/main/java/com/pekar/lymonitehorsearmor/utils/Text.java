package com.pekar.lymonitehorsearmor.utils;

import com.pekar.lymonitehorsearmor.tooltip.ITooltip;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.TooltipFlag;

public class Text
{
    Text()
    {

    }

    public boolean showExtendedDescription(ITooltip tooltip, TooltipFlag flag)
    {
        if (!hasShiftDown())
        {
            tooltip.addLineById("description.press_shift").apply();
            return false;
        }

        return true;
    }

    public boolean hasShiftDown()
    {
        var window = Minecraft.getInstance().getWindow().getWindow();
        return InputConstants.isKeyDown(window, InputConstants.KEY_LSHIFT)
                || InputConstants.isKeyDown(window, InputConstants.KEY_RSHIFT);
    }
}
