package mod.kagic.client.render;


import mod.kagic.client.model.ModelCrystalShrimp;
import mod.kagic.entity.EntityCrystalShrimp;
import mod.kagic.entity.EntitySlag;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.util.ResourceLocation;

public class RenderCrystalShrimp extends RenderLivingBase<EntityCrystalShrimp> {
	public RenderCrystalShrimp() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelCrystalShrimp(), 0.25F);
		
	}

    public RenderCrystalShrimp(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(Minecraft.getMinecraft().getRenderManager(),  new ModelCrystalShrimp(), 0.25F);
    }

    @Override
	protected void preRenderCallback(EntityCrystalShrimp entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1.0F,1.0F,1.0F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityCrystalShrimp entity) {
        // TODO Auto-generated method stub
        return new ResourceLocation("ndbkagic:textures/entities/crystalshrimp/shrimp.png");
    }

}