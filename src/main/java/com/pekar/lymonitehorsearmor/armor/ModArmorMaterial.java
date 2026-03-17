package com.pekar.lymonitehorsearmor.armor;

import com.pekar.lymonitehorsearmor.Main;
import com.pekar.lymonitehorsearmor.items.ItemRegistry;
import com.pekar.lymonitehorsearmor.utils.Utils;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

// Durability:
// LEATHER: 5
// GOLDEN: 7
// CHAINMAIL: 15
// IRON: 15
// DIAMOND: 33
// NETHERITE: 37

public class ModArmorMaterial
{
    private final Holder<ArmorMaterial> material;
    private final String materialName;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> armorResistanceMap;
    private final int enchantmentValue;
    private final float toughness;
    private final float knockbackResistance;
    private final Holder<SoundEvent> equipmentSound;
    private final Supplier<Ingredient> repairIngredient;
    private final boolean isFireResistant;

    private static final String LIMONITE_MATERIAL_NAME = "limonite";

    // ArmorMaterials

    public static final ModArmorMaterial LIMONITE = new ModArmorMaterial(LIMONITE_MATERIAL_NAME, "limonite_armor",
            createArmorTypeMap(2, 5, 7, 3, 9),
            30, 1F, 0F, 23, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(ItemRegistry.LYMONITE_INGOT.get()), false);


    public ModArmorMaterial(String materialName, String armorModelName, EnumMap<ArmorItem.Type, Integer> armorResistanceMap,
                            int enchantmentValue, float toughness, float knockbackResistance, int durabilityMultiplier,
                            Holder<SoundEvent> equipmentSound, Supplier<Ingredient> repairIngredient, boolean isFireResistant)
    {
        this.material = createVanillaMaterial(armorModelName, armorResistanceMap, enchantmentValue, equipmentSound, toughness, knockbackResistance, repairIngredient);
        this.materialName = materialName;
        this.armorResistanceMap = armorResistanceMap;
        this.enchantmentValue = enchantmentValue;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.durabilityMultiplier = durabilityMultiplier;
        this.equipmentSound = equipmentSound;
        this.repairIngredient = repairIngredient;
        this.isFireResistant = isFireResistant;
    }

    public Holder<ArmorMaterial> getMaterial()
    {
        return material;
    }

    public String getMaterialName()
    {
        return materialName;
    }

    public int getDurabilityMultiplier()
    {
        return durabilityMultiplier;
    }

    public boolean isFireResistant()
    {
        return isFireResistant;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof ModArmorMaterial another)) return false;
        return materialName.equals(another.materialName);
    }

    @Override
    public int hashCode()
    {
        return materialName.hashCode();
    }

    // copied from ArmorMaterials 1.21.1 and modified
    private static Holder<ArmorMaterial> createVanillaMaterial(
            String armorName,
            EnumMap<ArmorItem.Type, Integer> defence,
            int enchantmentValue,
            Holder<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient)
    {
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);

        for (ArmorItem.Type armoritem$type : ArmorItem.Type.values()) {
            enummap.put(armoritem$type, defence.get(armoritem$type));
        }

        var resourceLocation = Utils.instance.resources.createResourceLocation(Main.MODID, armorName);
        var armorLayers = List.of(new ArmorMaterial.Layer(resourceLocation));
        return Main.ARMOR_MATERIALS.register(armorName, () -> new ArmorMaterial(enummap, enchantmentValue, equipSound, repairIngredient, armorLayers, toughness, knockbackResistance));
    }

    private static EnumMap<ArmorItem.Type, Integer> createArmorTypeMap(int bootsResistance, int leggingsResistance, int chestplateResistance, int helmetResistance, int bodyResistance)
    {
        return Util.make(new EnumMap<>(ArmorItem.Type.class), armorTypeMap -> {
            armorTypeMap.put(ArmorItem.Type.BOOTS, bootsResistance);
            armorTypeMap.put(ArmorItem.Type.LEGGINGS, leggingsResistance);
            armorTypeMap.put(ArmorItem.Type.CHESTPLATE, chestplateResistance);
            armorTypeMap.put(ArmorItem.Type.HELMET, helmetResistance);
            armorTypeMap.put(ArmorItem.Type.BODY, bodyResistance);
        });
    }

    private static ModArmorMaterial copyOf(ModArmorMaterial armorMaterial, String armorModelName)
    {
        return new ModArmorMaterial(
                armorMaterial.materialName,
                armorModelName,
                armorMaterial.armorResistanceMap,
                armorMaterial.enchantmentValue,
                armorMaterial.toughness,
                armorMaterial.knockbackResistance,
                armorMaterial.durabilityMultiplier,
                armorMaterial.equipmentSound,
                armorMaterial.repairIngredient,
                armorMaterial.isFireResistant);
    }
}
