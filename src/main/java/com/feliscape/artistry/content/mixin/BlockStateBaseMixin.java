package com.feliscape.artistry.content.mixin;

import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.Tags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BlockStateBaseMixin {

    @Inject(method = "getOffset", at = @At("HEAD"), cancellable = true)
    public void centerFlowers(BlockGetter level, BlockPos pos, CallbackInfoReturnable<Vec3> cir){
        BlockState state = level.getBlockState(pos);
        if ((state.is(BlockTags.REPLACEABLE) || state.is(BlockTags.FLOWERS)) && level.getBlockState(pos.below()).is(ArtistryBlocks.FLOWER_VASE) ||
                (state.getBlock() instanceof DoublePlantBlock) && level.getBlockState(pos.below(2)).is(ArtistryBlocks.FLOWER_VASE)){
            cir.setReturnValue(Vec3.ZERO);
        }
    }
}
