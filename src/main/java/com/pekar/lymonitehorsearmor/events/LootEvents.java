package com.pekar.lymonitehorsearmor.events;

import com.pekar.lymonitehorsearmor.armor.ArmorRegistry;
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
        chestLootTableLoad(event);
    }

    private void chestLootTableLoad(LootTableLoadEvent event)
    {
        if (event.getName().toString().equals("minecraft:chests/jungle_temple"))
        {
            var pool = LootPool.lootPool()
                    .add(LootItem.lootTableItem(ArmorRegistry.HORSE_LYMONITE_ARMOR).setWeight(1))
                    .add(EmptyLootItem.emptyItem().setWeight(4))
                    .setRolls(ConstantValue.exactly(1f))
                    .build();

            event.getTable().addPool(pool);
            return;
        }

        if (event.getName().toString().equals("minecraft:chests/woodland_mansion"))
        {
            var pool = LootPool.lootPool()
                    .add(LootItem.lootTableItem(ArmorRegistry.HORSE_LYMONITE_ARMOR).setWeight(1))
                    .add(EmptyLootItem.emptyItem().setWeight(2))
                    .setRolls(ConstantValue.exactly(1f))
                    .build();

            event.getTable().addPool(pool);
            return;
        }
    }
}
