package mod.kagic.client.render;

import mod.kagic.client.model.corrupted.ModelCorruptedQuartz;
import mod.kagic.client.render.layers.LayerGemPlacement;
import mod.kagic.client.render.layers.LayerHair;
import mod.kagic.client.render.layers.LayerSkin;
import mod.kagic.entity.gem.corrupted.EntityCorruptedCarnelian;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;

public class RenderCorruptedCarnelian extends RenderLiving<EntityCorruptedCarnelian> {

	public RenderCorruptedCarnelian() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelCorruptedQuartz(), 2F);
		
		this.addLayer(new LayerSkin(this, 0F, "corrupted/carnelian"));
		this.addLayer(new LayerHair(this, 0F, "corrupted/carnelian"));
		this.addLayer(new LayerGemPlacement(this, "corrupted/carnelian"));
		/*
		 * if (KAGIC.isBirthday()) { this.addLayer(new
		 * LayerBirthdayHat(this)); } else if
		 * (KAGIC.isHalloween()) { this.addLayer(new
		 * LayerWitchHat(this)); }
		 */
	}
	
	@Override
	protected void preRenderCallback(EntityCorruptedCarnelian carnelian, float partialTickTime) {
		GlStateManager.scale(2F, 2F, 2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCorruptedCarnelian carnelian) {
		return new ResourceLocation("kagic:textures/entities/corrupted/carnelian/carnelian.png");
	}
}
