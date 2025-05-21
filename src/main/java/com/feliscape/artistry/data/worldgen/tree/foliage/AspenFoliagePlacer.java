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
    public static final MapCodec<AspenFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(aspenFoliagePlacerInstance
            -> foliagePlacerParts(aspenFoliagePlacerInstance)
            .and(Codec.intRange(0, 16).fieldOf("height").forGetter(fp -> fp.height))
            .and(IntProvider.codec(4, 16).fieldOf("leavesHeight").forGetter(fp -> fp.leavesHeight))
            .apply(aspenFoliagePlacerInstance, AspenFoliagePlacer::new));

    private final int height;
    private final IntProvider leavesHeight;

    public AspenFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height, IntProvider leavesHeight) {
        super(pRadius, pOffset);
        this.height = height;
        this.leavesHeight = leavesHeight;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ArtistryFoliagePlacers.ASPEN_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,
                                 int pMaxFreeTreeHeight,FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {

        BlockPos blockpos = pAttachment.pos().below(pOffset);
        int size = leavesHeight.sample(pRandom);
        for (int i = 0; i < size; i++){
            if (i < 2 || i == size - 1){
                this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 1, i, false);
            } else{
                this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 2, i, false);
            }
        }
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height + pRandom.nextInt(2);
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        if (pLocalY == 2){
            boolean isCorner = pLocalX != 0 && pLocalZ != 0;
            boolean isEdge = pLocalX == pRange || pLocalZ == pRange;
            return isCorner && isEdge;
        }
        else if (pLocalX == pRange && pLocalZ == pRange){
            if (pLocalY == 0) return true;
            else return pRange == 2 && pRandom.nextInt(3) < 2;
        } else{
            return false;
        }
    }
}
