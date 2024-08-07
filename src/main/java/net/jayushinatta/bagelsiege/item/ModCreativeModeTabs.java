package net.jayushinatta.bagelsiege.item;

import net.jayushinatta.bagelsiege.BagelSiege;
import net.jayushinatta.bagelsiege.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
//this class is where everything in the mod gets registered to the custom creative mode tab
public class ModCreativeModeTabs {
    //method used to create custom creative tab
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BagelSiege.MODID);
//method used to add mod blocks,items,etc to custom creative tab
public static final RegistryObject<CreativeModeTab> BAGELSIEGE_TAB = CREATIVE_MODE_TABS.register("bagelsiege_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BAGEL.get()))
                .title(Component.translatable("creativetab.bagelsiege_tab"))
                .displayItems((pParameters, pOutput) -> {
                    //all mod items added to tab here
                    pOutput.accept(ModItems.BAGEL.get());
                    pOutput.accept(ModItems.RAWBAGEL.get());
                    pOutput.accept(ModItems.BAGELSTAR.get());
                    pOutput.accept(ModItems.BAGEL_MUSIC_MUSIC_DISC.get());
                    //all mod armor added to tab here
                    pOutput.accept(ModItems.BAGEL_HELMET.get());
                    pOutput.accept(ModItems.BAGEL_CHESTPLATE.get());
                    pOutput.accept(ModItems.BAGEL_LEGGINGS.get());
                    pOutput.accept(ModItems.BAGEL_BOOTS.get());
                    //all mod tools added to tab here
                    pOutput.accept(ModItems.BAGEL_SWORD.get());
                    pOutput.accept(ModItems.BAGEL_AXE.get());
                    pOutput.accept(ModItems.BAGEL_PICKAXE.get());
                    pOutput.accept(ModItems.BAGEL_SHOVEL.get());
                    pOutput.accept(ModItems.BAGEL_HOE.get());
                    //all mod blocks added to tab here
                    pOutput.accept(ModBlocks.CRUMBLED_BAGEL_BLOCK.get());
                    pOutput.accept(ModBlocks.BAGELSTAR_ORE.get());
                    pOutput.accept(ModBlocks.HARD_CRUMBLED_BAGEL.get());

                })
                .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
