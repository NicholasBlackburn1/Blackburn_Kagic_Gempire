package mod.kagic.client.render;

import mod.kagic.client.model.corrupted.ModelCorruptedQuartz;
import mod.kagic.client.render.layers.LayerGemPlacement;
import mod.kagic.client.render.layers.LayerHair;
import mod.kagic.client.render.layers.LayerSkin;
import mod.kagic.entity.gem.corrupted.EntityCorruptedRoseQuartz;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;

public class RenderCorruptedRoseQuartz extends RenderLiving<EntityCorruptedRoseQuartz> {

	public RenderCorruptedRoseQuartz() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelCorruptedQuartz(), 2F);
		
		this.addLayer(new LayerSkin(this, 0F, "corrupted/rose_quartz"));
		this.addLayer(new LayerHair(this, 0F, "corrupted/rose_quartz"));
		this.addLayer(new LayerGemPlacement(this, "corrupted/rose_quartz"));
		/*
		 * if (KAGIC.isBirthday()) { this.addLayer(new
		 * LayerBirthdayHat(this)); } else if
		 * (KAGIC.isHalloween()) { this.addLayer(new
		 * LayerWitchHat(this)); }
		 */
	}
	
	@Override
	protected void preRenderCallback(EntityCorruptedRoseQuartz rose, float partialTickTime) {
		GlStateManager.scale(2F, 2F, 2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCorruptedRoseQuartz rose) {
		return new ResourceLocation("kagic:textures/entities/corrupted/rose_quartz/rose_quartz.png");
	}
}
