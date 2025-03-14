package reak.alliumcraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reak.alliumcraft.blocks.ModBlocks;
import reak.alliumcraft.item.ModItemGroups;
import reak.alliumcraft.item.ModItems;

public class AlliumCraft implements ModInitializer {
	public static final String MOD_ID = "alliumcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();
		ModBlocks.registerModBlocks();
		LOGGER.info("Hello Allium World!");

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MUILLA, RenderLayer.getCutout());
	}
}