package org.teamvoided.template.init

import com.mojang.serialization.MapCodec
import net.minecraft.core.Registry
import net.minecraft.core.component.DataComponents
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect
import org.teamvoided.template.Template.id

object NameDataComponents {
    fun init() = Unit

    // Steel from : DataComponents.class
    val x = DataComponents.ENTITY_DATA


    fun <T : EnchantmentEntityEffect> entityEffect(id: String, codec: MapCodec<T>): MapCodec<T> =
        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE, id(id), codec)
}