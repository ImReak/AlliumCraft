package reak.alliumcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import reak.alliumcraft.blocks.ModBlocks;
import reak.alliumcraft.item.ModItems;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
                blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ALLIUM_ORE);
                blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALLIUM_ORE);
                blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALLIUM_BLOCK);
                blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.MUILLA,ModBlocks.POTTED_MUILLA, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ALLIUM_DUST, Models.GENERATED);
    }
}
