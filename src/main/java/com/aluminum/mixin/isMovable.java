package com.aluminum.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PistonBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import static com.aluminum.Al.PISTON_FORCE_PUSH;

@Mixin(PistonBlock.class)
public abstract  class isMovable {
	@Shadow protected abstract void tryMove(World world, BlockPos pos, BlockState state);

	@Inject(at = @At("HEAD"),method = "isMovable",cancellable = true)
	private static void isMovableMIX(BlockState state, World world, BlockPos pos, Direction direction, boolean canBreak, Direction pistonDir, CallbackInfoReturnable<Boolean> cir) {
		boolean doForcePush = world.getGameRules().getBoolean(PISTON_FORCE_PUSH);
		if (doForcePush & !state.isOf(Blocks.MOVING_PISTON)) {
			cir.setReturnValue(true);
		}
	}
}