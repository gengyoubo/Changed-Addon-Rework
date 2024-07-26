package net.foxyas.changedaddon.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.foxyas.changedaddon.ChangedAddonMod;
import net.ltxprogrammer.changed.Changed;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import static net.ltxprogrammer.changed.entity.BasicPlayerInfo.SIZE_TOLERANCE;

public class SizeManipulatorProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null) return;

		double amount = DoubleArgumentType.getDouble(arguments, "size");
		SizeChange(entity, (float) amount);
	}

	public static float getSize(float size) {
		if (size < 1.0f - SIZE_TOLERANCE) {
			ChangedAddonMod.LOGGER.atWarn().log("Size value is too low: " + size + ", The Size Value is going to be auto set to 0.95"); // Too Low Warn
		} else if (size > 1.0f + SIZE_TOLERANCE) {
			ChangedAddonMod.LOGGER.atWarn().log("Size value is too high: " + size + ", The Size Value is going to be auto set to 1.05"); // Too High Warn
		}
		return Mth.clamp(size, 1.0f - SIZE_TOLERANCE, 1.0f + SIZE_TOLERANCE);
	}

	public static void SizeChange(Entity entity, float amount) {
		if (entity instanceof Player player) {
			float newSize = getSize(amount);
			Changed.config.client.basicPlayerInfo.setSize(newSize); // Change Size
			ChangedAddonMod.LOGGER.info("Size changed to: " + newSize + " for player: " + player.getName().getString()); // Command Classic Log
			player.displayClientMessage(Component.literal("Size changed to: " + newSize), false); // Chat log for the player
		} else {
			ChangedAddonMod.LOGGER.atError().log("Entity is not a player, cannot change size."); // Command Classic Error
		}
	}
}
