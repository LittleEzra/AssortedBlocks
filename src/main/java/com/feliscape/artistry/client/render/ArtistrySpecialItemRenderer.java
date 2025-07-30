package com.feliscape.artistry.client.render;

import com.feliscape.artistry.content.block.entity.PaintedPotBlockEntity;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ArtistrySpecialItemRenderer extends BlockEntityWithoutLevelRenderer {
    private final PaintedPotBlockEntity paintedPot;
    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    public ArtistrySpecialItemRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelSet entityModelSet) {
        super(blockEntityRenderDispatcher, entityModelSet);
        this.paintedPot = new PaintedPotBlockEntity(BlockPos.ZERO, ArtistryBlocks.PAINTED_POT.get().defaultBlockState());
        this.blockEntityRenderDispatcher = blockEntityRenderDispatcher;
    }
    public ArtistrySpecialItemRenderer() {
        this(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        Item item = stack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem)item).getBlock();

            BlockState blockstate = block.defaultBlockState();
            BlockEntity blockEntity = null;
            if (blockstate.is(ArtistryBlocks.PAINTED_POT)) {
                this.paintedPot.setFromItem(stack);
                blockEntity = this.paintedPot;
            }

            if (blockEntity != null) {
                this.blockEntityRenderDispatcher.renderItem(blockEntity, poseStack, buffer, packedLight, packedOverlay);
            }
        }

    }
}
