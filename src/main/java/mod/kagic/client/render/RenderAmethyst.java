package mod.kagic.client.render;

import java.util.Iterator;

import mod.kagic.client.model.ModelQuartz;
import mod.kagic.client.render.layers.LayerBirthdayHat;
import mod.kagic.client.render.layers.LayerGemPlacement;
import mod.kagic.client.render.layers.LayerHair;
import mod.kagic.client.render.layers.LayerInsignia;
import mod.kagic.client.render.layers.LayerQuartzCape;
import mod.kagic.client.render.layers.LayerQuartzItem;
import mod.kagic.client.render.layers.LayerSantaHat;
import mod.kagic.client.render.layers.LayerSkin;
import mod.kagic.client.render.layers.LayerUniform;
import mod.kagic.client.render.layers.LayerVisor;
import mod.kagic.client.render.layers.LayerWitchHat;
import mod.kagic.entity.gem.EntityAmethyst;
import mod.kagic.entity.gem.EntityJasper;
import mod.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderAmethyst extends RenderGemBase<EntityAmethyst> {
	public RenderAmethyst() {
        super(Minecraft.getMinecraft().getRenderManager(), new ModelQuartz(), 0.5F);

		this.addLayer(new LayerQuartzItem(this));
        this.addLayer(new LayerSkin(this));
        this.addLayer(new LayerUniform(this));
        this.addLayer(new LayerInsignia(this));
        this.addLayer(new LayerHair(this));
        this.addLayer(new LayerVisor(this));
        this.addLayer(new LayerQuartzCape(this));
        this.addLayer(new LayerGemPlacement(this));
		if (KAGIC.isBirthday()) {
			this.addLayer(new LayerBirthdayHat(this));
		} else if (KAGIC.isHalloween()) {
			this.addLayer(new LayerWitchHat(this));
		} else if (KAGIC.isChristmas()) {
			this.addLayer(new LayerSantaHat(this));
		}

		LayerBipedArmor amethystArmor = new LayerBipedArmor(this) {
			@Override
			protected void initArmor() {
				this.modelLeggings = new ModelQuartz(0.5F, true);
				this.modelArmor = new ModelQuartz(1F, true);
			}
		};
		this.addLayer(amethystArmor);
    }
	
	@Override
	protected void preRenderCallback(EntityAmethyst amethyst, float partialTickTime) {
		if (amethyst.isDefective()) {
			GlStateManager.scale(0.9F, 0.72F, 0.9F);
		} else if (amethyst.isPrimary()) {
			GlStateManager.scale(1.1F, 1.1F, 1.1F);
		}
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityAmethyst entity) {
		return new ResourceLocation("kagic:textures/entities/amethyst/amethyst.png");
	}
}
