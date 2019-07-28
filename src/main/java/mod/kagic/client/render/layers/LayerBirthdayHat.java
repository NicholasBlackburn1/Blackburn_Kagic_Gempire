package mod.kagic.client.render.layers;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGemBase;
import mod.kagic.entity.EntityGem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;

public class LayerBirthdayHat implements LayerRenderer<EntityGem> {
	private static final long NUM_HATS = 8;
	private final RenderGemBase<?> gemRenderer;
	private final ModelGem gemModel;

	public LayerBirthdayHat(RenderGemBase<?> gemRenderer) {
		this.gemRenderer = gemRenderer;
		this.gemModel = (ModelGem) gemRenderer.getMainModel();
	}
	
	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.gemRenderer.bindTexture(this.getTexture(gem));
		GlStateManager.color(1F, 1F, 1F, 1F);
		this.gemModel.setModelAttributes(this.gemRenderer.getMainModel());
		this.gemModel.renderWitchHat(scale);
	}
	
	public ResourceLocation getTexture(EntityGem gem) {
		ResourceLocation loc = EntityList.getKey(gem);
		return new ResourceLocation(loc.getResourceDomain() + ":textures/entities/other/birthday_hat_" + Math.abs(gem.getUniqueID().getLeastSignificantBits()) % LayerBirthdayHat.NUM_HATS + ".png");
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
	
}
