package org.teamvoided.template.components

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder

interface SimpleStorageComponent


data class SimpleGayData(val gayLevel: Int, val nonGayRelatedValue: Int) : SimpleStorageComponent {
    companion object {
        val DEFAULT = SimpleGayData(420, 69)
        val CODEC: Codec<SimpleGayData> = RecordCodecBuilder.create {
            it.group(
                Codec.INT.fieldOf("gay_level").forGetter(SimpleGayData::gayLevel),
                Codec.INT.fieldOf("non_gay_related_value").forGetter(SimpleGayData::nonGayRelatedValue),
            ).apply(it, ::SimpleGayData)
        }
    }
}