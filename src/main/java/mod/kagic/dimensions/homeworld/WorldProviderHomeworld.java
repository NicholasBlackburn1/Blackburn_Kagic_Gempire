package mod.kagic.dimensions.homeworld;

import mod.kagic.init.ModBiomes;
import mod.kagic.init.ModDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderHomeworld extends WorldProvider {
	public void createBiomeProvider() {
		this.biomeProvider = new BiomeProviderSingle(ModBiomes.HOMEWORLD);
		this.hasSkyLight = true;
		// this.hasNoSky = false;
	}
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderHomeworld(this.world, this.world.getSeed());
	}
	@Override
	public DimensionType getDimensionType() {
		return ModDimensions.HOMEWORLD;
	}
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	@Override
	public int getAverageGroundLevel() {
		return 54;
	}
	@Override
	public boolean canCoordinateBeSpawn(int x, int z) {
		return this.world.getGroundAboveSeaLevel(new BlockPos(x, 0, z)).getMaterial().blocksMovement();
	}
	@Override
	public BlockPos getSpawnCoordinate() {
		return new BlockPos(0, 80, 0);
	}
	@Override
	public boolean canRespawnHere() {
		return true;
	}
	public String getWelcomeMessage() {
		return new TextComponentTranslation("command.kagic.to_homeworld").getUnformattedText();
	}
	public String getDepartMessage() {
		return new TextComponentTranslation("command.kagic.to_earth").getUnformattedText();
	}
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getSkyColor(Entity cameraEntity, float partialTicks) {
		return new Vec3d(125D / 255D, 62D / 255D, 131D / 255D);
	}
	@SideOnly(Side.CLIENT)
	public Vec3d getCloudColour(float partialTicks) {
		return new Vec3d(1.0D, 1.0D, 1.0D);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(float x, float y) {
		return new Vec3d(0.0D, 0.0D, 0.0D);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z) {
		return true;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public float getCloudHeight() {
		return 8.0F;
	}
}
