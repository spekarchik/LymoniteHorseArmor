package com.pekar.lymonitehorsearmor.mixins;

import com.pekar.lymonitehorsearmor.events.fabric.FabricAnimalEventHooks;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TamableAnimal.class)
public abstract class TamableAnimalMixin
{
    @Inject(method = "tame", at = @At("TAIL"))
    private void lymonitehorsearmor$onTame(Player player, CallbackInfo ci)
    {
        FabricAnimalEventHooks.onAnimalTamed((Animal) (Object) this);
    }
}
