package com.foolsix.aue;

import com.foolsix.aue.enchantment.Unbreakable;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(Aue.MOD_ID)
public class Aue {
    public static final String MOD_ID = "aue";

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MOD_ID);
    public static final RegistryObject<Enchantment> UNBREAKABLE = ENCHANTMENTS.register("unbreakable", Unbreakable::new);

    public Aue() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        ENCHANTMENTS.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AueConfig.CONFIG_SPEC);
    }
}
