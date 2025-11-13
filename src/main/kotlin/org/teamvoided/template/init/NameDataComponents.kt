package org.teamvoided.template.init

import com.mojang.serialization.Codec
import net.minecraft.core.Registry
import net.minecraft.core.component.DataComponentType
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.codec.ByteBufCodecs
import org.teamvoided.template.Template.id
import org.teamvoided.template.components.SimpleGayData
import org.teamvoided.template.components.SimpleStorageComponent

object NameDataComponents {
    fun init() = Unit

    // Simple setup
    val SIMPLE_GAY_DATA = registerSimple("simple_gay_data", SimpleGayData.CODEC)

    fun <T : SimpleStorageComponent> registerSimple(name: String, codec: Codec<T>): DataComponentType<T> =
        Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            id(name),
            DataComponentType.builder<T>().persistent(codec).build()
        )

    // Steel from : DataComponents.class

    // Not Simple Setup
    val GAY_CORD = register("gay_cord") { it.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build() }
    fun <T> register(
        name: String, build: (DataComponentType.Builder<T>) -> DataComponentType<T>,
    ): DataComponentType<T> =
        Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, id(name), build(DataComponentType.builder()))
}