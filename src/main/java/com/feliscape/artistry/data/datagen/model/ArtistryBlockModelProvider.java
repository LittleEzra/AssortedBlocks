package com.feliscape.artistry.data.datagen.model;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.block.*;
import com.feliscape.artistry.content.block.plant.*;
import com.feliscape.artistry.content.block.properties.TriplePlantPart;
import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

import static com.feliscape.artistry.registry.ArtistryBlocks.*;

public class ArtistryBlockModelProvider extends BlockStateProvider {
    public ArtistryBlockModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Artistry.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(CRACKED_BRICKS);
        blockWithItem(MOSSY_BRICKS);

        ResourceLocation stoneTileTexture = blockTexture(STONE_TILES.get());
        blockWithItem(STONE_TILES);
        stairsBlock(STONE_TILE_STAIRS.get(), stoneTileTexture);
        slabBlock(STONE_TILE_SLAB.get(), stoneTileTexture, stoneTileTexture);

        ResourceLocation mossyStoneTileTexture = blockTexture(MOSSY_STONE_TILES.get());
        blockWithItem(MOSSY_STONE_TILES);
        stairsBlock(MOSSY_STONE_TILE_STAIRS.get(), mossyStoneTileTexture);
        slabBlock(MOSSY_STONE_TILE_SLAB.get(), mossyStoneTileTexture, mossyStoneTileTexture);

        blockWithItem(OVERGROWN_STONE_TILES);
        axisBlock(STONE_PILLAR.get());
        axisBlock(MOSSY_STONE_PILLAR.get());

        sunsprout(SUNSPROUT);
        crossBlockWithRenderType(SUNBURST_VINES.get(), "cutout");
        crossBlockWithRenderType(SUNBURST_VINES_PLANT.get(), "cutout");
        directionalBlock(SPARKLER.get(), models().getExistingFile(Artistry.location("block/sparkler")));
        amethystStars(AMETHYST_STARS.get());

        simpleBlock(SPARK_FOUNTAIN.get(), models().getExistingFile(Artistry.location("block/spark_fountain")));
        simpleBlockWithItem(WATER_FOUNTAIN.get(), models().getExistingFile(Artistry.location("block/water_fountain")));

        table(OAK_TABLE);
        table(SPRUCE_TABLE);
        table(BIRCH_TABLE);
        table(JUNGLE_TABLE);
        table(ACACIA_TABLE);
        table(CHERRY_TABLE);
        table(DARK_OAK_TABLE);
        table(MANGROVE_TABLE);
        table(ASPEN_TABLE);
        table(ROTTEN_TABLE);
        table(BAMBOO_TABLE);
        table(CRIMSON_TABLE);
        table(WARPED_TABLE);

        table(STONE_TABLE);
        table(ANDESITE_TABLE);
        table(GRANITE_TABLE);
        table(DIORITE_TABLE);
        table(DEEPSLATE_TABLE);
        table(POLISHED_BLACKSTONE_TABLE);
        table(TUFF_TABLE);
        table(CALCITE_TABLE);

        blockWithItem(WHITE_FROSTED_GLASS, "translucent");
        blockWithItem(LIGHT_GRAY_FROSTED_GLASS, "translucent");
        blockWithItem(GRAY_FROSTED_GLASS, "translucent");
        blockWithItem(BLACK_FROSTED_GLASS, "translucent");
        blockWithItem(BROWN_FROSTED_GLASS, "translucent");
        blockWithItem(RED_FROSTED_GLASS, "translucent");
        blockWithItem(ORANGE_FROSTED_GLASS, "translucent");
        blockWithItem(YELLOW_FROSTED_GLASS, "translucent");
        blockWithItem(LIME_FROSTED_GLASS, "translucent");
        blockWithItem(GREEN_FROSTED_GLASS, "translucent");
        blockWithItem(CYAN_FROSTED_GLASS, "translucent");
        blockWithItem(LIGHT_BLUE_FROSTED_GLASS, "translucent");
        blockWithItem(BLUE_FROSTED_GLASS, "translucent");
        blockWithItem(PURPLE_FROSTED_GLASS, "translucent");
        blockWithItem(MAGENTA_FROSTED_GLASS, "translucent");
        blockWithItem(PINK_FROSTED_GLASS, "translucent");

