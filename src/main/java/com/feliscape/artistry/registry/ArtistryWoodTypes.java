package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ArtistryWoodTypes {
    public static final WoodType ASPEN = WoodType.register(new WoodType(Artistry.stringLocation("aspen"), ArtistryBlockSetTypes.ASPEN));
}
