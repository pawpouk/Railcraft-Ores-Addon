package pawpouk.rcBasicOres.config;

import java.io.File;

import pawpouk.rcBasicOres.lib.Constants;

import net.minecraftforge.common.config.Configuration;

public final class ConfigurationHandler {

//	public static boolean doGenCopper;
//	public static boolean doGenTin;
//	public static boolean doGenLead;
	
	public static boolean[] doGenOre;
	
	public static void init(File file) {
		doGenOre = new boolean[Constants.OREDICTIONARY_ORES.length];
		Configuration config = new Configuration(file);
		config.load();
		for (int i=0; i< doGenOre.length; i++) {
			String name = Constants.ORE_NAMES[i];
			doGenOre[i] = config.getBoolean(name, "WorldGen ores", true, "Generate " + name + " deposits");
		}
		
//		doGenCopper = config.getBoolean("Copper", "WorldGen ores", true, "Generate copper deposits");
//		doGenTin = config.getBoolean("Tin", "WorldGen ores", true, "Generate tin deposits");
//		doGenLead = config.getBoolean("Lead", "WorldGen ores", true, "Generate tin deposits");

		config.save();
		
	}
	
}
