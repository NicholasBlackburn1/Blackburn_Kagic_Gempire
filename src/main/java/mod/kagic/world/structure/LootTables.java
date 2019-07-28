package mod.kagic.world.structure;

import mod.kagic.init.KAGIC;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTables {
	public static ResourceLocation SMALL_ARENA;
	public static ResourceLocation GALAXY_WARP;
	public static ResourceLocation SKY_SPIRE;
	public static ResourceLocation CONTROL_ROOM;
	public static ResourceLocation CONTROL_ROOM_MUSIC;
	public static ResourceLocation ROSE_FOUNTAIN;
	public static ResourceLocation OBELISK;
	public static ResourceLocation MASK_ISLAND;
	public static ResourceLocation SEA_SHRINE;
	public static ResourceLocation LARGE_ARENA_UPPER;
	public static ResourceLocation LARGE_ARENA_LOWER;

	public static void register() {
		LootTables.SMALL_ARENA = LootTableList.register(new ResourceLocation(KAGIC.MODID, "chests/smallarena"));
		LootTables.GALAXY_WARP = LootTableList.register(new ResourceLocation(KAGIC.MODID, "chests/galaxywarp"));
		LootTables.SKY_SPIRE = LootTableList.register(new ResourceLocation(KAGIC.MODID, "chests/skyspire"));
		LootTables.CONTROL_ROOM = LootTableList.register(new ResourceLocation(KAGIC.MODID, "dispensers/controlroom"));
		LootTables.CONTROL_ROOM_MUSIC = LootTableList.register(new ResourceLocation(KAGIC.MODID, "dispensers/controlroommusic"));
		LootTables.ROSE_FOUNTAIN = LootTableList.register(new ResourceLocation(KAGIC.MODID, "chests/rosefountain"));
		LootTables.OBELISK = LootTableList.register(new ResourceLocation(KAGIC.MODID, "entities/obelisk"));
		LootTables.MASK_ISLAND = LootTableList.register(new ResourceLocation(KAGIC.MODID, "chests/maskisland"));
		LootTables.SEA_SHRINE = LootTableList.register(new ResourceLocation(KAGIC.MODID, "chests/seashrine"));
		LootTables.LARGE_ARENA_UPPER = LootTableList.register(new ResourceLocation(KAGIC.MODID, "chests/largearenaupper"));
		LootTables.LARGE_ARENA_LOWER = LootTableList.register(new ResourceLocation(KAGIC.MODID, "chests/largearenalower"));
	}
	
}
