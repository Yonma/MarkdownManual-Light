package com.prx.mdmanual;

import com.prx.PRX;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class Textures {
    public static final ResourceLocation LOCATION_GUI_MANUAL_BACKGROUND = new ResourceLocation(PRX.MOD_ID, "textures/gui/manual.png");
    public static final ResourceLocation LOCATION_GUI_MANUAL_TAB = new ResourceLocation(PRX.MOD_ID, "textures/gui/manual_tab.png");
    public static final ResourceLocation LOCATION_GUI_MANUAL_SCROLL = new ResourceLocation(PRX.MOD_ID, "textures/gui/manual_scroll.png");

    private Textures() {
    }
}
