package reak.alliumcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import reak.alliumcraft.blocks.ModBlocks;
import reak.alliumcraft.item.ModItemGroups;
import reak.alliumcraft.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.ALLIUM_DUST,"Allium Dust");

        translationBuilder.add(ModBlocks.DEEPSLATE_ALLIUM_ORE, "Deepslate Allium Ore");
        translationBuilder.add(ModBlocks.ALLIUM_ORE, "Allium Ore");
        translationBuilder.add(ModBlocks.ALLIUM_PETALS, "Allium Petals");

        translationBuilder.add(ModItemGroups.ALLIUMCRAFT_GROUP,"AlliumCraft");
    }
}