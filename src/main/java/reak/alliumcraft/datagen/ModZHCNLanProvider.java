package reak.alliumcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import reak.alliumcraft.blocks.ModBlocks;
import reak.alliumcraft.item.ModItemGroups;
import reak.alliumcraft.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModZHCNLanProvider extends FabricLanguageProvider {
    public ModZHCNLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.ALLIUM_DUST,"绒球葱粉");

        translationBuilder.add(ModBlocks.DEEPSLATE_ALLIUM_ORE, "深层绒球葱矿石");
        translationBuilder.add(ModBlocks.ALLIUM_ORE, "绒球葱矿石");
        translationBuilder.add(ModBlocks.ALLIUM_PETALS, "绒球葱花簇");
        translationBuilder.add(ModBlocks.ALLIUM_BLOCK,"绒球葱块");

        translationBuilder.add(ModItemGroups.ALLIUMCRAFT_GROUP,"绒球葱工艺");
    }
}