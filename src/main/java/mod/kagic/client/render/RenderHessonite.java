package mod.kagic.client.render;

import mod.kagic.client.model.ModelHessonite;
import mod.kagic.client.render.layers.LayerBirthdayHat;
import mod.kagic.client.render.layers.LayerGemPlacement;
import mod.kagic.client.render.layers.LayerHair;
import mod.kagic.client.render.layers.LayerInsignia;
import mod.kagic.client.render.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.layers.LayerQuartzCape;
import mod.kagic.client.render.layers.LayerQuartzItem;
import mod.kagic.client.render.layers.LayerSantaHat;
import mod.kagic.client.render.layers.LayerSkin;
import mod.kagic.client.render.layers.LayerUniform;
import mod.kagic.client.render.layers.LayerVisor;
import mod.kagic.client.render.layers.LayerWitchHat;
import mod.kagic.entity.gem.EntityHessonite;
import mod.kagic.entity.gem.EntityRuby;
import mod.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class RenderHessonite extends RenderGemBase<EntityHessonite> {

	public RenderHessonite() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelHessonite(), 0.5F);

		this.addLayer(new LayerQuartzItem(this));
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerHair(this));
		this.addLayer(new LayerUniform(this));
		//this.addLayer(new LayerInsignia(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerQuartzCape(this));
		this.addLayer(new LayerQuartzCape(this, true, true));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerGemPlacement(this));
		if (KAGIC.isBirthday()) {
			this.addLayer(new LayerBirthdayHat(this));
		} else if (KAGIC.isHalloween()) {
			this.addLayer(new LayerWitchHat(this));
		} else if (KAGIC.isChristmas()) {
			this.addLayer(new LayerSantaHat(this));
		}
	}

	@Override
	protected void preRenderCallback(EntityHessonite gem, float partialTickTime) {
		if (gem.isDefective()) {
			GlStateManager.scale(0.8F, 0.7F, 0.8F);
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityHessonite entity) {
		return new ResourceLocation("kagic:textures/entities/hessonite/hessonite.png");
	}
}
