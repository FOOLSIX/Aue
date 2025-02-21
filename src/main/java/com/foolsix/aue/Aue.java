package com.foolsix.aue;


import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

import static com.foolsix.aue.Config.CONFIG;

@Mod(Aue.MODID)
public class Aue {
    public static final String MODID = "aue";

    public Aue(ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, CONFIG, MODID + ".toml");
    }
}
