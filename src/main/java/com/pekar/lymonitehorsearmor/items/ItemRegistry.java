package com.pekar.lymonitehorsearmor.items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static com.pekar.lymonitehorsearmor.Main.MODID;
import static com.pekar.lymonitehorsearmor.utils.Resources.createResourceLocation;

public class ItemRegistry
{
    private static final List<Item> ITEMS = new ArrayList<>();

    public static final TagKey<Item> LIMONITE_INGOT_TAG = TagKey.create(Registries.ITEM, createResourceLocation(MODID, "limonite_ingot_tag"));

    public static final Item LYMONITE_MIXTURE = registerItem("lymonite_mixture", ModItem::new);
    public static final Item LYMONITE_INGOT = registerItem("lymonite_ingot", ModItem::new);
    public static final Item HORSE_ARMOR_HANDBOOK = registerItem("horse_armor_handbook", AnimalArmorHandbook::new);

    public static void initStatic()
    {
        // just to initialize static members
    }

    public static List<Item> getItems()
    {
        return Collections.unmodifiableList(ITEMS);
    }

    public static <T extends Item> T registerItem(String name, Function<Item.Properties, T> itemFactory)
    {
        var id = createResourceLocation(MODID, name);
        var key = ResourceKey.create(Registries.ITEM, id);
        var item = itemFactory.apply(new Item.Properties());
        ITEMS.add(item);
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }
}
