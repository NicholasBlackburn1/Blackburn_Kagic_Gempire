package mod.kagic.client.render;

import java.util.Iterator;

import mod.kagic.client.model.ModelAgate;
import mod.kagic.client.render.layers.LayerAgateBand;
import mod.kagic.client.render.layers.LayerAgateHair;
import mod.kagic.client.render.layers.LayerAgateItem;
import mod.kagic.client.render.layers.LayerBirthdayHat;
import mod.kagic.client.render.layers.LayerGemPlacement;
import mod.kagic.client.render.layers.LayerInsignia;
import mod.kagic.client.render.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.layers.LayerQuartzCape;
import mod.kagic.client.render.layers.LayerSantaHat;
import mod.kagic.client.render.layers.LayerUniform;
import mod.kagic.client.render.layers.LayerVisor;
import mod.kagic.client.render.layers.LayerWitchHat;
import mod.kagic.entity.gem.EntityAgate;
import mod.kagic.entity.gem.GemPlacements;
import mod.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderAgate extends RenderGemBase<EntityAgate> {
	private static final float OFFSET = .0f;
	
	public RenderAgate() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelAgate(), 0.25F);
		for (Iterator<LayerRenderer<EntityAgate>> iter = this.layerRenderers.iterator(); iter.hasNext();) {
			LayerRenderer layer = iter.next();
			if (layer instanceof LayerHeldItem) {
				iter.remove();
			}
		}
		
		this.addLayer(new LayerAgateItem(this));
		this.addLayer(new LayerAgateHair(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerAgateBand(this));
		this.addLayer(new LayerUniform(this));
		this.addLayer(new LayerInsignia(this));
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
		
		LayerBipedArmor agateArmor = new LayerBipedArmor(this) {
			@Override
			protected void initArmor() {
				this.modelLeggings = new ModelAgate(0.5F, true);
				this.modelArmor = new ModelAgate(1F, true);
			}
		};
		this.addLayer(agateArmor);
	}

	@Override
	protected void preRenderCallback(EntityAgate agate, float partialTickTime) {
		if (!agate.isHolly()) {
			float[] afloat = EntityAgate.AGATECOLORS[agate.getColor()];
			GlStateManager.color(afloat[0] + RenderAgate.OFFSET, afloat[1] + RenderAgate.OFFSET, afloat[2] + RenderAgate.OFFSET);
		}
		if (agate.isDefective()) {
			GlStateManager.scale(0.8F, 0.8F, 0.8F);
		} else if (agate.isPrimary()) {
			GlStateManager.scale(1.1F, 1.1F, 1.1F);
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityAgate entity) {
		if (entity.getGemPlacement() == GemPlacements.BELLY) {
			return new ResourceLocation("ndbkagic:textures/entities/agate/agate_belly.png");
		} else if (entity.isHolly()) {
			return new ResourceLocation("ndbkagic:textures/entities/agate/holly_blue_agate.png");
		} else {
			return new ResourceLocation("ndbkagic:textures/entities/agate/agate.png");
		}
	}
}
