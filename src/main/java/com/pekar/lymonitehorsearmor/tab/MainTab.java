package com.pekar.lymonitehorsearmor.tab;

import com.pekar.lymonitehorsearmor.Main;
import com.pekar.lymonitehorsearmor.armor.ArmorRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;
import java.util.stream.Collectors;

public class MainTab extends ModTab
{
    @Override
    protected String getTabName()
    {
        return "main_tab";
    }

    @Override
    protected ItemStack getIconItem()
    {
        return ArmorRegistry.HORSE_LYMONITE_ARMOR.asItem().getDefaultInstance();
    }

    @Override
    protected Collection<Item> getTabItems()
    {
        ArmorRegistry.initStatic();

        return Main.ITEMS.getEntries().stream().map(x -> x.get()).collect(Collectors.toList()); // block items are also included
    }

    @Override
    protected ResourceKey<CreativeModeTab>[] getTabsBefore()
    {
        return new ResourceKey[]
                {
                        CreativeModeTabs.SPAWN_EGGS
                };
    }
}
