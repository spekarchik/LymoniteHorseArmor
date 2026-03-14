package com.pekar.lymonitehorsearmor.items;

import com.pekar.lymonitehorsearmor.Main;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class ItemRegistry
{
    public static final DeferredItem<Item> LYMONITE_MIXTURE = Main.ITEMS.registerItem("lymonite_mixture", ModItem::new);
    public static final DeferredItem<Item> LYMONITE_INGOT = Main.ITEMS.registerItem("lymonite_ingot", LymoniteIngot::new);
    public static final DeferredItem<Item> HORSE_ARMOR_HANDBOOK = Main.ITEMS.registerItem("horse_armor_handbook", AnimalArmorHandbook::new);

    public static void initStatic()
    {
        // just to initialize static members
    }
}
