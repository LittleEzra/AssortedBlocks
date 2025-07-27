package com.feliscape.artistry.data.datagen;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.data.datagen.language.ArtistryDeDeProvider;
import com.feliscape.artistry.data.datagen.language.ArtistryEnUsProvider;
import com.feliscape.artistry.data.datagen.loot.ArtistryBlockLootTableProvider;
import com.feliscape.artistry.data.datagen.loot.ArtistryGlobalLootModifierProvider;
import com.feliscape.artistry.data.datagen.map.ArtistryDataMapProvider;
import com.feliscape.artistry.data.datagen.model.ArtistryBlockModelProvider;
import com.feliscape.artistry.data.datagen.model.ArtistryItemModelProvider;
import com.feliscape.artistry.data.datagen.recipe.ArtistryRecipeProvider;
import com.feliscape.artistry.data.datagen.tag.ArtistryBlockTagGenerator;
import com.feliscape.artistry.data.datagen.tag.ArtistryDamageTypeTagGenerator;
import com.feliscape.artistry.data.datagen.tag.ArtistryItemTagGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Artistry.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();



        ArtistryGeneratedEntries generatedEntries = new ArtistryGeneratedEntries(packOutput, lookupProvider);
        lookupProvider = generatedEntries.getRegistryProvider();
        generator.addProvider(true, generatedEntries);

        generator.addProvider(true, new ArtistryRecipeProvider(packOutput, lookupProvider));

        var blockTags = new ArtistryBlockTagGenerator(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(true, blockTags);
        generator.addProvider(true, new ArtistryItemTagGenerator(packOutput, lookupProvider, blockTags.contentsGetter()));
        generator.addProvider(true, new ArtistryDamageTypeTagGenerator(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(true, new ArtistryDataMapProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeServer(), new ArtistryGlobalLootModifierProvider(packOutput, lookupProvider));

        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ArtistryBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        generator.addProvider(true, new ArtistryBlockModelProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new ArtistryItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(true, new ArtistryEnUsProvider(packOutput));
        generator.addProvider(true, new ArtistryDeDeProvider(packOutput));
    }
}
