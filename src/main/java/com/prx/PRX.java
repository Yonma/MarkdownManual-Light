package com.prx;

import com.prx.Registry.ItemRegistry;
import com.prx.Registry.RegistryUtils;
import com.prx.mdmanual.ManualPRX;
import li.cil.manual.api.render.FontRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PRX.MOD_ID)
public class PRX {

    public static final String MOD_ID = "manualwikimd";

    @OnlyIn(Dist.CLIENT) public static FontRenderer normalFontRenderer;
    @OnlyIn(Dist.CLIENT) public static FontRenderer smallFontRenderer;

    public PRX() {
        // Item, Block...
        RegistryUtils.begin();
        ItemRegistry.initialize();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ManualPRX::initialize);
        RegistryUtils.finish();

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().register(ClientSetup.class));
    }


}

