package com.feliscape.artistry.client.render.blockentity;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.client.ArtistryClient;
import com.feliscape.artistry.client.atlas.ArtistrySheets;
import com.feliscape.artistry.content.block.entity.PaintedPotBlockEntity;
import com.feliscape.artistry.content.pot.PaintedPotDecorations;
import com.feliscape.artistry.data.pot.PaintedPotDecoration;
import com.feliscape.artistry.data.registry.ArtistryDatapackRegistries;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.phys.AABB;
import org.checkerframework.checker.units.qual.C;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Optional;

public class PaintedPotRenderer implements BlockEntityRenderer<PaintedPotBlockEntity> {
    private static final String NECK = "neck";
    private static final String FRONT = "front";
    private static final String BACK = "back";
    private static final String LEFT = "left";
    private static final String RIGHT = "right";
    private static final String TOP = "top";
    private static final String BOTTOM = "bottom";
    private final ModelPart neck;
    private final ModelPart frontSide;
    private final ModelPart backSide;
    private final ModelPart leftSide;
    private final ModelPart rightSide;
    private final ModelPart top;
    private final ModelPart bottom;

    private final Layer trimLayer;
    private final Layer patternLayer;

    private static final float WOBBLE_AMPLITUDE = 0.125F;

    public PaintedPotRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart modelpart = context.bakeLayer(ModelLayers.DECORATED_POT_BASE);
        this.neck = modelpart.getChild("neck");
        this.top = modelpart.getChild("top");
        this.bottom = modelpart.getChild("bottom");
        ModelPart modelpart1 = context.bakeLayer(ModelLayers.DECORATED_POT_SIDES);
        this.frontSide = modelpart1.getChild("front");
        this.backSide = modelpart1.getChild("back");
        this.leftSide = modelpart1.getChild("left");
        this.rightSide = modelpart1.getChild("right");

        trimLayer = new Layer(ArtistryDatapackRegistries.PAINTED_POT_TRIM, context.bakeLayer(ModelLayers.DECORATED_POT_SIDES));
        patternLayer = new Layer(ArtistryDatapackRegistries.PAINTED_POT_PATTERN, context.bakeLayer(ModelLayers.DECORATED_POT_SIDES));
    }

    private static Material getBaseMaterial(Optional<DyeColor> color) {
        return ArtistryClient.reloadListeners().getPaintedPotDecorations().getBase(color);
    }
    private static Material getSideMaterial(Optional<DyeColor> color) {
        return ArtistryClient.reloadListeners().getPaintedPotDecorations().getSide(color);
    }

    public void render(PaintedPotBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        Direction direction = blockEntity.getDirection();
        poseStack.translate((double)0.5F, (double)0.0F, (double)0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - direction.toYRot()));
        poseStack.translate((double)-0.5F, (double)0.0F, (double)-0.5F);
        DecoratedPotBlockEntity.WobbleStyle lastWobbleStyle = blockEntity.lastWobbleStyle;
        if (lastWobbleStyle != null && blockEntity.getLevel() != null) {
            float f = ((float)(blockEntity.getLevel().getGameTime() - blockEntity.wobbleStartedAtTick) + partialTick) / (float)lastWobbleStyle.duration;
            if (f >= 0.0F && f <= 1.0F) {
                if (lastWobbleStyle == DecoratedPotBlockEntity.WobbleStyle.POSITIVE) {
                    float f1 = 0.015625F;
                    float f2 = f * ((float)Math.PI * 2F);
                    float f3 = -1.5F * (Mth.cos(f2) + 0.5F) * Mth.sin(f2 / 2.0F);
                    poseStack.rotateAround(Axis.XP.rotation(f3 * 0.015625F), 0.5F, 0.0F, 0.5F);
                    float f4 = Mth.sin(f2);
                    poseStack.rotateAround(Axis.ZP.rotation(f4 * 0.015625F), 0.5F, 0.0F, 0.5F);
                } else {
                    float f5 = Mth.sin(-f * 3.0F * (float)Math.PI) * 0.125F;
                    float f6 = 1.0F - f;
                    poseStack.rotateAround(Axis.YP.rotation(f5 * f6), 0.5F, 0.0F, 0.5F);
                }
            }
        }

        VertexConsumer vertexconsumer = getBaseMaterial(blockEntity.getDecorations().base()).buffer(bufferSource, RenderType::entitySolid);
        this.neck.render(poseStack, vertexconsumer, packedLight, packedOverlay);
        this.top.render(poseStack, vertexconsumer, packedLight, packedOverlay);
        this.bottom.render(poseStack, vertexconsumer, packedLight, packedOverlay);
        Material side = getSideMaterial(blockEntity.getDecorations().base());
        this.renderSide(this.frontSide, poseStack, bufferSource, packedLight, packedOverlay, side);
        this.renderSide(this.backSide, poseStack, bufferSource, packedLight, packedOverlay, side);
        this.renderSide(this.leftSide, poseStack, bufferSource, packedLight, packedOverlay, side);
        this.renderSide(this.rightSide, poseStack, bufferSource, packedLight, packedOverlay, side);

        PaintedPotDecorations decorations = blockEntity.getDecorations();
        if (decorations.trim().isPresent())
            trimLayer.render(decorations.trim().get(), partialTick, poseStack, bufferSource, packedLight, packedOverlay, decorations.trimColor());
        if (decorations.pattern().isPresent())
            patternLayer.render(decorations.pattern().get(), partialTick, poseStack, bufferSource, packedLight, packedOverlay, decorations.patternColor());

        poseStack.popPose();
    }

    private void renderSide(ModelPart modelPart, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, Material material) {
        modelPart.render(poseStack, material.buffer(buffer, RenderType::entitySolid), packedLight, packedOverlay);
    }

    public AABB getRenderBoundingBox(PaintedPotBlockEntity blockEntity) {
        BlockPos pos = blockEntity.getBlockPos();
        return new AABB(pos.getX(), pos.getY(), pos.getZ(), (double)pos.getX() + (double)1.0F, (double)pos.getY() + 1.3, (double)pos.getZ() + (double)1.0F);
    }

    private static class Layer{
        private final ModelPart frontSide;
        private final ModelPart backSide;
        private final ModelPart leftSide;
        private final ModelPart rightSide;
        private final ResourceKey<Registry<PaintedPotDecoration>> registry;

        public Layer(ResourceKey<Registry<PaintedPotDecoration>> registry, ModelPart root) {
            this.registry = registry;
            this.frontSide = root.getChild("front");
            this.backSide = root.getChild("back");
            this.leftSide = root.getChild("left");
            this.rightSide = root.getChild("right");
        }

        public void render(ResourceKey<PaintedPotDecoration> decoration, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, int color){
            Material material = getMaterial(decoration);

            this.renderSide(this.frontSide, poseStack, bufferSource, packedLight, packedOverlay, color, material);
            this.renderSide(this.backSide, poseStack, bufferSource, packedLight, packedOverlay, color, material);
            this.renderSide(this.leftSide, poseStack, bufferSource, packedLight, packedOverlay, color, material);
            this.renderSide(this.rightSide, poseStack, bufferSource, packedLight, packedOverlay, color, material);
        }

        @Nullable
        private Material getMaterial(ResourceKey<PaintedPotDecoration> decoration) {
            return ArtistryClient.reloadListeners().getPaintedPotDecorations().getPotPaint(registry, decoration);
        }

        private void renderSide(ModelPart modelPart, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, int color, @Nullable Material material) {
            if (material == null) return;
            modelPart.render(poseStack, material.buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay, color);
        }
    }
}
