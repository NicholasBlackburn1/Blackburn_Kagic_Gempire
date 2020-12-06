package mod.kagic.client.render;

import mod.kagic.client.model.fusions.ModelGarnet;
import mod.kagic.client.render.layers.LayerBirthdayHat;
import mod.kagic.client.render.layers.LayerCrossFusionGemPlacement;
import mod.kagic.client.render.layers.LayerFusionColor;
import mod.kagic.client.render.layers.LayerGarnetItem;
import mod.kagic.client.render.layers.LayerHair;
import mod.kagic.client.render.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.layers.LayerSantaHat;
import mod.kagic.client.render.layers.LayerSkin;
import mod.kagic.client.render.layers.LayerWitchHat;
import mod.kagic.entity.gem.fusion.EntityGarnet;
import mod.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class RenderGarnet extends RenderGemBase<EntityGarnet> {
	
	public RenderGarnet() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelGarnet(), 0.5F);

		this.addLayer(new LayerGarnetItem(this));
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerHair(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerFusionColor(this, 0.25F));
		// this.addLayer(new LayerVisor(this));
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
	protected void preRenderCallback(EntityGarnet garnet, float partialTickTime) {
		GlStateManager.scale(1F * garnet.getSizeFactor(), 1F * garnet.getSizeFactor(), 1F * garnet.getSizeFactor());
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGarnet entity) {
		return new ResourceLocation("ndbkagic:textures/entities/garnet/garnet.png");
	}
}