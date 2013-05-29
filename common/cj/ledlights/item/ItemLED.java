package cj.ledlights.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cj.ledlights.LEDLights;
import cj.ledlights.lib.Reference;
import cj.ledlights.lib.Strings;

public class ItemLED extends Item {

	public ItemLED(int id) {
        super(id);
        setHasSubtypes(true);
        setMaxDamage(0);
        setCreativeTab(LEDLights.tab);
    }
	
	@SideOnly(Side.CLIENT)
    private Icon[] icons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir) {
        icons = new Icon[Strings.COLORS.length];

        for (int i = 0; i < Strings.COLORS.length; i++) {
            icons[i] = ir.registerIcon((Reference.TEXTURES
                    + Strings.COLORS[i] + Strings.LED_NAME).toLowerCase());
        }
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int i) {
        return icons[i];
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        int meta = is.getItemDamage();
        return Strings.COLORS[meta] + "." + Strings.LED_NAME;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs creativetab, List list) {
        for (int i = 0; i < Strings.COLORS.length; i++) {
            list.add(new ItemStack(par1, 1, i));
        }
    }
}
