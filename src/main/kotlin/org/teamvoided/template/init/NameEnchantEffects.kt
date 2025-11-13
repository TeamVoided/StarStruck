package org.teamvoided.template.init

import com.mojang.serialization.MapCodec
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.enchantment.effects.ApplyMobEffect
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect
import org.teamvoided.template.Template.id

object NameEnchantEffects {
    fun init() = Unit

    // Steel from : EnchantmentEntityEffect.class
    val BAD = entityEffect("bad", ApplyMobEffect.CODEC)


    fun <T : EnchantmentEntityEffect> entityEffect(id: String, codec: MapCodec<T>): MapCodec<T> =
        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE, id(id), codec)
}