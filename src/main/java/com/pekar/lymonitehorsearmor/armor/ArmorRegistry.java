package com.pekar.lymonitehorsearmor.armor;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.BiFunction;

import static com.pekar.lymonitehorsearmor.Main.ITEMS;

public class ArmorRegistry
{
    public static final DeferredItem<ModAnimalArmor> HORSE_LYMONITE_ARMOR = registerAnimalArmor("horse_lymonite_armor", ModArmorMaterial.LIMONITE, HorseLimoniteArmor::new);


    public static void initStatic()
    {
        // just to initialize static members
    }

    private static <T extends ModAnimalArmor> DeferredItem<T> registerAnimalArmor(String name, ModArmorMaterial armorMaterial,
                                                                                  BiFunction<ModArmorMaterial, Item.Properties, T> armorConstructor)
    {
        return ITEMS.registerItem(name, p -> armorConstructor.apply(armorMaterial, p));
    }
}
