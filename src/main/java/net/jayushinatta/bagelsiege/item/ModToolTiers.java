package net.jayushinatta.bagelsiege.item;

import net.jayushinatta.bagelsiege.BagelSiege;
import net.jayushinatta.bagelsiege.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier BAGEL = TierSortingRegistry.registerTier(
            new ForgeTier(5, 5000,15.0f,6.0f,25,
                    ModTags.Blocks.NEEDS_BAGEL_TOOL, () -> Ingredient.of(ModItems.BAGELSTAR.get())),
            new ResourceLocation(BagelSiege.MODID, "bagel"), List.of(Tiers.NETHERITE), List.of());
}
