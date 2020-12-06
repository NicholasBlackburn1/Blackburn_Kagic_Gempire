package mod.kagic.client.render;

import mod.kagic.client.model.ModelNothing;
import mod.kagic.entity.gem.EntityPadparadscha;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class RenderPadparadscha extends RenderGemBase<EntityPadparadscha> {
	public RenderPadparadscha() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelNothing(), 0.25F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPadparadscha entity) {
		return new ResourceLocation("ndbkagic:textures/entities/sapphire/sapphire.png");
	}
}
