package com.feliscape.artistry.data.datagen.model;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.block.*;
import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class ArtistryBlockModelProvider extends BlockStateProvider {
    public ArtistryBlockModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Artistry.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ArtistryBlocks.CRACKED_BRICKS);
        blockWithItem(ArtistryBlocks.MOSSY_BRICKS);
        blockWithItem(ArtistryBlocks.STONE_TILES);
        blockWithItem(ArtistryBlocks.MOSSY_STONE_TILES);
        blockWithItem(ArtistryBlocks.OVERGROWN_STONE_TILES);
        axisBlock(ArtistryBlocks.STONE_PILLAR.get());
        axisBlock(ArtistryBlocks.MOSSY_STONE_PILLAR.get());

        sunsprout(ArtistryBlocks.SUNSPROUT);
        crossBlockWithRenderType(ArtistryBlocks.SUNBURST_VINES.get(), "cutout");
        crossBlockWithRenderType(ArtistryBlocks.SUNBURST_VINES_PLANT.get(), "cutout");

        table(ArtistryBlocks.OAK_TABLE);
        table(ArtistryBlocks.SPRUCE_TABLE);
        table(ArtistryBlocks.BIRCH_TABLE);
        table(ArtistryBlocks.JUNGLE_TABLE);
        table(ArtistryBlocks.ACACIA_TABLE);
        table(ArtistryBlocks.CHERRY_TABLE);
        table(ArtistryBlocks.DARK_OAK_TABLE);
        table(ArtistryBlocks.MANGROVE_TABLE);
        table(ArtistryBlocks.ASPEN_TABLE);
        table(ArtistryBlocks.BAMBOO_TABLE);
        table(ArtistryBlocks.CRIMSON_TABLE);
        table(ArtistryBlocks.WARPED_TABLE);

        table(ArtistryBlocks.STONE_TABLE);

        stringLights(ArtistryBlocks.STRING_LIGHTS.get());

        largeLantern(ArtistryBlocks.LARGE_LANTERN);
        largeLantern(ArtistryBlocks.LARGE_SOUL_LANTERN);

        bloomingVines(ArtistryBlocks.BLOOMING_VINES);

        leavesBlock(ArtistryBlocks.ASPEN_LEAVES, "cutout_mipped");

        ResourceLocation aspenLogTexture = blockTexture(ArtistryBlocks.ASPEN_LOG.get());
        ResourceLocation strippedAspenLogTexture = blockTexture(ArtistryBlocks.STRIPPED_ASPEN_LOG.get());
        ResourceLocation aspenPlanksTexture = blockTexture(ArtistryBlocks.ASPEN_PLANKS.get());

        signBlock(ArtistryBlocks.ASPEN_SIGN.get(), ArtistryBlocks.ASPEN_WALL_SIGN.get(),
                aspenPlanksTexture);
        hangingSignBlock(ArtistryBlocks.ASPEN_HANGING_SIGN.get(), ArtistryBlocks.ASPEN_WALL_HANGING_SIGN.get(),
                aspenPlanksTexture);

        logBlock(ArtistryBlocks.ASPEN_LOG.get());
        axisBlock(ArtistryBlocks.ASPEN_WOOD.get(), aspenLogTexture, aspenLogTexture);
        logBlock(ArtistryBlocks.STRIPPED_ASPEN_LOG.get());
        axisBlock(ArtistryBlocks.STRIPPED_ASPEN_WOOD.get(), strippedAspenLogTexture, strippedAspenLogTexture);

        blockWithItem(ArtistryBlocks.ASPEN_PLANKS);


        stairsBlock(ArtistryBlocks.ASPEN_STAIRS.get(), aspenPlanksTexture);
        slabBlock(ArtistryBlocks.ASPEN_SLAB.get(), aspenPlanksTexture, aspenPlanksTexture);
        buttonBlock(ArtistryBlocks.ASPEN_BUTTON.get(), aspenPlanksTexture);
        pressurePlateBlock(ArtistryBlocks.ASPEN_PRESSURE_PLATE.get(), aspenPlanksTexture);
        fenceBlock(ArtistryBlocks.ASPEN_FENCE.get(), aspenPlanksTexture);
        fenceGateBlock(ArtistryBlocks.ASPEN_FENCE_GATE.get(), aspenPlanksTexture);

        doorBlockWithRenderType(ArtistryBlocks.ASPEN_DOOR.get(), modLoc("block/aspen_door_bottom"), modLoc("block/aspen_door_top"), "cutout");
        trapdoorBlockWithRenderType(ArtistryBlocks.ASPEN_TRAPDOOR.get(), modLoc("block/aspen_trapdoor"), true, "cutout");

        crossBlockWithRenderType(ArtistryBlocks.ASPEN_SAPLING.get(), "cutout");

    }

    private void largeLantern(Supplier<? extends LargeLanternBlock> block){
        VariantBlockStateBuilder builder = getVariantBuilder(block.get());

        ModelFile standard = models().withExistingParent(getLocation(block).getPath(),
                        Artistry.stringLocation("block/template_large_lantern"))
                .texture("all", blockTexture(block.get()));
        ModelFile hanging = models().withExistingParent(getLocation(block).getPath() + "_hanging",
                        Artistry.stringLocation("block/template_large_lantern_hanging"))
                .texture("all", blockTexture(block.get()));

        builder.forAllStates(state -> ConfiguredModel.builder()
                .modelFile(state.getValue(LargeLanternBlock.HANGING) ? hanging : standard)
                .build());
    }

    private void sunsprout(Supplier<SunsproutBlock> block){
        VariantBlockStateBuilder builder = getVariantBuilder(block.get());

        builder.forAllStates(state -> {
            int age = state.getValue(SunsproutBlock.AGE);
            return ConfiguredModel.builder()
                    .modelFile(models().cross("sunsprout_" + age,
                            extend(blockTexture(block.get()), "_" + age)).renderType("cutout"))
                    .build();
        });
    }

    public void stringLights(StringLightsBlock block) {
        ModelFile down = models().withExistingParent(name(block) + "_down",
                        Artistry.stringLocation("block/template_string_lights_down"))
                .texture("texture", extend(blockTexture(block), "_down"));
        ModelFile side = models().withExistingParent(name(block) + "_side",
                        Artistry.stringLocation("block/template_string_lights_side"))
                .texture("texture", blockTexture(block));

        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block)
                .part()
                .modelFile(down)
                .addModel()
                .condition(StringLightsBlock.DOWN, true)
                .end();
        this.fourWayMultipart(builder, side);
    }

    private void bloomingVines(Supplier<BloomingVinesBlock> block){
        MultiPartBlockStateBuilder multipart = getMultipartBuilder(block.get());

        ModelFile model0 = models().getExistingFile(Artistry.location("block/blooming_vines"));
        ModelFile model1 = models().getExistingFile(Artistry.location("block/blooming_vines1"));
        ModelFile model2 = models().getExistingFile(Artistry.location("block/blooming_vines2"));
        ModelFile verticalModel0 = models().getExistingFile(Artistry.location("block/blooming_vines_vertical"));
        ModelFile verticalModel1 = models().getExistingFile(Artistry.location("block/blooming_vines_vertical1"));
        ModelFile verticalModel2 = models().getExistingFile(Artistry.location("block/blooming_vines_vertical2"));

        addBloomingVinesFaceLoop(multipart, 0, 0, MultifaceBlock.getFaceProperty(Direction.NORTH), model0, model1, model2);
        bloomingVinesAddAllFalse(model0, multipart, 0, 0);

        addBloomingVinesFaceLoop(multipart, 0, 90, MultifaceBlock.getFaceProperty(Direction.EAST), model0, model1, model2);
        bloomingVinesAddAllFalse(model0, multipart, 0, 90);

        addBloomingVinesFaceLoop(multipart, 0, 180, MultifaceBlock.getFaceProperty(Direction.SOUTH), model0, model1, model2);
        bloomingVinesAddAllFalse(model0, multipart, 0, 180);

        addBloomingVinesFaceLoop(multipart, 0, 270, MultifaceBlock.getFaceProperty(Direction.WEST), model0, model1, model2);
        bloomingVinesAddAllFalse(model0, multipart, 0, 270);

        addBloomingVinesFaceLoop(multipart, 270, 0, MultifaceBlock.getFaceProperty(Direction.UP), verticalModel0, verticalModel1, verticalModel2);
        bloomingVinesAddAllFalse(model0, multipart, 270, 0);

        addBloomingVinesFaceLoop(multipart, 90, 0, MultifaceBlock.getFaceProperty(Direction.DOWN), verticalModel0, verticalModel1, verticalModel2);
        bloomingVinesAddAllFalse(model0, multipart, 90, 0);
    }

    private void addBloomingVinesFaceLoop(MultiPartBlockStateBuilder multipart, int xRot, int yRot, BooleanProperty faceProperty, ModelFile model0, ModelFile... files) {
        var part = multipart.part()
                .modelFile(model0)
                .rotationX(xRot)
                .rotationY(yRot);

        for (ModelFile file : files){
            part = part.nextModel()
                    .modelFile(file)
                    .rotationX(xRot)
                    .rotationY(yRot);
        }


        part.addModel()
                .condition(faceProperty, true)
                .end();
    }

    private void bloomingVinesAddAllFalse(ModelFile model, MultiPartBlockStateBuilder builder, int xRotation, int yRotation){
        builder.part()
                .modelFile(model)
                .rotationX(xRotation)
                .rotationY(yRotation)
                .addModel()
                .condition(MultifaceBlock.getFaceProperty(Direction.DOWN), false)
                .condition(MultifaceBlock.getFaceProperty(Direction.EAST), false)
                .condition(MultifaceBlock.getFaceProperty(Direction.NORTH), false)
                .condition(MultifaceBlock.getFaceProperty(Direction.SOUTH), false)
                .condition(MultifaceBlock.getFaceProperty(Direction.UP), false)
                .condition(MultifaceBlock.getFaceProperty(Direction.WEST), false).end();
    }

    private void table(Supplier<TableBlock> block){
        ModelFile base = getTableBase(block);
        ModelFile inventory = getTableInventory(block);
        ModelFile northwestLeg = getTableLeg("northwest", block);
        ModelFile northeastLeg = getTableLeg("northeast", block);
        ModelFile southeastLeg = getTableLeg("southeast", block);
        ModelFile southwestLeg = getTableLeg("southwest", block);

        simpleBlockItem(block.get(), inventory);

        getMultipartBuilder(block.get())
                .part()
                .modelFile(base)
                .addModel().end()

                .part()
                .modelFile(northwestLeg)
                .addModel().condition(TableBlock.NORTH_WEST, true).end()
                .part()
                .modelFile(northeastLeg)
                .addModel().condition(TableBlock.NORTH_EAST, true).end()
                .part()
                .modelFile(southeastLeg)
                .addModel().condition(TableBlock.SOUTH_EAST, true).end()
                .part()
                .modelFile(southwestLeg)
                .addModel().condition(TableBlock.SOUTH_WEST, true).end()
        ;
    }

    private ModelFile getTableLeg(String direction, Supplier<? extends Block> block){
        return models().withExistingParent(name(block.get()) + "_%s_leg".formatted(direction), Artistry.location("block/template_table_%s_leg".formatted(direction)))
                .texture("side", extend(blockTexture(block.get()), "_side"))
                ;
    }
    private ModelFile getTableBase(Supplier<? extends Block> block){
        return models().withExistingParent(name(block.get()) + "_base", Artistry.location("block/template_table_base"))
                .texture("top", extend(blockTexture(block.get()), "_top"))
                .texture("side", extend(blockTexture(block.get()), "_side"))
                .texture("bottom", extend(blockTexture(block.get()), "_bottom"))
                ;
    }
    private ModelFile getTableInventory(Supplier<? extends Block> block){
        return models().withExistingParent(name(block.get()) + "_inventory", Artistry.location("block/template_table_inventory"))
                .texture("top", extend(blockTexture(block.get()), "_top"))
                .texture("side", extend(blockTexture(block.get()), "_side"))
                .texture("bottom", extend(blockTexture(block.get()), "_bottom"))
                ;
    }

    private void blockWithItem(Supplier<? extends Block> block){
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void leavesBlock(Supplier<? extends Block> block, String renderType){
        ModelFile model = models().withExistingParent(getLocation(block).getPath(), "minecraft:block/leaves")
                .texture("all", blockTexture(block.get())).renderType(renderType);
        getVariantBuilder(block.get())
                .partialState().setModels( new ConfiguredModel(model));
        simpleBlockItem(block.get(), model);
    }


    public void crossBlockWithRenderType(Block block, String renderType) {
        getVariantBuilder(block).partialState().setModels(new ConfiguredModel(models().cross(name(block), blockTexture(block)).renderType(renderType)));
    }

    private String name(Block block) {
        return this.getLocation(block).getPath();
    }

    private ResourceLocation getLocation(Supplier<? extends Block> block){
        return BuiltInRegistries.BLOCK.getKey(block.get());
    }
    private ResourceLocation getLocation(Block block){
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private ResourceLocation extend(ResourceLocation location, String suffix) {
        String namespace = location.getNamespace();
        String path = location.getPath();
        return ResourceLocation.fromNamespaceAndPath(namespace, path + suffix);
    }
}
