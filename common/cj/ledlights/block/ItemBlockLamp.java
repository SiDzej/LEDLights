package cj.ledlights.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cj.ledlights.lib.Strings;

public class ItemBlockLamp extends ItemBlock {
	
    public ItemBlockLamp(int par1) {
        super(par1);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    // The original name of block will be connected to this name
    // so we have to be sure that name will be unique
    @Override
    public String getUnlocalizedName(ItemStack is) {
        int meta = is.getItemDamage();
        return Strings.COLORS[meta] + Strings.LAMP_NAME + "ID_" + is.itemID; // set unique unlocalized name
    }    
}
