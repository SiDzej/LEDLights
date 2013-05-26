package cj.ledlights.block;

import net.minecraft.block.Block;
import cj.ledlights.lib.BlockIds;
import cj.ledlights.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {
	

    /* Mod block instances */
    public static Block lamp;

    public static void init() {

    	lamp = new BlockLamp(BlockIds.LAMP);

        GameRegistry.registerBlock(lamp, Strings.LAMP_NAME);
        
        LanguageRegistry.addName(lamp, Strings.LAMP_NAME);
        initBlockRecipes();
    }

    private static void initBlockRecipes() {

       // GameRegistry.addRecipe(new ItemStack(glassBell), new Object[] { "iii", "i i", "i i", Character.valueOf('i'), Block.glass });
       // GameRegistry.addRecipe(new ItemStack(aludelBase), new Object[] { "iii", "sis", "iii", Character.valueOf('i'), Item.ingotIron, Character.valueOf('s'), Block.stone });
    }
}
