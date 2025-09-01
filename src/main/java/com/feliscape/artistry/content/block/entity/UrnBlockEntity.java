package com.feliscape.artistry.content.block.entity;

import com.feliscape.artistry.registry.ArtistryBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.RandomizableContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.ticks.ContainerSingleItem;

import javax.annotation.Nullable;

public class UrnBlockEntity extends BlockEntity implements RandomizableContainer, ContainerSingleItem.BlockContainerSingleItem{
    public long wobbleStartedAtTick;
    @Nullable
    public WobbleStyle lastWobbleStyle;
    private ItemStack item = ItemStack.EMPTY;
    @Nullable
    protected ResourceKey<LootTable> lootTable;
    protected long lootTableSeed;

    public UrnBlockEntity(BlockPos pos, BlockState blockState) {
        super(ArtistryBlockEntityTypes.URN.get(), pos, blockState);
    }
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!this.trySaveLootTable(tag) && !this.item.isEmpty()) {
            tag.put("item", this.item.save(registries));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (!this.tryLoadLootTable(tag)) {
            if (tag.contains("item", 10)) {
                this.item = ItemStack.parse(registries, tag.getCompound("item")).orElse(ItemStack.EMPTY);
            } else {
                this.item = ItemStack.EMPTY;
            }
        }
    }

    public Direction getDirection() {
        return (Direction)this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public ResourceKey<LootTable> getLootTable() {
        return this.lootTable;
    }

    @Override
    public void setLootTable(@Nullable ResourceKey<LootTable> lootTable) {
        this.lootTable = lootTable;
    }

    @Override
    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    @Override
    public void setLootTableSeed(long seed) {
        this.lootTableSeed = seed;
    }

    @Override
    public BlockEntity getContainerBlockEntity() {
        return this;
    }

    @Override
    public ItemStack getTheItem() {
        this.unpackLootTable(null);
        return this.item;
    }

    @Override
    public ItemStack splitTheItem(int amount) {
        this.unpackLootTable(null);
        ItemStack itemstack = this.item.split(amount);
        if (this.item.isEmpty()) {
            this.item = ItemStack.EMPTY;
        }

        return itemstack;
    }

    public void wobble(WobbleStyle style) {
        if (this.level != null && !this.level.isClientSide()) {
            this.level.blockEvent(this.getBlockPos(), this.getBlockState().getBlock(), 1, style.ordinal());
        }
    }

    @Override
    public boolean triggerEvent(int id, int type) {
        if (this.level != null && id == 1 && type >= 0 && type < WobbleStyle.values().length) {
            this.wobbleStartedAtTick = this.level.getGameTime();
            this.lastWobbleStyle = WobbleStyle.values()[type];
            return true;
        } else {
            return super.triggerEvent(id, type);
        }
    }

    @Override
    public void setTheItem(ItemStack item) {
        this.unpackLootTable(null);
        this.item = item;
    }

    public static enum WobbleStyle {
        POSITIVE(7),
        NEGATIVE(10);

        public final int duration;

        private WobbleStyle(int duration) {
            this.duration = duration;
        }
    }
}
