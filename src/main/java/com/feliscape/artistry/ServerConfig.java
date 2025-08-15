package com.feliscape.artistry;

import net.neoforged.neoforge.common.ModConfigSpec;

//@EventBusSubscriber(modid = Artistry.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ServerConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue SURVIVABILITY_CHANGES;
    public static final ModConfigSpec.IntValue SNIFFER_CAKE_MOTIVATION;

    static final ModConfigSpec SPEC;

    static {
        BUILDER.push("tweaks");

        SNIFFER_CAKE_MOTIVATION = BUILDER
                .comment("How many times a Sniffer can dig in a row after eating Sniffer Cake")
                .translation("artistry.config.server.sniffer_cake_motivation")
                .defineInRange("sniffer_cake_motivation", 3, 1, 10);
        SURVIVABILITY_CHANGES = BUILDER
                .comment("Toggles some changes to how blocks can be placed, such as Lanterns being placed on the underside of leaves.")
                .translation("artistry.config.server.survivability_changes")
                .define("survivability_changes", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
