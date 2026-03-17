package com.pekar.lymonitehorsearmor.armor;

import com.pekar.lymonitehorsearmor.utils.QuadFunction;
import com.pekar.lymonitehorsearmor.utils.TriFunction;
import net.minecraft.world.item.ArmorItem;
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

    private static <T extends ModArmor> DeferredItem<T> registerAnimalArmor(String name, ModArmorMaterial armorMaterial, ArmorItem.Type armorType,
                                                                            TriFunction<ModArmorMaterial, ArmorItem.Type, Item.Properties, T> armorConstructor)
    {
        return ITEMS.registerItem(name, p -> armorConstructor.apply(armorMaterial, armorType, p));
    }

    private static <T extends ModArmor> DeferredItem<T> registerAnimalArmor(String name, ModArmorMaterial armorMaterial, ArmorItem.Type armorSlotType, AnimalArmorType armorType,
                                                                            QuadFunction<ModArmorMaterial, ArmorItem.Type, AnimalArmorType, Item.Properties, T> armorConstructor)
    {
        return ITEMS.registerItem(name, p -> armorConstructor.apply(armorMaterial, armorSlotType, armorType, p));
    }
}
