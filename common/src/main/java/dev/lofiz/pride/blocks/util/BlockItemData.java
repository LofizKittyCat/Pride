package dev.lofiz.pride.blocks.util;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;

public class BlockItemData {

    private final String id;
    private final RegistrySupplier<Item> item;

    public BlockItemData(String id, RegistrySupplier<Item> item) {
        this.id = id;
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public RegistrySupplier<Item> getItem() {
        return item;
    }
}
