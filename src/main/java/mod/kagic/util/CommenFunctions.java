package mod.kagic.util;

import java.util.Random;

import mod.kagic.entity.EntityCrystalShrimp;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class CommenFunctions extends StructureComponent {

    private int CrystalShrimpSpawned;

    public CommenFunctions() {

    }

    public void spawnShrimp(World par1World, StructureBoundingBox par2StructureBoundingBox, int par3, int par4,
            int par5, int par6) {
        if (this.CrystalShrimpSpawned < par6) {
            for (int var7 = this.CrystalShrimpSpawned; var7 < par6; ++var7) {
                int x = this.getXWithOffset(par3 + var7, par5);
                final int y = this.getYWithOffset(par4);
                int z = this.getZWithOffset(par3 + var7, par5);

                x += par1World.rand.nextInt(3) - 1;
                z += par1World.rand.nextInt(3) - 1;

                if (!par2StructureBoundingBox.isVecInside(new BlockPos(x, y, z))) {
                    break;
                }

                ++this.CrystalShrimpSpawned;
                final EntityCrystalShrimp var11 = new EntityCrystalShrimp(par1World);
                var11.setLocationAndAngles(x + 0.5D, y, z + 0.5D, 0.0F, 0.0F);
                par1World.spawnEntity(var11);
            }
        }
    }

    protected int getXWithOffset(int var1, int var2) {
        switch (getCoordBaseMode().getHorizontalIndex()) {
            case 0:
                return this.boundingBox.minX + var1;

            case 1:
                return this.boundingBox.maxX - var2;

            case 2:
                return this.boundingBox.maxX - var1;

            case 3:
                return this.boundingBox.minX + var2;

            default:
                return var1;
        }
    }

    protected int getZWithOffset(int var1, int var2) {
        switch (getCoordBaseMode().getHorizontalIndex()) {
            case 0:
                return this.boundingBox.minZ + var2;

            case 1:
                return this.boundingBox.minZ + var1;

            case 2:
                return this.boundingBox.maxZ - var2;

            case 3:
                return this.boundingBox.maxZ - var1;

            default:
                return var2;
        }
    }

    protected int getYWithOffset(int var1) {
        return getYWithOffset(var1);
    }

    protected static class SwitchEnumFacing {
        protected static int[] field_176064_a = new int[EnumFacing.VALUES.length];

        static {
            try {
                field_176064_a[EnumFacing.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError var4) {
            }

            try {
                field_176064_a[EnumFacing.SOUTH.ordinal()] = 2;
            } catch (NoSuchFieldError var3) {
            }

            try {
                field_176064_a[EnumFacing.WEST.ordinal()] = 3;
            } catch (NoSuchFieldError var2) {
            }

            try {
                field_176064_a[EnumFacing.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError var1) {
            }
        }
    }

    @Override
    protected void writeStructureToNBT(NBTTagCompound tagCompound) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
        // TODO Auto-generated method stub
        return false;
    }
}