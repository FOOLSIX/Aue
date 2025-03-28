package com.foolsix.aue;

import net.minecraftforge.common.ForgeConfigSpec;

public class AueConfig {

    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final AueConfig CONFIG;

    static {
        var pair = new ForgeConfigSpec.Builder().configure(AueConfig::new);
        CONFIG_SPEC = pair.getRight();
        CONFIG = pair.getLeft();
    }

    public final ForgeConfigSpec.BooleanValue IS_TREASURE;
    public final ForgeConfigSpec.BooleanValue IS_TRADABLE;
    public final ForgeConfigSpec.BooleanValue IS_ALLOWED_ON_BOOKS;
    public final ForgeConfigSpec.BooleanValue IS_DISCOVERABLE;
    public final ForgeConfigSpec.IntValue MIN_COST;

    public AueConfig(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER.push("Another Unbreakable Enchantment");
        IS_TRADABLE = BUILDER.define("IS_TRADABLE", true);
        IS_TREASURE = BUILDER.define("IS_TREASURE", true);
        IS_ALLOWED_ON_BOOKS = BUILDER.define("IS_ALLOWED_ON_BOOKS", true);
        IS_DISCOVERABLE = BUILDER.define("IS_DISCOVERABLE", true);
        MIN_COST = BUILDER.defineInRange("MIN_COST", 30, 0, Integer.MAX_VALUE);
        BUILDER.pop();
    }
}
