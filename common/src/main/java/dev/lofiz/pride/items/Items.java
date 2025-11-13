package dev.lofiz.pride.items;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.lofiz.pride.Pride;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public final class Items {

    private static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Pride.MOD_ID, Registries.ITEM);

    public static RegistrySupplier<Item> register(String id, Supplier<Item> item) {
        return ITEMS.register(Pride.toResourceLocation(id), item);
    }

    public static Item.Properties baseProps(String name) {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Pride.toResourceLocation(name)));
    }

    public static void init() {
        Pride.logger.info("Initializing Items Class!");
        ITEMS.register();
    }
}
