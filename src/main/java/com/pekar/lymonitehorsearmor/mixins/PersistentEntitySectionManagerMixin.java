package com.pekar.lymonitehorsearmor.mixins;

import com.pekar.lymonitehorsearmor.events.fabric.FabricAnimalEventHooks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.entity.PersistentEntitySectionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentEntitySectionManager.class)
public abstract class PersistentEntitySectionManagerMixin
{
    @Inject(method = "startTracking", at = @At("TAIL"))
    private void lymonitehorsearmor$onStartTracking(EntityAccess entityAccess, CallbackInfo ci)
    {
        if (entityAccess instanceof Entity entity)
        {
            FabricAnimalEventHooks.onEntityJoinLevel(entity);
        }
    }
}
