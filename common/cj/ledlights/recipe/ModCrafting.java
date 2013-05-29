package cj.ledlights.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cj.ledlights.block.ModBlocks;
import cj.ledlights.item.ModItems;
import cj.ledlights.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void init(){
		
		initLEDs();
		initLamps();
		
	}
	
	private static void initLEDs(){
		for (int i = 0; i < Strings.COLORS.length; i++) {
			GameRegistry.addRecipe(new ItemStack(ModItems.led, 2, i), new Object[] { " # ", "OAO"," I ",
				Character.valueOf('#'), Item.lightStoneDust, Character.valueOf('I'), Item.ingotIron,
				Character.valueOf('O'), new ItemStack(Item.dyePowder, 1, Strings.COLORS.length - i - 1),
				Character.valueOf('A'), Item.redstone});
		}
	}
	
	private static void initLamps(){
		for (int i = 0; i < Strings.COLORS.length; i++) {
			GameRegistry.addRecipe(new ItemStack(ModBlocks.lampOff, 1, i), new Object[]{"#L#", "#L#","#R#",
				Character.valueOf('#'), Block.thinGlass, Character.valueOf('R'), Item.redstone,
				Character.valueOf('L'), new ItemStack(ModItems.led, 1, i),});
			GameRegistry.addRecipe(new ItemStack(ModBlocks.lampInvOn, 1, i), new Object[]{"#L#", "#L#","#T#",
				Character.valueOf('#'), Block.thinGlass, Character.valueOf('T'), Block.torchRedstoneActive,
				Character.valueOf('L'), new ItemStack(ModItems.led, 1, i)});
		}
	}
	
}
