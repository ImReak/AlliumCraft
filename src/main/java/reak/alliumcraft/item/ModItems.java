package reak.alliumcraft.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import net.minecraft.util.Identifier;
import reak.alliumcraft.AlliumCraft;

public class ModItems {
   public static final Item ALLIUM_DUST= registerItems("allium_dust",new Item(new Item.Settings()));

    private static Item registerItems(String id, Item item){
        return Registry.register(Registries.ITEM,Identifier.of(AlliumCraft.MOD_ID,id),item);
    }
    public static void registerModItems(){
        AlliumCraft.LOGGER.info("Registering Items.");
    }
}
