package net.jayushinatta.bagelsiege.block;

import net.jayushinatta.bagelsiege.BagelSiege;
import net.jayushinatta.bagelsiege.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

// this class is specifically just for registering normal custom blocks
// will have any blocks with unique interactions in their own class
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BagelSiege.MODID);

    public static final RegistryObject<Block> CRUMBLED_BAGEL_BLOCK = registerBlock("crumbled_bagel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> HARD_CRUMBLED_BAGEL = registerBlock("hard_crumbled_bagel",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> BAGELSTAR_ORE = registerBlock("bagelstar_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.DEEPSLATE)));

    // registry method used to allow the block to register correctly
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn =BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
