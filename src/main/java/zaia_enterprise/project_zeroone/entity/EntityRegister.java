package zaia_enterprise.project_zeroone.entity;

import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import zaia_enterprise.project_zeroone.Versions;

public class EntityRegister {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Versions.MODID);
}
