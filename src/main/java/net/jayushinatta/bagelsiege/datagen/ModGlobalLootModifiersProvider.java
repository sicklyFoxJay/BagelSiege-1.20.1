package net.jayushinatta.bagelsiege.datagen;

import net.jayushinatta.bagelsiege.BagelSiege;
import net.jayushinatta.bagelsiege.item.ModItems;
import net.jayushinatta.bagelsiege.loot.AddItemModifier;
import net.jayushinatta.bagelsiege.loot.AddSusSandItemModifier;
import net.jayushinatta.bagelsiege.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, BagelSiege.MODID);
    }

    @Override
    protected void start() {
   //     add("wheat_from_bagel_grass", new AddItemModifier(new LootItemCondition[] {
   //             LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
   //             LootItemRandomChanceCondition.randomChance(0.35f).build()}, Items.WHEAT));
//
   //     add("wheat_from_creeper", new AddItemModifier(new LootItemCondition[] {
   //             new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build() }, Items.WHEAT));
           add("bagel_from_butcher", new AddItemModifier(new LootItemCondition[] {
                   new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_butcher")).build(),
                       LootItemRandomChanceCondition.randomChance(0.95f)
                               .build()}, ModItems.BAGEL.get()));
           add("bagel_from_plains_house", new AddItemModifier(new LootItemCondition[] {
                   new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                       LootItemRandomChanceCondition.randomChance(0.95f)
                               .build()}, ModItems.BAGEL.get()));
           add("bagel_from_savanna_house", new AddItemModifier(new LootItemCondition[] {
                   new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_savanna_house")).build(),
                       LootItemRandomChanceCondition.randomChance(0.95f)
                               .build()}, ModItems.BAGEL.get()));
           add("bagel_from_snowy_house", new AddItemModifier(new LootItemCondition[] {
                   new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_snowy_house")).build(),
                       LootItemRandomChanceCondition.randomChance(0.95f)
                               .build()}, ModItems.BAGEL.get()));
           add("bagel_from_taiga_house", new AddItemModifier(new LootItemCondition[] {
                   new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_taiga_house")).build(),
                       LootItemRandomChanceCondition.randomChance(0.95f)
                               .build()}, ModItems.BAGEL.get()));
           add("bagel_from_sus_sand", new AddSusSandItemModifier(new LootItemCondition[] {
                   new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_pyramid"))
                           .build()}, ModItems.BAGEL.get()));

    }
}
