package zaia_enterprise.project_zeroone.client;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import zaia_enterprise.project_zeroone.client.gui.GuiHumagear;
import zaia_enterprise.project_zeroone.item.ItemHumagearModule;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class HUDEventHandler {
	@SubscribeEvent
	public static void onOverlayRender(RenderGameOverlayEvent event) {
		if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
			return;
		}
		if (Minecraft.getInstance().player == null || !(Minecraft.getInstance().player
				.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof ItemHumagearModule)) {
			return;
		}
		GuiHumagear obsidianGUI = new GuiHumagear(event.getMatrixStack());
		obsidianGUI.render();
	}

}
