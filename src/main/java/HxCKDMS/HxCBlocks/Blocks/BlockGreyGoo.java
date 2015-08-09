package HxCKDMS.HxCBlocks.Blocks;

import HxCKDMS.HxCBlocks.Reference.References;
import HxCKDMS.HxCBlocks.Registry.CreativeTabHxCBlocks;
import HxCKDMS.HxCBlocks.TileEntities.TileGreyGoo;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGreyGoo extends BlockContainer {
    public BlockGreyGoo(Material material) {
		super(material);
		setCreativeTab(CreativeTabHxCBlocks.tabHxCBlocks);
		setUnlocalizedName("GreyGoo");
		setStepSound(soundTypeMetal);
        setTextureName(References.MOD_ID + ":GreyGoo");
		setHardness(1.0F);
		setResistance(1600.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileGreyGoo();
	}
}
