package com.feliscape.artistry.content.block.entity;

import com.feliscape.artistry.content.pot.PaintedPotDecorations;
import com.feliscape.artistry.data.pot.ArtistryPaintedPotDecorations;
import com.feliscape.artistry.data.pot.PaintedPotDecoration;
import com.feliscape.artistry.data.registry.ArtistryDatapackRegistries;
import com.feliscape.artistry.registry.ArtistryBlockEntityTypes;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.RandomizableContainer;
import net.minecraft.world.entity.animal.WolfVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.ticks.ContainerSingleItem;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class PaintedPotBlockEntity extends BlockEntity implements RandomizableContainer, ContainerSingleItem.BlockContainerSingleItem {
    public long wobbleStartedAtTick;
    @Nullable
    public DecoratedPotBlockEntity.WobbleStyle lastWobbleStyle;
    private PaintedPotDecorations decorations;
    private ItemStack item;
    @Nullable
    protected ResourceKey<LootTable> lootTable;
    protected long lootTableSeed;


    public PaintedPotBlockEntity(BlockPos pos, BlockState state) {
        super(ArtistryBlockEntityTypes.PAINTED_POT.get(), pos, state);
        this.item = ItemStack.EMPTY;
        this.decorations = PaintedPotDecorations.EMPTY;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        this.decorations.save(tag);
        if (!this.trySaveLootTable(tag) && !this.item.isEmpty()) {
            tag.put("item", this.item.save(registries));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.decorations = PaintedPotDecorations.load(tag);
        if (!this.tryLoadLootTable(tag)) {
            if (tag.contains("item", 10)) {
                this.item = (ItemStack)ItemStack.parse(registries, tag.getCompound("item")).orElse(ItemStack.EMPTY);
            } else {
                this.item = ItemStack.EMPTY;
            }
        }
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveCustomOnly(registries);
    }

    public Direction getDirection() {
        return (Direction)this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
    }

    public PaintedPotDecorations getDecorations(){
        return decorations;
    }

    public boolean paintBase(ItemStack itemStack){
        Optional<DyeColor> newColor = Optional.empty();
        DyeColor dyeColor = DyeColor.getColor(itemStack);
        if (dyeColor == this.decorations.base().orElse(null)){
            return false;
        }

        if (dyeColor != null){
            newColor = Optional.of(dyeColor);
        }
        this.decorations = new PaintedPotDecorations(newColor,
                this.decorations.trim(), this.decorations.trimColor(),
                this.decorations.pattern(), this.decorations.patternColor());

        this.setChanged();
        if (level != null)
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
        return true;
    }

    public boolean paintTrim(ItemStack itemStack) {
        if (itemStack.is(Items.SPONGE)){
            this.decorations = new PaintedPotDecorations(this.decorations.base(),
                    Optional.empty(), -1,
                    this.decorations.pattern(), this.decorations.patternColor());

            this.setChanged();
            if (level != null)
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
            return true;
        }

        int color = DyeColor.getColor(itemStack).getTextureDiffuseColor();
        ResourceKey<PaintedPotDecoration> trim;

        if (this.decorations.trim().isEmpty()){
            trim = ArtistryPaintedPotDecorations.WAVY_TRIM;
        } else if (this.decorations.trimColor() == color){
            trim = this.decorations.trim().get();
            if (level != null) {
                var registry = level.registryAccess().registryOrThrow(ArtistryDatapackRegistries.PAINTED_POT_TRIM);
                var list = registry.stream().toList();

                var optional = registry.getResourceKey(list.get((list.indexOf(registry.getOrThrow(trim)) + 1) % list.size())); // try to cycle through the registry
                if (optional.isPresent()){
                    trim = optional.get();
                }
            }
        } else {
            trim = this.decorations.trim().get();
        }

        this.decorations = new PaintedPotDecorations(this.decorations.base(),
                Optional.of(trim), color,
                this.decorations.pattern(), this.decorations.patternColor());

        this.setChanged();
        if (level != null)
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
        return true;
    }

    public boolean paintPattern(ItemStack itemStack) {
        if (itemStack.is(Items.SPONGE)){
            this.decorations = new PaintedPotDecorations(this.decorations.base(),
                    this.decorations.trim(), this.decorations.trimColor(),
                    Optional.empty(), -1);
            this.setChanged();
            if (level != null)
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
            return true;
        }

        int color = DyeColor.getColor(itemStack).getTextureDiffuseColor();
        ResourceKey<PaintedPotDecoration> pattern;

        if (this.decorations.pattern().isEmpty()){
            pattern = ArtistryPaintedPotDecorations.FREQUENCY_PATTERN;
        } else if (this.decorations.patternColor() == color){
            pattern = this.decorations.pattern().get();
            if (level != null) {
                var registry = level.registryAccess().registryOrThrow(ArtistryDatapackRegistries.PAINTED_POT_PATTERN);
                var list = registry.stream().toList();

                var optional = registry.getResourceKey(list.get((list.indexOf(registry.getOrThrow(pattern)) + 1) % list.size())); // try to cycle through the registry
                if (optional.isPresent()){
                    pattern = optional.get();
                }
            }
        } else {
            pattern = this.decorations.pattern().get();
        }

        this.decorations = new PaintedPotDecorations(this.decorations.base(),
                this.decorations.trim(), this.decorations.trimColor(),
                Optional.of(pattern), color);

        this.setChanged();
        if (level != null)
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
        return true;
    }

    public void setFromItem(ItemStack item) {
        this.applyComponentsFromItemStack(item);
    }

    public ItemStack getPotAsItem() {
        ItemStack itemstack = ArtistryItems.PAINTED_POT.get().getDefaultInstance();
        itemstack.applyComponents(this.collectComponents());
        return itemstack;
    }

    public static ItemStack createDecoratedPotItem(PaintedPotDecorations decorations) {
        ItemStack itemstack = ArtistryItems.PAINTED_POT.get().getDefaultInstance();
        itemstack.set(PaintedPotDecorations.type(), decorations);
        return itemstack;
    }

    @Nullable
    public ResourceKey<LootTable> getLootTable() {
        return this.lootTable;
    }

    public void setLootTable(@Nullable ResourceKey<LootTable> lootTable) {
        this.lootTable = lootTable;
    }

    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    public void setLootTableSeed(long seed) {
        this.lootTableSeed = seed;
    }

    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        super.collectImplicitComponents(components);
        components.set(PaintedPotDecorations.type(), this.decorations);
        components.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(List.of(this.item)));
    }

    protected void applyImplicitComponents(BlockEntity.DataComponentInput componentInput) {
        super.applyImplicitComponents(componentInput);
        this.decorations = componentInput.getOrDefault(PaintedPotDecorations.type(), PaintedPotDecorations.EMPTY);
        this.item = ((ItemContainerContents)componentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY)).copyOne();
    }

    public void removeComponentsFromTag(CompoundTag tag) {
        super.removeComponentsFromTag(tag);
        tag.remove("layers");
        tag.remove("item");
    }

    public ItemStack getTheItem() {
        this.unpackLootTable((Player)null);
        return this.item;
    }

    public ItemStack splitTheItem(int amount) {
        this.unpackLootTable((Player)null);
        ItemStack itemstack = this.item.split(amount);
        if (this.item.isEmpty()) {
            this.item = ItemStack.EMPTY;
        }

        return itemstack;
    }

    public void setTheItem(ItemStack item) {
        this.unpackLootTable((Player)null);
        this.item = item;
    }

    public BlockEntity getContainerBlockEntity() {
        return this;
    }

    public void wobble(DecoratedPotBlockEntity.WobbleStyle style) {
        if (this.level != null && !this.level.isClientSide()) {
            this.level.blockEvent(this.getBlockPos(), this.getBlockState().getBlock(), 1, style.ordinal());
        }

    }

    public boolean triggerEvent(int id, int type) {
        if (this.level != null && id == 1 && type >= 0 && type < DecoratedPotBlockEntity.WobbleStyle.values().length) {
            this.wobbleStartedAtTick = this.level.getGameTime();
            this.lastWobbleStyle = DecoratedPotBlockEntity.WobbleStyle.values()[type];
            return true;
        } else {
            return super.triggerEvent(id, type);
        }
    }
}
