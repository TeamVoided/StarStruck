package org.teamvoided.template.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import org.teamvoided.template.Template.MODID
import org.teamvoided.template.Template.log
import org.teamvoided.template.data.gen.prov.assets.EnLangProvider
import org.teamvoided.template.data.gen.prov.assets.ModelProvider
import org.teamvoided.template.data.gen.prov.data.DamageTypeCreator
import org.teamvoided.template.data.gen.prov.data.EnchantmentCreator
import org.teamvoided.template.data.gen.prov.data.PaintingCreator
import org.teamvoided.template.data.gen.prov.tags.EnchantmentTagsProvider
import org.teamvoided.template.data.gen.prov.tags.ItemTagsProvider
import java.util.concurrent.CompletableFuture

@Suppress("unused")
object TemplateData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
        val pack = gen.createPack()

        // Asset
        pack.addProvider(::EnLangProvider)
        pack.addProvider(::ModelProvider)
        // Data
        pack.addProvider(::DynamicRegistryProvider)
        // Tags
        pack.addProvider(::ItemTagsProvider)
        pack.addProvider(::EnchantmentTagsProvider)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
        gen.add(Registries.DAMAGE_TYPE, DamageTypeCreator::bootstrap)
        gen.add(Registries.ENCHANTMENT, EnchantmentCreator::bootstrap)
        gen.add(Registries.PAINTING_VARIANT, PaintingCreator::bootstrap)
    }

    class DynamicRegistryProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
        FabricDynamicRegistryProvider(o, r) {

        override fun getName(): String = "$MODID/dyn_data"

        override fun configure(reg: HolderLookup.Provider, e: Entries) {
            e.addAll(reg.lookupOrThrow(Registries.DAMAGE_TYPE))
            e.addAll(reg.lookupOrThrow(Registries.ENCHANTMENT))
            e.addAll(reg.lookupOrThrow(Registries.PAINTING_VARIANT))
        }
    }
}
