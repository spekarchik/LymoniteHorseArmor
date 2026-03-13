package com.pekar.lymonitehorsearmor.items;

import com.pekar.lymonitehorsearmor.Main;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;

public class ItemRegistry
{
    public static final DeferredItem<Item> LYMONITE_INGOT = Main.ITEMS.registerItem("lymonite_ingot", LymoniteIngot::new, p -> p.rarity(Rarity.UNCOMMON));

    public static void initStatic()
    {
        // just to initialize static members
    }
}
