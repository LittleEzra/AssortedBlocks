package com.feliscape.artistry.content.block.entity;

import com.feliscape.artistry.registry.ArtistryBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CrystalBallBlockEntity extends BlockEntity {
    private int pulse;

    public CrystalBallBlockEntity(BlockPos pos, BlockState blockState) {
        super(ArtistryBlockEntityTypes.CRYSTAL_BALL.get(), pos, blockState);
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, CrystalBallBlockEntity crystalBall){
        crystalBall.pulse++;
    }

    public int getPulse(){
        return pulse;
    }
}
