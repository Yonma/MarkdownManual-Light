package com.prx;

import com.prx.mdmanual.NormalFontRenderer;
import com.prx.mdmanual.SmallFontRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Takes care of client-side only setup.
 */
@OnlyIn(Dist.CLIENT)
public final class ClientSetup {
    @SubscribeEvent
    public static void handleSetupEvent(final FMLClientSetupEvent event) {
        PRX.normalFontRenderer = NormalFontRenderer.INSTANCE;
        PRX.smallFontRenderer = SmallFontRenderer.INSTANCE;
    }
}
