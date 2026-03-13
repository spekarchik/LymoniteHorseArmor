package com.pekar.lymonitehorsearmor.events;

import com.pekar.lymonitehorsearmor.armor.ArmorRegistry;
import com.pekar.lymonitehorsearmor.items.ItemRegistry;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.LootTableLoadEvent;

public class LootEvents implements IEventHandler
{
    @SubscribeEvent
    public void onChestLootTableLoad(LootTableLoadEvent event)
    {
        if (event.getKey().equals(BuiltInLootTables.JUNGLE_TEMPLE))
        {
            var pool = LootPool.lootPool()
                    .add(LootItem.lootTableItem(ArmorRegistry.HORSE_LYMONITE_ARMOR).setWeight(1))
                    .add(LootItem.lootTableItem(ItemRegistry.LYMONITE_INGOT).setWeight(1))
                    .add(EmptyLootItem.emptyItem().setWeight(2))
                    .setRolls(ConstantValue.exactly(1f))
                    .build();

            event.getTable().addPool(pool);
            return;
        }

        if (event.getKey().equals(BuiltInLootTables.WOODLAND_MANSION))
        {
            var pool = LootPool.lootPool()
                    .add(LootItem.lootTableItem(ArmorRegistry.HORSE_LYMONITE_ARMOR).setWeight(1))
                    .add(LootItem.lootTableItem(ItemRegistry.LYMONITE_INGOT).setWeight(1))
                    .add(EmptyLootItem.emptyItem().setWeight(2))
                    .setRolls(ConstantValue.exactly(1f))
                    .build();

            event.getTable().addPool(pool);
            return;
        }

        if (event.getKey().equals(BuiltInLootTables.STRONGHOLD_LIBRARY))
        {
            var pool = LootPool.lootPool()
                    .add(LootItem.lootTableItem(ItemRegistry.HORSE_ARMOR_HANDBOOK).setWeight(1))
                    .add(EmptyLootItem.emptyItem().setWeight(2))
                    .setRolls(ConstantValue.exactly(1f))
                    .build();

            event.getTable().addPool(pool);
            return;
        }
    }
}
