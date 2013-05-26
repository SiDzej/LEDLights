package cj.ledlights.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cj.ledlights.lib.BlockIds;
import cj.ledlights.lib.Reference;
import cj.ledlights.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLamp extends Block {
	
	private boolean state; // Normal or Inverted lamp
	private boolean powered; // on or off
	
	
	public BlockLamp(int id, boolean state) {
        super(id, Material.glass);
        setStepSound(soundGlassFootstep);
        setCreativeTab(CreativeTabs.tabRedstone);
        
        this.setHardness(1.5F);

        this.powered = false;
        this.state = state;
        
        if (state)
        {
            this.setLightValue(1.0F);
        }
    }
	
	// Return metadata for itemBlock (not damage but subID)
	@Override
	public int damageDropped(int meta){
		return meta;
	}
	
	@SideOnly(Side.CLIENT)
    private Icon[] icons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir) {
    	icons = new Icon[Strings.COLORS.length];
    	String tmp = "";
    	if(this.state == true) tmp = "on";

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
	
	
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            if (this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
            	powered = !powered;
            	this.setLightValue(0.0F);
            	par1World.setLightValue(EnumSkyBlock.Block, par2, par3, par4, 0);
                par1World.updateLightByType(EnumSkyBlock.Block, par2, par3, par4);
            }
            else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
            	powered = !powered;
            	this.setLightValue(1.0F);
            	par1World.setLightValue(EnumSkyBlock.Block, par2, par3, par4, 15);
                par1World.updateLightByType(EnumSkyBlock.Block, par2, par3, par4);            				
            }
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            if (this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
            	powered = !powered;
            	this.setLightValue(0.0F);
            	par1World.setLightValue(EnumSkyBlock.Block, par2, par3, par4, 0);
                par1World.updateLightByType(EnumSkyBlock.Block, par2, par3, par4);
            }
            else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
            	powered = !powered;
            	this.setLightValue(1.0F);
            	par1World.setLightValue(EnumSkyBlock.Block, par2, par3, par4, 15);
                par1World.updateLightByType(EnumSkyBlock.Block, par2, par3, par4);
            }
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote && this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
        {
        	powered = !powered;
        	this.setLightValue(0.0F);
        	par1World.setLightValue(EnumSkyBlock.Block, par2, par3, par4, 0);
            par1World.updateLightByType(EnumSkyBlock.Block, par2, par3, par4);
        }
    }

}
