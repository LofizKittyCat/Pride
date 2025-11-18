package dev.lofiz.pride.blocks;

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

import java.util.function.Function;

public class PrideBlocks {

    private static <T extends Block> T register(String id, Function<AbstractBlock.Settings, T> factory, AbstractBlock.Settings settings, Item.Settings itemSettings) {
        RegistryKey<Block> blockKey = KeyUtil.keyOfBlock(id);
        T block = factory.apply(settings.registryKey(blockKey));

        RegistryKey<Item> blockItemKey = KeyUtil.keyOfItem(id);
        BlockItem blockItem = new BlockItem(block, itemSettings.registryKey(blockItemKey).useBlockPrefixedTranslationKey());
        Registry.register(Registries.ITEM, blockItemKey, blockItem);

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static <T extends Block> T register(String id, Function<AbstractBlock.Settings, T> factory, AbstractBlock.Settings settings) {
        return register(id, factory, settings, new Item.Settings());
    }

    public static final Block PRIDE_FLAG = register("pride_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque().noCollision());
    public static final Block PROGRESS_PRIDE_FLAG = register("progress_pride_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque().noCollision());

    public static final Block LESBIAN_FLAG = register("lesbian_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque().noCollision());
    public static final Block GAY_FLAG = register("gay_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque().noCollision());
    public static final Block BISEXUAL_FLAG = register("bisexual_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque().noCollision());
    public static final Block TRANSGENDER_FLAG = register("transgender_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque().noCollision());
    public static final Block QUEER_FLAG = register("queer_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque().noCollision());
    public static final Block INTERSEX_FLAG = register("intersex_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque().noCollision());
    public static final Block ASEXUAL_FLAG = register("asexual_flag", StandingFlagBlock::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.2f).nonOpaque().noCollision());

    public static final Block[] FLAG_BLOCKS = {

            PRIDE_FLAG,
            PROGRESS_PRIDE_FLAG,

            LESBIAN_FLAG,
            GAY_FLAG,
            BISEXUAL_FLAG,
            TRANSGENDER_FLAG,
            QUEER_FLAG,
            INTERSEX_FLAG,
            ASEXUAL_FLAG
    };

    public static void init() {
        Pride.logger.info("Initializing Blocks!");
    }
}
