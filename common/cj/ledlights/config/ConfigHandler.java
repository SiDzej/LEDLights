package cj.ledlights.config;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;

import cj.ledlights.lib.BlockIds;
import cj.ledlights.lib.Reference;
import cj.ledlights.utils.LogHelper;

public class ConfigHandler {
    public static Configuration configuration;

    public static void init(File configFile) {
        Configuration conf = new Configuration(configFile);

        try {
            conf.load();
            BlockIds.LAMP = conf.getBlock("lamp",BlockIds.LAMP_DEFAULT).getInt(BlockIds.LAMP_DEFAULT);
            BlockIds.LAMP_ON = conf.getBlock("lampon",BlockIds.LAMP_ON_DEFAULT)
            		.getInt(BlockIds.LAMP_ON_DEFAULT);

        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, "Mod called " + Reference.MOD_NAME
                    + " was unable to load its configs!");
        } finally {
            conf.save();
        }

    }
}
