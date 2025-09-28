package com.feliscape.artistry.data.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugeGlowingMushroomFeature extends AbstractHugeMushroomFeature {
    public HugeGlowingMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected int getTreeRadiusForHeight(int p_65977_, int height, int foliageRadius, int y) {
        int i = 0;
        if (y < height && y >= height - 2) {
            i = foliageRadius;
        } else if (y == height) {
            i = foliageRadius;
        }

        return i;
    }

    @Override
    protected void makeCap(LevelAccessor levelAccessor, RandomSource randomSource, BlockPos blockPos, int height, BlockPos.MutableBlockPos mutableBlockPos, HugeMushroomFeatureConfiguration config) {
        for(int y = height - 2; y <= height; ++y) {
            int j = y < height ? config.foliageRadius : config.foliageRadius - 1;
            int k = config.foliageRadius - 2;

            for(int x = -j; x <= j; ++x) {
                for(int z = -j; z <= j; ++z) {
                    boolean onWestEdge  = x == -j;
                    boolean onEastEdge = x == j;
                    boolean onNorthEdge = z == -j;
                    boolean onSouthEdge = z == j;
                    boolean xEdge = onWestEdge || onEastEdge;
                    boolean zEdge = onNorthEdge || onSouthEdge;
                    if (y >= height || xEdge != zEdge) { // xEdge XOR zEdge means that it selects for the edges minus the corners
                        mutableBlockPos.setWithOffset(blockPos, x, y, z);
                        if (!levelAccessor.getBlockState(mutableBlockPos).isSolidRender(levelAccessor, mutableBlockPos)) {
                            BlockState blockstate = config.capProvider.getState(randomSource, blockPos);
                            if (blockstate.hasProperty(HugeMushroomBlock.WEST) && blockstate.hasProperty(HugeMushroomBlock.EAST) && blockstate.hasProperty(HugeMushroomBlock.NORTH) && blockstate.hasProperty(HugeMushroomBlock.SOUTH) && blockstate.hasProperty(HugeMushroomBlock.UP)) {
                                blockstate = blockstate
                                        .setValue(HugeMushroomBlock.UP, y >= height - 1)
                                        .setValue(HugeMushroomBlock.WEST, x < -k)
                                        .setValue(HugeMushroomBlock.EAST, x > k)
                                        .setValue(HugeMushroomBlock.NORTH, z < -k)
                                        .setValue(HugeMushroomBlock.SOUTH, z > k);
                            }

                            this.setBlock(levelAccessor, mutableBlockPos, blockstate);
                        }
                    }
                }
            }
        }
    }
}
