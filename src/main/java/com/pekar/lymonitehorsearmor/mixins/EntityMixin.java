package com.pekar.lymonitehorsearmor.mixins;

import com.pekar.lymonitehorsearmor.events.fabric.FabricAnimalEventHooks;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin
{
    @Inject(method = "setRemoved", at = @At("HEAD"))
    private void lymonitehorsearmor$onRemoved(Entity.RemovalReason removalReason, CallbackInfo ci)
    {
        FabricAnimalEventHooks.onEntityLeaveLevel((Entity) (Object) this);
    }
}
