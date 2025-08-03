package com.feliscape.artistry.content.block.entity;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.block.SparkFountainBlock;
import com.feliscape.artistry.registry.ArtistryBlockEntityTypes;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import com.feliscape.artistry.registry.ArtistryParticles;
import com.feliscape.artistry.util.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.FastColor;
import net.minecraft.util.FastColor.ARGB32;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SparkFountainBlockEntity extends BlockEntity {
    public static final int DEFAULT_SPARK_COLOR_RGB = 0xffe68a;
    public static final int DEFAULT_SPARK_COLOR = 0xffffe68a;
    private int color;

    public SparkFountainBlockEntity(BlockPos pos, BlockState blockState) {
        super(ArtistryBlockEntityTypes.SPARK_FOUNTAIN.get(), pos, blockState);
        color = DEFAULT_SPARK_COLOR_RGB;
    }

    @Override
    protected void applyImplicitComponents(DataComponentInput componentInput) {
        super.applyImplicitComponents(componentInput);
        var dyedItemColor = componentInput.get(DataComponents.DYED_COLOR);
        if (dyedItemColor == null){
            color = DEFAULT_SPARK_COLOR_RGB;
        } else{
            Artistry.LOGGER.debug("{}", dyedItemColor.rgb());
            color = removeAlpha(dyedItemColor.rgb());
            //color = dyedItemColor.rgb();
        }
    }

    private static int flattenAlpha(int color){
        return color | 0xFF000000;
    }

    private static int removeAlpha(int color){
        return color & 0xFFFFFF;
    }

    public ItemStack getAsItem() {
        ItemStack itemstack = ArtistryBlocks.SPARK_FOUNTAIN.asItem().getDefaultInstance();
        itemstack.applyComponents(this.collectComponents());
        return itemstack;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveCustomOnly(registries);
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        super.collectImplicitComponents(components);
        components.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("color", this.color);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.color = tag.getInt("color");
    }

    public int getColor(){
        return color;
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, SparkFountainBlockEntity fountain) {
        boolean powered = state.getValue(SparkFountainBlock.POWERED);
        if (powered) {
            RandomSource random = level.getRandom();
            for (int i = 0; i < 2; i++){
                double x = pos.getX() + 0.4375 + random.nextDouble() * 0.125;
                double z = pos.getZ() + 0.4375 + random.nextDouble() * 0.125;

                double theta = random.nextDouble() * Math.TAU;
                double xSpeed = Math.cos(theta) * 0.3D * RandomUtil.centeredDouble(random);
                double ySpeed = random.nextDouble() * 0.7D + 1.5D;
                double zSpeed = Math.sin(theta) * 0.3D * RandomUtil.centeredDouble(random);

                level.addParticle(ColorParticleOption.create(ArtistryParticles.SPARK.get(), flattenAlpha(fountain.color)),
                        x, pos.getY() + 1, z,
                        xSpeed, ySpeed, zSpeed);
            }
        }
    }
}
