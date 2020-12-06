package mod.kagic.client.render;

import mod.kagic.client.model.shardfusions.ModelHandBody;
import mod.kagic.client.render.layers.LayerShardPlacement;
import mod.kagic.entity.shardfusion.EntityHandBody;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderHandBody extends RenderLivingBase<EntityHandBody> {
	
	public RenderHandBody() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelHandBody(), 0.25F);
		this.addLayer(new LayerShardPlacement(this));
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityHandBody entity) {
		return new ResourceLocation("ndbkagic:textures/entities/shardfusions/handbody/handbody.png");
	}
}
