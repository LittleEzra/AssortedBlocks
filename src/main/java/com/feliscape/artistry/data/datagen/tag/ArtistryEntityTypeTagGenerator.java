package com.feliscape.artistry.data.datagen.tag;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryEntityTypes;
import com.feliscape.artistry.registry.ArtistryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ArtistryEntityTypeTagGenerator extends EntityTypeTagsProvider {
    public ArtistryEntityTypeTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Artistry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ArtistryTags.EntityTypes.NOT_SCARED_OF_CORPSE_FLOWER)
                .add(EntityType.IRON_GOLEM)
                .add(EntityType.SNOW_GOLEM)
                .add(EntityType.SLIME)
                .add(EntityType.MAGMA_CUBE)
                // Piglins and Hoglins are handled separately, since they have this function built-in
                .add(EntityType.PIGLIN)
                .add(EntityType.HOGLIN)
                .addTag(Tags.EntityTypes.BOSSES)
        ;

        this.tag(Tags.EntityTypes.BOATS)
                .add(ArtistryEntityTypes.MOD_BOAT.get())
                .add(ArtistryEntityTypes.MOD_CHEST_BOAT.get());
    }
}
