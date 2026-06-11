package com.pekar.lymonitehorsearmor.mixins;

import com.pekar.lymonitehorsearmor.items.ItemRegistry;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.LevelEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(net.minecraft.world.inventory.SmithingMenu.class)
public abstract class SmithingMenuMixin
{
    @Inject(
            method = "onTake",
            at = @At("HEAD"),
            cancellable = true
    )
    private void keepHorseArmorHandbook(Player player, ItemStack stack, CallbackInfo ci)
    {
        var accessor = (ItemCombinerMenuAccessor)this;
        var inputSlots = accessor.lymonitehorsearmor$getInputSlots();
        var template = inputSlots.getItem(0);
        if (!template.is(ItemRegistry.HORSE_ARMOR_HANDBOOK))
        {
            return;
        }

        var base = inputSlots.getItem(1);
        var addition = inputSlots.getItem(2);

        stack.onCraftedBy(player.level(), player, stack.getCount());
        accessor.lymonitehorsearmor$getResultSlots().awardUsedRecipes(player, List.of(template, base, addition));

        shrinkStackInSlot(inputSlots, 1);
        shrinkStackInSlot(inputSlots, 2);

        accessor.lymonitehorsearmor$getAccess().execute((level, pos) ->
                level.levelEvent(LevelEvent.SOUND_SMITHING_TABLE_USED, pos, 0)
        );

        ci.cancel();
    }

    private void shrinkStackInSlot(Container inputSlots, int slot)
    {
        var itemStack = inputSlots.getItem(slot);
        if (!itemStack.isEmpty())
        {
            itemStack.shrink(1);
            inputSlots.setItem(slot, itemStack);
        }
    }
}
