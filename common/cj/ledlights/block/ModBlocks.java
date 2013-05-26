package cj.ledlights.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cj.ledlights.lib.BlockIds;
import cj.ledlights.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {
	
    /* Mod block instances */
    public static Block lamp,lampon;

    public static void init() {

    	lamp = new BlockLamp(BlockIds.LAMP, 0); // second param for specify on/off state
    	lampon = new BlockLamp(BlockIds.LAMP_ON, 1);

        GameRegistry.registerBlock(lamp, ItemBlockLamp.class,Strings.LAMP_NAME + "set");
        GameRegistry.registerBlock(lampon, ItemBlockLamp.class,Strings.LAMP_NAME + "on"+ "set");
        
        for (int i = 0; i < Strings.COLORS.length; i++) {
	        LanguageRegistry.addName(new ItemStack(lamp, 1, i),
	        		Strings.COLORS[i] + " " + Strings.LAMP_NAME);
	        LanguageRegistry.addName(new ItemStack(lampon, 1, i),
	        		"Inverted " + Strings.COLORS[i] + " " + Strings.LAMP_NAME);
        }
        //initBlockRecipes();
    }

    private static void initBlockRecipes() {

       // GameRegistry.addRecipe(new ItemStack(glassBell), new Object[] { "iii", "i i", "i i", Character.valueOf('i'), Block.glass });
       // GameRegistry.addRecipe(new ItemStack(aludelBase), new Object[] { "iii", "sis", "iii", Character.valueOf('i'), Item.ingotIron, Character.valueOf('s'), Block.stone });
    }
}
