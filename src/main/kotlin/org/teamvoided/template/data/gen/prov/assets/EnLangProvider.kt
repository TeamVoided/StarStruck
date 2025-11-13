package org.teamvoided.template.data.gen.prov.assets

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.EntityType
import net.minecraft.world.item.Item
import org.teamvoided.template.data.tags.NameItemTags
import org.teamvoided.template.init.NameEntityTypes
import org.teamvoided.template.init.NameItems
import org.teamvoided.template.init.NameTabs
import java.util.concurrent.CompletableFuture

class EnLangProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricLanguageProvider(o, r) {

    override fun generateTranslations(lookup: HolderLookup.Provider, gen: TranslationBuilder) {
        NameItems.ITEMS.forEach { gen.add(it.descriptionId, genLang(it.id)) }
        NameEntityTypes.ENTITY_TYPES.forEach { gen.add(it.descriptionId, genLang(it.id)) }
        NameTabs.MOD_TAB.let { gen.add(it.key(), "modid") }

        NameItemTags.ITEM_TAGS.forEach { gen.add(it.translationKey, genLang(it.location)) }
        DamageTypeLang.translations(gen)
//        PaintingTranslations.translations(gen) steel from dd if we do make some

        // (ender) TODO we need enchant lang datagen, for some reason dusk didnt have it
    }


    private fun genLang(id: ResourceLocation): String =
        id.path.split("_").joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }

    val Item.id get() = BuiltInRegistries.ITEM.getKey(this)

    //    val Block.id get() = BuiltInRegistries.BLOCK.getKey(this)
    val EntityType<*>.id get() = BuiltInRegistries.ENTITY_TYPE.getKey(this)
}