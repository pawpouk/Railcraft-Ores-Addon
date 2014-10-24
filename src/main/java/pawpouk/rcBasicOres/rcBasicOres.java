package pawpouk.rcBasicOres;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import pawpouk.rcBasicOres.blocks.OreBlocks;
import pawpouk.rcBasicOres.config.ConfigurationHandler;
import pawpouk.rcBasicOres.lib.Constants;
import pawpouk.rcBasicOres.world.WorldGenRCOres;


@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.VERSION, dependencies = "required-after:Railcraft;before:RcDusts")
public class rcBasicOres {

	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		OreBlocks.init();
		OreBlocks.registerOres();
		GameRegistry.registerWorldGenerator(new WorldGenRCOres(), 20);
    }
 
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
 
    }
 
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
 
    }

}
