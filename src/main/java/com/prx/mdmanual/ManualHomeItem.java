package com.prx.mdmanual;

import com.prx.ModGroup.ModGroup;
import net.minecraft.item.Item;

public class ManualHomeItem extends Item {
    public ManualHomeItem() {
        super(new Properties().tab(ModGroup.manualWiki));
    }
}
