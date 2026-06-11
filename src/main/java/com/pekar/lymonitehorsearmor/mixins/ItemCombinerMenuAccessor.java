package com.pekar.lymonitehorsearmor.mixins;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.ResultContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemCombinerMenu.class)
public interface ItemCombinerMenuAccessor
{
    @Accessor("inputSlots")
    Container lymonitehorsearmor$getInputSlots();

    @Accessor("resultSlots")
    ResultContainer lymonitehorsearmor$getResultSlots();

    @Accessor("access")
    ContainerLevelAccess lymonitehorsearmor$getAccess();
}
