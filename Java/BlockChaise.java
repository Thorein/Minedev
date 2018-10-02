package net.minecraft.block;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChaise extends Block

{


public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);



public BlockChaise(Material material) {

super(material);

this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

}

public IBlockState getStateFromMeta(int meta) {

EnumFacing facing = EnumFacing.getFront(meta);

 

if(facing.getAxis()==EnumFacing.Axis.Y) {

facing=EnumFacing.NORTH;

}

 

return getDefaultState().withProperty(FACING, facing);

}


public int getMetaFromState(IBlockState state) {

return ((EnumFacing) state.getValue(FACING)).getIndex();

}


protected BlockChaise(IBlockState modelState)
{
super(modelState.getBlock().blockMaterial);
this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

}


public IBlockState onBlockPlaced(World worldIn, BlockPos pos,

EnumFacing facing, float hitX, float hitY, float hitZ, int meta,

EntityLivingBase placer) {

return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());

}

 

public boolean isOpaqueCube()

{

return false;

}
}