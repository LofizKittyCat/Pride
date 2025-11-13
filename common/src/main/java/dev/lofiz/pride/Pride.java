package dev.lofiz.pride;

import dev.architectury.platform.Platform;
import dev.lofiz.pride.blocks.Blocks;
import dev.lofiz.pride.items.Items;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Pride {

    public static final String MOD_ID = "pride";
    public static final Logger logger = LoggerFactory.getLogger(MOD_ID);

    public static void init() {

        logger.info("Initializing Pride!");
        logger.info("Startup Info >>>");
        logger.info("   Minecraft Version: {}", Platform.getMinecraftVersion());

        Items.init();
        Blocks.init();
    }

    public static ResourceLocation toResourceLocation(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }
}
