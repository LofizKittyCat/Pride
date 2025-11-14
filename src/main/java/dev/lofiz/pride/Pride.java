package dev.lofiz.pride;

import dev.lofiz.pride.blocks.PrideBlocks;
import dev.lofiz.pride.groups.PrideItemGroups;
import dev.lofiz.pride.items.PrideItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pride implements ModInitializer {

	public static final String MOD_ID = "pride";
	public static final Logger logger = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        logger.info("Initializing Mod Pride!");

        PrideBlocks.init();
        PrideItems.init();
        PrideItemGroups.init();
	}

    public static Identifier toIdentifier(String path) {
        return Identifier.of(MOD_ID, path);
    }
}