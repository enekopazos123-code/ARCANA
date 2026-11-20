package dev.arcana;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Arcana.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ARCANA_TAB =
            TABS.register("arcana", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.arcana"))
                    .icon(() -> new ItemStack(ModItems.ARCANE_CORE.get()))
                    .displayItems((parameters, output) -> output.accept(ModItems.ARCANE_CORE.get()))
                    .build());

    private ModCreativeTabs() {
    }
}
