package com.feliscape.artistry.content.block.plant;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SunburstVinesPlantBlock extends GrowingPlantBodyBlock {
    public static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    public static final MapCodec<SunburstVinesPlantBlock> CODEC = simpleCodec(SunburstVinesPlantBlock::new);

    public SunburstVinesPlantBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);
    }

    @Override
    protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
        return CODEC;
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return ArtistryBlocks.SUNBURST_VINES.get();
    }
}
