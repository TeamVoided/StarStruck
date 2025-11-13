package org.teamvoided.template.data.gen.prov.tags

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.Enchantments
import org.teamvoided.template.data.tags.NameEnchantmentTags
import java.util.concurrent.CompletableFuture

class EnchantmentTagsProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider<Enchantment>(o, Registries.ENCHANTMENT, r) {
    override fun addTags(arg: HolderLookup.Provider) {
        getOrCreateTagBuilder(NameEnchantmentTags.TAG)
            .add(Enchantments.MENDING)
    }
}