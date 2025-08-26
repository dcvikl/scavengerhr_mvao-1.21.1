package com.scavengerhr.scavengerhr_mvao.item;

import com.scavengerhr.scavengerhr_mvao.ScavengerHRMoltenVentsAddOn;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ScavengerHRMoltenVentsAddOn.MOD_ID);

    // Example item registration

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
