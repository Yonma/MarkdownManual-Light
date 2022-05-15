package com.prx.mdmanual;

import com.prx.PRX;
import com.prx.Registry.ItemRegistry;
import com.prx.Registry.RegistryUtils;
import li.cil.manual.api.ManualModel;
import li.cil.manual.api.Tab;
import li.cil.manual.api.prefab.Manual;
import li.cil.manual.api.prefab.provider.NamespaceDocumentProvider;
import li.cil.manual.api.prefab.tab.ItemStackTab;
import li.cil.manual.api.prefab.tab.TextureTab;
import li.cil.manual.api.provider.DocumentProvider;
import li.cil.manual.api.provider.PathProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;
import java.util.Objects;

@OnlyIn(Dist.CLIENT)
public final class ManualPRX {
    private static final DeferredRegister<ManualModel> ManualPRB = RegistryUtils.create(ManualModel.class);

    public static final RegistryObject<ManualModel> MANUAL = ManualPRB.register("manual", Manual::new);


    public static void initialize() {

        final DeferredRegister<PathProvider> pathProviders = RegistryUtils.create(PathProvider.class);
        final DeferredRegister<DocumentProvider> documentProviders = RegistryUtils.create(DocumentProvider.class);
        final DeferredRegister<Tab> tabs = RegistryUtils.create(Tab.class);

        pathProviders.register("path_provider", ModPathProvider::new);
        documentProviders.register("content_provider", () -> new NamespaceDocumentProvider(PRX.MOD_ID, "doc"));

        // reg tabs
        tabs.register("home", () -> new ItemStackTab(
                ManualModel.LANGUAGE_KEY + "/index.md",
                new TranslationTextComponent("manualwikimd.manual.home"),
                new ItemStack(ItemRegistry.Manual_home.get())));

        ManualUpdateUtils filenameUtil = new ManualUpdateUtils();
        List<String> folderNames = filenameUtil.getlocalFiles();

        if (folderNames != null) {
            for (String folderName : folderNames) {
                if (!Objects.equals(folderName, "index.md")) {
                    tabs.register(folderName, () -> new TextureTab(
                            ManualModel.LANGUAGE_KEY + "/" + folderName + "/index.md",
                            new TranslationTextComponent("manualwikimd.manual." + folderName),
                            new ResourceLocation(PRX.MOD_ID, "textures/gui/tab_" + folderName + ".png")));
                }
            }
        }
    }
}
