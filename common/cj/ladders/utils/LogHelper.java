package cj.ladders.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import cj.ladders.lib.Reference;

import cpw.mods.fml.common.FMLLog;

/**
 * LED Lights
 * 
 * LogHelper
 * 
 * @author _CJ_
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class LogHelper {

    private static Logger logger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {

    	logger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String in) {

    	logger.log(logLevel, in);
    }

}
