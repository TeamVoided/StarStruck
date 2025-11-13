package org.teamvoided.template.data.gen.prov.data

import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.world.damagesource.DamageScaling
import net.minecraft.world.damagesource.DamageType
import org.teamvoided.template.data.NameDamageTypes

object DamageTypeCreator {
    fun bootstrap(c: BootstrapContext<DamageType>) {
        // Steel from DamageTypes.class
        c.register(
            NameDamageTypes.GAY,
            DamageType(NameDamageTypes.GAY.location().path, DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 1f)
        )
    }

}