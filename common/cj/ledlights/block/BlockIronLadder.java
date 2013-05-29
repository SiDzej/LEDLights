package cj.ledlights.block;

import net.minecraft.block.BlockLadder;
import net.minecraft.client.renderer.texture.IconRegister;
import cj.ledlights.LEDLights;

public class BlockIronLadder extends BlockLadder {

	public BlockIronLadder(int par1) {
		super(par1);
		setCreativeTab(LEDLights.tab);
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("ledlights:ironladder");
    }
}


