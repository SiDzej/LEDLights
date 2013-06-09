package cj.ladders.block;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLadder;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cj.ladders.LEDLights;
import cj.ladders.lib.BlockIds;
import cj.ladders.lib.Reference;
import cj.ladders.lib.Strings;
import cj.ladders.utils.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLadders extends BlockLadder {

	public BlockLadders(int par1) {
		super(par1);
		//setMaterial(Material.iron);
		setCreativeTab(LEDLights.tab);
		setStepSound(soundMetalFootstep);
	}

	// Return metadata for itemBlock (not damage but subID)
	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		if(this.blockID == BlockIds.IRON_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[0] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.GOLDEN_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[1] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.DIAMOND_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[2] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.OBSIDIAN_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[3] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.LAPIS_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[4] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.EMERALD_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[5] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.WARN_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[6] + Strings.LADDER_NAME).toLowerCase());
	}
	
	public String getUnlocalizedName(String par1Str)
    {
        return Strings.LADDER_NAME + this.blockID;
    }
}
