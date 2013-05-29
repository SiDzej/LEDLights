package cj.ledlights.block;


import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cj.ledlights.lib.BlockIds;
import cj.ledlights.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {
	
    /* Mod block instances */
    public static Block lampOff, lampOn;
    public static Block lampInvOff, lampInvOn;

    public static void init() {
    	
    	initLamps(); // init all block-like lamps
        //initBlockRecipes();
    }

    private static void initBlockRecipes() {

       // GameRegistry.addRecipe(new ItemStack(glassBell), new Object[] { "iii", "i i", "i i", Character.valueOf('i'), Block.glass });
       // GameRegistry.addRecipe(new ItemStack(aludelBase), new Object[] { "iii", "sis", "iii", Character.valueOf('i'), Item.ingotIron, Character.valueOf('s'), Block.stone });
    }
    
    
    private static void initLamps(){
    	// getting IDs
    	lampOff = new BlockLamp(BlockIds.LAMP_OFF, false); // second param for specify on/off state
    	lampOn = new BlockLamp(BlockIds.LAMP_ON, true); 
    	
    	lampInvOff = new BlockLamp(BlockIds.LAMP_INV_OFF, false);
    	lampInvOn = new BlockLamp(BlockIds.LAMP_INV_ON, true);
    	
    	// register normal lamps
        GameRegistry.registerBlock(lampOff, ItemBlockLamp.class,Strings.LAMP_NAME + "OffSet");
        GameRegistry.registerBlock(lampOn, ItemBlockLamp.class,Strings.LAMP_NAME + "OnSet");
        // register inverted lamps
        GameRegistry.registerBlock(lampInvOff, ItemBlockLamp.class, Strings.LAMP_NAME + "InvOffSet");
        GameRegistry.registerBlock(lampInvOn, ItemBlockLamp.class, Strings.LAMP_NAME + "InvOnSet");
        
        for (int i = 0; i < Strings.COLORS.length; i++) {
	        LanguageRegistry.addName(new ItemStack(lampOff, 1, i),
	        		Strings.COLORS[i] + " " + Strings.LAMP_NAME);

	        LanguageRegistry.addName(new ItemStack(lampInvOn, 1, i),
	        		"Inverted " + Strings.COLORS[i] + " " + Strings.LAMP_NAME);
        }
    }
    
}
