package com.pekar.lymonitehorsearmor.armor;

import com.pekar.lymonitehorsearmor.utils.QuadFunction;
import com.pekar.lymonitehorsearmor.utils.TriFunction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.pekar.lymonitehorsearmor.Main.ITEMS;

public class ArmorRegistry
{
    public static final DeferredItem<ModHorseArmor> HORSE_LYMONITE_ARMOR = registerAnimalArmor("horse_lymonite_armor", ModArmorMaterial.LIMONITE, ArmorType.BODY, HorseLimoniteArmor::new);


    public static void initStatic()
    {
        // just to initialize static members
    }

    private static <T extends ModAnimalArmor> DeferredItem<T> registerAnimalArmor(String name, ModArmorMaterial armorMaterial, ArmorType armorType,
                                                                            TriFunction<ModArmorMaterial, ArmorType, Item.Properties, T> armorConstructor)
    {
        return ITEMS.registerItem(name, p -> armorConstructor.apply(armorMaterial, armorType, p));
    }

    private static <T extends ModAnimalArmor> DeferredItem<T> registerAnimalArmor(String name, ModArmorMaterial armorMaterial, ArmorType armorSlotType, AnimalArmorType armorType,
                                                                            QuadFunction<ModArmorMaterial, ArmorType, AnimalArmorType, Item.Properties, T> armorConstructor)
    {
        return ITEMS.registerItem(name, p -> armorConstructor.apply(armorMaterial, armorSlotType, armorType, p));
    }
}
