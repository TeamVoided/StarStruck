package org.teamvoided.template.data.tags

import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.item.enchantment.Enchantment
import org.teamvoided.template.Template.id

object NameEnchantmentTags {

    val TAG = create("tag")


    fun create(id: String): TagKey<Enchantment> = TagKey.create(Registries.ENCHANTMENT, id(id))

}