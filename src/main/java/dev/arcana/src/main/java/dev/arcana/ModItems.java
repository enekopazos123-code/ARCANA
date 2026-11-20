package dev.arcana;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Arcana.MOD_ID);

    public static final DeferredItem<Item> ARCANE_CORE =
            ITEMS.register("arcane_core",
                    () -> new Item(new Item.Properties()));

    private ModItems() {
    }
}
