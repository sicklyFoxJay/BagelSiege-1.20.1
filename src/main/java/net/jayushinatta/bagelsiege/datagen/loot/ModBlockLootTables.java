package net.jayushinatta.bagelsiege.datagen.loot;

import net.jayushinatta.bagelsiege.block.ModBlocks;
import net.jayushinatta.bagelsiege.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // this.dropself = block drops itself in loot table
        this.dropSelf(ModBlocks.CRUMBLED_BAGEL_BLOCK.get());
        this.dropSelf(ModBlocks.HARD_CRUMBLED_BAGEL.get());
        // this.add in this context is being used to help create a custom loottable for bagelstar ore
        this.add(ModBlocks.BAGELSTAR_ORE.get(),
                block -> createBagelStarOreDrops(ModBlocks.BAGELSTAR_ORE.get(), ModItems.BAGELSTAR.get()));

    }
    //this is the loottable builder for bagelstar ore, subject to modification for balancing
    protected LootTable.Builder createBagelStarOreDrops(Block pBlock,Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
