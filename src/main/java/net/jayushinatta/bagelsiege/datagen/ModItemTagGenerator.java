package net.jayushinatta.bagelsiege.datagen;

import net.jayushinatta.bagelsiege.BagelSiege;
import net.jayushinatta.bagelsiege.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {

    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, BagelSiege.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BAGEL_HELMET.get(),
                    ModItems.BAGEL_CHESTPLATE.get(),
                    ModItems.BAGEL_LEGGINGS.get(),
                    ModItems.BAGEL_BOOTS.get());

        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.BAGEL_MUSIC_MUSIC_DISC.get());

    }
}
