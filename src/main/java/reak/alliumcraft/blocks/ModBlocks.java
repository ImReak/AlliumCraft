package reak.alliumcraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import reak.alliumcraft.AlliumCraft;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

public class ModBlocks {

    public static final Block ALLIUM_BLOCK = register("allium_block",new Block(
            AbstractBlock.Settings.create()
                    .strength(5.0F,6.0F)
                    .requiresTool()));
    public static final Block ALLIUM_ORE = register("allium_ore",new AlliumOreBlock(
            AbstractBlock.Settings.create()
                    .strength(3.0F,3.0F).luminance(createLightLevelFromLitBlockState(9))
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .mapColor(MapColor.STONE_GRAY)
                    .requiresTool()));
    public static final Block DEEPSLATE_ALLIUM_ORE = register("deepslate_allium_ore",new AlliumOreBlock(
            AbstractBlock.Settings.create()
                    .strength(4.5F,3.0F)
                    .luminance(createLightLevelFromLitBlockState(9))
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .requiresTool()));
    public static final Block ALLIUM_PETALS = register("allium_petals",new FlowerbedBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .sounds(BlockSoundGroup.PINK_PETALS)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MUILLA =register("muilla",new FlowerBlock(
            StatusEffects.FIRE_RESISTANCE,
            4.0F,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)
    ));

    public static void registerBlockItems(String id,Block block){
        Item item = Registry.register(Registries.ITEM,Identifier.of(AlliumCraft.MOD_ID,id),new BlockItem(block,new Item.Settings()));
        if (item instanceof BlockItem){
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS,item);
        }
    }
    public static Block register(String id,Block block){
        registerBlockItems(id,block);
        return Registry.register(Registries.BLOCK,Identifier.of(AlliumCraft.MOD_ID,id),block);
    }
    public static void registerModBlocks(){
        AlliumCraft.LOGGER.info("Registering Blocks.");
    }
}
