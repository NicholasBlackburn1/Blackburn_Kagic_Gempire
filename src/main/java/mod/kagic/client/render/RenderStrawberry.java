package mod.kagic.client.render;

import mod.kagic.client.model.ModelPepo;
import mod.kagic.entity.pepo.EntityStrawberry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.util.ResourceLocation;

public class RenderStrawberry extends RenderLivingBase<EntityStrawberry> {
	public RenderStrawberry() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelPepo(), 0.25F);
		this.addLayer(new LayerArrow(this));
	}
	@Override
	protected void preRenderCallback(EntityStrawberry entitylivingbaseIn, float partialTickTime) {

	}
	@Override
	protected ResourceLocation getEntityTexture(EntityStrawberry entity) {
		return new ResourceLocation("ndbkagic:textures/entities/pepo/strawberry.png");
	}
}
