package mod.kagic.client.render;

import mod.kagic.client.model.shardfusions.ModelMouthTorso;
import mod.kagic.client.render.layers.LayerShardPlacement;
import mod.kagic.entity.shardfusion.EntityMouthTorso;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderMouthTorso extends RenderLivingBase<EntityMouthTorso> {
	
	public RenderMouthTorso() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelMouthTorso(), 0.25F);
		this.addLayer(new LayerShardPlacement(this));
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityMouthTorso entity) {
		return new ResourceLocation("ndbkagic:textures/entities/shardfusions/mouthtorso/mouthtorso.png");
	}
}
