package com.feliscape.artistry;

import net.neoforged.neoforge.common.ModConfigSpec;

//@EventBusSubscriber(modid = Artistry.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue SURVIVABILITY_CHANGES;

    static final ModConfigSpec SPEC;

    static {
        BUILDER.push("tweaks");

        SURVIVABILITY_CHANGES = BUILDER
                .comment("Toggles some changes to how blocks can be placed, such as Lanterns being placed on the underside of leaves.")
                .translation("artistry.config.common.survivability_changes")
                .define("survivability_changes", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
