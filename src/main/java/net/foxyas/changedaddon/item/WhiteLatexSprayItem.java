
package net.foxyas.changedaddon.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.foxyas.changedaddon.procedures.WhiteLatexSprayRightClickProcedure;
import net.foxyas.changedaddon.init.ChangedAddonModTabs;

public class WhiteLatexSprayItem extends Item {
	public WhiteLatexSprayItem() {
		super(new Item.Properties().tab(ChangedAddonModTabs.TAB_CHANGED_ADDON).durability(10).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BLOCK;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		WhiteLatexSprayRightClickProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getLevel().getBlockState(context.getClickedPos()), context.getPlayer(),
				context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}