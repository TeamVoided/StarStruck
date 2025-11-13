package org.teamvoided.template.data.gen.prov.assets


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators
import net.minecraft.data.models.model.ModelTemplates
import org.teamvoided.template.init.NameItems

class ModelProvider(o: FabricDataOutput) : FabricModelProvider(o) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockModelGenerators) = Unit
    override fun generateItemModels(gen: ItemModelGenerators) {
        for (item in NameItems.ITEMS) {
            gen.generateFlatItem(item, ModelTemplates.FLAT_ITEM)
        }
    }
}
