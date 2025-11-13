package org.teamvoided.template.init

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.core.Holder
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import org.teamvoided.template.Template.MODID
import org.teamvoided.template.Template.id


@Suppress("SameParameterValue")
object NameTabs {

    val MOD_TAB = register(
        MODID, FabricItemGroup.builder()
            .icon { NameItems.GAY_CORE.defaultInstance }
            .title(Component.translatable("itemGroup.$MODID.main"))
            .displayItems { _, tab ->
                tab.accept(NameItems.GAY_CORE)
            }
    )

    fun init() = Unit

    fun register(name: String, builder: CreativeModeTab.Builder): Holder.Reference<CreativeModeTab> {
        return Registry.registerForHolder(BuiltInRegistries.CREATIVE_MODE_TAB, id(name), builder.build())
    }
}