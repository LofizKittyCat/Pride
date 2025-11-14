package dev.lofiz.pride.groups;

import dev.lofiz.pride.Pride;
import dev.lofiz.pride.blocks.PrideBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;

public class PrideItemGroups {

    public static final RegistryKey<ItemGroup> PRIDE_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Pride.toIdentifier("item_group"));

    public static final ItemGroup PRIDE_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.DIRT))
            .displayName(Text.translatable("itemGroup.pride"))
            .build();

    public static void init() {
        Pride.logger.info("Initializing Item Groups!");

        ItemGroupEvents.modifyEntriesEvent(PrideItemGroups.PRIDE_GROUP_KEY).register((group) -> {
            group.add(PrideBlocks.TEST_BLOCK.asItem());
        });
    }
}
