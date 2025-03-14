package reak.alliumcraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocksAllium {
    public static final Block ALLIUM_WIRE = register("allium_wire", new AlliumWireBlock(
            AbstractBlock.Settings
                    .create()
                    .noCollision()
                    .breakInstantly()
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, id, block);
    }
}
