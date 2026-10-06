package com.dev.axle;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {
    public static final ResourceKey<CreativeModeTab> AXLE_TAB_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB, Axle.id("axle_tab"));

    // displaying the creative mode tab
    public static final CreativeModeTab AXLE_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.TEST_BLOCK))
            .title(Component.translatable("creativeTab.axle"))
            .displayItems((params, output) -> {
                output.accept(ModBlocks.TEST_BLOCK);
            })
            .build();

    public static void init() {
        // registers the tab
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, AXLE_TAB_KEY, AXLE_TAB);
    }
}
