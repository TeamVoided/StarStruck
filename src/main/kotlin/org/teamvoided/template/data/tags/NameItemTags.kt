package org.teamvoided.template.data.tags

import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import org.teamvoided.template.Template.id

object NameItemTags {
    val ITEM_TAGS = mutableSetOf<TagKey<Item>>()

    val TEST = create("test")


    fun create(id: String): TagKey<Item> {
        val tag = TagKey.create(Registries.ITEM, id(id))
        ITEM_TAGS.add(tag)
        return tag
    }
}