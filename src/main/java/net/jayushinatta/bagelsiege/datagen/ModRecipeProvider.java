package net.jayushinatta.bagelsiege.datagen;

import net.jayushinatta.bagelsiege.BagelSiege;
import net.jayushinatta.bagelsiege.block.ModBlocks;
import net.jayushinatta.bagelsiege.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmokingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
//    this is an example of how we're making a new recipe .json for cookable/smeltable items and blocks.
//    we make a List<ItemLike> to create a list for the items to make a recipe for in that recipe category.
//    private static final List<ItemLike> BAGEL_SMELTABLES = List.of(ModItems.RAWBAGEL.get(),
//            ModBlocks.BAGELSTAR_ORE.get());

    private static final List<ItemLike> BAGEL_ORE_SMELTABLES = List.of(ModBlocks.BAGELSTAR_ORE.get());
    private static final List<ItemLike> BAGEL_SMELTABLES = List.of(ModItems.RAWBAGEL.get());

    private static final List<ItemLike> BAGEL = List.of(ModItems.RAWBAGEL.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {



        // for the cooking/smelting recipes you need: pWriter, List, Category, Item returned, Exp Gained, Cook Time, Group
        oreBlasting(pWriter, BAGEL_ORE_SMELTABLES, RecipeCategory.MISC, ModItems.BAGELSTAR.get(), 0.25f,
                100, "bagelstar");
        oreSmelting(pWriter, BAGEL_ORE_SMELTABLES, RecipeCategory.MISC, ModItems.BAGELSTAR.get(), 0.25f,
                200, "bagelstar");
        oreSmelting(pWriter, BAGEL_SMELTABLES, RecipeCategory.MISC, ModItems.BAGEL.get(), 0.25f,
                200, "bagel");



        // for the smoking recipes you need: (Ingredient.of([Item used in recipe].get()*), Category, Item received from recipe,
        // exp, cooking time, RecipeSerializer.SMOKING_RECIPE)
        // .group("[whatever name you decided for group]")
        // .unlockedBy(getHasName([what item name to unlock recipe in recipe].get()*),
        //        has([item name from previous or which ever item you choose].get()*)
        // .save(pWriter, BagelSiege.MODID + ":" + getItemName([what item is being obtained from recipe].get()*)
        //                                 + _from_smoking" + "_" + getItemName([what item is used in recipe].get()*));
        //  *.get() is only necessary for items being called that are not vanilla. vanilla items can use Items.[vanillaItem] instead.
        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItems.RAWBAGEL.get()), RecipeCategory.MISC,
                        ModItems.BAGEL.get(), 0.25f, 100, RecipeSerializer.SMOKING_RECIPE)
                .group("bagel")
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(pWriter, BagelSiege.MODID + ":" + getItemName(ModItems.BAGEL.get()) + "_from_smoking" + "_" + getItemName(ModItems.RAWBAGEL.get()));



        //  this example makes a shaped recipe for crumbled bagel
        //  the builder specifies a shaped recipe: Category, Item/Block obtained after craft
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRUMBLED_BAGEL_BLOCK.get())
                 .pattern("BBB")
                 .pattern("BBB")
                 .pattern("BBB")
                 .define('B', ModItems.BAGEL.get())
                 .unlockedBy(getHasName(ModItems.BAGEL.get()), has(ModItems.BAGEL.get()))
                 .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAWBAGEL.get(), 8)
                .pattern("WSW")
                .pattern("EBE")
                .pattern("WWW")
                .define('E', Tags.Items.EGGS)
                .define( 'W', Items.WHEAT)
                .define( 'S', Items.WHEAT_SEEDS)
                .define('B', Items.WATER_BUCKET)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BAGEL_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .define( 'S', ModItems.BAGELSTAR.get())
                .unlockedBy(getHasName(ModItems.BAGEL.get()), has(ModItems.BAGEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BAGEL_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define( 'S', ModItems.BAGELSTAR.get())
                .unlockedBy(getHasName(ModItems.BAGEL.get()), has(ModItems.BAGEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BAGEL_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define( 'S', ModItems.BAGELSTAR.get())
                .unlockedBy(getHasName(ModItems.BAGEL.get()), has(ModItems.BAGEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BAGEL_BOOTS.get())
                .pattern("S S")
                .pattern("S S")
                .define( 'S', ModItems.BAGELSTAR.get())
                .unlockedBy(getHasName(ModItems.BAGEL.get()), has(ModItems.BAGEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BAGEL_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" H ")
                .define( 'S', ModItems.BAGELSTAR.get())
                .define('H', Items.STICK)
                .unlockedBy(getHasName(ModItems.BAGEL.get()), has(ModItems.BAGEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BAGEL_AXE.get())
                .pattern("SS ")
                .pattern("SH ")
                .pattern(" H ")
                .define( 'S', ModItems.BAGELSTAR.get())
                .define('H', Items.STICK)
                .unlockedBy(getHasName(ModItems.BAGEL.get()), has(ModItems.BAGEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BAGEL_PICKAXE.get())
                .pattern("SSS")
                .pattern(" H ")
                .pattern(" H ")
                .define( 'S', ModItems.BAGELSTAR.get())
                .define('H', Items.STICK)
                .unlockedBy(getHasName(ModItems.BAGEL.get()), has(ModItems.BAGEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BAGEL_SHOVEL.get())
                .pattern(" S ")
                .pattern(" H ")
                .pattern(" H ")
                .define( 'S', ModItems.BAGELSTAR.get())
                .define('H', Items.STICK)
                .unlockedBy(getHasName(ModItems.BAGEL.get()), has(ModItems.BAGEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BAGEL_HOE.get())
                .pattern("SS ")
                .pattern(" H ")
                .pattern(" H ")
                .define( 'S', ModItems.BAGELSTAR.get())
                .define('H', Items.STICK)
                .unlockedBy(getHasName(ModItems.BAGEL.get()), has(ModItems.BAGEL.get()))
                .save(pWriter);

        //  the shapeless version is essentially the same, but there is no .pattern included in the builder
        //  in either recipe you can include a count for the amount of an item you get from the recipe in the first line
        //  should look something like this
        //  ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.BAGEL.get(), 9)
        //          .requires(ModBlocks.CRUMBLED_BAGEL_BLOCK.get())
        //          .unlockedBy(getHasName(ModBlocks.CRUMBLED_BAGEL_BLOCK.get()), has(ModItems.BAGEL.get()))
        //          .save(pWriter);
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme,
                                      String pGroup) {oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE,
            pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime,
                                      String pGroup) {oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE,
            pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<?
            extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory,
                                     ItemLike pResult, float pExperience, int pCookingTime, String pGroup,
                                     String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory,
                pResult, pExperience, pCookingTime, pCookingSerializer)
                .group(pGroup)
                .unlockedBy(getHasName(itemlike),
                has(itemlike))
                .save(pFinishedRecipeConsumer,
                BagelSiege.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}