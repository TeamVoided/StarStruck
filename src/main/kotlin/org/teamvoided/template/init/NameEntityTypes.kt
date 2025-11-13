package org.teamvoided.template.init

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.entity.animal.allay.Allay
import org.teamvoided.template.Template.id


@Suppress("unused", "MemberVisibilityCanBePrivate")
object NameEntityTypes {
    val ENTITY_TYPES = mutableListOf<EntityType<*>>()

    // Steel from : EntityType.class
    val GAY_BEAM = register(
        "gay_beam", EntityType.Builder.of(::Allay, MobCategory.CREATURE)
            .sized(0.35f, 0.6f)
            .eyeHeight(0.36f)
            .ridingOffset(0.04f)
            .clientTrackingRange(8).updateInterval(2)
    )


    fun init() = Unit
    fun <T : Entity> register(id: String, builder: EntityType.Builder<T>): EntityType<T> {
        val regItem = Registry.register(BuiltInRegistries.ENTITY_TYPE, id(id), builder.build(id(id).toString()))
        ENTITY_TYPES.add(regItem)
        return regItem
    }
}