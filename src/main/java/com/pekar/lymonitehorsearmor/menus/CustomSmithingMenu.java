package com.pekar.lymonitehorsearmor.menus;

import com.pekar.lymonitehorsearmor.items.ItemRegistry;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.item.ItemStack;

public class CustomSmithingMenu extends SmithingMenu
{
    public CustomSmithingMenu(int containerId, Inventory playerInventory)
    {
        super(containerId, playerInventory);
    }

    public CustomSmithingMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access)
    {
        super(containerId, playerInventory, access);
    }

    @Override
    protected void onTake(Player player, ItemStack stack)
    {
        var template = getSlot(0).getItem();
        var mainItem = getSlot(1).getItem();
        var secondaryItem = getSlot(2).getItem();
        var result = stack;

        if (template.is(ItemRegistry.HORSE_ARMOR_HANDBOOK))
        {
            mainItem.shrink(1);
            secondaryItem.shrink(1);

            access.execute((level, pos) ->
                    level.levelEvent(1044, pos, 0)
            );

            inputSlots.setChanged();
            slotsChanged(inputSlots);

            return;
        }

        super.onTake(player, stack);
    }
}
