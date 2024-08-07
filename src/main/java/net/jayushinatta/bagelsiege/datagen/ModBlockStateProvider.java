package net.jayushinatta.bagelsiege.datagen;

import net.jayushinatta.bagelsiege.BagelSiege;
import net.jayushinatta.bagelsiege.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BagelSiege.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CRUMBLED_BAGEL_BLOCK);
        blockWithItem(ModBlocks.BAGELSTAR_ORE);
        blockWithItem(ModBlocks.HARD_CRUMBLED_BAGEL);
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
