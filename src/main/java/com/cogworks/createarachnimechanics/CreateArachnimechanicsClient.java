package com.cogworks.createarachnimechanics;

import com.cogworks.createarachnimechanics.registry.ModEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = CreateArachnimechanics.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = CreateArachnimechanics.MODID, value = Dist.CLIENT)
public class CreateArachnimechanicsClient {
    public CreateArachnimechanicsClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        CreateArachnimechanics.LOGGER.info("HELLO FROM CLIENT SETUP");
    }

    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.SPIDERTRON, SpidertronRenderer::new);
        event.registerEntityRenderer(ModEntities.SPIDERTRON_SEGMENT, SpidertronRenderer::new);
    }
}
