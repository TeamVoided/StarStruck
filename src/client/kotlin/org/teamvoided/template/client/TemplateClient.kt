package org.teamvoided.template.client

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.renderer.entity.NoopRenderer
import org.teamvoided.template.Template
import org.teamvoided.template.init.NameEntityTypes

@Suppress("unused")
object TemplateClient {
    fun init() {
        Template.log.info("Hello from Client")

        EntityRendererRegistry.register(NameEntityTypes.GAY_BEAM, ::NoopRenderer)
    }
}