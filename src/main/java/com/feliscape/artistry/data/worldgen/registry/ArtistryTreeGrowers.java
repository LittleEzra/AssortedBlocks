package com.feliscape.artistry.data.worldgen.registry;

import com.feliscape.artistry.Artistry;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ArtistryTreeGrowers {
    public static final TreeGrower PRISMA =
            new TreeGrower(Artistry.location("aspen").toString(),
                    Optional.empty(),
                    Optional.of(ArtistryTreeFeatures.ASPEN_TREE),
                    Optional.empty());
}
