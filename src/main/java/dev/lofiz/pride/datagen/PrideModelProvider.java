package dev.lofiz.pride.datagen;

import dev.lofiz.pride.blocks.PrideBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class PrideModelProvider extends FabricModelProvider {

    public PrideModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for(Block block : PrideBlocks.FLAG_BLOCKS) {
            blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(block);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
