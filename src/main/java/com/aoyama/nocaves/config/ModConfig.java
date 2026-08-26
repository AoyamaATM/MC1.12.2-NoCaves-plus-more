package com.aoyama.nocaves.config;

import com.aoyama.nocaves.NoCaves;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Config(modid = NoCaves.MODID)
public class ModConfig {

    @Config.Comment("Disable cave generation in the Overworld.")
    public static boolean removeCaves = true;

    @Config.Comment("Disable lava spring generation in the Overworld.")
    public static boolean removeLavaSprings = true;

    @Config.Comment("Disable cave generation in the Nether.")
    public static boolean removeNetherCaves = false;

    @Config.Comment("Disable hidden lava pockets inside Netherrack.")
    public static boolean removeNetherLavaPockets = true;

    @Config.Comment("Disable exposed lava springs in the Nether.")
    public static boolean removeNetherLavaSprings = true;

    @Config.Comment("Disable ravine generation in the Overworld.")
    public static boolean removeRavines = true;

    @Config.Comment("Disable Underground water lake generation in the Underground.")
    public static boolean removeUndergroundWaterLakes = true;

    @Config.Comment("Disable Underground lava lake generation in the Overworld.")
    public static boolean removeUndergroundLavaLakes = true;


    @Mod.EventBusSubscriber(
            modid = NoCaves.MODID,
            value = Side.CLIENT)
    public static class EventHandler {

        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (NoCaves.MODID.equals(event.getModID())) {
                ConfigManager.sync(NoCaves.MODID, Config.Type.INSTANCE);
            }
        }
    }
}