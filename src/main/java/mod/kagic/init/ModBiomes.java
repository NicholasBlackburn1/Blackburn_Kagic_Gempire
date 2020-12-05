package mod.kagic.init;

import mod.kagic.biomes.BiomeHomeworld;
import mod.kagic.biomes.BiomeLion;
import mod.kagic.world.biome.BiomeFloatingPeaks;
import mod.kagic.world.biome.BiomeKindergarten;
import mod.kagic.world.biome.BiomeStrawberryBattlefield;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
/** 
 * this class regesters new bioms to mc 
 * @param Biomes homeworld,
 * LION
 * ,KINDERGARTEN
 * ,FLOATINGPEAKS
 * ,STRAWBERRYBATTLEFIELD
 * 
 */
public class ModBiomes {
	public static final Biome HOMEWORLD = new BiomeHomeworld();
	public static final Biome LION = new BiomeLion();
	public static final Biome KINDERGARTEN = new BiomeKindergarten();
	public static final Biome FLOATINGPEAKS = new BiomeFloatingPeaks();
	public static final Biome STRAWBERRYBATTLEFIELD = new BiomeStrawberryBattlefield();

	// Registers all Biomes
	public static void register(RegistryEvent.Register<Biome> event) {
		BiomeManager.addBiome(BiomeType.DESERT, new BiomeManager.BiomeEntry(HOMEWORLD, 0));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeManager.BiomeEntry(LION, 0));
		
		KAGIC.logger.info("Setting biome weights: Kindergarten = " + ModConfigs.kindergartenWeight + ", Floating Peaks = " + ModConfigs.floatingPeaksWeight);
		event.getRegistry().register(ModBiomes.KINDERGARTEN);
		BiomeManager.addBiome(BiomeType.DESERT, new BiomeManager.BiomeEntry(ModBiomes.KINDERGARTEN, ModConfigs.kindergartenWeight));
		BiomeDictionary.addTypes(ModBiomes.KINDERGARTEN, Type.DEAD, Type.DRY, Type.MESA, Type.SPOOKY, Type.WASTELAND, Type.RARE);
		event.getRegistry().register(ModBiomes.FLOATINGPEAKS);
		BiomeManager.addBiome(BiomeType.WARM, new BiomeManager.BiomeEntry(ModBiomes.FLOATINGPEAKS, ModConfigs.floatingPeaksWeight));
		BiomeManager.addSpawnBiome(ModBiomes.FLOATINGPEAKS);
		BiomeDictionary.addTypes(ModBiomes.FLOATINGPEAKS, Type.MOUNTAIN, Type.SAVANNA, Type.MAGICAL, Type.DRY, Type.RARE);
		event.getRegistry().register(ModBiomes.STRAWBERRYBATTLEFIELD);
		BiomeManager.addBiome(BiomeType.WARM, new BiomeManager.BiomeEntry(ModBiomes.STRAWBERRYBATTLEFIELD, ModConfigs.strawberryBattlefieldWeight));
		BiomeDictionary.addTypes(ModBiomes.STRAWBERRYBATTLEFIELD, Type.HILLS, Type.PLAINS, Type.MAGICAL, Type.LUSH, Type.RARE);
	}
}
