package com.feliscape.artistry.client.render.blockentity;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.client.ArtistryModelLayers;
import com.feliscape.artistry.client.model.UrnModel;
import com.feliscape.artistry.content.block.entity.UrnBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;

public class UrnRenderer implements BlockEntityRenderer<UrnBlockEntity> {
    private UrnModel model;
    private static final ResourceLocation TEXTURE = Artistry.location("textures/entity/urn.png");

    public UrnRenderer(BlockEntityRendererProvider.Context context) {
        model = new UrnModel(context.bakeLayer(ArtistryModelLayers.URN));
    }

    @Override
    public void render(UrnBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.scale(1.0F, -1.0F, -1.0F);
        Direction direction = blockEntity.getDirection();
        model.rotate(direction);


        UrnBlockEntity.WobbleStyle lastWobbleStyle = blockEntity.lastWobbleStyle;
        if (lastWobbleStyle != null && blockEntity.getLevel() != null) {
            float wobbleProgress = ((float)(blockEntity.getLevel().getGameTime() - blockEntity.wobbleStartedAtTick) + partialTick) / (float)lastWobbleStyle.duration;
            if (wobbleProgress >= 0.0F && wobbleProgress <= 1.0F) {
                if (lastWobbleStyle == UrnBlockEntity.WobbleStyle.POSITIVE) {
                    float theta = wobbleProgress * ((float)Math.PI * 2F);
                    float xRotation = -1.5F * (Mth.cos(theta) + 0.5F) * Mth.sin(theta / 2.0F);
                    poseStack.rotateAround(Axis.XP.rotation(xRotation * 0.015625F), 0.5F, 0.0F, -0.5F);
                    float zRotation = Mth.sin(theta);
                    poseStack.rotateAround(Axis.ZP.rotation(zRotation * 0.015625F), 0.5F, 0.0F, -0.5F);
                } else {
                    float f5 = Mth.sin(-wobbleProgress * 3.0F * (float)Math.PI) * 0.125F;
                    float f6 = 1.0F - wobbleProgress;
                    poseStack.rotateAround(Axis.YP.rotation(f5 * f6), 0.5F, 0.0F, -0.5F);
                }
            }
        }
        poseStack.translate(0.5F, 0.0F, -0.5F);
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutout(TEXTURE));
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay);
        poseStack.popPose();
    }
}
