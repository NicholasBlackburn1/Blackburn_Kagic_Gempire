package mod.kagic.init;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.function.Consumer;

import javax.swing.text.html.parser.Entity;

import com.google.common.base.Predicate;

import mod.kagic.advancements.ModTriggers;
import mod.kagic.entity.EntityGem;
import mod.kagic.entity.ai.EntityAIFollowTopaz;
import mod.kagic.entity.gem.EntityAgate;
import mod.kagic.entity.gem.EntityPadparadscha;
import mod.kagic.entity.gem.EntityPearl;
import mod.kagic.entity.gem.EntityRuby;
import mod.kagic.entity.gem.EntityRutile;
import mod.kagic.entity.gem.EntitySapphire;
import mod.kagic.init.ModMetrics.Update;

import mod.kagic.server.SpaceStuff;
import net.minecraft.advancements.critereon.PlayerHurtEntityTrigger;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ModEvents {
	


	public static void register() {
		MinecraftForge.EVENT_BUS.register(new ModEvents());
	
	}
	
	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerLoggedInEvent e) {

		e.player.sendMessage(
			new TextComponentString("§6 You are playing KAGIC-Blackburn " + KAGIC.VERSION + " Please Enjoy"));
			KAGIC.logger.info("in Player innteract Fucntion need to execute the advancement");
			ModTriggers.MOD_START.trigger(e.player);
			KAGIC.logger.info("Executed the Trigger");
		
	}

	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent e) {
		if (e.getEntity() instanceof EntityPadparadscha) {
			EntityPadparadscha paddy = (EntityPadparadscha) e.getEntity();
			e.getWorld().spawnEntity(EntitySapphire.convertFrom(paddy));
		}
		if (e.getEntity() instanceof EntityMob) {
			EntityMob mob = (EntityMob) e.getEntity();
			if (!(e.getEntity() instanceof EntityEnderman || e.getEntity() instanceof EntityGolem)) {
				mob.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityGem>(mob, EntityGem.class, 1, true,
						true, new Predicate<EntityGem>() {
							@Override
							public boolean apply(EntityGem input) {
								return !(input instanceof EntityAgate
										|| input.isDefective() && input instanceof EntityRutile);
							}
						}));
			}
			mob.tasks.addTask(1,
					new EntityAIAvoidEntity<EntityAgate>(mob, EntityAgate.class, new Predicate<EntityAgate>() {
						@Override
						public boolean apply(EntityAgate input) {
							return !input.isDefective();
						}
					}, 6.0F, 1.0D, 1.2D));
		}
		if (e.getEntity() instanceof EntityAnimal) {
			EntityAnimal animal = (EntityAnimal) e.getEntity();
			animal.targetTasks.addTask(3, new EntityAIFollowTopaz(animal, 0.9D));
		} else if (e.getEntity() instanceof EntityGolem) {
			EntityGolem golem = (EntityGolem) e.getEntity();
			golem.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityGem>(golem, EntityGem.class, 1, true,
					true, new Predicate<EntityGem>() {
						@Override
						public boolean apply(EntityGem input) {
							return input.getServitude() > EntityGem.SERVE_HUMAN;
						}
					}));
		}
	}

	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent e) {
		if (e.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) e.getEntity();
			if (!e.getEntity().world.isRemote) {
				List<EntityPearl> list = player.world.<EntityPearl>getEntitiesWithinAABB(EntityPearl.class,
						player.getEntityBoundingBox().grow(8.0D, 4.0D, 8.0D));
				for (EntityPearl entity : list) {
					entity.sendMessage(new TextComponentTranslation("command.kagic.pearl_warning", player.getName()));
				}
			}
		}
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		MinecraftServer server = event.world.getMinecraftServer();
		if (ModConfigs.spawnMeteorRubies && server.getCurrentPlayerCount() > 0) {
			EntityPlayerMP player = server.getPlayerList().getPlayers().get(event.world.rand.nextInt(server.getCurrentPlayerCount()));
			if (!player.world.isRemote) {
				if (player.dimension == 0 && !player.world.isDaytime()) {
					if (player.world.getTotalWorldTime() - SpaceStuff.get().getLastRubyImpactTime() >= 24000  && player.world.rand.nextInt(12000) == 0) {
						EntityRuby ruby = new EntityRuby(player.world);
						double xdev = player.world.rand.nextInt(128) - 64;
						double newX = player.posX + Math.abs(xdev) < 16 ? 128 : xdev;
						double zdev = player.world.rand.nextInt(128) - 64;
						double newZ = player.posZ + Math.abs(zdev) < 16 ? 128 : zdev;
						ruby.setPosition(newX, 256, newZ);
						ruby.isSpaceBorn = true;
						player.world.spawnEntity(ruby);
						ruby.onInitialSpawn(ruby.world.getDifficultyForLocation(new BlockPos(ruby)), (IEntityLivingData) null);
						player.world.playSound(player, player.getPosition(), ModSounds.RUBY_EXPLODE, SoundCategory.NEUTRAL, 10.0F, 1.0F);
						SpaceStuff.get().setLastRubyImpactTime(player.world.getTotalWorldTime());
					}
					
					
					
				}
			}
		}
	}
	/*
	 * @SubscribeEvent public void onPlayerTick(TickEvent.PlayerTickEvent event) {
	 * if (event.player.posY > 480 && !event.player.world.isRemote) {
	 * event.player.world.getMinecraftServer().
	 * getPlayerList().transferPlayerToDimension(( EntityPlayerMP) event.player, 2,
	 * new TeleporterHomeworld(event.player.world.
	 * getMinecraftServer().worldServerForDimension( event.player.dimension))); } }
	 */

	@SubscribeEvent
	public void onLootTableLoad(LootTableLoadEvent e) {
		if (e.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)
				|| e.getName().equals(LootTableList.CHESTS_VILLAGE_BLACKSMITH)) {
			e.getTable()
					.addPool(
							new LootPool(
									new LootEntry[] {
											new LootEntryItem(ModItems.CRACKED_BISMUTH_GEM, 1, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic"),
											new LootEntryItem(
													ModItems.CRACKED_PERIDOT_GEM, 3, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic"),
											new LootEntryItem(
													ModItems.CRACKED_PEARL_GEM, 3, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic"),
											new LootEntryItem(
													ModItems.INACTIVE_GEM_BASE, 3, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(2)) },
													new LootCondition[0], "kagic"),
											new LootEntryItem(
													Item.getItemFromBlock(ModBlocks.INJECTOR), 3, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic"),
											new LootEntryItem(
													Item.getItemFromBlock(ModBlocks.GEM_DRILL), 3, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic"),
											new LootEntryItem(Item.getItemFromBlock(ModBlocks.INCUBATOR), 3, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic") },
									new LootCondition[0], new RandomValueRange(1), new RandomValueRange(2), "kagic"));
		} else if (e.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID)
				|| e.getName().equals(LootTableList.CHESTS_END_CITY_TREASURE)
				|| e.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE)
				|| e.getName().equals(LootTableList.CHESTS_NETHER_BRIDGE)) {
			e.getTable()
					.addPool(
							new LootPool(
									new LootEntry[] {
											new LootEntryItem(ModItems.CRACKED_PERIDOT_GEM, 4, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic"),
											new LootEntryItem(
													ModItems.CRACKED_AMETHYST_GEM, 2, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic"),
											new LootEntryItem(
													ModItems.CRACKED_JASPER_GEM, 2, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic"),
											new LootEntryItem(ModItems.CRACKED_CARNELIAN_GEM, 2, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic"), },
									new LootCondition[0], new RandomValueRange(1), new RandomValueRange(2), "kagic"));
		} else if (e.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON)
				|| e.getName().equals(LootTableList.CHESTS_STRONGHOLD_CORRIDOR)) {
			e.getTable()
					.addPool(
							new LootPool(
									new LootEntry[] {
											new LootEntryItem(ModItems.CRACKED_RUBY_GEM, 2, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic"),
											new LootEntryItem(
													ModItems.CRACKED_PEARL_GEM, 2, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(1)) },
													new LootCondition[0], "kagic"),
											new LootEntryItem(ModItems.INACTIVE_GEM_BASE, 5, 1,
													new LootFunction[] { new SetCount(new LootCondition[0],
															new RandomValueRange(4)) },
													new LootCondition[0], "kagic") },
									new LootCondition[0], new RandomValueRange(1), new RandomValueRange(2), "kagic"));
		}
	}

	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load e) {
		if (!e.getWorld().isRemote) {
			try {
				KAGIC.spaceStuff = new SpaceStuff(e.getWorld());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SubscribeEvent
	public void onWorldSave(WorldEvent.Save e) {
		if (!e.getWorld().isRemote) {
			KAGIC.spaceStuff.save();
			
		}
	}
	/**
	 * Whenever player enters a biome Send the Acivement based on that biome
	 * @param e
	 */
	@SubscribeEvent
	public void onPlayerWalkInBiome(LivingUpdateEvent e){
		EntityLivingBase theEntity = e.getEntityLiving();
		EntityPlayerMP player;
		if(theEntity instanceof EntityPlayerMP){
			player = (EntityPlayerMP) theEntity;
			
			
			switch (player.getEntityWorld().getBiome(theEntity.getPosition()).getRegistryName().toString()) {
				case "ndbkagic:strawberry_battlefield":
					ModTriggers.BATTLE_FIELD.trigger(player);
					break;
				
				case "ndbkagic:floatingpeaks":
					ModTriggers.HEAVEN_BEATLE.trigger(player);
					break;
			
				case "ndbkagic:kindergarten":
					ModTriggers.KINDERGARDEN.trigger(player);
					break;
			
			}
		}


	}
	

	

		
		
}

	

