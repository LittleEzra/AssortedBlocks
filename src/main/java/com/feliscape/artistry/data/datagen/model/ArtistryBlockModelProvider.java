package com.feliscape.artistry.data.datagen.model;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.block.RoundLanternBlock;
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

public class ArtistryBlockModelProvider extends BlockStateProvider {
    public ArtistryBlockModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Artistry.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ArtistryBlocks.CRACKED_BRICKS);
        blockWithItem(ArtistryBlocks.MOSSY_BRICKS);

        ResourceLocation stoneTileTexture = blockTexture(ArtistryBlocks.STONE_TILES.get());
        blockWithItem(ArtistryBlocks.STONE_TILES);
        stairsBlock(ArtistryBlocks.STONE_TILE_STAIRS.get(), stoneTileTexture);
        slabBlock(ArtistryBlocks.STONE_TILE_SLAB.get(), stoneTileTexture, stoneTileTexture);

        ResourceLocation mossyStoneTileTexture = blockTexture(ArtistryBlocks.MOSSY_STONE_TILES.get());
        blockWithItem(ArtistryBlocks.MOSSY_STONE_TILES);
        stairsBlock(ArtistryBlocks.MOSSY_STONE_TILE_STAIRS.get(), mossyStoneTileTexture);
        slabBlock(ArtistryBlocks.MOSSY_STONE_TILE_SLAB.get(), mossyStoneTileTexture, mossyStoneTileTexture);

        blockWithItem(ArtistryBlocks.OVERGROWN_STONE_TILES);
        axisBlock(ArtistryBlocks.STONE_PILLAR.get());
        axisBlock(ArtistryBlocks.MOSSY_STONE_PILLAR.get());

        sunsprout(ArtistryBlocks.SUNSPROUT);
        crossBlockWithRenderType(ArtistryBlocks.SUNBURST_VINES.get(), "cutout");
        crossBlockWithRenderType(ArtistryBlocks.SUNBURST_VINES_PLANT.get(), "cutout");
        directionalBlock(ArtistryBlocks.SPARKLER.get(), models().getExistingFile(Artistry.location("block/sparkler")));
        amethystStars(ArtistryBlocks.AMETHYST_STARS.get());

        simpleBlock(ArtistryBlocks.SPARK_FOUNTAIN.get(), models().getExistingFile(Artistry.location("block/spark_fountain")));
        simpleBlockWithItem(ArtistryBlocks.WATER_FOUNTAIN.get(), models().getExistingFile(Artistry.location("block/water_fountain")));

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
        table(ArtistryBlocks.ANDESITE_TABLE);
        table(ArtistryBlocks.GRANITE_TABLE);
        table(ArtistryBlocks.DIORITE_TABLE);
        table(ArtistryBlocks.DEEPSLATE_TABLE);
        table(ArtistryBlocks.POLISHED_BLACKSTONE_TABLE);
        table(ArtistryBlocks.TUFF_TABLE);
        table(ArtistryBlocks.CALCITE_TABLE);

        blockWithItem(ArtistryBlocks.WHITE_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.LIGHT_GRAY_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.GRAY_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.BLACK_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.BROWN_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.RED_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.ORANGE_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.YELLOW_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.LIME_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.GREEN_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.CYAN_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.LIGHT_BLUE_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.BLUE_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.PURPLE_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.MAGENTA_FROSTED_GLASS, "translucent");
        blockWithItem(ArtistryBlocks.PINK_FROSTED_GLASS, "translucent");

        stringLights(ArtistryBlocks.STRING_LIGHTS.get());
        wallStringLights(ArtistryBlocks.WALL_STRING_LIGHTS.get());

        largeLantern(ArtistryBlocks.LARGE_LANTERN);
        largeLantern(ArtistryBlocks.LARGE_SOUL_LANTERN);
        roundLantern(ArtistryBlocks.ROUND_LANTERN);
        directionalBlock(ArtistryBlocks.FLAT_LIGHT.get(), models().getExistingFile(Artistry.location("block/flat_light")));

        bloomingVines(ArtistryBlocks.BLOOMING_VINES);
        /*getVariantBuilder(ArtistryBlocks.LUSH_FERN.get())
                .partialState().addModels(ConfiguredModel.builder().modelFile(
                        models().getExistingFile(Artistry.location("block/lush_fern"))
                ).buildLast());*/
        simpleBlock(ArtistryBlocks.LUSH_FERN.get(), models().getExistingFile(Artistry.location("block/lush_fern")));
        lushFernCropBlock(ArtistryBlocks.LUSH_FERN_CROP.get());
        teardropGrassBlock(ArtistryBlocks.TEARDROP_GRASS_BLOCK.get());
        crossBlockWithRenderType(ArtistryBlocks.SHORT_TEARDROP_GRASS.get(), "cutout");
        doublePlantBlock(ArtistryBlocks.TALL_TEARDROP_GRASS.get(), "cutout");
        pottedCrossPlantBlock(ArtistryBlocks.POTTED_TEARDROP_GRASS, Artistry.location("block/potted_teardrop_grass"));
        corpseFlowerBlock(ArtistryBlocks.CORPSE_FLOWER.get());
        flyLureBlock(ArtistryBlocks.FLY_LURE.get());
        simpleBlock(ArtistryBlocks.SPIRAL_FUNGUS.get(), models().getExistingFile(Artistry.location("block/spiral_fungus")));

        axisBlock(ArtistryBlocks.COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/copper_chain")));
        axisBlock(ArtistryBlocks.EXPOSED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/exposed_copper_chain")));
        axisBlock(ArtistryBlocks.WEATHERED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/weathered_copper_chain")));
        axisBlock(ArtistryBlocks.OXIDIZED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/oxidized_copper_chain")));

        axisBlock(ArtistryBlocks.WAXED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/copper_chain")));
        axisBlock(ArtistryBlocks.WAXED_EXPOSED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/exposed_copper_chain")));
        axisBlock(ArtistryBlocks.WAXED_WEATHERED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/weathered_copper_chain")));
        axisBlock(ArtistryBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get(), models().getExistingFile(Artistry.location("block/oxidized_copper_chain")));

        blockWithItem(ArtistryBlocks.ROCKY_DIRT);

        particlesOnly(ArtistryBlocks.PAINTED_POT.get(), blockTexture(Blocks.TERRACOTTA));

        ResourceLocation calciteTexture = blockTexture(Blocks.CALCITE);
        ResourceLocation smoothCalciteTexture = blockTexture(ArtistryBlocks.SMOOTH_CALCITE.get());
        ResourceLocation polishedCalciteTexture = blockTexture(ArtistryBlocks.POLISHED_CALCITE.get());
        ResourceLocation calciteBrickTexture = blockTexture(ArtistryBlocks.CALCITE_BRICKS.get());
        ResourceLocation smallCalciteBrickTexture = blockTexture(ArtistryBlocks.SMALL_CALCITE_BRICKS.get());

        stairsBlock(ArtistryBlocks.CALCITE_STAIRS.get(), calciteTexture);
        slabBlock(ArtistryBlocks.CALCITE_SLAB.get(), calciteTexture, calciteTexture);
        wallBlock(ArtistryBlocks.CALCITE_WALL.get(), calciteTexture);

        blockWithItem(ArtistryBlocks.SMOOTH_CALCITE);
        stairsBlock(ArtistryBlocks.SMOOTH_CALCITE_STAIRS.get(), smoothCalciteTexture);
        slabBlock(ArtistryBlocks.SMOOTH_CALCITE_SLAB.get(), smoothCalciteTexture, smoothCalciteTexture);

        blockWithItem(ArtistryBlocks.POLISHED_CALCITE);
        blockWithItem(ArtistryBlocks.CHISELED_CALCITE);
        stairsBlock(ArtistryBlocks.POLISHED_CALCITE_STAIRS.get(), polishedCalciteTexture);
        slabBlock(ArtistryBlocks.POLISHED_CALCITE_SLAB.get(), polishedCalciteTexture, polishedCalciteTexture);
        wallBlock(ArtistryBlocks.POLISHED_CALCITE_WALL.get(), polishedCalciteTexture);

        blockWithItem(ArtistryBlocks.CALCITE_BRICKS);
        stairsBlock(ArtistryBlocks.CALCITE_BRICK_STAIRS.get(), calciteBrickTexture);
        slabBlock(ArtistryBlocks.CALCITE_BRICK_SLAB.get(), calciteBrickTexture, calciteBrickTexture);
        wallBlock(ArtistryBlocks.CALCITE_BRICK_WALL.get(), calciteBrickTexture);

        ResourceLocation smallCalciteBrickTopTexture = blockTexture(ArtistryBlocks.SMALL_CALCITE_BRICKS.get()).withSuffix("_top");
        cubeColumn(ArtistryBlocks.SMALL_CALCITE_BRICKS.get());
        stairsBlock(ArtistryBlocks.SMALL_CALCITE_BRICK_STAIRS.get(), smallCalciteBrickTexture, smallCalciteBrickTopTexture, smallCalciteBrickTopTexture);
        slabBlock(ArtistryBlocks.SMALL_CALCITE_BRICK_SLAB.get(), smallCalciteBrickTexture, smallCalciteBrickTexture, smallCalciteBrickTopTexture, smallCalciteBrickTopTexture);

        blockWithItem(ArtistryBlocks.PAINTED_SMOOTH_CALCITE);
        blockWithItem(ArtistryBlocks.PAINTED_POLISHED_CALCITE);
        blockWithItem(ArtistryBlocks.PAINTED_CALCITE_BRICKS);
        cubeColumn(ArtistryBlocks.PAINTED_SMALL_CALCITE_BRICKS.get());

        ResourceLocation dripstoneTexture = blockTexture(Blocks.DRIPSTONE_BLOCK);
        ResourceLocation polishedDripstoneTexture = blockTexture(ArtistryBlocks.POLISHED_DRIPSTONE.get());
        ResourceLocation dripstoneBrickTexture = blockTexture(ArtistryBlocks.DRIPSTONE_BRICKS.get());

        stairsBlock(ArtistryBlocks.DRIPSTONE_STAIRS.get(), dripstoneTexture);
        slabBlock(ArtistryBlocks.DRIPSTONE_SLAB.get(), dripstoneTexture, dripstoneTexture);
        wallBlock(ArtistryBlocks.DRIPSTONE_WALL.get(), dripstoneTexture);

        blockWithItem(ArtistryBlocks.POLISHED_DRIPSTONE);
        blockWithItem(ArtistryBlocks.CHISELED_DRIPSTONE);
        stairsBlock(ArtistryBlocks.POLISHED_DRIPSTONE_STAIRS.get(), polishedDripstoneTexture);
        slabBlock(ArtistryBlocks.POLISHED_DRIPSTONE_SLAB.get(), polishedDripstoneTexture, polishedDripstoneTexture);
        wallBlock(ArtistryBlocks.POLISHED_DRIPSTONE_WALL.get(), polishedDripstoneTexture);

        blockWithItem(ArtistryBlocks.DRIPSTONE_BRICKS);
        stairsBlock(ArtistryBlocks.DRIPSTONE_BRICK_STAIRS.get(), dripstoneBrickTexture);
        slabBlock(ArtistryBlocks.DRIPSTONE_BRICK_SLAB.get(), dripstoneBrickTexture, dripstoneBrickTexture);
        wallBlock(ArtistryBlocks.DRIPSTONE_BRICK_WALL.get(), dripstoneBrickTexture);

        // Aspen Wood

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

        pottedCrossPlantBlock(ArtistryBlocks.POTTED_ASPEN_SAPLING);

        stairsBlock(ArtistryBlocks.ASPEN_STAIRS.get(), aspenPlanksTexture);
        slabBlock(ArtistryBlocks.ASPEN_SLAB.get(), aspenPlanksTexture, aspenPlanksTexture);
        buttonBlock(ArtistryBlocks.ASPEN_BUTTON.get(), aspenPlanksTexture);
        pressurePlateBlock(ArtistryBlocks.ASPEN_PRESSURE_PLATE.get(), aspenPlanksTexture);
        fenceBlock(ArtistryBlocks.ASPEN_FENCE.get(), aspenPlanksTexture);
        fenceGateBlock(ArtistryBlocks.ASPEN_FENCE_GATE.get(), aspenPlanksTexture);

        doorBlockWithRenderType(ArtistryBlocks.ASPEN_DOOR.get(), modLoc("block/aspen_door_bottom"), modLoc("block/aspen_door_top"), "cutout");
        trapdoorBlockWithRenderType(ArtistryBlocks.ASPEN_TRAPDOOR.get(), modLoc("block/aspen_trapdoor"), true, "cutout");

        crossBlockWithRenderType(ArtistryBlocks.ASPEN_SAPLING.get(), "cutout");

        // Woven Wood

        leavesBlock(ArtistryBlocks.WOVEN_LEAVES, "cutout_mipped");

        ResourceLocation wovenLogTexture = blockTexture(ArtistryBlocks.WOVEN_LOG.get());
        ResourceLocation strippedWovenLogTexture = blockTexture(ArtistryBlocks.STRIPPED_WOVEN_LOG.get());
        ResourceLocation wovenPlanksTexture = blockTexture(ArtistryBlocks.WOVEN_PLANKS.get());

        logBlock(ArtistryBlocks.WOVEN_LOG.get());
        axisBlock(ArtistryBlocks.WOVEN_WOOD.get(), wovenLogTexture, wovenLogTexture);
        logBlock(ArtistryBlocks.STRIPPED_WOVEN_LOG.get());
        axisBlock(ArtistryBlocks.STRIPPED_WOVEN_WOOD.get(), strippedWovenLogTexture, strippedWovenLogTexture);

        blockWithItem(ArtistryBlocks.WOVEN_PLANKS);


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

    public void axisBlock(RotatedPillarBlock block, ModelFile model) {
        this.axisBlock(block, model, model);
    }

    private void particlesOnly(Block block, ResourceLocation particle) {
        ModelFile model = models().getBuilder(name(block)).texture("particle", particle);
        this.simpleBlock(block, model);
    }

    private void cubeColumn(Block block) {
        ModelFile modelFile = models().cubeColumn(name(block), blockTexture(block), blockTexture(block).withSuffix("_top"));
        simpleBlockWithItem(block, modelFile);
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
