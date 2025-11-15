package dev.lofiz.pride.groups;

import dev.lofiz.pride.Pride;
import dev.lofiz.pride.blocks.PrideBlocks;

import dev.lofiz.pride.items.PrideItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class PrideItemGroups {

   public static final ItemGroup PRIDE_GROUP = Registry.register(Registries.ITEM_GROUP, Pride.toIdentifier("pride"),
           FabricItemGroup.builder()
                   .icon(() -> new ItemStack(PrideBlocks.PRIDE_FLAG))
                   .displayName(Text.translatable("itemGroup.pride"))
                   .entries((context, entries) -> {
                       for(Block block : PrideBlocks.FLAG_BLOCKS) {
                           entries.add(new ItemStack(block));
                       }
                       entries.add(new ItemStack(PrideItems.FLAG_POLE));
                   }).build()
   );

    public static void init() {
        Pride.logger.info("Initializing Item Groups!");
    }
}
