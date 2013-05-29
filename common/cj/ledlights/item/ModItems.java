package cj.ledlights.item;

import cj.ledlights.block.ItemBlockLamp;
import cj.ledlights.lib.ItemIds;
import cj.ledlights.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems {
	
	public static Item led;
	
	public static void init() {
    	
    	initLed(); // init all block-like lamps
    }
	
	private static void initLed(){
		
		led = new ItemLED(ItemIds.LED);
				
		GameRegistry.registerItem(led, Strings.LED_NAME);
		
		for (int i = 0; i < Strings.COLORS.length; i++) {
	        LanguageRegistry.addName(new ItemStack(led, 1, i),
	        		Strings.COLORS[i] + " " + Strings.LED_NAME);;
        }
	}

}
