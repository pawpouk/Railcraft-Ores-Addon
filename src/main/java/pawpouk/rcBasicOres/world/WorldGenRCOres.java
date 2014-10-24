package pawpouk.rcBasicOres.world;

import java.util.Random;

import pawpouk.rcBasicOres.blocks.OreBlocks;
import pawpouk.rcBasicOres.config.ConfigurationHandler;
import pawpouk.rcBasicOres.lib.Constants;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenRCOres implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		switch (world.provider.dimensionId) {
			case 0: GenerateOresOverworld(random, chunkX *16, chunkZ*16, world); break;
			case -1: GenerateOresNether(random, chunkX *16, chunkZ*16, world); break;
			case 1: GenerateOresEnd(random, chunkX *16, chunkZ*16, world); break;
			default: GenerateOresOverworld(random, chunkX *16, chunkZ*16, world); break;
		}

	}

	private void GenerateOresOverworld(Random random, int x, int z, World world) {
		//Biomes: Extreme Hills will have different maxY and more resources... 
		// 3 	Extreme Hills 	
		// 131 	Extreme Hills M
		// 20 	Extreme Hills Edge
		// 34 	Extreme Hills+ 	
		// 162 	Extreme Hills+ M
		int biomeID = world.getBiomeGenForCoords(x, z).biomeID;
		if (biomeID == 3 || biomeID == 131 || biomeID == 20 || biomeID == 34 || biomeID == 162) {
			for (int i=0; i < Constants.GEN_MAX_VEIN_SIZE.length; i++) {
				if (ConfigurationHandler.doGenOre[i] == true) {
					int finalChance = (int) (Constants.GEN_SPAWN_CHANCE[i] * 1.5F);
					int finalMaxY = (int) Math.min(120, Constants.GEN_MAX_Y_POS[i] * 1.5F);
				
					this.addOreSpawn(OreBlocks.rcOre, i, Blocks.stone , world, random, x, z, 
							Constants.GEN_MIN_VEIN_SIZE[i], Constants.GEN_MAX_VEIN_SIZE[i], finalChance, 
							Constants.GEN_MIN_Y_POS[i], finalMaxY, Constants.GEN_ONLY_ONE_VEIN[i]);
				}
			}
		}
		else {
			for (int i=0; i < Constants.GEN_MAX_VEIN_SIZE.length; i++) {
				if (ConfigurationHandler.doGenOre[i] == true) {
					this.addOreSpawn(OreBlocks.rcOre, i, Blocks.stone , world, random, x, z, 
							Constants.GEN_MIN_VEIN_SIZE[i], Constants.GEN_MAX_VEIN_SIZE[i], Constants.GEN_SPAWN_CHANCE[i], 
							Constants.GEN_MIN_Y_POS[i], Constants.GEN_MAX_Y_POS[i], Constants.GEN_ONLY_ONE_VEIN[i]);
				}
			}
		}

	}

	private void GenerateOresNether(Random random, int x, int z, World world) {
		// TODO Auto-generated method stub
		
	}
	
	private void GenerateOresEnd(Random random, int x, int z, World world) {
		// TODO Auto-generated method stub
		
	}

	private void addOreSpawn(Block block, Block replacedBlock, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY, boolean genOnce )
    {
        WorldGenMinable minable = new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), replacedBlock);
        boolean success = false; 
        for(int i = 0; i < chancesToSpawn; i++)
        {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            success = minable.generate(world, random, posX, posY, posZ);
            if (success == true && genOnce == true) {
            	break;
            }
        }
    }
	
	private void addOreSpawn(Block block, int meta, Block replacedBlock, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY, boolean genOnce)
    {
        WorldGenMinable minable = new WorldGenMinable(block, meta, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), replacedBlock);
        boolean success = false;

        for(int i = 0; i < chancesToSpawn; i++)
        {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            success = minable.generate(world, random, posX, posY, posZ);
            if (success == true && genOnce == true) {
            	break;
            }
        }
    }

	


}
