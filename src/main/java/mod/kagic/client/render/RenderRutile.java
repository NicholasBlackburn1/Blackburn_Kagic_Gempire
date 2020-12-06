package mod.kagic.client.render;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.model.ModelNothing;
import mod.kagic.client.model.ModelRutile;
import mod.kagic.client.model.ModelTwinRutile;
import mod.kagic.client.render.layers.LayerBirthdayHat;
import mod.kagic.client.render.layers.LayerRutileGemPlacement;
import mod.kagic.client.render.layers.LayerRutileHair;
import mod.kagic.client.render.layers.LayerRutileInsignia;
import mod.kagic.client.render.layers.LayerRutileItem;
import mod.kagic.client.render.layers.LayerRutileModel;
import mod.kagic.client.render.layers.LayerRutileSkin;
import mod.kagic.client.render.layers.LayerRutileUniform;
import mod.kagic.client.render.layers.LayerRutileVisor;
import mod.kagic.client.render.layers.LayerSantaHat;
import mod.kagic.client.render.layers.LayerWitchHat;
import mod.kagic.entity.gem.EntityRutile;
import mod.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class RenderRutile extends RenderGemBase<EntityRutile> {
	private ModelGem normalRutile = new ModelRutile();
	private ModelGem twinRutile = new ModelTwinRutile();
	public RenderRutile() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelNothing(), 0.25F);
		this.addLayer(new LayerRutileModel(this));
		this.addLayer(new LayerRutileItem(this));
		this.addLayer(new LayerRutileSkin(this));
		this.addLayer(new LayerRutileUniform(this));
		this.addLayer(new LayerRutileInsignia(this));
		this.addLayer(new LayerRutileHair(this));
		this.addLayer(new LayerRutileVisor(this));
		this.addLayer(new LayerRutileGemPlacement(this));
		if (KAGIC.isBirthday()) {
			this.addLayer(new LayerBirthdayHat(this));
		} else if (KAGIC.isHalloween()) {
			this.addLayer(new LayerWitchHat(this));
		} else if (KAGIC.isChristmas()) {
			this.addLayer(new LayerSantaHat(this));
		}
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityRutile entity) {
		return new ResourceLocation("ndbkagic:textures/entities/rutile/rutile.png");
	}

	public ModelGem getModel(boolean defective) {
		if (defective) {
			return this.twinRutile;
		}
		return this.normalRutile;
	}
}
