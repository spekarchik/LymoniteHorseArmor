package com.pekar.lymonitehorsearmor.events.fabric;

import com.pekar.lymonitehorsearmor.events.LootEvents;
import com.pekar.lymonitehorsearmor.events.params.LootTableLoadEvent;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;

public final class FabricLootEventHooks
{
    private static final LootEvents LOOT_EVENTS = new LootEvents();
    private static boolean initialized = false;

    private FabricLootEventHooks()
    {}

    public static void init()
    {
        if (initialized) return;
        initialized = true;

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) ->
                LOOT_EVENTS.onChestLootTableLoad(new LootTableLoadEvent(key, tableBuilder)));
    }
}
