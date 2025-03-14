package reak.alliumcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import reak.alliumcraft.blocks.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ALLIUM_BLOCK)
                .add(ModBlocks.ALLIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ALLIUM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ALLIUM_BLOCK)
                .add(ModBlocks.ALLIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ALLIUM_ORE);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.ALLIUM_PETALS);

        getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
                .add(ModBlocks.ALLIUM_PETALS);

        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
                .add(ModBlocks.ALLIUM_PETALS)
                .add(ModBlocks.MUILLA);

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.ALLIUM_PETALS);

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.MUILLA);

        getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE)
                .add(ModBlocks.MUILLA);

    }
}
