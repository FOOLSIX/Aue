package com.foolsix.aue.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import static com.foolsix.aue.AueConfig.CONFIG;


public class Unbreakable extends Enchantment {

    public Unbreakable() {
        super(Rarity.VERY_RARE, EnchantmentCategory.create("ALL", a -> true), new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND, EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
    }

    @Override
    public int getMinLevel() {
        return CONFIG.MIN_COST.get();
    }

    @Override
    public boolean isTradeable() {
        return CONFIG.IS_TRADABLE.get();
    }

    @Override
    public boolean isDiscoverable() {
        return CONFIG.IS_DISCOVERABLE.get();
    }

    @Override
    public boolean isTreasureOnly() {
        return CONFIG.IS_TREASURE.get();
    }

    @Override
    public boolean isAllowedOnBooks() {
        return CONFIG.IS_ALLOWED_ON_BOOKS.get();
    }
}
