package com.pekar.lymonitehorsearmor.menus;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

import static com.pekar.lymonitehorsearmor.Main.MODID;
import static com.pekar.lymonitehorsearmor.utils.Resources.createResourceLocation;

public class MenuRegistry
{
    public static final MenuType<CustomSmithingMenu> CUSTOM_SMITHING_MENU =
            register("custom_smithing", new MenuType<>(CustomSmithingMenu::new, FeatureFlags.DEFAULT_FLAGS));

    public static void initStatic()
    {
        // just to initialize static members
    }

    private static <T extends MenuType<?>> T register(String name, T menuType)
    {
        var id = createResourceLocation(MODID, name);
        var key = ResourceKey.create(Registries.MENU, id);
        return Registry.register(BuiltInRegistries.MENU, key, menuType);
    }
}
