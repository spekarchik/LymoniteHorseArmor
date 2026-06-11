package com.pekar.lymonitehorsearmor.events;

import static net.neoforged.neoforge.common.NeoForge.EVENT_BUS;

public class EventRegistry
{
    public static void registerEvents()
    {
        register((AnimalManager)AnimalManager.instance());
        register(new TickEvents());
        register(new AnimalEvents());
        register(new LootEvents());
    }

    private static void register(IEventHandler eventHandler)
    {
        EVENT_BUS.register(eventHandler);
    }
}
