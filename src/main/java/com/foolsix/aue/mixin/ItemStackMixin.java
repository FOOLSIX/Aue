package com.foolsix.aue.mixin;

import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static com.foolsix.aue.Aue.UNBREAKABLE;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Redirect(method = "hurtAndBreak", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isDamageableItem()Z"))
    private boolean rejudge(ItemStack instance) {
        if (instance.getEnchantmentLevel(UNBREAKABLE.get()) > 0) {
            instance.setDamageValue(0);
            return false;
        }
        return instance.isDamageableItem();
    }
}
