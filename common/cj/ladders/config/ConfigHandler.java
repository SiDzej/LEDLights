package cj.ladders.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cj.ladders.lib.BlockIds;
import cj.ladders.lib.ItemIds;
import cj.ladders.lib.Reference;
import cpw.mods.fml.common.FMLLog;

public class ConfigHandler {
    public static Configuration configuration;

    public static void init(File configFile) {
        Configuration conf = new Configuration(configFile);

        try {
            conf.load();
            //////
            BlockIds.IRON_LADDER = conf.getBlock("ironladder",BlockIds.IRON_LADDER_DEFAULT)
            		.getInt(BlockIds.IRON_LADDER_DEFAULT);
            BlockIds.GOLDEN_LADDER = conf.getBlock("goldenladder",BlockIds.GOLDEN_LADDER_DEFAULT)
            		.getInt(BlockIds.GOLDEN_LADDER_DEFAULT);
            BlockIds.DIAMOND_LADDER = conf.getBlock("diamondladder",BlockIds.DIAMOND_LADDER_DEFAULT)
            		.getInt(BlockIds.DIAMOND_LADDER_DEFAULT);
            BlockIds.OBSIDIAN_LADDER = conf.getBlock("obsidianladder",BlockIds.OBSIDIAN_LADDER_DEFAULT)
            		.getInt(BlockIds.OBSIDIAN_LADDER_DEFAULT);
            BlockIds.LAPIS_LADDER = conf.getBlock("lapisladder",BlockIds.LAPIS_LADDER_DEFAULT)
            		.getInt(BlockIds.LAPIS_LADDER_DEFAULT);
            BlockIds.EMERALD_LADDER = conf.getBlock("emeraldladder",BlockIds.EMERALD_LADDER_DEFAULT)
            		.getInt(BlockIds.EMERALD_LADDER_DEFAULT);
            BlockIds.WARN_LADDER = conf.getBlock("warnladder",BlockIds.WARN_LADDER_DEFAULT)
            		.getInt(BlockIds.WARN_LADDER_DEFAULT);
            ///////

        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, "Mod called " + Reference.MOD_NAME
                    + " was unable to load its configs!");
        } finally {
            conf.save();
        }

    }
}
