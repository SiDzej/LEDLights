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
            BlockIds.LAMP_OFF = conf.getBlock("lampOff",BlockIds.LAMP_OFF_DEFAULT)
            		.getInt(BlockIds.LAMP_OFF_DEFAULT);
            BlockIds.LAMP_ON = conf.getBlock("lampOn",BlockIds.LAMP_ON_DEFAULT)
            		.getInt(BlockIds.LAMP_ON_DEFAULT);
            
            BlockIds.LAMP_INV_OFF = conf.getBlock("lampInvOff",BlockIds.LAMP_INV_OFF_DEFAULT)
            		.getInt(BlockIds.LAMP_INV_OFF_DEFAULT);
            BlockIds.LAMP_INV_ON = conf.getBlock("lampInvOn",BlockIds.LAMP_INV_ON_DEFAULT)
            		.getInt(BlockIds.LAMP_INV_ON_DEFAULT);

        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, "Mod called " + Reference.MOD_NAME
                    + " was unable to load its configs!");
        } finally {
            conf.save();
        }

    }
}
