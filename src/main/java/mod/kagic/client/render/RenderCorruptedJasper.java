package mod.kagic.client.render;

import mod.kagic.client.model.corrupted.ModelCorruptedQuartz;
import mod.kagic.client.render.layers.LayerGemPlacement;
import mod.kagic.entity.gem.corrupted.EntityCorruptedJasper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;

public class RenderCorruptedJasper extends RenderLiving<EntityCorruptedJasper> {

	public RenderCorruptedJasper() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelCorruptedQuartz(), 2F);
		
		this.addLayer(new LayerGemPlacement(this, "corrupted/jasper"));
		/*
		 * this.addLayer(new LayerSkin(this));
		 * this.addLayer(new LayerHair(this)); if
		 * (KAGIC.isBirthday()) { this.addLayer(new
		 * LayerBirthdayHat(this)); } else if
		 * (KAGIC.isHalloween()) { this.addLayer(new
		 * LayerWitchHat(this)); }
		 */
	}
	
	@Override
	protected void preRenderCallback(EntityCorruptedJasper jasper, float partialTickTime) {
		GlStateManager.scale(2F, 2F, 2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCorruptedJasper jasper) {
		return new ResourceLocation("kagic:textures/entities/corrupted/jasper/" + jasper.getSpecialSkin() + "jasper.png");
	}
}
