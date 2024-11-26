package com.guavahater.guavapulp.block;

import com.guavahater.guavapulp.GuavaPulp;
import com.guavahater.guavapulp.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GuavaPulp.MOD_ID);
    //Glass bowl block addition to the registry!
    public static final DeferredBlock<TransparentBlock> GLASS_BOWL = registerBlock("glass_bowl", () -> new TransparentBlock(BlockBehaviour.Properties.of()
            .strength(0.3F)
            .sound(SoundType.GLASS)
            .noOcclusion()
            .isValidSpawn((state, level, pos, value) -> false)
            .isRedstoneConductor((state, level, pos) -> false)
            .isSuffocating((state, level, pos) -> false)
            .isViewBlocking((state, level, pos) -> false)));

    public static final DeferredBlock<RotatedPillarBlock> SANDALWOOD_LOG = registerBlock("sandalwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .sound(SoundType.WOOD)
            .ignitedByLava()
    ));

    private static <T extends  Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn =  BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return  toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register((eventBus));
    }
}
