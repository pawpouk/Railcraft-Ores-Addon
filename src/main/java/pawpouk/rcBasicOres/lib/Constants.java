package pawpouk.rcBasicOres.lib;

public class Constants {
	//General informations
	public static final String MODID = "rcbasicores";
	public static final String MODNAME = "Railcraft Basic Ores";
	public static final String VERSION = "0.1";
	
	//Ore informations
	public static final String[] ORE_UNLOCALIZED_NAMES = {"blockOreCopper", "blockOreTin", "blockOreLead"};
	public static final String[] ORE_NAMES = {"Copper", "Tin", "Lead"};
	public static final String[] OREDICTIONARY_ORES = { "oreCopper", "oreTin", "oreLead" };
	public static final String[] OREDICTIONARY_INGOTS = { "ingotCopper", "ingotTin", "ingotLead" };

	//WorldGen values
	public static final int[] GEN_SPAWN_CHANCE = { 10, 5, 5 };
	public static final int[] GEN_MIN_VEIN_SIZE = { 4, 4, 4 };
	public static final int[] GEN_MAX_VEIN_SIZE = { 8, 8, 8 };
	public static final int[] GEN_MIN_Y_POS = { 20, 0, 30 };
	public static final int[] GEN_MAX_Y_POS = { 60, 45, 64 };
	public static final boolean[] GEN_ONLY_ONE_VEIN = { false, false, false };
}
