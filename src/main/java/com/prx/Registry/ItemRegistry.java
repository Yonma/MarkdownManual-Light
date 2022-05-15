package com.prx.Registry;

import com.prx.PRX;
import com.prx.mdmanual.ManualHomeItem;
import com.prx.mdmanual.ManualItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;


public class ItemRegistry {
    private static final DeferredRegister<Item> ITEMS = RegistryUtils.create(ForgeRegistries.ITEMS);

    // --------------------------------------------------------------------- //

    public static final RegistryObject<Item> BOOK_MANUAL = register("manual", ManualItem::new);
    public static final RegistryObject<Item> Manual_home = register("manual_home", ManualHomeItem::new);

    // --------------------------------------------------------------------- //

    public static void initialize() {
    }

    public static <T extends Item> boolean is(final ItemStack stack, final RegistryObject<T> item) {
        return is(stack, item.get());
    }

    public static <T extends Item> boolean is(final ItemStack stack, final T item) {
        return !stack.isEmpty() && stack.getItem() == item;
    }

    // --------------------------------------------------------------------- //

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> factory) {
        return ITEMS.register(name, factory);
    }

}
