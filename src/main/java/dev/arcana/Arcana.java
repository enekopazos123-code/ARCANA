package dev.arcana;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Arcana.MOD_ID)
public final class Arcana {

    public static final String MOD_ID = "arcana";

    public Arcana() {
        ModItems.ITEMS.register(
            FMLJavaModLoadingContext.get().getModEventBus()
        );
    }
}
