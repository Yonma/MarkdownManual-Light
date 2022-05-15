package com.prx.mdmanual;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ManualUpdateUtils {

    public List<String> getlocalFiles() {
        List<String> results = new ArrayList<>();

        // below codes run successfully in runtime and jar ev.
        String resource_path = "/assets/manualwikimd/doc/tabs.txt";
        InputStream loader = this.getClass().getResourceAsStream(resource_path);

        if (loader == null) {
            throw new IllegalArgumentException(resource_path + " is not found");
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(loader));
            br.lines().forEach(results::add);
        }

        return results;
    }
}
