package mod.kagic.client.render.layers;

import mod.kagic.client.render.RenderSlag;
import mod.kagic.entity.EntitySlag;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class LayerSlagVariants implements LayerRenderer<EntitySlag> {
	private final RenderSlag slagRenderer;
	private final ModelBase slagModel;
	public LayerSlagVariants(RenderSlag slagRendererIn) {
		this.slagRenderer = slagRendererIn;
		this.slagModel = slagRendererIn.getMainModel();
	}
	@Override
	public void doRenderLayer(EntitySlag slag, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		String[] placements = Integer.toString(slag.getVariant()).split("");
		for (String placement : placements) {
			this.slagRenderer.bindTexture(new ResourceLocation("kagic:textures/entities/slag/slag_" + placement + ".png"));
			this.slagModel.setModelAttributes(this.slagRenderer.getMainModel());
			this.slagModel.render(slag, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.disableBlend();
		}
	}
	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
