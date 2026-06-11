package com.pekar.lymonitehorsearmor.events.fabric;

import com.pekar.lymonitehorsearmor.events.CustomizationEvents;
import com.pekar.lymonitehorsearmor.events.params.RightClickBlockEvent;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionResult;

public final class FabricCustomizationEventHooks
{
    private static final CustomizationEvents CUSTOMIZATION_EVENTS = new CustomizationEvents();
    private static boolean initialized = false;

    private FabricCustomizationEventHooks()
    {}

    public static void init()
    {
        if (initialized) return;
        initialized = true;

        UseBlockCallback.EVENT.register((player, level, hand, hitResult) ->
        {
            var event = new RightClickBlockEvent(player, level, hitResult.getBlockPos());
            CUSTOMIZATION_EVENTS.onRightClickBlock(event);
            if (!event.isCanceled()) return InteractionResult.PASS;
            return event.getCancellationResult();
        });
    }
}
