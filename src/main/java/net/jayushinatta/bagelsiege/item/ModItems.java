package net.jayushinatta.bagelsiege.item;

import net.jayushinatta.bagelsiege.BagelSiege;
import net.jayushinatta.bagelsiege.item.custom.ModArmorItem;
import net.jayushinatta.bagelsiege.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BagelSiege.MODID);

    public static final RegistryObject<Item> BAGEL = ITEMS.register("bagel",
            () -> new Item(new Item.Properties().food(ModFoods.BAGEL)));

    public static final RegistryObject<Item> BAGELSTAR = ITEMS.register("bagelstar",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAWBAGEL = ITEMS.register("rawbagel",
            () -> new Item(new Item.Properties().food(ModFoods.RAWBAGEL)));
    public static final RegistryObject<Item> BAGEL_MUSIC_MUSIC_DISC = ITEMS.register("bagel_music_music_disc",
            () -> new RecordItem(6, ModSounds.BAGEL_MUSIC, new Item.Properties().stacksTo(1), 2340));

    public static final RegistryObject<Item> BAGEL_HELMET = ITEMS.register("bagel_helmet",
            () -> new ModArmorItem(ModArmorMaterials.BAGEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BAGEL_CHESTPLATE =ITEMS.register("bagel_chestplate",
            () -> new ArmorItem(ModArmorMaterials.BAGEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BAGEL_LEGGINGS =ITEMS.register("bagel_leggings",
            () -> new ArmorItem(ModArmorMaterials.BAGEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BAGEL_BOOTS =ITEMS.register("bagel_boots",
            () -> new ArmorItem(ModArmorMaterials.BAGEL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> BAGEL_SWORD =ITEMS.register("bagel_sword",
            () -> new SwordItem(ModToolTiers.BAGEL, 6, 4, new Item.Properties()));
    public static final RegistryObject<Item> BAGEL_PICKAXE =ITEMS.register("bagel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BAGEL, 2, 2, new Item.Properties()));
    public static final RegistryObject<Item> BAGEL_AXE =ITEMS.register("bagel_axe",
            () -> new AxeItem(ModToolTiers.BAGEL, 9, 3, new Item.Properties()));
    public static final RegistryObject<Item> BAGEL_SHOVEL =ITEMS.register("bagel_shovel",
            () -> new ShovelItem(ModToolTiers.BAGEL, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> BAGEL_HOE =ITEMS.register("bagel_hoe",
            () -> new HoeItem(ModToolTiers.BAGEL, 1, 1, new Item.Properties()));




    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
