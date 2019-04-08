package mod.kagic.client.render;

import mod.kagic.client.model.fusions.ModelRhodonite;
import mod.kagic.client.render.layers.LayerBirthdayHat;
import mod.kagic.client.render.layers.LayerCrossFusionGemPlacement;
import mod.kagic.client.render.layers.LayerHair;
import mod.kagic.client.render.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.layers.LayerRhodoniteItem;
import mod.kagic.client.render.layers.LayerSantaHat;
import mod.kagic.client.render.layers.LayerSkin;
import mod.kagic.client.render.layers.LayerWitchHat;
import mod.kagic.entity.gem.fusion.EntityRhodonite;
import mod.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class RenderRhodonite extends RenderGemBase<EntityRhodonite> {

	public RenderRhodonite() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelRhodonite(), 0.5F);

		this.addLayer(new LayerRhodoniteItem(this));
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerHair(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerCrossFusionGemPlacement(this));

		if (KAGIC.isBirthday()) {
			this.addLayer(new LayerBirthdayHat(this));
		} else if (KAGIC.isHalloween()) {
			this.addLayer(new LayerWitchHat(this));
		} else if (KAGIC.isChristmas()) {
			this.addLayer(new LayerSantaHat(this));
		}
	}

	@Override
	protected void preRenderCallback(EntityRhodonite rhodonite, float partialTickTime) {
		GlStateManager.scale(1F * rhodonite.getSizeFactor(), 1F * rhodonite.getSizeFactor(), 1F * rhodonite.getSizeFactor());
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityRhodonite entity) {
		return new ResourceLocation("kagic:textures/entities/rhodonite/rhodonite.png");
	}
}
