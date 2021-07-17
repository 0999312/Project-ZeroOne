package zaia_enterprise.project_zeroone.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import zaia_enterprise.project_zeroone.Versions;

public class EntityRegister {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			Versions.MODID);
	public static final RegistryObject<EntityType<EntityMotor>> RISE_HOPPER = ENTITY_TYPES.register("rise_hopper",
			() -> EntityType.Builder.<EntityMotor>of(EntityMotor::new, EntityClassification.MISC)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(10)
					.build("rise_hopper"));

}
