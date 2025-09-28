package com.feliscape.artistry.data.worldgen.tree.foliage;

import com.feliscape.artistry.data.worldgen.registry.ArtistryFoliagePlacers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class AspenFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<AspenFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance
            -> foliagePlacerParts(instance)
            .and(Codec.intRange(0, 16).fieldOf("height").forGetter(fp -> fp.height))
            .and(IntProvider.codec(4, 16).fieldOf("leavesHeight").forGetter(fp -> fp.leavesHeight))
            .apply(instance, AspenFoliagePlacer::new));


    private final int height;
    private final IntProvider leavesHeight;

    public AspenFoliagePlacer(IntProvider radius, IntProvider offset, int height, IntProvider leavesHeight) {
        super(radius, offset);
        this.height = height;
        this.leavesHeight = leavesHeight;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ArtistryFoliagePlacers.ASPEN_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config,
                                 int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos blockpos = attachment.pos().below(offset);
        int size = leavesHeight.sample(random);
        for (int i = 0; i < size; i++){
            if (i == size - 1){
                this.placeLeavesRow(level, blockSetter, random, config, blockpos, 0, size - 1, i, attachment.doubleTrunk());
            } else if (i == 0 || i >= size - 3){
                this.placeLeavesRow(level, blockSetter, random, config, blockpos, 1, size - 1, i, attachment.doubleTrunk());
            } else{
                this.placeLeavesRow(level, blockSetter, random, config, blockpos, 2, size - 1, i, attachment.doubleTrunk());
            }
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return this.height + random.nextInt(2);
    }

    protected void placeLeavesRow(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration treeConfiguration, BlockPos pos, int range, int foliageHeight, int localY, boolean large) {
        int i = large ? 1 : 0;
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for(int j = -range; j <= range + i; ++j) {
            for(int k = -range; k <= range + i; ++k) {
                if (!this.shouldSkipLocationSigned(random, j, localY, k, range, foliageHeight, large)) {
                    mutablePos.setWithOffset(pos, j, localY, k);
                    tryPlaceLeaf(level, foliageSetter, random, treeConfiguration, mutablePos);
                }
            }
        }
    }

    protected boolean shouldSkipLocationSigned(RandomSource random, int localX, int localY, int localZ, int range, int foliageHeight, boolean large) {
        int x;
        int z;
        if (large) {
            x = Math.min(Math.abs(localX), Math.abs(localX - 1));
            z = Math.min(Math.abs(localZ), Math.abs(localZ - 1));
        } else {
            x = Math.abs(localX);
            z = Math.abs(localZ);
        }

        return this.shouldSkipLocation(random, x, localY, z, range, foliageHeight, large);
    }

    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, int foliageHeight, boolean large) {
        int reversedY = foliageHeight - localY;
        if (range == 0) return false;

        boolean isCorner = localX != 0 && localZ != 0;
        boolean isEdge = localX == range || localZ == range;
        boolean isOuterCorner = Math.abs(localX) == range && Math.abs(localZ) == range;

        if (reversedY <= 1){ // block below top
            return isCorner;
        } else if (reversedY == 3){
            return isCorner && isEdge;
        } else if (reversedY == 4){
            return isOuterCorner;
        } else if (localY > 0 && Math.abs(localX) == range && Math.abs(localZ) == range){
            return range == 2 && random.nextInt(3) < 2;
        }
        return false;

        /*if (localX == range && localZ == range && reversedY % 2 != 0 && localY >= 2) return true;

        if (reversedY == 2){
            boolean isCorner = localX != 0 && localZ != 0;
            boolean isEdge = localX == range || localZ == range;
            return isCorner && isEdge;
        }
        else if (localX == range && localZ == range){
            if (reversedY <= 1) return true;
            else return range == 2 && random.nextInt(3) < 2;
        } else{
            return false;
        }*/
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        if (localY == 2){
            boolean isCorner = localX != 0 && localZ != 0;
            boolean isEdge = localX == range || localZ == range;
            return isCorner && isEdge;
        }
        else if (localX == range && localZ == range){
            if (localY == 0) return true;
            else return range == 2 && random.nextInt(3) < 2;
        } else{
            return false;
        }
    }
}
