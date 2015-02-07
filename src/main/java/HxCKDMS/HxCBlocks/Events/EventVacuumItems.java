package HxCKDMS.HxCBlocks.Events;

import HxCKDMS.HxCBlocks.TileEntities.TileVacuum;
import HxCKDMS.HxCCore.Utils.IOHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.List;

@SuppressWarnings("unchecked")
public class EventVacuumItems {
    public void vacuum(BlockPos pos, World world) {
        TileEntity tile = world.getTileEntity(pos);
        TileVacuum HxCTile = (TileVacuum)tile;
        int modifier = HxCTile.modifier;
        int nx; int ny; int nz;
        if (pos.getX() >= 0) nx = pos.getX() + 1;
        else nx = pos.getX() - 1;
        if (pos.getY() >= 0) ny = pos.getY() + 1;
        else ny = pos.getY() - 1;
        if (pos.getZ() >= 0) nz = pos.getZ() + 1;
        else nz = pos.getZ() - 1;
        List list  = world.getEntitiesWithinAABB(EntityItem.class, getAreaBoundingBox(pos.getX(), pos.getY(), pos.getZ(), nx, ny, nz, modifier));
        for (EntityItem entity : (List<EntityItem>) list) {
            if (!entity.isDead) {
                ItemStack s = IOHelper.insert((IInventory)HxCTile, entity.getEntityItem(), EnumFacing.UP, true);
                if (s == null) {
                    IOHelper.insert((IInventory)HxCTile, entity.getEntityItem(), EnumFacing.UP, false);
                    entity.setDead();
                }
            }
        }
    }

    protected AxisAlignedBB getAreaBoundingBox(int mx, int my, int mz, int Mx, int My, int Mz, int mod) {
        if (mx > 0) mx += mod; else mx -= mod;
        if (my > 0) my += mod; else my -= mod;
        if (mz > 0) mz += mod; else mz -= mod;
        if (Mx > 0) Mx += mod; else Mx -= mod;
        if (My > 0) My += mod; else My -= mod;
        if (Mz > 0) Mz += mod; else Mz -= mod;
        return AxisAlignedBB.fromBounds(mx, my, mz, Mx, My, Mz);
    }
}
