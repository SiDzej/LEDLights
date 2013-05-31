package cj.ledlights;

import cj.ledlights.render.LightEffect;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	public static int blockLampRenderType;
	public static int renderPass;

	public static void setCustomRenderers() {
		blockLampRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new LightEffect());
	}
}