        stringLights(STRING_LIGHTS.get());
        wallStringLights(WALL_STRING_LIGHTS.get());

        largeLantern(LARGE_LANTERN);
        largeLantern(LARGE_SOUL_LANTERN);
        roundLantern(ROUND_LANTERN);
        directionalBlock(FLAT_LIGHT.get(), models().getExistingFile(Artistry.location("block/flat_light")));

        bloomingVines(BLOOMING_VINES);
        /*getVariantBuilder(ArtistryBlocks.LUSH_FERN.get())
                .partialState().addModels(ConfiguredModel.builder().modelFile(
                        models().getExistingFile(Artistry.location("block/lush_fern"))
                ).buildLast());*/
        simpleBlock(LUSH_FERN.get(), models().getExistingFile(Artistry.location("block/lush_fern")));
        lushFernCropBlock(LUSH_FERN_CROP.get());
        teardropGrassBlock(TEARDROP_GRASS_BLOCK.get());
        crossBlockWithRenderType(SHORT_TEARDROP_GRASS.get(), "cutout");
        doublePlantBlock(TALL_TEARDROP_GRASS.get(), "cutout");
        pottedCrossPlantBlock(POTTED_TEARDROP_GRASS, Artistry.location("block/potted_teardrop_grass"));
        corpseFlowerBlock(CORPSE_FLOWER.get());
        flyLureBlock(FLY_LURE.get());

        honeydewFruitBlock(HONEYDEW_FRUIT.get());
        crossCropBlock(HONEYDEW_STALK.get());

