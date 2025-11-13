package org.teamvoided.template.data

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.damagesource.DamageType
import net.minecraft.world.entity.Entity
import org.teamvoided.template.Template.id

object NameDamageTypes {

    val GAY = create("gay")

    fun create(id: String): ResourceKey<DamageType> = ResourceKey.create(Registries.DAMAGE_TYPE, id(id))

    fun Entity.hurtByType(
        type: ResourceKey<DamageType>, amount: Float, source: Entity? = null, attacker: Entity? = null
    ): Boolean = hurt(damageSources().source(type, source, attacker), amount)
}