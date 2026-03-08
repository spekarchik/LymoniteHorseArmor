package com.pekar.lymonitehorsearmor.events.effect.base;

import com.pekar.lymonitehorsearmor.armor.ModArmor;
import com.pekar.lymonitehorsearmor.events.armor.IArmor;
import com.pekar.lymonitehorsearmor.events.mob.IMob;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.function.BiPredicate;

public class ArmorEffectSetup<E extends IArmorEffectWithOptions<M, A>, M extends IMob, A extends IArmor> implements IArmorEffectSetup<E, M, A>
{
    protected final E effect;

    public ArmorEffectSetup(E effect)
    {
        this.effect = effect;
    }

    @Override
    public IArmorEffectSetup<E, M, A> setupAvailability(BiPredicate<M, A> predicate)
    {
        effect.setupAvailability(predicate);
        return this;
    }

    @Override
    public IArmorEffectSetup<E, M, A> alwaysAvailable()
    {
        effect.setupAvailability((mob, armor) -> true);
        return this;
    }

    @Override
    public IArmorEffectSetup<E, M, A> unavailableIfNotModArmor(EquipmentSlot slot)
    {
        effect.setupAvailability((mob, armor) ->
        {
            var slotItemStack = mob.getEntity().getItemBySlot(slot);
            return !slotItemStack.isEmpty() && slotItemStack.getItem() instanceof ModArmor;
        });

        return this;
    }

    @Override
    public IArmorEffectSetup<E, M, A> showIcon()
    {
        effect.setShowIcon(true);
        return this;
    }

    @Override
    public IArmorEffectSetup<E, M, A> hideIcon()
    {
        effect.setShowIcon(false);
        return this;
    }
}
