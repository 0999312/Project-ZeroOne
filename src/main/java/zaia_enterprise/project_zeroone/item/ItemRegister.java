package zaia_enterprise.project_zeroone.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import zaia_enterprise.project_zeroone.Main;
import zaia_enterprise.project_zeroone.Versions;

public class ItemRegister {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Versions.MODID);
	public static final RegistryObject<Item> testItem = ITEMS.register("test_armor",
			() -> new ArmorTest(ArmorMaterial.TURTLE, EquipmentSlotType.HEAD,
					(new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<Item> testItem1 = ITEMS.register("test_armor1",
			() -> new ArmorTest(ArmorMaterial.TURTLE, EquipmentSlotType.CHEST,
					(new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<Item> testItem2 = ITEMS.register("test_armor2",
			() -> new ArmorTest(ArmorMaterial.TURTLE, EquipmentSlotType.LEGS,
					(new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<Item> testItem3 = ITEMS.register("test_armor3",
			() -> new ArmorTest(ArmorMaterial.TURTLE, EquipmentSlotType.FEET,
					(new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));

	public static final RegistryObject<Item> izu_1 = ITEMS.register("izu_1",
			() -> new ArmorSecurity(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST,
					(new Item.Properties()).tab(Main.ZERO_ONE_GROUP)));
	public static final RegistryObject<Item> izu_2 = ITEMS.register("izu_2",
			() -> new ArmorSecurity(ArmorMaterial.LEATHER, EquipmentSlotType.LEGS,
					(new Item.Properties()).tab(Main.ZERO_ONE_GROUP)));
	public static final RegistryObject<Item> izu_3 = ITEMS.register("izu_3",
			() -> new ArmorSecurity(ArmorMaterial.LEATHER, EquipmentSlotType.FEET,
					(new Item.Properties()).tab(Main.ZERO_ONE_GROUP)));

	public static final RegistryObject<Item> risingHopperKey = ITEMS.register("rising_hopper_progrise_key",
			() -> new ProgriseKey(new Item.Properties().stacksTo(1).tab(Main.ZERO_ONE_GROUP)));
	public static final RegistryObject<Item> shootingWolfKey = ITEMS.register("shooting_wolf_progrise_key",
			() -> new ProgriseKey(new Item.Properties().stacksTo(1).tab(Main.ZERO_ONE_GROUP)));
	public static final RegistryObject<Item> rushingCheetahKey = ITEMS.register("rushing_cheetah_progrise_key",
			() -> new ProgriseKey(new Item.Properties().stacksTo(1).tab(Main.ZERO_ONE_GROUP)));
	public static final RegistryObject<Item> flyingFalconKey = ITEMS.register("flying_falcon_progrise_key",
			() -> new ProgriseKey(new Item.Properties().stacksTo(1).tab(Main.ZERO_ONE_GROUP)));
	public static final RegistryObject<Item> rockingHopperKey = ITEMS.register("rocking_hopper_progrise_key",
			() -> new ProgriseKey(new Item.Properties().stacksTo(1).tab(Main.ZERO_ONE_GROUP)));
	public static final RegistryObject<Item> punchingKongKey = ITEMS.register("punching_kong_progrise_key",
			() -> new ProgriseKey(new Item.Properties().stacksTo(1).tab(Main.ZERO_ONE_GROUP)));
	public static final RegistryObject<Item> japaneseWolfKey = ITEMS.register("japanese_wolf_progrise_key",
			() -> new ProgriseKey(new Item.Properties().stacksTo(1).tab(Main.ZERO_ONE_GROUP)));
	public static final RegistryObject<Item> invadingHorseshoecrabKey = ITEMS.register(
			"invading_horseshoe_crab_progrise_key",
			() -> new ProgriseKey(new Item.Properties().stacksTo(1).tab(Main.ZERO_ONE_GROUP)));
	public static final RegistryObject<Item> crowdingHopperKey = ITEMS.register("crowding_hopper_progrise_key",
			() -> new ProgriseKey(new Item.Properties().stacksTo(1).tab(Main.ZERO_ONE_GROUP)));

	public static final RegistryObject<Item> risePhoneBlack = ITEMS.register("rise_phone_black", RisePhone::new);
}
