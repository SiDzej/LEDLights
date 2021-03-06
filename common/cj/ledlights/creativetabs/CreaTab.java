package cj.ledlights.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import cj.ledlights.block.ModBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreaTab extends CreativeTabs {

    public CreaTab(int id, String name) {
        super(id, name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {
        return ModBlocks.lampOff.blockID;
    }

    @Override
    public String getTranslatedTabLabel() {
        return "LED Lights";
    }

}
