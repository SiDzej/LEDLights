package cj.ledlights.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cj.ledlights.lib.Reference;
import cj.ledlights.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLamp extends Block {
	
	private int state;
	private int id;
	
	public BlockLamp(int id, int state) {
        super(id, Material.glass);
        setStepSound(soundGlassFootstep);
        setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(5F);
        this.setLightValue(1.0f);
        this.state = state;  
        this.id = id;
    }
	
	@SideOnly(Side.CLIENT)
    private Icon[] icons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir) {
    	icons = new Icon[Strings.COLORS.length];
    	String tmp = "";
    	if(this.state == 1) tmp = "on";

        for (int i = 0; i < Strings.COLORS.length; i++) {
            icons[i] = ir.registerIcon(Reference.TEXTURES + Strings.COLORS[i].toLowerCase() 
            		+ Strings.LAMP_NAME + tmp);
        }
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return icons[meta];
    }

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < Strings.COLORS.length; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}
}
