package zaia_enterprise.project_zeroone.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ProgriseKey extends Item {
	private boolean startSoundPlayed = false;
	private boolean midLoadSoundPlayed = false;
	private boolean openSoundPlayed = false;

	public ProgriseKey(Properties p_i48487_1_) {
		super(p_i48487_1_);
	}

	public static boolean isOpened(ItemStack stack) {
		CompoundNBT compoundnbt = stack.getTag();
		return compoundnbt != null && compoundnbt.getBoolean("opened");
	}

	public static void setOpened(ItemStack stack, boolean opened) {
		CompoundNBT compoundnbt = stack.getOrCreateTag();
		compoundnbt.putBoolean("opened", opened);
	}

	public static boolean isAuthorized(ItemStack stack) {
		CompoundNBT compoundnbt = stack.getTag();
		return compoundnbt != null && compoundnbt.getBoolean("authorized");
	}

	public static void setAuthorized(ItemStack stack, boolean Authorized) {
		CompoundNBT compoundnbt = stack.getOrCreateTag();
		compoundnbt.putBoolean("authorized", Authorized);
	}

	public int getUseDuration(ItemStack stack) {
		return 7200;
	}

	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.BOW;
	}

	@Override
	public void onUseTick(World world, LivingEntity p_219972_2_, ItemStack stack, int p_219972_4_) {
		float f = getChargeTime(stack, p_219972_4_);
		if (!world.isClientSide) {
			if (f < 0.2F) {
				this.startSoundPlayed = false;
				this.midLoadSoundPlayed = false;
				this.openSoundPlayed = false;
			}

			if (f >= 0.2F && !this.startSoundPlayed) {
				this.startSoundPlayed = true;
				world.playSound((PlayerEntity) null, p_219972_2_.blockPosition(), SoundEvents.VILLAGER_NO,
						SoundCategory.PLAYERS, 1F, 1.0F);
			}

			if (f >= 0.85F && !this.midLoadSoundPlayed) {
				this.midLoadSoundPlayed = true;
				world.playSound((PlayerEntity) null, p_219972_2_.blockPosition(), SoundEvents.VILLAGER_HURT,
						SoundCategory.PLAYERS, 1F, 1.0F);
			}
			if(f >= 1.0F && !this.openSoundPlayed) {
				this.openSoundPlayed = true;
				world.playSound(null, p_219972_2_.blockPosition(), SoundEvents.ITEM_BREAK, SoundCategory.NEUTRAL, 1F,
						1F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
			}
		}
	}

	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getItemInHand(hand);
		if (!isOpened(stack)) {
			this.startSoundPlayed = false;
			this.midLoadSoundPlayed = false;
			this.openSoundPlayed = false;
			player.startUsingItem(hand);
			return ActionResult.consume(stack);
		} else if (isOpened(stack)) {
			if (!isAuthorized(stack)) {
				setOpened(stack, false);
				return ActionResult.consume(stack);
			}
		}
		return ActionResult.fail(stack);
	}

	@Override
	public void releaseUsing(ItemStack p_77615_1_, World p_77615_2_, LivingEntity p_77615_3_, int p_77615_4_) {
		if (getChargeTime(p_77615_1_, p_77615_4_) >= 1.0F && !isOpened(p_77615_1_)) {
			setOpened(p_77615_1_, true);
			p_77615_2_.playSound(null, p_77615_3_.blockPosition(), SoundEvents.VILLAGER_DEATH, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);

		}
//		super.releaseUsing(p_77615_1_, p_77615_2_, p_77615_3_, p_77615_4_);
	}

	private float getChargeTime(ItemStack stack, int time) {
		return (stack.getUseDuration() - time) / 60.0F;
	}
}
