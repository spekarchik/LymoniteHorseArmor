package com.pekar.lymonitehorsearmor;

import com.mojang.logging.LogUtils;
import com.pekar.lymonitehorsearmor.armor.ArmorRegistry;
import com.pekar.lymonitehorsearmor.events.EventRegistry;
import com.pekar.lymonitehorsearmor.items.ItemRegistry;
import com.pekar.lymonitehorsearmor.menus.MenuRegistry;
import com.pekar.lymonitehorsearmor.tab.MainTab;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class Main implements ModInitializer
{
    public static final String MODID = "lymonitehorsearmor";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize()
    {
        initializeRegistry();

        new MainTab().createTab();

        EventRegistry.registerEvents();
    }

    private void initializeRegistry()
    {
        ItemRegistry.initStatic();
        ArmorRegistry.initStatic();
        MenuRegistry.initStatic();
    }
}
