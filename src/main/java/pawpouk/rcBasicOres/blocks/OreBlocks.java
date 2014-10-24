package pawpouk.rcBasicOres.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import pawpouk.rcBasicOres.config.ConfigurationHandler;
import pawpouk.rcBasicOres.lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class OreBlocks {
	public static Block rcOre;
	public static boolean hasCopperIngot;
	public static boolean hasLeadIngot;
	public static boolean hasTinIngot;
	
	public static void init(){
		rcOre = new OreBlock();
	}
	
	public static void registerOres() {
		for (int i=0; i < Constants.OREDICTIONARY_ORES.length; i++) {
			if( ConfigurationHandler.doGenOre[i]==true) {
				ItemStack newOreStack = new ItemStack(rcOre, 1, i);
				//register ore
				OreDictionary.registerOre(Constants.OREDICTIONARY_ORES[i], newOreStack);
				//smelting receipes
				boolean ingotAvailable = !OreDictionary.getOres(Constants.OREDICTIONARY_INGOTS[i]).isEmpty();
				if (ingotAvailable) {
					GameRegistry.addSmelting(newOreStack, OreDictionary.getOres(Constants.OREDICTIONARY_INGOTS[i]).get(0), 0.1f);
				}
			}
		}
	}
}
