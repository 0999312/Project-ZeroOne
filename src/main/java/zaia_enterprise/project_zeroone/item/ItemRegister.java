package zaia_enterprise.project_zeroone.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegister {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "project_zeroone");
    public static final RegistryObject<Item> testItem = ITEMS.register("test_armor", () -> new ArmorTest(ArmorMaterial.TURTLE, EquipmentSlotType.HEAD, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> testItem1 = ITEMS.register("test_armor1", () -> new ArmorTest(ArmorMaterial.TURTLE, EquipmentSlotType.CHEST, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> testItem2 = ITEMS.register("test_armor2", () -> new ArmorTest(ArmorMaterial.TURTLE, EquipmentSlotType.LEGS, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> testItem3 = ITEMS.register("test_armor3", () -> new ArmorTest(ArmorMaterial.TURTLE, EquipmentSlotType.FEET, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
}
