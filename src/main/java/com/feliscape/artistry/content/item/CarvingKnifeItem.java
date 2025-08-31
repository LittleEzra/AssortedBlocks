package com.feliscape.artistry.content.item;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;

public class CarvingKnifeItem extends SwordItem {
    private final List<Block> CARVED_PUMPKINS = List.of(
            Blocks.CARVED_PUMPKIN,
            ArtistryBlocks.WICKED_CARVED_PUMPKIN.get(),
            ArtistryBlocks.HUNGRY_CARVED_PUMPKIN.get(),
            ArtistryBlocks.HAPPY_CARVED_PUMPKIN.get(),
            ArtistryBlocks.STALWART_CARVED_PUMPKIN.get(),
            ArtistryBlocks.PEEKING_CARVED_PUMPKIN.get(),
            ArtistryBlocks.BELLOWING_CARVED_PUMPKIN.get()
    );

    public CarvingKnifeItem(Properties properties) {
        super(Tiers.IRON, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState state = level.getBlockState(blockpos);

        if (state.is(ArtistryTags.Blocks.CARVABLE_PUMPKINS)){
            Player player = context.getPlayer();

            ItemStack itemstack = context.getItemInHand();
            if (player instanceof ServerPlayer serverplayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverplayer, blockpos, itemstack);
            }

            if (!level.isClientSide()) {
                BlockState newState = CARVED_PUMPKINS.get(level.getRandom().nextInt(CARVED_PUMPKINS.size())).withPropertiesOf(state);
                if (!state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)){
                    Direction clickedFace = context.getClickedFace();
                    Direction alternateDirection = clickedFace.getAxis() == Direction.Axis.Y ? context.getHorizontalDirection().getOpposite() : clickedFace;
                    newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, alternateDirection);
                }
                level.setBlock(blockpos, newState, 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, newState));

                level.playSound(null, blockpos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
