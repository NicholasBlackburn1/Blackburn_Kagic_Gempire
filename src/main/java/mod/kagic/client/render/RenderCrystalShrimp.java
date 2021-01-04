package mod.kagic.client.render;

import mod.kagic.entity.EntityCrystaShrimp;
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

    public RenderCrystalShrimp(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(Minecraft.getMinecraft().getRenderManager(), new ModelSilverfish(), 0.25F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityCrystalShrimp entity) {
        // TODO Auto-generated method stub
        return new ResourceLocation("ndbkagic:textures/entities/crystalshrimp/shrimp.png");
    }
    
}