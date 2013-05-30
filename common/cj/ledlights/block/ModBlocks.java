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

	public static Block ironladder,goldenladder,diamondladder,obsidianladder,
		lapisladder,emeraldladder,warnladder;

	public static void init() {

		initLamps(); // init all block-like lamps

		int i = 0;
		// init ladders
		ironladder = new BlockLadders(BlockIds.IRON_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(ironladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		goldenladder = new BlockLadders(BlockIds.GOLDEN_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(goldenladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		diamondladder = new BlockLadders(BlockIds.DIAMOND_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(diamondladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		obsidianladder = new BlockLadders(BlockIds.OBSIDIAN_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(obsidianladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		lapisladder = new BlockLadders(BlockIds.LAPIS_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(lapisladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		emeraldladder = new BlockLadders(BlockIds.EMERALD_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(emeraldladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		warnladder = new BlockLadders(BlockIds.WARN_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(warnladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		
		i=0;
		LanguageRegistry.addName(ironladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(goldenladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(diamondladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(obsidianladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(lapisladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(emeraldladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(warnladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);

	}

	private static void initLamps() {
		// getting IDs
		lampOff = new BlockLamp(BlockIds.LAMP_OFF, false); // second param for
															// specify on/off
															// state
		lampOn = new BlockLamp(BlockIds.LAMP_ON, true);

		lampInvOff = new BlockLamp(BlockIds.LAMP_INV_OFF, false);
		lampInvOn = new BlockLamp(BlockIds.LAMP_INV_ON, true);

		// register normal lamps
		GameRegistry.registerBlock(lampOff, ItemBlockLamp.class, Strings.LAMP_NAME + "OffSet");
		GameRegistry.registerBlock(lampOn, ItemBlockLamp.class, Strings.LAMP_NAME + "OnSet");
		// register inverted lamps
		GameRegistry
				.registerBlock(lampInvOff, ItemBlockLamp.class, Strings.LAMP_NAME + "InvOffSet");
		GameRegistry.registerBlock(lampInvOn, ItemBlockLamp.class, Strings.LAMP_NAME + "InvOnSet");

		for (int i = 0; i < Strings.COLORS.length; i++) {
			LanguageRegistry.addName(new ItemStack(lampOff, 1, i), Strings.COLORS[i] + " "
					+ Strings.LAMP_NAME);

			LanguageRegistry.addName(new ItemStack(lampInvOn, 1, i), "Inverted "
					+ Strings.COLORS[i] + " " + Strings.LAMP_NAME);
		}
	}

}
