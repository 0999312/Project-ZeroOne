package zaia_enterprise.project_zeroone.item;

import cn.mcmod_mmf.mmlib.utils.ClientUtil;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import zaia_enterprise.project_zeroone.Main;
import zaia_enterprise.project_zeroone.Versions;

public class ItemHumagearModule extends ArmorItem {
	public ItemHumagearModule() {
		super(ArmorMaterial.TURTLE, EquipmentSlotType.HEAD, new Item.Properties().stacksTo(1).tab(Main.ZERO_ONE_GROUP));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlotType armorSlot, A _default) {
		
		return (A) ClientUtil.getArmorModelFromJSON(new ResourceLocation(Versions.MODID, "models/entity/test_model.json"), armorSlot);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		return "project_zeroone:textures/armor/test.png";
	}
}
