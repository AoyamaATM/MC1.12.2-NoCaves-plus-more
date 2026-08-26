package com.aoyama.nocaves;

import com.aoyama.nocaves.worldgen.WorldGenEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(
    modid = NoCaves.MODID,
    name = NoCaves.NAME,
    version = NoCaves.VERSION,
    useMetadata = true
)

public class NoCaves {

    public static final String MODID = "nocaves";
    public static final String NAME = "Aoyama's NoCaves+more";
    public static final String VERSION = "2.0.0";


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.TERRAIN_GEN_BUS.register(new WorldGenEventHandler());
    }
}