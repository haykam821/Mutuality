package io.github.haykam821.mutuality.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.haykam821.mutuality.Main;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin extends Enchantment {
	private DamageEnchantmentMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
		super(weight, type, slotTypes);
	}

	@Inject(method = "canAccept", at = @At("HEAD"), cancellable = true)
	public void allowMutuality(Enchantment other, CallbackInfoReturnable<Boolean> ci) {
		if (Main.getConfig().damageMutuality) {
			ci.setReturnValue(super.canAccept(other));
		}
	}
}