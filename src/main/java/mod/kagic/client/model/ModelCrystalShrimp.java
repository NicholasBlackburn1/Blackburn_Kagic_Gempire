// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports
package mod.kagic.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrystalShrimp extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer spike_r1;
	private final ModelRenderer spike_r2;
	private final ModelRenderer spike_r3;
	private final ModelRenderer spike_r4;
	private final ModelRenderer spike_r5;
	private final ModelRenderer spike_r6;
	private final ModelRenderer spike_r7;
	private final ModelRenderer spike_r8;
	private final ModelRenderer spike_r9;
	private final ModelRenderer spike_r10;
	private final ModelRenderer spike_r11;
	private final ModelRenderer spike_r12;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer spike_r13;
	private final ModelRenderer spike_r14;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer spike_r15;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer spike_r16;
	private final ModelRenderer spike_r17;
	private final ModelRenderer spike_r18;
	private final ModelRenderer spike_r19;
	private final ModelRenderer spike_r20;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;

	public ModelCrystalShrimp() {
		textureWidth = 64;
		textureHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 1, 20, -3.0F, -3.0F, -7.0F, 4, 3, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 32, 18, -3.0F, -4.0F, -5.0F, 4, 4, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 14, 17, -3.5F, -5.0F, -2.0F, 5, 5, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -1.0F, -1.0F, 7.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 48, 18, -3.0F, -3.0F, 0.0F, 3, 3, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 32, 18, -4.0F, -5.0F, 0.0F, 4, 4, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 14, 17, -3.5F, -5.0F, -2.0F, 5, 5, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 32, 18, -3.0F, -4.0F, 3.0F, 4, 4, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 32, 18, -3.0F, -4.0F, 5.0F, 4, 4, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 32, 18, -3.0F, -4.0F, 7.0F, 4, 4, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 1, 20, -3.0F, -3.0F, 9.0F, 4, 3, 2, 0.0F, false));

		spike_r1 = new ModelRenderer(this);
		spike_r1.setRotationPoint(-0.5F, -3.0F, 9.6F);
		bb_main.addChild(spike_r1);
		setRotationAngle(spike_r1, -0.829F, 0.0F, 0.0F);
		spike_r1.cubeList.add(new ModelBox(spike_r1, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r2 = new ModelRenderer(this);
		spike_r2.setRotationPoint(-4.3F, -1.7F, 3.3F);
		bb_main.addChild(spike_r2);
		setRotationAngle(spike_r2, -0.829F, 0.0F, 0.0F);
		spike_r2.cubeList.add(new ModelBox(spike_r2, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r3 = new ModelRenderer(this);
		spike_r3.setRotationPoint(2.5F, -2.0F, 4.0F);
		bb_main.addChild(spike_r3);
		setRotationAngle(spike_r3, -0.829F, 0.0F, 0.0F);
		spike_r3.cubeList.add(new ModelBox(spike_r3, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r4 = new ModelRenderer(this);
		spike_r4.setRotationPoint(2.5F, -5.0F, 4.0F);
		bb_main.addChild(spike_r4);
		setRotationAngle(spike_r4, -0.829F, 0.0F, 0.0F);
		spike_r4.cubeList.add(new ModelBox(spike_r4, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r5 = new ModelRenderer(this);
		spike_r5.setRotationPoint(2.5F, -5.0F, 1.0F);
		bb_main.addChild(spike_r5);
		setRotationAngle(spike_r5, -0.829F, 0.0F, 0.0F);
		spike_r5.cubeList.add(new ModelBox(spike_r5, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r6 = new ModelRenderer(this);
		spike_r6.setRotationPoint(-3.3F, -5.7F, 5.3F);
		bb_main.addChild(spike_r6);
		setRotationAngle(spike_r6, -0.829F, 0.0F, 0.0F);
		spike_r6.cubeList.add(new ModelBox(spike_r6, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r7 = new ModelRenderer(this);
		spike_r7.setRotationPoint(-0.6F, -7.4F, 5.0F);
		bb_main.addChild(spike_r7);
		setRotationAngle(spike_r7, -0.829F, 0.0F, 0.0F);
		spike_r7.cubeList.add(new ModelBox(spike_r7, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r8 = new ModelRenderer(this);
		spike_r8.setRotationPoint(-3.5F, -7.0F, 1.0F);
		bb_main.addChild(spike_r8);
		setRotationAngle(spike_r8, -0.829F, 0.0F, 0.0F);
		spike_r8.cubeList.add(new ModelBox(spike_r8, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r9 = new ModelRenderer(this);
		spike_r9.setRotationPoint(-0.6F, -8.0F, -1.0F);
		bb_main.addChild(spike_r9);
		setRotationAngle(spike_r9, -0.829F, 0.0F, 0.0F);
		spike_r9.cubeList.add(new ModelBox(spike_r9, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r10 = new ModelRenderer(this);
		spike_r10.setRotationPoint(-0.6F, -8.0F, 1.0F);
		bb_main.addChild(spike_r10);
		setRotationAngle(spike_r10, -0.829F, 0.0F, 0.0F);
		spike_r10.cubeList.add(new ModelBox(spike_r10, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r11 = new ModelRenderer(this);
		spike_r11.setRotationPoint(-0.6F, -8.0F, 3.0F);
		bb_main.addChild(spike_r11);
		setRotationAngle(spike_r11, -0.829F, 0.0F, 0.0F);
		spike_r11.cubeList.add(new ModelBox(spike_r11, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r12 = new ModelRenderer(this);
		spike_r12.setRotationPoint(-0.5F, -6.0F, 7.6F);
		bb_main.addChild(spike_r12);
		setRotationAngle(spike_r12, -0.829F, 0.0F, 0.0F);
		spike_r12.cubeList.add(new ModelBox(spike_r12, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-3.0F, -22.0F, 1.5F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.004F, 0.0058F, -0.23F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(1.0F, -22.0F, 1.5F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.004F, 0.0058F, 0.1627F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-3.0F, -23.0F, -2.5F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.004F, 0.0058F, -0.23F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(1.0F, -23.0F, -2.5F);
		bb_main.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.004F, 0.0058F, 0.1627F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(1.0F, -22.0F, -0.5F);
		bb_main.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.004F, 0.0058F, 0.1627F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-3.0F, -22.0F, -2.5F);
		bb_main.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.004F, 0.0058F, -0.23F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-3.0F, -22.0F, -0.5F);
		bb_main.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.004F, 0.0058F, -0.23F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(1.0F, -22.0F, -2.5F);
		bb_main.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.004F, 0.0058F, 0.1627F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		spike_r13 = new ModelRenderer(this);
		spike_r13.setRotationPoint(2.0F, -5.0F, -4.0F);
		bb_main.addChild(spike_r13);
		setRotationAngle(spike_r13, -0.829F, 0.0F, 0.0F);
		spike_r13.cubeList.add(new ModelBox(spike_r13, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r14 = new ModelRenderer(this);
		spike_r14.setRotationPoint(2.0F, -7.0F, 0.0F);
		bb_main.addChild(spike_r14);
		setRotationAngle(spike_r14, -0.829F, 0.0F, 0.0F);
		spike_r14.cubeList.add(new ModelBox(spike_r14, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-3.0F, -23.0F, -4.5F);
		bb_main.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.004F, 0.0058F, -0.23F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(1.0F, -23.0F, -4.5F);
		bb_main.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.004F, 0.0058F, 0.1627F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		spike_r15 = new ModelRenderer(this);
		spike_r15.setRotationPoint(-0.5F, -7.8F, -1.7F);
		bb_main.addChild(spike_r15);
		setRotationAngle(spike_r15, -2.9234F, 0.2618F, 0.0F);
		spike_r15.cubeList.add(new ModelBox(spike_r15, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(1.0F, -23.0F, -6.5F);
		bb_main.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.004F, 0.0058F, 0.1627F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-3.0F, -23.0F, -6.5F);
		bb_main.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.004F, 0.0058F, -0.23F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-3.0F, -21.0F, -8.5F);
		bb_main.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.004F, 0.0058F, -0.23F);
		cube_r13.cubeList.add(new ModelBox(cube_r13, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(1.0F, -21.0F, -8.5F);
		bb_main.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.004F, 0.0058F, 0.1627F);
		cube_r14.cubeList.add(new ModelBox(cube_r14, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		spike_r16 = new ModelRenderer(this);
		spike_r16.setRotationPoint(-3.5F, -4.0F, -2.0F);
		bb_main.addChild(spike_r16);
		setRotationAngle(spike_r16, -2.9234F, -0.4363F, 0.0F);
		spike_r16.cubeList.add(new ModelBox(spike_r16, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r17 = new ModelRenderer(this);
		spike_r17.setRotationPoint(-0.5F, -5.8F, -3.7F);
		bb_main.addChild(spike_r17);
		setRotationAngle(spike_r17, -2.9234F, 0.2618F, 0.0F);
		spike_r17.cubeList.add(new ModelBox(spike_r17, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r18 = new ModelRenderer(this);
		spike_r18.setRotationPoint(-1.0F, -4.0F, -5.0F);
		bb_main.addChild(spike_r18);
		setRotationAngle(spike_r18, -2.9234F, -1.7453F, 0.0F);
		spike_r18.cubeList.add(new ModelBox(spike_r18, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r19 = new ModelRenderer(this);
		spike_r19.setRotationPoint(2.0F, -2.0F, -2.0F);
		bb_main.addChild(spike_r19);
		setRotationAngle(spike_r19, -0.829F, 0.0F, 0.0F);
		spike_r19.cubeList.add(new ModelBox(spike_r19, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		spike_r20 = new ModelRenderer(this);
		spike_r20.setRotationPoint(-3.5F, -4.0F, 0.0F);
		bb_main.addChild(spike_r20);
		setRotationAngle(spike_r20, -0.829F, 0.0F, 0.0F);
		spike_r20.cubeList.add(new ModelBox(spike_r20, 3, 10, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(4.0F, -21.0F, -1.0F);
		bb_main.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, 0.0137F);
		cube_r15.cubeList.add(new ModelBox(cube_r15, 30, 5, -8.0F, 18.0F, 5.0F, 6, 3, 3, 0.0F, false));
		cube_r15.cubeList.add(new ModelBox(cube_r15, 30, 5, -8.0F, 18.0F, 2.0F, 6, 3, 3, 0.0F, false));

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(1.5F, -20.0F, -1.0F);
		bb_main.addChild(cube_r16);
		setRotationAngle(cube_r16, -0.004F, 0.0F, -0.007F);
		cube_r16.cubeList.add(new ModelBox(cube_r16, 31, 12, -3.5F, 18.0F, 1.0F, 2, 2, 3, 0.0F, false));

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(0.5F, -23.0F, 6.0F);
		bb_main.addChild(cube_r17);
		setRotationAngle(cube_r17, -0.0043F, 0.0F, 0.0F);
		cube_r17.cubeList.add(new ModelBox(cube_r17, 46, 12, -3.5F, 20.0F, -6.0F, 3, 3, 1, 0.0F, false));

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(0.0F, -17.0F, -1.5F);
		bb_main.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.004F, 0.0058F, -0.0119F);
		cube_r18.cubeList.add(new ModelBox(cube_r18, 0, 0, -2.0F, 13.0F, 1.5F, 3, 4, 2, 0.0F, false));

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(-2.0F, -19.0F, -4.5F);
		bb_main.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.004F, -0.0058F, 0.0119F);
		cube_r19.cubeList.add(new ModelBox(cube_r19, 17, 10, 1.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(0.0F, -20.0F, -3.5F);
		bb_main.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.004F, 0.0058F, -0.0119F);
		cube_r20.cubeList.add(new ModelBox(cube_r20, 17, 10, -2.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(0.0F, -19.0F, -4.5F);
		bb_main.addChild(cube_r21);
		setRotationAngle(cube_r21, -0.004F, -0.0058F, 0.0119F);
		cube_r21.cubeList.add(new ModelBox(cube_r21, 17, 10, -1.0F, 15.0F, 4.5F, 3, 4, 2, 0.0F, false));

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(-3.0F, -2.0F, 1.0F);
		bb_main.addChild(cube_r22);
		setRotationAngle(cube_r22, -0.004F, 0.0F, 0.007F);
		cube_r22.cubeList.add(new ModelBox(cube_r22, 49, 19, 3.0F, 0.0F, -1.0F, 2, 2, 3, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}