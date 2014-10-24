package pawpouk.rcBasicOres.blocks;

import java.util.List;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import pawpouk.rcBasicOres.items.ItemOreBlocks;
import pawpouk.rcBasicOres.lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.oredict.OreDictionary;


public class OreBlock extends Block {

	private String name = "rcoreblock";
	private int maxMeta = Constants.ORE_UNLOCALIZED_NAMES.length ;
	private IIcon[] icons;
	
	public OreBlock() {
		super(Material.rock);
		this.setBlockName(Constants.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockTextureName(Constants.MODID + ":" + name);
		icons = new IIcon[maxMeta];
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("pickaxe", 1);
		GameRegistry.registerBlock(this, ItemOreBlocks.class, name );
	}
	
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        for(int i = 0; i < icons.length; i++) {
            icons[i] = iconRegister.registerIcon(Constants.MODID + ":" + Constants.ORE_UNLOCALIZED_NAMES[i]);
        }
    }
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
    	return icons[meta];
    }
    
    @Override
    public int damageDropped(int meta) {
        return meta;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        for(int i = 0; i < maxMeta; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
