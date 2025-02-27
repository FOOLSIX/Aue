package com.foolsix.aue.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.foolsix.aue.enchantment.ModEnchantments.UNBREAKABLE;
import static net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion.MOD_ID;

public class AUEEnchantmentTagProvider extends EnchantmentTagsProvider {
    public AUEEnchantmentTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(UNBREAKABLE.location());
        this.tag(EnchantmentTags.TRADEABLE).addOptional(UNBREAKABLE.location());
        this.tag(EnchantmentTags.ON_RANDOM_LOOT).addOptional(UNBREAKABLE.location());
        this.tag(EnchantmentTags.DOUBLE_TRADE_PRICE).addOptional(UNBREAKABLE.location());
    }
}
