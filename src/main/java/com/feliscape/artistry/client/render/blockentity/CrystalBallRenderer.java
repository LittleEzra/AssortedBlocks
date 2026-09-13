package com.feliscape.artistry.client.render.blockentity;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.client.render.ArtistryRenderTypes;
import com.feliscape.artistry.content.block.CrystalBallBlock;
import com.feliscape.artistry.content.block.entity.CrystalBallBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class CrystalBallRenderer implements BlockEntityRenderer<CrystalBallBlockEntity> {
    private static final ResourceLocation SHINE_TEXTURE = Artistry.location("textures/entity/shine.png");
    private static final RenderType RENDER_TYPE = ArtistryRenderTypes.flatTranslucentCull(SHINE_TEXTURE);

    private final EntityRenderDispatcher entityRenderDispatcher;

    public CrystalBallRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderDispatcher = context.getEntityRenderer();
    }

    @Override
    public void render(CrystalBallBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        var direction = blockEntity.getBlockState().getValue(CrystalBallBlock.FACING).getOpposite();

        var pos = blockEntity.getBlockPos();
        Vector3f offset = new Vector3f(
                0.5F + 0.0625F * direction.getStepX(),
                0.5F + 0.0625F * direction.getStepY(),
                0.5F + 0.0625F * direction.getStepZ()
        );
        var cameraDirection = entityRenderDispatcher.camera.getPosition().toVector3f().sub(
                offset.x + pos.getX(),
                offset.y + pos.getY(),
                offset.z + pos.getZ(),
                new Vector3f());
        float horizontalLength = Mth.sqrt(Mth.square(cameraDirection.x) + Mth.square(cameraDirection.z));

        float xRot = (Mth.wrapDegrees((float)(-(Mth.atan2(cameraDirection.y, horizontalLength)))));
        float yRot = (Mth.wrapDegrees((float)(Mth.atan2(cameraDirection.z, cameraDirection.x)) - Mth.HALF_PI));

        poseStack.translate(offset.x, offset.y, offset.z);
        Quaternionf rot = new Quaternionf();
        rot.rotateY(-yRot).rotateX(xRot);
        poseStack.mulPose(rot);
        poseStack.translate(0.0F, 0.0F, -0.2F);
        //poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());

        float t = blockEntity.getPulse() + partialTick;
        float extent = 0.74F + Mth.sin(t * 0.1F) * 0.05F;
        float alpha = 0.6F + Mth.sin(t * 0.05F) * 0.16F;

        VertexConsumer vertexConsumer = bufferSource.getBuffer(RENDER_TYPE);
        var pose = poseStack.last();

        vertex(vertexConsumer, pose, -extent, -extent, 0.0F, 0.0F, alpha);
        vertex(vertexConsumer, pose,  extent, -extent, 1.0F, 0.0F, alpha);
        vertex(vertexConsumer, pose,  extent,  extent, 1.0F, 1.0F, alpha);
        vertex(vertexConsumer, pose, -extent,  extent, 0.0F, 1.0F, alpha);

        poseStack.popPose();
    }

    private static void vertex(
            VertexConsumer consumer,
            PoseStack.Pose pose,
            float x,
            float y,
            float u,
            float v,
            float alpha
    ) {
        consumer.addVertex(pose, x, y, 0.0F)
                .setColor(200 / 255F, 144 / 255F, 240 / 255F, alpha)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(LightTexture.FULL_BRIGHT)
                .setNormal(pose, 0.0F, 1.0F, 0.0F);
    }
}
