package com.pekar.lymonitehorsearmor.armor;

import com.pekar.lymonitehorsearmor.Main;
import com.pekar.lymonitehorsearmor.utils.Utils;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

import static com.pekar.lymonitehorsearmor.utils.Resources.createResourceLocation;

// Durability:
// LEATHER: 5
// GOLDEN: 7
// CHAINMAIL: 15
// IRON: 15
// DIAMOND: 33
// NETHERITE: 37

public class ModArmorMaterial
{
    private final ArmorMaterial material;
    private final String materialName;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorType, Integer> armorResistanceMap;
    private final int enchantmentValue;
    private final float toughness;
    private final float knockbackResistance;
    private final Holder<SoundEvent> equipmentSound;
    private final TagKey<Item> repairIngredient;
    private final boolean isFireResistant;

    public static final String LIMONITE_MATERIAL_NAME = "limonite";
    public static final TagKey<Item> LIMONITE_INGOT_TAG = TagKey.create(Registries.ITEM, createResourceLocation(Main.MODID, "limonite_ingot_tag"));

    // ArmorMaterials

    protected static final ModArmorMaterial LIMONITE = new ModArmorMaterial(LIMONITE_MATERIAL_NAME, "limonite_armor",
            createArmorTypeMap(2, 5, 7, 3, 9),
            30, 1F, 0F, 23, SoundEvents.ARMOR_EQUIP_LEATHER, LIMONITE_INGOT_TAG, false);


    public ModArmorMaterial(String materialName, String armorModelName, EnumMap<ArmorType, Integer> armorResistanceMap,
                            int enchantmentValue, float toughness, float knockbackResistance, int durabilityMultiplier,
                            Holder<SoundEvent> equipmentSound, TagKey<Item> repairIngredient, boolean isFireResistant)
    {
        this.material = createVanillaMaterial(armorModelName, durabilityMultiplier, armorResistanceMap, enchantmentValue, equipmentSound, toughness, knockbackResistance, repairIngredient);
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

    public ArmorMaterial getMaterial()
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
    private static ArmorMaterial createVanillaMaterial(
            String armorName,
            int durability,
            EnumMap<ArmorType, Integer> defence,
            int enchantmentValue,
            Holder<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            TagKey<Item> repairIngredient)
    {
        var modelId = Utils.instance.resources.createEquipmentResourceKey(Main.MODID, armorName);
        return new ArmorMaterial(durability, defence, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, modelId);
    }

    private static EnumMap<ArmorType, Integer> createArmorTypeMap(int bootsResistance, int leggingsResistance, int chestplateResistance, int helmetResistance, int bodyResistance)
    {
        return Util.make(new EnumMap<>(ArmorType.class), armorTypeMap -> {
            armorTypeMap.put(ArmorType.BOOTS, bootsResistance);
            armorTypeMap.put(ArmorType.LEGGINGS, leggingsResistance);
            armorTypeMap.put(ArmorType.CHESTPLATE, chestplateResistance);
            armorTypeMap.put(ArmorType.HELMET, helmetResistance);
            armorTypeMap.put(ArmorType.BODY, bodyResistance);
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
