package pawpouk.rcBasicOres.items;

import pawpouk.rcBasicOres.lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemOreBlocks extends ItemBlock {
	public ItemOreBlocks(Block block) {
		super(block);
		setHasSubtypes(true);
	}
	
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return getUnlocalizedName() + "." + Constants.ORE_UNLOCALIZED_NAMES[itemStack.getItemDamage()];
    }
    
    @Override
    public int getMetadata(int meta) {
        return meta;
    }
    
}
