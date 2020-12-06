package mod.kagic.client.render;

import mod.kagic.client.model.corrupted.ModelCorruptedWaterBear;
import mod.kagic.client.render.layers.LayerWaterBearTransparency;
import mod.kagic.entity.gem.corrupted.EntityCorruptedWaterBear;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class RenderCorruptedWaterBear extends RenderGemBase<EntityCorruptedWaterBear> {
	
	public RenderCorruptedWaterBear() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelCorruptedWaterBear(), 1F);
		this.addLayer(new LayerWaterBearTransparency(this));
	}
	
	@Override
	protected void preRenderCallback(EntityCorruptedWaterBear waterBear, float partialTickTime) {
		GlStateManager.scale(1F, 1F, 1F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCorruptedWaterBear waterBear) {
		return new ResourceLocation("ndbkagic:textures/entities/corrupted/water_bear/water_bear_" + waterBear.getSpecial() + ".png");
	}
}
