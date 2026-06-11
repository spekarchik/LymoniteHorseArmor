package com.pekar.lymonitehorsearmor.armor;

import com.pekar.lymonitehorsearmor.utils.TriFunction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;

import static com.pekar.lymonitehorsearmor.items.ItemRegistry.registerItem;

public class ArmorRegistry
{
    public static final ModHorseArmor HORSE_LYMONITE_ARMOR = registerAnimalArmor("horse_lymonite_armor", ModArmorMaterial.LIMONITE, ArmorType.BODY, HorseLimoniteArmor::new);


    public static void initStatic()
    {
        // just to initialize static members
    }

    private static <T extends ModAnimalArmor> T registerAnimalArmor(String name, ModArmorMaterial armorMaterial, ArmorType armorType,
                                                                    TriFunction<ModArmorMaterial, ArmorType, Item.Properties, T> armorConstructor)
    {
        return registerItem(name, p -> armorConstructor.apply(armorMaterial, armorType, p));
    }
}