        axisBlock(COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/copper_chain")));
        axisBlock(EXPOSED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/exposed_copper_chain")));
        axisBlock(WEATHERED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/weathered_copper_chain")));
        axisBlock(OXIDIZED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/oxidized_copper_chain")));

        axisBlock(WAXED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/copper_chain")));
        axisBlock(WAXED_EXPOSED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/exposed_copper_chain")));
        axisBlock(WAXED_WEATHERED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/weathered_copper_chain")));
        axisBlock(WAXED_OXIDIZED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/oxidized_copper_chain")));

        blockWithItem(ROCKY_DIRT);

        particlesOnly(PAINTED_POT.get(), blockTexture(Blocks.TERRACOTTA));

        ResourceLocation calciteTexture = blockTexture(Blocks.CALCITE);
        ResourceLocation smoothCalciteTexture = blockTexture(SMOOTH_CALCITE.get());
        ResourceLocation polishedCalciteTexture = blockTexture(POLISHED_CALCITE.get());
        ResourceLocation calciteBrickTexture = blockTexture(CALCITE_BRICKS.get());
        ResourceLocation smallCalciteBrickTexture = blockTexture(SMALL_CALCITE_BRICKS.get());

        stairsBlock(CALCITE_STAIRS.get(), calciteTexture);
        slabBlock(CALCITE_SLAB.get(), calciteTexture, calciteTexture);
        wallBlock(CALCITE_WALL.get(), calciteTexture);

        blockWithItem(SMOOTH_CALCITE);
        stairsBlock(SMOOTH_CALCITE_STAIRS.get(), smoothCalciteTexture);
        slabBlock(SMOOTH_CALCITE_SLAB.get(), smoothCalciteTexture, smoothCalciteTexture);

        blockWithItem(POLISHED_CALCITE);
        blockWithItem(CHISELED_CALCITE);
        stairsBlock(POLISHED_CALCITE_STAIRS.get(), polishedCalciteTexture);
        slabBlock(POLISHED_CALCITE_SLAB.get(), polishedCalciteTexture, polishedCalciteTexture);
        wallBlock(POLISHED_CALCITE_WALL.get(), polishedCalciteTexture);

        blockWithItem(CALCITE_BRICKS);
        stairsBlock(CALCITE_BRICK_STAIRS.get(), calciteBrickTexture);
        slabBlock(CALCITE_BRICK_SLAB.get(), calciteBrickTexture, calciteBrickTexture);
        wallBlock(CALCITE_BRICK_WALL.get(), calciteBrickTexture);

        ResourceLocation smallCalciteBrickTopTexture = blockTexture(SMALL_CALCITE_BRICKS.get()).withSuffix("_top");
        simpleCubeColumn(SMALL_CALCITE_BRICKS.get());
        stairsBlock(SMALL_CALCITE_BRICK_STAIRS.get(), smallCalciteBrickTexture, smallCalciteBrickTopTexture, smallCalciteBrickTopTexture);
        slabBlock(SMALL_CALCITE_BRICK_SLAB.get(), smallCalciteBrickTexture, smallCalciteBrickTexture, smallCalciteBrickTopTexture, smallCalciteBrickTopTexture);

        blockWithItem(PAINTED_SMOOTH_CALCITE);
        blockWithItem(PAINTED_POLISHED_CALCITE);
        blockWithItem(PAINTED_CALCITE_BRICKS);
        simpleCubeColumn(PAINTED_SMALL_CALCITE_BRICKS.get());

        ResourceLocation dripstoneTexture = blockTexture(Blocks.DRIPSTONE_BLOCK);
        ResourceLocation polishedDripstoneTexture = blockTexture(POLISHED_DRIPSTONE.get());
        ResourceLocation dripstoneBrickTexture = blockTexture(DRIPSTONE_BRICKS.get());

        stairsBlock(DRIPSTONE_STAIRS.get(), dripstoneTexture);
        slabBlock(DRIPSTONE_SLAB.get(), dripstoneTexture, dripstoneTexture);
        wallBlock(DRIPSTONE_WALL.get(), dripstoneTexture);

        blockWithItem(POLISHED_DRIPSTONE);
        blockWithItem(CHISELED_DRIPSTONE);
        stairsBlock(POLISHED_DRIPSTONE_STAIRS.get(), polishedDripstoneTexture);
        slabBlock(POLISHED_DRIPSTONE_SLAB.get(), polishedDripstoneTexture, polishedDripstoneTexture);
        wallBlock(POLISHED_DRIPSTONE_WALL.get(), polishedDripstoneTexture);

        blockWithItem(DRIPSTONE_BRICKS);
        stairsBlock(DRIPSTONE_BRICK_STAIRS.get(), dripstoneBrickTexture);
        slabBlock(DRIPSTONE_BRICK_SLAB.get(), dripstoneBrickTexture, dripstoneBrickTexture);
        wallBlock(DRIPSTONE_BRICK_WALL.get(), dripstoneBrickTexture);

        // Aspen Wood

        leavesBlock(ASPEN_LEAVES, "cutout_mipped");

        ResourceLocation aspenLogTexture = blockTexture(ASPEN_LOG.get());
        ResourceLocation strippedAspenLogTexture = blockTexture(STRIPPED_ASPEN_LOG.get());
        ResourceLocation aspenPlanksTexture = blockTexture(ASPEN_PLANKS.get());

        signBlock(ASPEN_SIGN.get(), ASPEN_WALL_SIGN.get(),
                aspenPlanksTexture);
        hangingSignBlock(ASPEN_HANGING_SIGN.get(), ASPEN_WALL_HANGING_SIGN.get(),
                aspenPlanksTexture);

        logBlock(ASPEN_LOG.get());
        axisBlock(ASPEN_WOOD.get(), aspenLogTexture, aspenLogTexture);
        logBlock(STRIPPED_ASPEN_LOG.get());
        axisBlock(STRIPPED_ASPEN_WOOD.get(), strippedAspenLogTexture, strippedAspenLogTexture);

        blockWithItem(ASPEN_PLANKS);

        pottedCrossPlantBlock(POTTED_ASPEN_SAPLING);

        stairsBlock(ASPEN_STAIRS.get(), aspenPlanksTexture);
        slabBlock(ASPEN_SLAB.get(), aspenPlanksTexture, aspenPlanksTexture);
        buttonBlock(ASPEN_BUTTON.get(), aspenPlanksTexture);
        pressurePlateBlock(ASPEN_PRESSURE_PLATE.get(), aspenPlanksTexture);
        fenceBlock(ASPEN_FENCE.get(), aspenPlanksTexture);
        fenceGateBlock(ASPEN_FENCE_GATE.get(), aspenPlanksTexture);

        doorBlockWithRenderType(ASPEN_DOOR.get(), modLoc("block/aspen_door_bottom"), modLoc("block/aspen_door_top"), "cutout");
        trapdoorBlockWithRenderType(ASPEN_TRAPDOOR.get(), modLoc("block/aspen_trapdoor"), true, "cutout");

        crossBlockWithRenderType(ASPEN_SAPLING.get(), "cutout");



        horizontalBlock(HEADSTONE.get(), models().getExistingFile(Artistry.location("block/headstone")));
        blockWithItem(LEECHING_SOIL);
        simpleBlockWithItem(WAXED_LEECHING_SOIL.get(), cubeAll(LEECHING_SOIL.get()));

        crossBlockWithRenderType(MARIGOLD.get(), "cutout");
        pottedCrossPlantBlock(POTTED_MARIGOLD);

        carvedPumpkin(WICKED_CARVED_PUMPKIN.get());
        carvedPumpkin(HUNGRY_CARVED_PUMPKIN.get());
        carvedPumpkin(HAPPY_CARVED_PUMPKIN.get());
        carvedPumpkin(STALWART_CARVED_PUMPKIN.get());
        carvedPumpkin(PEEKING_CARVED_PUMPKIN.get());
        carvedPumpkin(BELLOWING_CARVED_PUMPKIN.get());

        carvedPumpkin(WICKED_JACK_O_LANTERN.get());
        carvedPumpkin(HUNGRY_JACK_O_LANTERN.get());
        carvedPumpkin(HAPPY_JACK_O_LANTERN.get());
        carvedPumpkin(STALWART_JACK_O_LANTERN.get());
        carvedPumpkin(PEEKING_JACK_O_LANTERN.get());
        carvedPumpkin(BELLOWING_JACK_O_LANTERN.get());

        // Rotten Wood

        leavesBlock(ROTTEN_LEAVES, "cutout_mipped");


        ResourceLocation rottenLogTexture = blockTexture(ROTTEN_LOG.get());
        ResourceLocation strippedRottenLogTexture = blockTexture(STRIPPED_ROTTEN_LOG.get());
        ResourceLocation rottenPlanksTexture = blockTexture(ROTTEN_PLANKS.get());

        signBlock(ROTTEN_SIGN.get(), ROTTEN_WALL_SIGN.get(),
                rottenPlanksTexture);
        hangingSignBlock(ROTTEN_HANGING_SIGN.get(), ROTTEN_WALL_HANGING_SIGN.get(),
                rottenPlanksTexture);

        logBlock(ROTTEN_LOG.get());
        axisBlock(ROTTEN_WOOD.get(), rottenLogTexture, rottenLogTexture);
        logBlock(STRIPPED_ROTTEN_LOG.get());
        axisBlock(STRIPPED_ROTTEN_WOOD.get(), strippedRottenLogTexture, strippedRottenLogTexture);

        simpleBlockWithVariants(ROTTEN_PLANKS.get(), 3);

        stairsBlock(ROTTEN_STAIRS.get(), rottenPlanksTexture);
        slabBlock(ROTTEN_SLAB.get(), rottenPlanksTexture, rottenPlanksTexture);
        buttonBlock(ROTTEN_BUTTON.get(), rottenPlanksTexture);
        pressurePlateBlock(ROTTEN_PRESSURE_PLATE.get(), rottenPlanksTexture);
        fenceBlock(ROTTEN_FENCE.get(), rottenPlanksTexture);
        fenceGateBlock(ROTTEN_FENCE_GATE.get(), rottenPlanksTexture);

        doorBlockWithRenderType(ROTTEN_DOOR.get(), modLoc("block/rotten_door_bottom"), modLoc("block/rotten_door_top"), "cutout");
        trapdoorBlockWithRenderType(ROTTEN_TRAPDOOR.get(), modLoc("block/rotten_trapdoor"), true, "cutout");

        crossBlockWithRenderType(ROTTEN_SAPLING.get(), "cutout");
        pottedCrossPlantBlock(POTTED_ROTTEN_SAPLING);

    }

    private static final ResourceLocation PUMPKIN_SIDE = ResourceLocation.withDefaultNamespace("block/pumpkin_side");
    private static final ResourceLocation PUMPKIN_TOP = ResourceLocation.withDefaultNamespace("block/pumpkin_top");

    private void carvedPumpkin(CarvedPumpkinBlock block) {
        ModelFile model = models().orientable(name(block), PUMPKIN_SIDE, blockTexture(block), PUMPKIN_TOP);
        horizontalBlock(block, model);
        simpleBlockItem(block, model);
    }

    private void honeydewFruitBlock(HoneydewFruitBlock block) {
        ModelFile planted = models().cubeAll(name(block) + "_planted", blockTexture(block));
        ModelFile placed = models().cubeColumn(name(block), blockTexture(block), blockTexture(block).withSuffix("_top"));
        getVariantBuilder(block)
                .forAllStates(
                        state -> ConfiguredModel.builder().modelFile(state.getValue(HoneydewFruitBlock.PLANTED) ? planted : placed).build()
                );
        simpleBlockItem(block, placed);
    }

    private void flyLureBlock(FlyLureBlock block) {
        ModelFile wallModel = models().getExistingFile(Artistry.location("block/wall_fly_lure"));
        ModelFile floorModel = models().getExistingFile(Artistry.location("block/fly_lure"));
        ModelFile hangingModel = models().getExistingFile(Artistry.location("block/fly_lure_hanging"));

        getVariantBuilder(block).forAllStatesExcept(state -> {
            Direction d = state.getValue(FlyLureBlock.FACING);
            if (d == Direction.DOWN){
                return ConfiguredModel.builder().modelFile(hangingModel).build();
            }
            if (d == Direction.UP){
                return ConfiguredModel.builder().modelFile(floorModel).build();
            }

            return ConfiguredModel.builder().modelFile(wallModel)
                    .rotationY((((int) d.toYRot()) + 180) % 360)
                    .build();
        }, FlyLureBlock.WATERLOGGED);
    }


    private void teardropGrassBlock(Block block) {
        ModelFile variant0 = models().cubeBottomTop(name(block),
                blockTexture(block).withSuffix("_side"),
                blockTexture(Blocks.DIRT),
                blockTexture(block).withSuffix("_top_0"));
        ModelFile variant1 = models().cubeBottomTop(name(block),
                blockTexture(block).withSuffix("_side"),
                blockTexture(Blocks.DIRT),
                blockTexture(block).withSuffix("_top_1"));
        getVariantBuilder(block).partialState()
                .addModels(ConfiguredModel.allYRotations(variant0, 0, false, 1))
                .addModels(ConfiguredModel.allYRotations(variant1, 0, false, 1))
        ;
        simpleBlockItem(block, variant0);
    }

    /**
     * A simple block and item with multiple variants
     * @param variants The number of variants excluding the primary texture
     */
    private void simpleBlockWithVariants(Block block, int variants){
        ModelFile primary = cubeAll(block);
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.partialState().addModels(ConfiguredModel.builder().modelFile(primary).weight(1).build());

        for (int i = 0; i < variants; i++){
            variantBuilder.partialState().addModels(ConfiguredModel.builder()
                    .modelFile(models().cubeAll(name(block) + "_" + i, blockTexture(block).withSuffix("_" + i)))
                    .weight(1).build());
        }
        simpleBlockItem(block, primary);
    }

    public void axisBlock(RotatedPillarBlock block, ModelFile model) {
        this.axisBlock(block, model, model);
    }

    private void particlesOnly(Block block, ResourceLocation particle) {
        ModelFile model = models().getBuilder(name(block)).texture("particle", particle);
        this.simpleBlock(block, model);
    }

    private void simpleCubeColumn(Block block) {
        ModelFile modelFile = models().cubeColumn(name(block), blockTexture(block), blockTexture(block).withSuffix("_top"));
        simpleBlockWithItem(block, modelFile);
    }
    private ModelFile cubeColumn(Block block) {
        return models().cubeColumn(name(block), blockTexture(block), blockTexture(block).withSuffix("_top"));
    }

    private void pottedCrossPlantBlock(Supplier<? extends FlowerPotBlock> block) {
        ModelFile model = models().withExistingParent(getLocation(block).getPath(),
                        "minecraft:block/flower_pot_cross")
                .renderType("cutout")
                .texture("plant", blockTexture(block.get().getPotted()));
        simpleBlock(block.get(), model);
    }
    private void pottedCrossPlantBlock(Supplier<? extends FlowerPotBlock> block, ResourceLocation plantLocation) {
        ModelFile model = models().withExistingParent(getLocation(block).getPath(),
                        "minecraft:block/flower_pot_cross")
                .renderType("cutout")
                .texture("plant", plantLocation);
        simpleBlock(block.get(), model);
    }

    private void crossCropBlock(CropBlock block){
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().cross(name(block) + "_stage" + block.getAge(state),
                                blockTexture(block).withSuffix("_stage" + block.getAge(state)))
                        .renderType("cutout"))
                .build());
    }
    private void lushFernCropBlock(LushFernCropBlock block){
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().getExistingFile(Artistry.location("block/" + name(block) + "_stage" + state.getValue(LushFernCropBlock.AGE))))
                .build());
    }

    private void corpseFlowerBlock(CorpseFlowerBlock block){
        ResourceLocation inside = blockTexture(block).withSuffix("_leaves_inside");
        ResourceLocation outside = blockTexture(block).withSuffix("_leaves_outside");

        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.forAllStates(state -> {
            TriplePlantPart part = state.getValue(TriplePlantBlock.PART);
            String modelName = Artistry.stringLocation("block/" + name(block) + "_" + part);
            if (part == TriplePlantPart.BASE) {
                return ConfiguredModel.builder()
                        .modelFile(
                                models().withExistingParent(modelName,
                                                Artistry.stringLocation("block/template_corpse_flower_base"))
                                        .texture("cross", blockTexture(block).withSuffix("_bloom_" + part))
                                        .texture("inside", inside)
                                        .texture("outside", outside)
                        )
                        .build();
            } else{
                return ConfiguredModel.builder()
                        .modelFile(models().cross(
                                modelName,
                                blockTexture(block).withSuffix("_bloom_" + part))
                                .renderType("cutout"))
                        .build();
            }
        });
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
    private void roundLantern(Supplier<? extends RoundLanternBlock> block){
        VariantBlockStateBuilder builder = getVariantBuilder(block.get());

        ModelFile standard = models().getExistingFile(Artistry.location("block/round_lantern"));
        ModelFile hanging = models().getExistingFile(Artistry.location("block/round_lantern_hanging"));

        builder.forAllStates(state -> ConfiguredModel.builder()
                .modelFile(state.getValue(RoundLanternBlock.HANGING) ? hanging : standard)
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

    public void amethystStars(AmethystStarsBlock block) {
        ModelFile model = models().getExistingFile(Artistry.location("block/amethyst_stars"));
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block);

        for (Direction direction : Direction.values()) {
            var part = builder.part().modelFile(model)
                    .rotationY(((int) direction.toYRot() + 180) % 360);
            if (direction == Direction.UP){
                part.rotationX(270);
            } else if (direction == Direction.DOWN){
                part.rotationX(90);
            }
            part.addModel().condition(MultifaceBlock.getFaceProperty(direction), true);
        }
    }

    @SuppressWarnings("unchecked")
    public void wallStringLights(WallStringLightsBlock block) {
        ModelFile model = models().getExistingFile(Artistry.location("block/wall_string_lights"));
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block);

        WallStringLightsBlock.PROPERTY_BY_DIRECTION.forEach((dir, value) -> {
            if (dir.getAxis().isHorizontal()) {
                builder.part().modelFile(model)
                        .rotationY(((int) dir.toYRot() + 180) % 360).addModel()
                        .condition(value, true);
            }
        });
    }
    @SuppressWarnings("unchecked")
    public void stringLights(StringLightsBlock block) {
        ModelFile down = models().withExistingParent(name(block) + "_down",
                        Artistry.stringLocation("block/template_string_lights_down"))
                .texture("texture", extend(blockTexture(block), "_down"));
        ModelFile side = models().withExistingParent(name(block) + "_side",
                        Artistry.stringLocation("block/template_string_lights_side"))
                .texture("texture", blockTexture(block));
        ModelFile side1 = models().withExistingParent(name(block) + "_side_1",
                        Artistry.stringLocation("block/template_string_lights_side_1"))
                .texture("texture", blockTexture(block));
        ModelFile sideLow = models().withExistingParent(name(block) + "_side_low",
                        Artistry.stringLocation("block/template_string_lights_side"))
                .texture("texture", blockTexture(block) + "_low");
        ModelFile sideLow1 = models().withExistingParent(name(block) + "_side_low_1",
                        Artistry.stringLocation("block/template_string_lights_side_1"))
                .texture("texture", blockTexture(block) + "_low");

        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(block)
                .part()
                .modelFile(down)
                .addModel()
                .condition(StringLightsBlock.DOWN, true)
                .end();

        PipeBlock.PROPERTY_BY_DIRECTION.forEach((dir, value) -> {
            if (dir.getAxis().isHorizontal()) {
                builder.part().modelFile(dir.getAxisDirection() == Direction.AxisDirection.NEGATIVE ? side1 : side)
                        .rotationY(((int) dir.toYRot() + 180) % 360)
                        .uvLock(true).addModel()
                        .condition(value, true)
                        .condition(StringLightsBlock.SUPPORTED, true);
                builder.part().modelFile(dir.getAxisDirection() == Direction.AxisDirection.NEGATIVE ? sideLow1 : sideLow)
                        .rotationY(((int) dir.toYRot() + 180) % 360)
                        .uvLock(true).addModel()
                        .condition(value, true)
                        .condition(StringLightsBlock.SUPPORTED, false);
            }
        });
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
    private void blockWithItem(Supplier<? extends Block> block, String renderType){
        simpleBlockWithItem(block.get(), models().cubeAll(this.name(block.get()), this.blockTexture(block.get())).renderType(renderType));
    }

    private void leavesBlock(Supplier<? extends Block> block, String renderType){
        ModelFile model = models().withExistingParent(getLocation(block).getPath(), "minecraft:block/leaves")
                .texture("all", blockTexture(block.get())).renderType(renderType);
        getVariantBuilder(block.get())
                .partialState().setModels( new ConfiguredModel(model));
        simpleBlockItem(block.get(), model);
    }


    public void doublePlantBlock(Block block, String renderType) {
        ModelFile top = models().cross(name(block) + "_top", blockTexture(block).withSuffix("_top")).renderType(renderType);
        ModelFile bottom = models().cross(name(block) + "_bottom", blockTexture(block).withSuffix("_bottom")).renderType(renderType);

        getVariantBuilder(block).forAllStatesExcept(state -> {
            var half = state.getValue(DoublePlantBlock.HALF);
            return ConfiguredModel.builder()
                    .modelFile(half == DoubleBlockHalf.UPPER ? top : bottom).build();
            }
            , DoubleTeardropGrassBlock.WATERLOGGED)
        ;
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
