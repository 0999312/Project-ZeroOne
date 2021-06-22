package zaia_enterprise.project_zeroone.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import zaia_enterprise.project_zeroone.Main;

public class RisePhone extends Item {

	public RisePhone() {
		super(new Properties().stacksTo(1).tab(Main.ZERO_ONE_GROUP));
	}
	
	public static boolean isOpened(ItemStack stack) {
		CompoundNBT compoundnbt = stack.getTag();
		return compoundnbt != null && compoundnbt.getBoolean("opened");
	}

	public static void setOpened(ItemStack stack, boolean opened) {
		CompoundNBT compoundnbt = stack.getOrCreateTag();
		compoundnbt.putBoolean("opened", opened);
	}	
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getItemInHand(hand);
		if(isOpened(stack)) {
			setOpened(stack, false);
			return ActionResult.consume(stack);
		}
		setOpened(stack, true);
		return ActionResult.consume(stack);
	}
}
