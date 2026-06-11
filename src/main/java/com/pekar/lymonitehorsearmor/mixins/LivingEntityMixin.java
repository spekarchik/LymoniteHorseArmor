package com.pekar.lymonitehorsearmor.mixins;

import com.pekar.lymonitehorsearmor.events.fabric.FabricAnimalEventHooks;
import com.pekar.lymonitehorsearmor.events.fabric.FabricDamageEventHooks;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin
{
    @Inject(method = "onEquipItem", at = @At("TAIL"))
    private void lymonitehorsearmor$onEquipItem(EquipmentSlot slot, ItemStack oldItem, ItemStack newItem, CallbackInfo ci)
    {
        FabricAnimalEventHooks.onEquipmentChange((LivingEntity) (Object) this, slot, oldItem, newItem);
    }

    @ModifyVariable(method = "actuallyHurt", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private float lymonitehorsearmor$modifyDamage(float amount, DamageSource source)
    {
        return FabricDamageEventHooks.modifyDamage((LivingEntity) (Object) this, source, amount);
    }
}
