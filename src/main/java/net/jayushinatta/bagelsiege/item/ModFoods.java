package net.jayushinatta.bagelsiege.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BAGEL = new FoodProperties.Builder()
            .alwaysEat()
            .fast()
            .saturationMod(2)
            .nutrition(8)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2000), 0.1f)
            .build();

    public static final FoodProperties RAWBAGEL = new FoodProperties.Builder()
            .alwaysEat()
            .saturationMod(0.5f)
            .nutrition(4)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200), 0.1f)
            .build();

    public static final FoodProperties BAGEL_HELMET = new FoodProperties.Builder()
            .meat()
            .alwaysEat()
            .fast()
            .saturationMod(2)
            .nutrition(8)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600), 1f)
            .build();

    public static final FoodProperties BAGEL_CHESTPLATE = new FoodProperties.Builder()
            .alwaysEat()
            .fast()
            .saturationMod(2)
            .nutrition(8)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600), 1f)
            .build();

    public static final FoodProperties BAGEL_LEGGINGS = new FoodProperties.Builder()
            .alwaysEat()
            .fast()
            .saturationMod(2)
            .nutrition(8)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600), 1f)
            .build();

    public static final FoodProperties BAGEL_BOOTS = new FoodProperties.Builder()
            .alwaysEat()
            .fast()
            .saturationMod(2)
            .nutrition(8)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600), 1f)
            .build();
}
