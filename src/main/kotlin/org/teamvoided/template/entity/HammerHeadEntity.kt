package org.teamvoided.template.entity

import net.minecraft.network.syncher.EntityDataAccessor
import net.minecraft.network.syncher.EntityDataSerializers
import net.minecraft.network.syncher.SynchedEntityData
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.damagesource.DamageTypes
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.projectile.Projectile
import net.minecraft.world.level.Level
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.EntityHitResult
import org.teamvoided.template.data.NameDamageTypes.hurtByType

class HammerHeadEntity(entityType: EntityType<out Projectile>, level: Level) : Projectile(entityType, level) {
    override fun defineSynchedData(builder: SynchedEntityData.Builder) {
        builder.define(FUNNY_NUMBER, 69)
    }

    var funnyNumber: Int
        get() = entityData.get(FUNNY_NUMBER)
        set(value) = entityData.set(FUNNY_NUMBER, value)

    override fun onHitEntity(entityHitResult: EntityHitResult) {
        val entity = entityHitResult.entity
        val level = entity.level()
        if (entity != owner) {
            entity.hurtByType(DamageTypes.ARROW, 10f, this, owner)
            entity.deltaMovement = deltaMovement.multiply(1.5, 0.0, 1.5)
            level.playSound(null, this, SoundEvents.ANVIL_HIT, SoundSource.PLAYERS, 1f, 1f)

            println(funnyNumber)
        }
        super.onHitEntity(entityHitResult)
    }

    override fun onHitBlock(blockHitResult: BlockHitResult) {
        super.onHitBlock(blockHitResult)
    }

    companion object {
        // (ender) look at EntityDataSerializers.class for all available data types
        val FUNNY_NUMBER: EntityDataAccessor<Int> =
            SynchedEntityData.defineId(HammerHeadEntity::class.java, EntityDataSerializers.INT)
    }

}