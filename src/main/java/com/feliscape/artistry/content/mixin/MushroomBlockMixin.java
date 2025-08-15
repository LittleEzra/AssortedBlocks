package com.feliscape.artistry.content.mixin;

import com.feliscape.artistry.ServerConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MushroomBlock.class)
public abstract class MushroomBlockMixin extends BushBlock implements BonemealableBlock {
    protected MushroomBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "canSurvive", at = @At("RETURN"), cancellable = true)
    protected void overrideCanSurvive(BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (ServerConfig.SURVIVABILITY_CHANGES.get()){
            if (level.getBlockState(pos.below()).is(BlockTags.LOGS)) cir.setReturnValue(true);
            else {
                BlockPos below = pos.below();
                if (level.getRawBrightness(pos, 0) >= 13 && level.getBlockState(below).isSolidRender(level, below)){
                    for (Direction d : Direction.values()){
                        var blockState = level.getBlockState(pos.relative(d));
                        if (blockState.is(BlockTags.LOGS)){
                            cir.setReturnValue(true);
                            break;
                        }
                    }
                }
            }
        }
    }
}
