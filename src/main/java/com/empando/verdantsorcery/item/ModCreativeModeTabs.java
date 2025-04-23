package com.empando.verdantsorcery.item;

import com.empando.verdantsorcery.VerdantSorcery;
import com.empando.verdantsorcery.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.empando.verdantsorcery.item.ModItems.RADIATION_STAFF;

public class ModCreativeModeTabs { public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VerdantSorcery.MODID);

    public static final Supplier<CreativeModeTab> VERDANTSORCERY_ITEMS_TAB = CREATIVE_MODE_TAB.register("verdantsorcery_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(RADIATION_STAFF.get()))
                    .title(Component.translatable("creativetab.verdantsorcery.verdantsorcery_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(RADIATION_STAFF);
                        output.accept(ModBlocks.COOKING_POT);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}