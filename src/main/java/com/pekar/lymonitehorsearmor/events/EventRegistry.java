package com.pekar.lymonitehorsearmor.events;

import com.pekar.lymonitehorsearmor.events.fabric.FabricAnimalEventHooks;
import com.pekar.lymonitehorsearmor.events.fabric.FabricDamageEventHooks;
import com.pekar.lymonitehorsearmor.events.fabric.FabricLootEventHooks;

public class EventRegistry
{
    public static void registerEvents()
    {
        FabricAnimalEventHooks.init();
        FabricDamageEventHooks.init();
        FabricLootEventHooks.init();
    }
}
