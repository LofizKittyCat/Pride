package dev.lofiz.pride.blocks;

import dev.lofiz.pride.Pride;
import dev.lofiz.pride.util.KeyUtil;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public class PrideBlocks {

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        RegistryKey<Block> blockKey = KeyUtil.keyOfBlock(id);
        Block block = factory.apply(settings.registryKey(blockKey));

        RegistryKey<Item> blockItemKey = KeyUtil.keyOfItem(id);
        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(blockItemKey).useBlockPrefixedTranslationKey());
        Registry.register(Registries.ITEM, blockItemKey, blockItem);

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static final Block TEST_BLOCK = register("test_block", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK));

    public static void init() {
        Pride.logger.info("Initializing Blocks!");
    }
}
