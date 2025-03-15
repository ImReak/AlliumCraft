package reak.alliumcraft.world;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import reak.alliumcraft.AlliumCraft;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> MUILLA_FLOWER = of("mulla_flower");

    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(AlliumCraft.MOD_ID,id));

    }
}
