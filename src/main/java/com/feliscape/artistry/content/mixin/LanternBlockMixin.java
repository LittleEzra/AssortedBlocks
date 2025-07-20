package com.feliscape.artistry.content.mixin;

import com.feliscape.artistry.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LanternBlock.class)
public abstract class LanternBlockMixin extends Block implements SimpleWaterloggedBlock {
    public LanternBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
    protected void overrideSurvive(BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (Config.SURVIVABILITY_CHANGES.get() && level.getBlockState(pos.relative(getConnectedDirection(state).getOpposite())).is(BlockTags.LEAVES)){
            cir.setReturnValue(true);
        }
    }

    @Unique
    private static Direction getConnectedDirection(BlockState state) {
        return (Boolean)state.getValue(LanternBlock.HANGING) ? Direction.DOWN : Direction.UP;
    }
}
