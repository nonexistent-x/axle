package com.dev.axle;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    public static final Block TEST_BLOCK = register(
            "test_block",
            Block::new,
            BlockBehaviour.Properties.of().strength(2.0f)
    );
    private static Block register(String name,
                                  Function<BlockBehaviour.Properties, Block> factory,
                                  BlockBehaviour.Properties properties) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, Axle.id(name));
        Block block = factory.apply(properties.setId(blockKey));
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Axle.id(name));
        BlockItem blockItem = new BlockItem(block,
                new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    public static void init() {
        // does nothing, only here so java will load the class and run registration for the block
    }
}
