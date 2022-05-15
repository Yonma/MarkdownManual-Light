package com.prx.ModGroup;

import com.prx.Registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class PRXModdedGroup extends ItemGroup {
    public PRXModdedGroup() {
        super("manualwikimd_group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.BOOK_MANUAL.get());
    }
}
