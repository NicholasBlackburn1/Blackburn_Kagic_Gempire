package mod.kagic.world;

import java.util.ArrayList;
import java.util.Random;

import mod.kagic.init.ModConfigs;
import mod.kagic.world.structure.AncientSkyArena;
import mod.kagic.world.structure.CommunicationHub;
import mod.kagic.world.structure.ControlRoom;
import mod.kagic.world.structure.DesertWarpPad;
import mod.kagic.world.structure.GalaxyWarp;
import mod.kagic.world.structure.GiantWeapon;
import mod.kagic.world.structure.LunarSeaSpire;
import mod.kagic.world.structure.MaskIsland;
import mod.kagic.world.structure.PyramidTemple;
import mod.kagic.world.structure.RoseFountain;
import mod.kagic.world.structure.RuinStructure;
import mod.kagic.world.structure.SeaShrine;
import mod.kagic.world.structure.SkySpire;
import mod.kagic.world.structure.SmallArena;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class KAGICWorldGenerator implements IWorldGenerator {
	private ArrayList<RuinStructure> ruins = new ArrayList<RuinStructure>();
	private ArrayList<Integer> ruinDimensions = new ArrayList<Integer>();

	public KAGICWorldGenerator() {
		this.ruins.add(new CommunicationHub("CommHub"));
		this.ruins.add(new DesertWarpPad("DesertWarpPad"));
		this.ruins.add(new SmallArena("SmallArena"));
		this.ruins.add(new GalaxyWarp("GalaxyWarp"));
		this.ruins.add(new SkySpire("SkySpire"));
		this.ruins.add(new ControlRoom("controlroom"));
		// ruins.add(new
		// PinkSandstoneTest("pinksandstonetest"));
		this.ruins.add(new RoseFountain("rosefountain"));
		this.ruins.add(new GiantWeapon("giant_weapon"));
		this.ruins.add(new PyramidTemple("pyramid_temple"));
		this.ruins.add(new MaskIsland("mask_island"));
		this.ruins.add(new SeaShrine("sea_shrine"));
		this.ruins.add(new LunarSeaSpire("lunar_sea_spire"));
		this.ruins.add(new AncientSkyArena("large_arena"));
		this.ruinDimensions.add(0);
		for (String dimS : ModConfigs.ruinDimensions.split(",")) {
			Integer dim = Integer.getInteger(dimS);
			if (dim != null) {
				this.ruinDimensions.add(dim.intValue());
			}
		}
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (this.ruinDimensions.contains(world.provider.getDimension())) {
			for (RuinStructure ruin : this.ruins) {
				this.runGenerator(ruin, world, rand, chunkX, chunkZ, 1);
			}
		}
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn) {
		for (int i = 0; i < chancesToSpawn; ++i) {
			int x = chunk_X * 16 + rand.nextInt(16);// + 8;
			int z = chunk_Z * 16 + rand.nextInt(16);// + 8;
			int y = world.getHeight(x, z);
			generator.generate(world, rand, world.getTopSolidOrLiquidBlock(new BlockPos(x, y, z)));
		}
	}
}
