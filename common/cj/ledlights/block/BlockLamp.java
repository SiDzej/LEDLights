package cj.ledlights.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import cj.ledlights.lib.Reference;
import cj.ledlights.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLamp extends Block {
	
	public BlockLamp(int id) {

        super(id, Material.glass);
        this.setUnlocalizedName(Strings.LAMP_NAME);
        setStepSound(soundGlassFootstep);
        setCreativeTab(CreativeTabs.tabMaterials);
        this.setHardness(5F);
        this.setLightValue(1.0f);
    }
	
	@SideOnly(Side.CLIENT)
	
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	
	
	
	
	
	
	@SideOnly(Side.CLIENT)
    private Icon icon;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir) {
    	icon = ir.registerIcon(Reference.TEXTURES + Strings.LAMP_NAME);

    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return icon;
    }

}
