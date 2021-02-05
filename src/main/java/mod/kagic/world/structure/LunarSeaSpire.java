package mod.kagic.world.structure;

import java.util.Random;

import mod.kagic.entity.EntityCrystalShrimp;
import mod.kagic.init.KAGIC;
import mod.kagic.util.CommenFunctions;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class LunarSeaSpire extends SunkenRuinStructure {

	public LunarSeaSpire(String type) {
		super(type, 40, Blocks.STONE.getDefaultState(), false, true);
		
		this.structures.add("/assets/kagic/structures/LunarSeaSpire.schematic");
		
		this.allowedBiomes.add(Biomes.DEEP_OCEAN);
		this.allowedBiomes.add(Biomes.OCEAN);
		//this.chestTables.put(new BlockPos(54, 1, 11), LootTables.SEA_SHRINE);
		
	}
	
	@Override
	protected boolean checkBiome(World world, BlockPos corner1) {
		int xFar = corner1.getX() + (this.rotation % 2 == 0 ? this.width : this.length) - 1;
		int zFar = corner1.getZ() + (this.rotation % 2 == 0 ? this.length : this.width) - 1;
		BlockPos corner2 = new BlockPos(xFar, 255, corner1.getZ());
		BlockPos corner3 = new BlockPos(corner1.getX(), 255, zFar);
		BlockPos corner4 = new BlockPos(xFar, 255, zFar);

		if (this.allowedBiomes.contains(world.getBiome(corner1)) && this.allowedBiomes.contains(world.getBiome(corner2)) && this.allowedBiomes.contains(world.getBiome(corner3)) && this.allowedBiomes.contains(world.getBiome(corner4))) {
			return true;
		}
		return false;
	}
	
	//TODO: add Crystal Shrimp to spawn into the Structure 
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		
	
		if (rand.nextInt(2000) != 0) {
			
			return false;
		}
		
		return super.generate(world, rand, pos);
	}
}
