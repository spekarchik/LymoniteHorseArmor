package com.pekar.lymonitehorsearmor.events.effect.base;

import com.pekar.lymonitehorsearmor.events.armor.IArmor;
import com.pekar.lymonitehorsearmor.events.mob.IMob;

import java.util.function.BiPredicate;

public interface IArmorEffectWithOptions<M extends IMob, A extends IArmor> extends IArmorEffect
{
    boolean getShowIcon();
    void setShowIcon(boolean showIcon);
    void setupAvailability(BiPredicate<M, A> value);
}
