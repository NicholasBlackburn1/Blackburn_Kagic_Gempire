package mod.kagic.client.render.layers;

import mod.kagic.client.model.ModelPearl;
import mod.kagic.client.render.RenderGemBase;
import mod.kagic.entity.gem.EntityPearl;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public class LayerPearlHair implements LayerRenderer<EntityPearl> {
	private static final float OFFSET = .0f;
	private final RenderGemBase pearlRenderer;
	private final ModelPearl pearlModel = new ModelPearl();
	
	public LayerPearlHair(RenderGemBase pearlRendererIn) {
		this.pearlRenderer = pearlRendererIn;
	}

	@Override
	public void doRenderLayer(EntityPearl gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (gem.getSpecialSkin().equals("_0")) {
			this.pearlRenderer.bindTexture(EntityPearl.PEARL_HAIR_STYLES.get(gem.getHairStyle()));
			int hair = gem.generateHairColor();
			float r = ((hair & 16711680) >> 16) / 255f;
			float g = ((hair & 65280) >> 8) / 255f;
			float b = ((hair & 255) >> 0) / 255f;
			// KAGIC.instance.chatInfoMessage("Skin color is
			// " + r + " , " + g + " , " + b);
			GlStateManager.color(r + LayerPearlHair.OFFSET, g + LayerPearlHair.OFFSET, b + LayerPearlHair.OFFSET, 1f);
			this.pearlModel.setModelAttributes(this.pearlRenderer.getMainModel());
			this.pearlModel.render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
