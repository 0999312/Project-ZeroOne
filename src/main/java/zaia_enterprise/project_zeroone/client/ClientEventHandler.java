package zaia_enterprise.project_zeroone.client;

import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import zaia_enterprise.project_zeroone.Versions;
import zaia_enterprise.project_zeroone.item.ItemRegister;
import zaia_enterprise.project_zeroone.item.ProgriseKey;
import zaia_enterprise.project_zeroone.item.RisePhone;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
	@SubscribeEvent
	public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemRegister.ITEMS.getEntries().forEach((item) -> {
				if (item.get() instanceof ProgriseKey) {
					ItemModelsProperties.register(item.get(), new ResourceLocation(Versions.MODID, "opened"),
							(itemStack, clientWorld, livingEntity) -> ProgriseKey.isOpened(itemStack) ? 1F : 0F);
					ItemModelsProperties.register(item.get(), new ResourceLocation(Versions.MODID, "opening"),
							(itemStack, clientWorld, livingEntity) -> {
								if (livingEntity == null) {
									return 0.0F;
								}
								return livingEntity.getUseItem() != itemStack ? 0.0F
										: (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 60.0F;
					});
				}
				if(item.get() instanceof RisePhone) {
					ItemModelsProperties.register(item.get(), new ResourceLocation(Versions.MODID, "opened"),
							(itemStack, clientWorld, livingEntity) -> RisePhone.isOpened(itemStack) ? 1F : 0F);
				}
				
			});

		});
	}
}
