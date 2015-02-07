package HxCKDMS.HxCBlocks.Blocks;

import HxCKDMS.HxCBlocks.Registry.CreativeTabHxCBlocks;
import HxCKDMS.HxCBlocks.TileEntities.TileSlaughterBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSlaughterBlock extends BlockContainer {

	public BlockSlaughterBlock(Material material) {
		super(material);
		setCreativeTab(CreativeTabHxCBlocks.tabHxCBlocks);
		setUnlocalizedName("SlaughterBlock");
		setStepSound(soundTypeMetal);
		setHardness(1.0F);
		setResistance(1600.0F);
        setLightLevel(1);
	}

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileSlaughterBlock();
    }

    @Override
    public boolean canConnectRedstone(IBlockAccess world, BlockPos pos, EnumFacing side) {
        return true;
    }
    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        super.onBlockAdded(world, pos, state);
        TileSlaughterBlock block = (TileSlaughterBlock)world.getTileEntity(pos);
        block.modifier = 1;
    }
}
