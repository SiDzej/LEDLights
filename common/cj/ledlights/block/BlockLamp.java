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
	
	private boolean powered; // on or off
	
	
	public BlockLamp(int id, boolean state) {
        super(id, Material.redstoneLight);
        setStepSound(soundGlassFootstep);
        setCreativeTab(CreativeTabs.tabRedstone);
        
        this.setHardness(1.5F);

        this.powered = state;
        
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
    	if(this.powered == true) tmp = "on";

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
		// prevent unwated state of lamp to show in creative tab
		if (this.blockID == BlockIds.LAMP_ON || this.blockID == BlockIds.LAMP_INV_OFF)
			return;
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
            if (this.powered)
            {
            	par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 4);
            }
            else if (!this.powered)
            { 
            	// turn on normal lamp
            	if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)){
            		if(this.blockID == BlockIds.LAMP_OFF)
	            		par1World.setBlock(par2, par3, par4, BlockIds.LAMP_ON, 
	            				par1World.getBlockMetadata(par2, par3, par4), 2);
            	}
            	// turn on inverted
            	else if(!par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)){
            		if(this.blockID == BlockIds.LAMP_INV_OFF)
    	            	par1World.setBlock(par2, par3, par4, BlockIds.LAMP_INV_ON, 
    	        				par1World.getBlockMetadata(par2, par3, par4), 2);
            	}
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
        	if (this.powered)
            {
            	par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 4);
            }
            else if (!this.powered)
            {

            	// turn on normal lamp
            	if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)){
            		if(this.blockID == BlockIds.LAMP_OFF)
	            		par1World.setBlock(par2, par3, par4, BlockIds.LAMP_ON, 
	            				par1World.getBlockMetadata(par2, par3, par4), 2);
            	}

            	// turn on inverted
            	else if(!par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)){
            		if(this.blockID == BlockIds.LAMP_INV_OFF)
    	            	par1World.setBlock(par2, par3, par4, BlockIds.LAMP_INV_ON, 
    	        				par1World.getBlockMetadata(par2, par3, par4), 2);
            	}
            }
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
        	if (this.powered)
        	{
        		// turn off normal lamp
        		if (!par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)){
        			if(this.blockID == BlockIds.LAMP_ON)
    	        		par1World.setBlock(par2, par3, par4, BlockIds.LAMP_OFF, 
    	        			par1World.getBlockMetadata(par2, par3, par4), 2);
        		}
        		// turn off inverted
    	        else if (this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)){
    	        	if(this.blockID == BlockIds.LAMP_INV_ON)
    	            	par1World.setBlock(par2, par3, par4, BlockIds.LAMP_INV_OFF, 
    	        			par1World.getBlockMetadata(par2, par3, par4), 2);
    	        }
        	}
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	if (this.blockID == BlockIds.LAMP_ON)
    		return BlockIds.LAMP_OFF;
    	
    	if (this.blockID == BlockIds.LAMP_INV_OFF)
    		return BlockIds.LAMP_INV_ON;
    	
    	return this.blockID;
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
    	if (this.blockID == BlockIds.LAMP_ON)
    		return BlockIds.LAMP_OFF;
    	
    	if (this.blockID == BlockIds.LAMP_INV_OFF)
    		return BlockIds.LAMP_INV_ON;
    	
    	return this.blockID;
        
    }

}
