package com.guavahater.guavapulp.item;

import com.guavahater.guavapulp.GuavaPulp;
import com.guavahater.guavapulp.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GuavaPulp.MOD_ID);
    //ITEMS
    public static final Supplier<CreativeModeTab> GUAVAPULP_ITEMS_TAB = CREATIVE_MODE_TAB.register("guavapulp_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.SMALL_LEAF.get()))
            .title(Component.translatable("creativetab.guavapulp.guavapulp_items"))
            .displayItems((itemDisplayparameters, output) -> {
                output.accept(ModItems.SMALL_LEAF);
            }).build());

    //BLOCKS
    public static final Supplier<CreativeModeTab> GUAVAPULP_BLOCKS_TAB = CREATIVE_MODE_TAB.register("guavapulp_blocks_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.GLASS_BOWL))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GuavaPulp.MOD_ID, "guavapulp_items_tab"))
            .title(Component.translatable("creativetab.guavapulp.guavapulp_blocks"))
            .displayItems((itemDisplayparameters, output) -> {
                output.accept(ModBlocks.GLASS_BOWL);
                output.accept(ModBlocks.SANDALWOOD_LOG);
                output.accept(ModBlocks.INCENSE);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}


