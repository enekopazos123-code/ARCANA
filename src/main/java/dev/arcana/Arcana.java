package dev.arcana;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Arcana.MOD_ID)
public final class Arcana {
    public static final String MOD_ID = "arcana";

    public Arcana(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);
    }
}
