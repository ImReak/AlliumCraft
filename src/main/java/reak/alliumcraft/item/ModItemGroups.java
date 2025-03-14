package reak.alliumcraft.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import reak.alliumcraft.AlliumCraft;
import reak.alliumcraft.blocks.ModBlocks;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> ALLIUMCRAFT_GROUP = register("alliumcraft_group");
    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP,Identifier.of(AlliumCraft.MOD_ID,id));
    }
    public static void registerModItemGroups() {
        Registry.register(Registries.ITEM_GROUP, ALLIUMCRAFT_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                                .displayName(Text.translatable("itemGroup.alliumcraft_group"))
                                        .icon(() -> new ItemStack(ModBlocks.MUILLA))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.MUILLA);
                            entries.add(ModBlocks.ALLIUM_BLOCK);
                            entries.add(ModBlocks.ALLIUM_ORE);
                            entries.add(ModBlocks.DEEPSLATE_ALLIUM_ORE);
                            entries.add(ModBlocks.ALLIUM_PETALS);
                        }).build());
        AlliumCraft.LOGGER.info("Registering Item Groups");
    }}
