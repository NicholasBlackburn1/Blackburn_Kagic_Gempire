package mod.kagic.client.render.layers;

import mod.kagic.client.render.RenderRutile;
import mod.kagic.entity.gem.EntityRutile;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class LayerRutileSkin implements LayerRenderer<EntityRutile> {
	private final RenderRutile gemRenderer;
	
	public LayerRutileSkin(RenderRutile gemRenderer) {
		this.gemRenderer = gemRenderer;
	}
	
	@Override
	public void doRenderLayer(EntityRutile gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.gemRenderer.bindTexture(this.getTexture(gem));
		int skin = gem.getSkinColor();
		float r = ((skin & 16711680) >> 16) / 255f;
		float g = ((skin & 65280) >> 8) / 255f;
		float b = ((skin & 255) >> 0) / 255f;
		// KAGIC.instance.chatInfoMessage("Skin color is " +
		// r + " , " + g + " , " + b);
		GlStateManager.color(r, g, b, 1f);
		// GlStateManager.enableBlend();
		// GlStateManager.blendFunc(SourceFactor.SRC_ALPHA,
		// DestFactor.ONE_MINUS_SRC_ALPHA);
		this.gemRenderer.getModel(gem.isDefective()).setModelAttributes(this.gemRenderer.getMainModel());
		this.gemRenderer.getModel(gem.isDefective()).render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GlStateManager.disableBlend();
	}
	
	public ResourceLocation getTexture(EntityRutile gem) {
		return new ResourceLocation("kagic:textures/entities/rutile/skin.png");
	}

	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
	
}
