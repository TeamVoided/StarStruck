package org.teamvoided.template.init

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import org.teamvoided.template.Template.id
import org.teamvoided.template.entity.HammerHeadEntity


@Suppress("unused", "MemberVisibilityCanBePrivate")
object NameEntityTypes {
    val ENTITY_TYPES = mutableListOf<EntityType<*>>()

    // Steel from : EntityType.class
    val HAMMER_HEAD = register(
        "hammer_head", EntityType.Builder.of(::HammerHeadEntity, MobCategory.MISC)
            .sized(0.5f, 0.5f)
            //(ender) prevents the item from being spawned by normal means, like `/summon`
            .noSummon()
    )


    fun init() = Unit
    fun <T : Entity> register(id: String, builder: EntityType.Builder<T>): EntityType<T> {
        val regItem = Registry.register(BuiltInRegistries.ENTITY_TYPE, id(id), builder.build(id(id).toString()))
        ENTITY_TYPES.add(regItem)
        return regItem
    }
}