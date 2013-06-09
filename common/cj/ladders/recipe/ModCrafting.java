package cj.ladders.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cj.ladders.block.ModBlocks;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void init() {
		
		initLadders();

	}

	private static void initLadders() {
		// iron ladder
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.ironladder, 4, 0), true,
				new Object[] { "I I", "I-I", "I I", Character.valueOf('I'), Item.stick,
						Character.valueOf('-'), "ingotIron" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.ironladder, 4, 0), true,
				new Object[] { "I I", "I-I", "I I", Character.valueOf('I'), Item.stick,
						Character.valueOf('-'), Item.ingotIron }));
		// golden ladder
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.goldenladder, 8, 0), true,
				new Object[] { "I I", "I-I", "I I", Character.valueOf('I'), Item.stick,
						Character.valueOf('-'), "ingotGold" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.goldenladder, 8, 0), true,
				new Object[] { "I I", "I-I", "I I", Character.valueOf('I'), Item.stick,
						Character.valueOf('-'), Item.ingotGold }));
		// diamond ladder
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.diamondladder, 16, 0), true,
				new Object[] { "I I", "I-I", "I I", Character.valueOf('I'), Item.stick,
						Character.valueOf('-'), Item.diamond }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.obsidianladder, 2, 0), true,
				new Object[] { "I I", "I-I", "I I", Character.valueOf('I'), Item.stick,
						Character.valueOf('-'), Block.obsidian }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.lapisladder, 2, 0), true,
				new Object[] { "I I", "I-I", "I I", Character.valueOf('I'), Item.stick,
						Character.valueOf('-'), new ItemStack(Item.dyePowder, 1, 4) }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.emeraldladder, 8, 0), true,
				new Object[] { "I I", "I-I", "I I", Character.valueOf('I'), Item.stick,
						Character.valueOf('-'), Item.emerald }));
		
		// warn ladder
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.warnladder, 4, 0), true,
				new Object[] { "IxI", "III", "IyI", Character.valueOf('I'), Item.stick,
						Character.valueOf('x'), new ItemStack(Item.dyePowder, 1, 0),
						Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.warnladder, 4, 0), true,
				new Object[] { "IyI", "III", "IxI", Character.valueOf('I'), Item.stick,
						Character.valueOf('x'), new ItemStack(Item.dyePowder, 1, 0),
						Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11)}));
	}

}
