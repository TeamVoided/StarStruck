package org.teamvoided.template.data.gen.prov.tags

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags
import net.minecraft.core.HolderLookup
import net.minecraft.world.item.Items
import org.teamvoided.template.data.tags.NameItemTags
import java.util.concurrent.CompletableFuture

class ItemTagsProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.ItemTagProvider(o, r) {
    override fun addTags(arg: HolderLookup.Provider) {
        getOrCreateTagBuilder(NameItemTags.TEST)
            .add(Items.HEAVY_CORE, Items.TRIDENT)


        conventionTags()
    }

    fun conventionTags() {
        getOrCreateTagBuilder(ConventionalItemTags.EGGS)
//            .add(Items.HEAVY_CORE)
    }
}