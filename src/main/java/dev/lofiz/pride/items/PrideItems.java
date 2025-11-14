package dev.lofiz.pride.items;

import dev.lofiz.pride.Pride;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

public class PrideItems {

    private static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Pride.toIdentifier(id));

        Item item = factory.apply(settings.registryKey(key));

        Registry.register(Registries.ITEM, key, item);

        return item;
    }

    public static void init() {
        Pride.logger.info("Initializing Items");
    }
}
