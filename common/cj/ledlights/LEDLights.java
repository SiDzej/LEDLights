package cj.ledlights;

/**
 * LED Lights
 * 
 * @author _CJ_
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

import cj.ledlights.block.ModBlocks;
import cj.ledlights.config.ConfigHandler;
import cj.ledlights.creativetabs.CreaTab;
import cj.ledlights.item.ModItems;
import cj.ledlights.lib.Reference;
import cj.ledlights.recipe.ModCrafting;
import cj.ledlights.utils.LogHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod( modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class LEDLights {
	
	@Instance(Reference.MOD_ID)
    public static LEDLights instance;
	
	public static CreaTab tab = new CreaTab(CreaTab.getNextID(),
            Reference.MOD_ID);
	
	@SidedProxy(clientSide="cj.ledlights.ClientProxy", serverSide="cj.ledlights.CommonProxy")
    public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		
		// super Log Helper init for LEDLights
		LogHelper.init();
		
		// Load config to get our IDs and so
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		// Loading blocks
		ModBlocks.init();
		ModItems.init();
		
		ModCrafting.init();
		
		ClientProxy.setCustomRenderers();
	}
	
	@Init
	public void Init(FMLInitializationEvent event){
		
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
