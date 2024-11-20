package com.guavahater.guavapulp.item;

import com.guavahater.guavapulp.GuavaPulp;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GuavaPulp.MOD_ID);

    //Item registry for the incense item.
    public static final DeferredItem<Item> INCENSE = ITEMS.register
            ("incense", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SMALL_LEAF = ITEMS.register
            ("small_leaf", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}

