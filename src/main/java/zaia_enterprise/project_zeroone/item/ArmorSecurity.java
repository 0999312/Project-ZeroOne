package zaia_enterprise.project_zeroone.item;

import cn.mcmod_mmf.mmlib.utils.ClientUtil;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import zaia_enterprise.project_zeroone.Versions;

public class ArmorSecurity extends ArmorItem {

	public ArmorSecurity(IArmorMaterial p_i48534_1_, EquipmentSlotType p_i48534_2_, Properties p_i48534_3_) {
		super(p_i48534_1_, p_i48534_2_, p_i48534_3_);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlotType armorSlot, A _default) {
		
		return (A) ClientUtil.getArmorModelFromJSON(new ResourceLocation(Versions.MODID, "models/entity/security_izu.json"), armorSlot);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		return "project_zeroone:textures/armor/izu.png";
	}
}
