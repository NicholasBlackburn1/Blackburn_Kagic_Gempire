package mod.kagic.client.render;

import mod.kagic.client.model.ModelSapphire;
import mod.kagic.client.render.layers.LayerBirthdayHat;
import mod.kagic.client.render.layers.LayerGemPlacement;
import mod.kagic.client.render.layers.LayerHair;
import mod.kagic.client.render.layers.LayerInsignia;
import mod.kagic.client.render.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.layers.LayerSantaHat;
import mod.kagic.client.render.layers.LayerSapphireItem;
import mod.kagic.client.render.layers.LayerSkin;
import mod.kagic.client.render.layers.LayerUniform;
import mod.kagic.client.render.layers.LayerWitchHat;
import mod.kagic.entity.gem.EntitySapphire;
import mod.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class RenderSapphire extends RenderGemBase<EntitySapphire> {
	public RenderSapphire() {
        super(Minecraft.getMinecraft().getRenderManager(), new ModelSapphire(), 0.25F);
        this.addLayer(new LayerSapphireItem(this));
		this.addLayer(new LayerSkin(this, 0.25F));
        this.addLayer(new LayerUniform(this));
        this.addLayer(new LayerNoDyeOverlay(this));
        this.addLayer(new LayerInsignia(this));
        this.addLayer(new LayerHair(this, 0.5F));
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
	protected void preRenderCallback(EntitySapphire gem, float partialTickTime) {
		GlStateManager.scale(0.85F, 0.85F, 0.85F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySapphire entity) {
		return new ResourceLocation("kagic:textures/entities/sapphire/sapphire.png");
	}
}
