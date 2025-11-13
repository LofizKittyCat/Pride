package dev.lofiz.pride.neoforge;

import dev.lofiz.pride.Pride;
import net.neoforged.fml.common.Mod;

@Mod(Pride.MOD_ID)
public final class PrideNeoForge {
    public PrideNeoForge() {
        // Run our common setup.
        Pride.init();
    }
}
