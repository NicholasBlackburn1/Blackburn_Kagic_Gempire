package mod.kagic.client.render;

import java.util.Iterator;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.model.corrupted.ModelCorruptedQuartz;
import mod.kagic.client.model.corrupted.ModelTongueMonster;
import mod.kagic.client.render.layers.LayerBirthdayHat;
import mod.kagic.client.render.layers.LayerGemPlacement;
import mod.kagic.client.render.layers.LayerHair;
import mod.kagic.client.render.layers.LayerInsignia;
import mod.kagic.client.render.layers.LayerJasperMark1;
import mod.kagic.client.render.layers.LayerJasperMark2;
import mod.kagic.client.render.layers.LayerQuartzCape;
import mod.kagic.client.render.layers.LayerQuartzItem;
import mod.kagic.client.render.layers.LayerSkin;
import mod.kagic.client.render.layers.LayerUniform;
import mod.kagic.client.render.layers.LayerVisor;
import mod.kagic.client.render.layers.LayerWitchHat;
import mod.kagic.entity.gem.EntityJasper;
import mod.kagic.entity.gem.corrupted.EntityCorruptedJasper;
import mod.kagic.entity.gem.corrupted.EntityTongueMonster;
import mod.kagic.entity.gem.fusion.EntityGarnet;
import mod.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderTongueMonster extends RenderGemBase<EntityTongueMonster> {
	
	public RenderTongueMonster() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelTongueMonster(), 0.75F);

		
		this.addLayer(new LayerSkin(this, 0F, "corrupted/tongue_monster"));
		this.addLayer(new LayerGemPlacement(this, "corrupted/tongue_monster"));
		/*
		if (KAGIC.isBirthday()) {
			this.addLayer(new LayerBirthdayHat(this));
		} else if (KAGIC.isHalloween()) {
			this.addLayer(new LayerWitchHat(this));
		}*/
	}
			
	@Override
	protected void preRenderCallback(EntityTongueMonster tongueMonster, float partialTickTime) {
		GlStateManager.scale(1.5F, 1.5F, 1.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityTongueMonster tongueMonster) {
		return new ResourceLocation("kagic:textures/entities/corrupted/tongue_monster/tongue_monster.png");
	}
}
