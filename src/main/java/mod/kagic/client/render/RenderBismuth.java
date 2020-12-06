package mod.kagic.client.render;

import mod.kagic.client.model.ModelBismuth;
import mod.kagic.client.render.layers.LayerBirthdayHat;
import mod.kagic.client.render.layers.LayerBismuthItem;
import mod.kagic.client.render.layers.LayerGemPlacement;
import mod.kagic.client.render.layers.LayerInsignia;
import mod.kagic.client.render.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.layers.LayerSantaHat;
import mod.kagic.client.render.layers.LayerSkin;
import mod.kagic.client.render.layers.LayerUniform;
import mod.kagic.client.render.layers.LayerVisor;
import mod.kagic.client.render.layers.LayerWitchHat;
import mod.kagic.entity.gem.EntityBismuth;
import mod.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class RenderBismuth extends RenderGemBase<EntityBismuth> {
	public RenderBismuth() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelBismuth(), 0.25F);
		this.addLayer(new LayerBismuthItem(this));
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerInsignia(this));
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
	protected void preRenderCallback(EntityBismuth gem, float partialTickTime) {
		if (gem.isDefective()) {
			GlStateManager.scale(0.67F, 0.9F, 0.8F);
		}
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityBismuth entity) {
		return new ResourceLocation("ndbkagic:textures/entities/bismuth/bismuth.png");
	}
}
