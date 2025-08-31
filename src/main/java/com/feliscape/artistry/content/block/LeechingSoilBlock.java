package com.feliscape.artistry.content.block;

import com.feliscape.artistry.data.map.Leechable;
import com.feliscape.artistry.networking.ArtistryLevelEventPayload;
import com.feliscape.artistry.networking.ArtistryLevelEvents;
import com.feliscape.artistry.registry.ArtistryDataMapTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class LeechingSoilBlock extends Block {
    public LeechingSoilBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        float f = 0.11377778f;
        if (random.nextFloat() < 0.11377778f) {
            BlockPos above = pos.above();
            BlockState aboveBlockState = level.getBlockState(above);

            Leechable leechable = aboveBlockState.getBlockHolder().getData(ArtistryDataMapTypes.LEECHABLES);
            if (leechable == null) return;

            BlockState newState = leechable.block().withPropertiesOf(aboveBlockState);
            level.setBlock(above, newState, Block.UPDATE_ALL);
            ArtistryLevelEventPayload.send(ArtistryLevelEvents.LEECHING_SOIL_LEECH, above);
        }
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }
}
