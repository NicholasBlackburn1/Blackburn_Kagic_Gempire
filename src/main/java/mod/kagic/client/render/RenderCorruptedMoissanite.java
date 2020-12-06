package mod.kagic.client.render;

import mod.kagic.client.model.corrupted.ModelMoissanite;
import mod.kagic.entity.gem.corrupted.EntityCorruptedMoissanite;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class RenderCorruptedMoissanite extends RenderGemBase<EntityCorruptedMoissanite> {
	
	public RenderCorruptedMoissanite() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelMoissanite(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityCorruptedMoissanite moissanite, float partialTickTime) {
		GlStateManager.scale(2F, 2F, 2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCorruptedMoissanite moissanite) {
		return new ResourceLocation("ndbkagic:textures/entities/corrupted/moissanite/moissanite.png");
	}
}
