package zaia_enterprise.project_zeroone.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import zaia_enterprise.project_zeroone.Versions;

public class ZeroOneGroup extends ItemGroup {

	public ZeroOneGroup() {
		super(Versions.MODID);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(ItemRegister.risingHopperKey.get());
	}

}
