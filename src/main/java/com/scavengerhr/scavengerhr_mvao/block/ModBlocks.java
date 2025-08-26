package com.scavengerhr.scavengerhr_mvao.block;

import com.scavengerhr.scavengerhr_mvao.ScavengerHRMoltenVentsAddOn;
import com.scavengerhr.scavengerhr_mvao.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ScavengerHRMoltenVentsAddOn.MOD_ID);

    public static final DeferredBlock<Block> ACTIVE_MOLTEN_DIAMOND = registerBlock("active_molten_diamond",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> DORMANT_MOLTEN_DIAMOND = registerBlock("dormant_molten_diamond",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> ACTIVE_MOLTEN_SULFUR = registerBlock("active_molten_sulfur",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> DORMANT_MOLTEN_SULFUR = registerBlock("dormant_molten_sulfur",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        // Register a BlockItem for the block
        // This will allow the block to be placed in the world by the player
        // The item will have the same properties as a normal item
        // If you want to customize the item, you will need to register it separately in ModItems
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
