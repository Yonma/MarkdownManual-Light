package com.prx.mdmanual;

import com.prx.PRX;
import li.cil.manual.api.ManualModel;
import li.cil.manual.api.prefab.provider.NamespacePathProvider;

import java.util.Objects;

public class ModPathProvider extends NamespacePathProvider {
    public ModPathProvider() {
        super(PRX.MOD_ID);
    }

    @Override
    public boolean matches(final ManualModel manual) {
        return Objects.equals(manual, ManualPRX.MANUAL.get());
    }

}
