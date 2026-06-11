package com.pekar.lymonitehorsearmor.events.params;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class LootTableLoadEvent
{
    private final ResourceKey<LootTable> key;
    private final LootTable.Builder tableBuilder;

    public LootTableLoadEvent(ResourceKey<LootTable> key, LootTable.Builder tableBuilder)
    {
        this.key = key;
        this.tableBuilder = tableBuilder;
    }

    public ResourceKey<LootTable> getKey()
    {
        return key;
    }

    public LootTable.Builder getTable()
    {
        return tableBuilder;
    }
}
