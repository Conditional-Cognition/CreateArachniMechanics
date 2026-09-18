package com.cogworks.createarachnimechanics.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import static com.cogworks.createarachnimechanics.CreateArachnimechanics.MODID;

public class ModEntities {
    public static EntityType<SpidertronEntity> SPIDERTRON;
    public static EntityType<SpidertronEntity> SPIDERTRON_SEGMENT;

    public static void register(RegisterEvent event) {
        event.register(Registries.ENTITY_TYPE, helper -> {
            SPIDERTRON = EntityType.Builder.of(SpidertronEntity::new, MobCategory.MISC)
                    .sized(1.5F, 1.5F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID, "spidertron").toString());

            helper.register(ResourceLocation.fromNamespaceAndPath(MODID, "spidertron"), SPIDERTRON);
            SPIDERTRON = EntityType.Builder.of(SpidertronLegEntity::new, MobCategory.MISC)
                    .sized(1.5F, 1.5F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID, "spidertron").toString());

            helper.register(ResourceLocation.fromNamespaceAndPath(MODID, "spidertron"), SPIDERTRON);
        });
    }

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SPIDERTRON, SpidertronEntity.createAttributes().build());
        event.put(SPIDERTRON_SEGMENT, SpidertronEntity.createAttributes().build());
    }
}