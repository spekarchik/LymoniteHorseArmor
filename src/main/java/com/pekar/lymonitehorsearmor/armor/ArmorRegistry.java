package com.pekar.lymonitehorsearmor.armor;

import net.minecraft.world.item.Item;

import java.util.function.BiFunction;

import static com.pekar.lymonitehorsearmor.items.ItemRegistry.registerItem;

public class ArmorRegistry
{
    public static final ModAnimalArmor HORSE_LYMONITE_ARMOR = registerAnimalArmor("horse_lymonite_armor", ModArmorMaterial.LIMONITE, HorseLimoniteArmor::new);


    public static void initStatic()
    {
        // just to initialize static members
    }

    private static <T extends ModAnimalArmor> T registerAnimalArmor(String name, ModArmorMaterial armorMaterial,
                                                                    BiFunction<ModArmorMaterial, Item.Properties, T> armorConstructor)
    {
        return registerItem(name, p -> armorConstructor.apply(armorMaterial, p));
    }
}
