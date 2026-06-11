package com.pekar.lymonitehorsearmor.mixins;

import com.pekar.lymonitehorsearmor.events.fabric.FabricAnimalEventHooks;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractHorse.class)
public abstract class AbstractHorseMixin
{
    @Unique
    private ItemStack lymonitehorsearmor$bodyArmorBeforeEquip = ItemStack.EMPTY;

    @Inject(method = "tameWithName", at = @At("TAIL"))
    private void lymonitehorsearmor$onTameWithName(Player player, CallbackInfoReturnable<Boolean> cir)
    {
        if (cir.getReturnValue())
        {
            FabricAnimalEventHooks.onAnimalTamed((Animal) (Object) this);
        }
    }

    @Inject(method = "equipBodyArmor", at = @At("HEAD"))
    private void lymonitehorsearmor$beforeEquipBodyArmor(Player player, ItemStack stack, CallbackInfo ci)
    {
        lymonitehorsearmor$bodyArmorBeforeEquip = ((Animal) (Object) this).getBodyArmorItem().copy();
    }

    @Inject(method = "equipBodyArmor", at = @At("TAIL"))
    private void lymonitehorsearmor$afterEquipBodyArmor(Player player, ItemStack stack, CallbackInfo ci)
    {
        var horse = (Animal) (Object) this;
        FabricAnimalEventHooks.onEquipmentChange((LivingEntity) (Object) this, EquipmentSlot.BODY, lymonitehorsearmor$bodyArmorBeforeEquip, horse.getBodyArmorItem());
        lymonitehorsearmor$bodyArmorBeforeEquip = ItemStack.EMPTY;
    }
}
