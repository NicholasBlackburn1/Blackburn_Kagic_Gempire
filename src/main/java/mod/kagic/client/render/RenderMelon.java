package mod.kagic.client.render;

import mod.kagic.client.model.ModelPepo;
import mod.kagic.entity.pepo.EntityMelon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.util.ResourceLocation;

public class RenderMelon extends RenderLivingBase<EntityMelon> {
	public RenderMelon() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelPepo(), 0.25F);
		this.addLayer(new LayerArrow(this));
	}
	@Override
	protected void preRenderCallback(EntityMelon entitylivingbaseIn, float partialTickTime) {

	}
	@Override
	protected ResourceLocation getEntityTexture(EntityMelon entity) {
		return new ResourceLocation("kagic:textures/entities/pepo/melon.png");
	}
}
