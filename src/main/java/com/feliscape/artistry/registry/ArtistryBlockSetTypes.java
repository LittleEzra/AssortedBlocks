package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import static net.minecraft.world.level.block.state.properties.BlockSetType.register;

public class ArtistryBlockSetTypes {
    public static final BlockSetType ASPEN = register(new BlockSetType(Artistry.stringLocation("aspen")));
    public static final BlockSetType ROTTEN = register(new BlockSetType(Artistry.stringLocation("rotten")));
}
