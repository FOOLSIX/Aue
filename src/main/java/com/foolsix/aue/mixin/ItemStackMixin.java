package com.foolsix.aue.mixin;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

import static com.foolsix.aue.enchantment.ModEnchantments.UNBREAKABLE;

@Mixin(ItemStack.class)public abstract class ItemStackMixin {
    @Redirect(method = "hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isDamageableItem()Z"))
    private boolean rejudge(ItemStack instance) {
        ItemEnchantments enchantments = instance.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
        if (enchantments.entrySet().stream().map(Map.Entry::getKey).map(Holder::getKey).anyMatch(UNBREAKABLE::equals)) {
            instance.setDamageValue(0);
            return false;
        }
        return instance.isDamageableItem();
    }
}
