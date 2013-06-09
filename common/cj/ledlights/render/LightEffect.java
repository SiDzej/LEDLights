package cj.ledlights.render;
 
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cj.ledlights.ClientProxy;
import cj.ledlights.block.BlockLamp;
import cj.ledlights.lib.BlockIds;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
 
public class LightEffect implements ISimpleBlockRenderingHandler {
 
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
    	Tessellator tessellator = Tessellator.instance;
        
        renderer.setRenderBoundsFromBlock(block);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
 
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
        tessellator.draw();
 
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, metadata));
        tessellator.draw();
 
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, metadata));
        tessellator.draw();
 
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, metadata));
        tessellator.draw();
 
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, metadata));
        tessellator.draw();
 
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, metadata));
        tessellator.draw();
 
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }
 
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block blocka, int modelId, RenderBlocks renderer)         {
    	if (ClientProxy.renderPass == 1) {
    		if(!((BlockLamp)blocka).getPowered()) // dont render not powered lamps
    			return false;
    		/** avoid texture glitching */
    		double p = 19D;
    		double a,b,c,d,e,f;
    		a=b=c=d=e=f=1;
    		int tmpId = world.getBlockId(x + 1, y, z);
    		if( tmpId != BlockIds.LAMP_ON && tmpId != BlockIds.LAMP_INV_ON)
    			a = (p+1)/p; // east
    		tmpId = world.getBlockId(x - 1, y, z);
    		if( tmpId == BlockIds.LAMP_ON || tmpId == BlockIds.LAMP_INV_ON)
    			b = 0; // west
    		tmpId = world.getBlockId(x, y + 1, z);
    		if( tmpId != BlockIds.LAMP_ON && tmpId != BlockIds.LAMP_INV_ON)
    			c = (p+1)/p; //up
    		tmpId = world.getBlockId(x, y - 1, z);
    		if( tmpId == BlockIds.LAMP_ON || tmpId == BlockIds.LAMP_INV_ON)
    			d = 0; //down
    		tmpId = world.getBlockId(x, y, z + 1);
    		if( tmpId != BlockIds.LAMP_ON && tmpId != BlockIds.LAMP_INV_ON)
    			e = (p+1)/p; //south
    		tmpId = world.getBlockId(x, y, z - 1);
    		if( tmpId == BlockIds.LAMP_ON || tmpId == BlockIds.LAMP_INV_ON)
    			f = 0; // north
    		
            renderer.overrideBlockBounds(-1/p*b, -1/p*d, -1/p*f, a, c, e);
            
            renderer.setOverrideBlockTexture(BlockLamp.getEffect());
            int meta = world.getBlockMetadata(x, y, z);
            renderer.renderStandardBlockWithColorMultiplier(Block.ice, x, y, z, 
            		BlockLamp.overlay[meta][0], BlockLamp.overlay[meta][1], BlockLamp.overlay[meta][2]);
            
            renderer.clearOverrideBlockTexture();
            renderer.unlockBlockBounds();
            return true;
        } else {
            if(renderer.hasOverrideBlockTexture()){
                renderer.clearOverrideBlockTexture();
            }
            renderer.renderStandardBlock(blocka, x, y, z);
            return true;
        }
    }
 
    @Override
    public boolean shouldRender3DInInventory() {
        return true;
    }
 
    @Override
    public int getRenderId() {
        return ClientProxy.blockLampRenderType;
    }
 
}