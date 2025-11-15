package dev.lofiz.pride.blocks;

import com.google.common.collect.Lists;
import dev.lofiz.pride.Pride;
import dev.lofiz.pride.blocks.flag.StandingFlagBlock;
import dev.lofiz.pride.util.KeyUtil;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;

import java.util.Arrays;
import java.util.function.Function;

public class PrideBlocks {

    private static <T extends Block> T register(String id, Function<AbstractBlock.Settings, T> factory, AbstractBlock.Settings settings) {
        RegistryKey<Block> blockKey = KeyUtil.keyOfBlock(id);
        T block = factory.apply(settings.registryKey(blockKey));

        RegistryKey<Item> blockItemKey = KeyUtil.keyOfItem(id);
        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(blockItemKey).useBlockPrefixedTranslationKey());
        Registry.register(Registries.ITEM, blockItemKey, blockItem);

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static final Block TEST_BLOCK = register("test_block", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK));

    public static final Block DEFAULT_FLAG = register("default_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque());
    public static final Block PRIDE_FLAG = register("pride_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque());
    public static final Block BISEXUAL_FLAG = register("bisexual_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque());
    public static final Block TRANSGENDER_FLAG = register("transgender_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque());

    public static final Block[] FLAG_BLOCKS = {
            DEFAULT_FLAG,
            PRIDE_FLAG,
            BISEXUAL_FLAG,
            TRANSGENDER_FLAG
    };

    public static void init() {
        Pride.logger.info("Initializing Blocks!");
    }
}
