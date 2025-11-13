package org.teamvoided.template.data

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.enchantment.Enchantment
import org.teamvoided.template.Template.id


object NameEnchantments {
    val ENCHANTMENTS = mutableSetOf<ResourceKey<Enchantment>>()
    
    val GAYING = create("gaying")

     fun create(id: String): ResourceKey<Enchantment> {
        val enchantment = ResourceKey.create(Registries.ENCHANTMENT, id(id))
        ENCHANTMENTS.add(enchantment)
        return enchantment
    }
}