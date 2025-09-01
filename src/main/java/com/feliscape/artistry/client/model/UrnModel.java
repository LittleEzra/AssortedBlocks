package com.feliscape.artistry.client.model;

import com.feliscape.artistry.util.MathUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;

public class UrnModel extends Model {
	private final ModelPart root;

	public UrnModel(ModelPart root) {
        super(RenderType::entityCutout);
        this.root = root.getChild("root");
	}

	public static LayerDefinition createLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("root", CubeListBuilder.create()
						.texOffs(0, 16).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
						.texOffs(0, 24).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
						.texOffs(0, 0).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
						.texOffs(24, 16).addBox(-8.0F, -13.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
						.texOffs(24, 16).mirror().addBox(4.0F, -13.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(0, 16).addBox(-3.0F, -16.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
						.texOffs(5, 11).addBox(-2.0F, -14.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	public void rotate(Direction direction){
		root.yRot = MathUtil.toRadians(180.0F - direction.toYRot());
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}