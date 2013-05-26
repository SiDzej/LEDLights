package cj.ledlights.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cj.ledlights.lib.Strings;

public class ItemBlockLamp extends ItemBlock {
    public ItemBlockLamp(int par1) {
        super(par1);
        setHasSubtypes(true);
        setMaxDamage(0);
        //setNames(Strings.COLORS);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    public String getUnlocalizedName(ItemStack is) {
        int meta = is.getItemDamage();
        return Strings.COLORS[meta] + Strings.LAMP_NAME;
        //getUnlocalizedName() + "." + Strings.ORES[meta];
    }

}
