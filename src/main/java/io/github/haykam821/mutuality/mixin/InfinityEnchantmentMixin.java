package io.github.haykam821.mutuality.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.haykam821.mutuality.Main;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.entity.EquipmentSlot;

@Mixin(value = { InfinityEnchantment.class })
public class InfinityEnchantmentMixin extends Enchantment {
	private InfinityEnchantmentMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
		super(weight, type, slotTypes);
	}

	@Inject(method = "canAccept", at = @At("HEAD"), cancellable = true)
	public void allowMutuality(Enchantment other, CallbackInfoReturnable<Boolean> ci) {
		if (Main.getConfig().infinityMutuality) {
			ci.setReturnValue(super.canAccept(other));
		}
	}
}