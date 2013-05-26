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
    public static Block lamp;
    
    public static ItemStack[] lamps;

    public static void init() {

    	lamp = new BlockLamp(BlockIds.LAMP);

        GameRegistry.registerBlock(lamp, ItemBlockLamp.class, Strings.LAMP_NAME);
        
        lamps = new ItemStack[Strings.COLORS.length];
        for (int i = 0; i < Strings.COLORS.length; i++) {
        	lamps[i] = new ItemStack(lamp, 1, i);
            LanguageRegistry.addName(lamps[i],
            Strings.COLORS[i] + " " + Strings.LAMP_NAME);
            GameRegistry.registerBlock(lamp, ItemBlockLamp.class, Strings.COLORS[i] + " " + Strings.LAMP_NAME);
        }
        //LanguageRegistry.addName(lamp, Strings.LAMP_NAME);
        //initBlockRecipes();
    }

    private static void initBlockRecipes() {

       // GameRegistry.addRecipe(new ItemStack(glassBell), new Object[] { "iii", "i i", "i i", Character.valueOf('i'), Block.glass });
       // GameRegistry.addRecipe(new ItemStack(aludelBase), new Object[] { "iii", "sis", "iii", Character.valueOf('i'), Item.ingotIron, Character.valueOf('s'), Block.stone });
    }
}
