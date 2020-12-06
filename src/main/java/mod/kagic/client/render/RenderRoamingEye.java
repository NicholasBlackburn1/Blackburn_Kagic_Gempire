package mod.kagic.client.render;

import mod.kagic.client.model.ModelRoamingEye;
import mod.kagic.entity.vehicles.EntityRoamingEye;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderRoamingEye extends RenderLivingBase<EntityRoamingEye> {
	public RenderRoamingEye() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelRoamingEye(), 2.0F);
	}
	@Override
	protected void preRenderCallback(EntityRoamingEye entitylivingbaseIn, float partialTickTime) {
		GlStateManager.scale(4.0F, 4.0F, 4.0F);
	}
	@Override
	protected boolean canRenderName(EntityRoamingEye entity) {
		return entity.hasCustomName();
	}
	@Override
	protected ResourceLocation getEntityTexture(EntityRoamingEye entity) {
		if (entity.isBeingRidden()) {
			return new ResourceLocation("ndbkagic:textures/entities/roaming_eye/roaming_eye.png");
		}
		return new ResourceLocation("ndbkagic:textures/entities/roaming_eye/roaming_eye_empty.png");
	}
}
