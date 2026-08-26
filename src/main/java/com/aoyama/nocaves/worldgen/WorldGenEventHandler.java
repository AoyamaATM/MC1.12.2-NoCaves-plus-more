package com.aoyama.nocaves.worldgen;

import com.aoyama.nocaves.config.ModConfig;
import com.aoyama.nocaves.NoCaves;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class WorldGenEventHandler {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onInitMapGen(InitMapGenEvent event) {

        // Overworld Caves
        if (event.getType() == InitMapGenEvent.EventType.CAVE
                && ModConfig.removeCaves) {

            event.setNewGen(new MapGenBase());
        }

        // Overworld Ravines
        if (event.getType() == InitMapGenEvent.EventType.RAVINE
                && ModConfig.removeRavines) {

            event.setNewGen(new MapGenBase());
        }

        // Nether Caves
        if (event.getType() == InitMapGenEvent.EventType.NETHER_CAVE
                && ModConfig.removeNetherCaves) {

            event.setNewGen(new MapGenBase());
        }
    }

    @SubscribeEvent
    public void onPopulate(PopulateChunkEvent.Populate event) {

        // Nether Lava Springs
        if (event.getType() == PopulateChunkEvent.Populate.EventType.NETHER_LAVA
                && ModConfig.removeNetherLavaSprings
                && event.getWorld().provider.getDimension() == -1) {

            event.setResult(Event.Result.DENY);
            return;
        }

        // Nether Lava Pockets
        if (event.getType() == PopulateChunkEvent.Populate.EventType.NETHER_LAVA2
                && ModConfig.removeNetherLavaPockets
                && event.getWorld().provider.getDimension() == -1) {

            event.setResult(Event.Result.DENY);
            return;
        }

        // Delete Underground Lava Lakes in the Overworld
        if (event.getType() == PopulateChunkEvent.Populate.EventType.LAVA
                && ModConfig.removeUndergroundLavaLakes
                && event.getWorld().provider.getDimension() == 0) {

            ChunkGeneratorSettings settings = getOverworldSettings(event);

            // バニラ側の溶岩湖生成はいったん止める
            event.setResult(Event.Result.DENY);

            if (settings == null) {
                return;
            }

            int x = event.getChunkX() * 16 + event.getRand().nextInt(16) + 8;
            int y = event.getRand().nextInt(event.getRand().nextInt(248) + 8);
            int z = event.getChunkZ() * 16 + event.getRand().nextInt(16) + 8;

            int surfaceY = event.getWorld().getHeight(x, z);
            int surfaceLavaChance = Math.max(1, settings.lavaLakeChance / 8);

            // 地表まで届く候補だけ許可
            if (y >= surfaceY
                    && event.getRand().nextInt(surfaceLavaChance) == 0) {

                new WorldGenLakes(Blocks.LAVA).generate(
                        event.getWorld(),
                        event.getRand(),
                        new BlockPos(x, y, z)
                );
            }

            return;
        }

        if (!ModConfig.removeUndergroundWaterLakes) {
            return;
        }

        if (event.getType() != PopulateChunkEvent.Populate.EventType.LAKE) {
            return;
        }

        // Overworld Only
        if (event.getWorld().provider.getDimension() != 0) {
            return;
        }

        int x = event.getChunkX() * 16 + event.getRand().nextInt(16) + 8;
        int y = event.getRand().nextInt(256);
        int z = event.getChunkZ() * 16 + event.getRand().nextInt(16) + 8;

        BlockPos lakePos = new BlockPos(x, y, z);

        // このX/Z地点の地表の高さ
        int surfaceY = event.getWorld().getHeight(x, z);

        // バニラ側の湖生成を一度切る
        event.setResult(Event.Result.DENY);

        // 湖候補が地表(surfaceY)以上なら、「地表の湖」として生成し直す
        if (y >= surfaceY) {
            new WorldGenLakes(Blocks.WATER).generate(
                    event.getWorld(),
                    event.getRand(),
                    lakePos
            );
        }
    }

    @SubscribeEvent
    public void onDecorate(DecorateBiomeEvent.Decorate event) {

        if (event.getType() == DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA
                && ModConfig.removeLavaSprings
                && event.getWorld().provider.getDimension() == 0) {

            event.setResult(Event.Result.DENY);
        }
    }

    private ChunkGeneratorSettings getOverworldSettings(
            PopulateChunkEvent.Populate event) {

        if (!(event.getGenerator() instanceof ChunkGeneratorOverworld)) {
            return null;
        }

        ChunkGeneratorOverworld generator =
                (ChunkGeneratorOverworld) event.getGenerator();

        return ObfuscationReflectionHelper.getPrivateValue(
                ChunkGeneratorOverworld.class,
                generator,
                "field_186000_s"
        );
    }
}