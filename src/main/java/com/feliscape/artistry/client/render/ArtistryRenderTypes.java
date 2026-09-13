package com.feliscape.artistry.client.render;

import com.feliscape.artistry.Artistry;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;

import javax.annotation.Nullable;
import java.util.function.Function;

@EventBusSubscriber(modid = Artistry.MOD_ID, value = Dist.CLIENT)
public class ArtistryRenderTypes {
    @Nullable
    private static ShaderInstance rendertypeFlatTranslucentCullShader;

    @SubscribeEvent
    public static void fetchShaders(RegisterShadersEvent event){
        var resourceProvider = event.getResourceProvider();
        try{
            event.registerShader(
                    new ShaderInstance(resourceProvider, Artistry.location("rendertype_flat_translucent_cull"), DefaultVertexFormat.POSITION_TEX_COLOR),
                    instance -> rendertypeFlatTranslucentCullShader = instance
            );
        } catch (Exception e){
            throw new RuntimeException("could not reload shaders", e);
        }
    }

    public static final Function<ResourceLocation, RenderType> FLAT_TRANSLUCENT_CULL = Util.memoize(
            textureState -> {
                RenderType.CompositeState composite = RenderType.CompositeState.builder()
                        .setShaderState(CustomRenderStateShards.RENDERTYPE_FLAT_TRANSLUCENT_CULL_SHADER)
                        .setTextureState(new RenderStateShard.TextureStateShard(textureState, false, false))
                        .setTransparencyState(RenderStateShard.TRANSLUCENT_TRANSPARENCY)
                        .setCullState(RenderStateShard.CULL)
                        .setOutputState(RenderStateShard.ITEM_ENTITY_TARGET)
                        .setWriteMaskState(RenderStateShard.COLOR_DEPTH_WRITE)
                        .createCompositeState(true);
                return RenderType.create("flat_translucent_cull", DefaultVertexFormat.POSITION_TEX_COLOR, VertexFormat.Mode.QUADS, 1536, true, true, composite);
            }
    );
    public static RenderType flatTranslucentCull(ResourceLocation location) {
        return FLAT_TRANSLUCENT_CULL.apply(location);
    }

    public static class CustomRenderStateShards{
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_FLAT_TRANSLUCENT_CULL_SHADER = new RenderStateShard.ShaderStateShard(() -> rendertypeFlatTranslucentCullShader);}
}
