package dev.lofiz.pride.blocks;

import com.google.common.collect.Maps;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.lofiz.pride.Pride;
import dev.lofiz.pride.blocks.flag.StandingFlagBlock;
import dev.lofiz.pride.blocks.util.BlockItemData;
import dev.lofiz.pride.items.Items;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class Blocks {

    private static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Pride.MOD_ID, Registries.BLOCK);

    private static final DeferredRegister<Item> BLOCK_ITEMS =
            DeferredRegister.create(Pride.MOD_ID, Registries.ITEM);

    public static RegistrySupplier<Block> DEFAULT_FLAG;
    public static RegistrySupplier<Item> DEFAULT_FLAG_ITEM;

    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> supplier) {
        return BLOCKS.register(Pride.toResourceLocation(id), supplier);
    }

    private static RegistrySupplier<Item> registerItem(String id, Supplier<Item> supplier) {
        return BLOCK_ITEMS.register(Pride.toResourceLocation(id), supplier);
    }

    private static BlockBehaviour.Properties baseProps(String name) {
        return BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Pride.toResourceLocation(name)));
    }

    public static void init() {
        Pride.logger.info("Initializing Blocks Class!");

        DEFAULT_FLAG = register("default_flag", () -> new StandingFlagBlock(baseProps("default_flag").sound(SoundType.WOOL).strength(0.2f).noOcclusion()));
        DEFAULT_FLAG_ITEM = registerItem("default_flag", () -> new BlockItem(DEFAULT_FLAG.get(), Items.baseProps("default_flag")));

        BLOCKS.register();
        BLOCK_ITEMS.register();
    }
}
