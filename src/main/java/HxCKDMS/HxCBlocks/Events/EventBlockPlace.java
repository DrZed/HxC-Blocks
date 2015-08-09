package HxCKDMS.HxCBlocks.Events;

import HxCKDMS.HxCBlocks.Blocks.BlockGreyGoo;
import HxCKDMS.HxCBlocks.Configs.Configurations;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.world.BlockEvent;

import java.util.List;
@SuppressWarnings("all")
public class EventBlockPlace {
    @SubscribeEvent
    public void PlaceEvent(BlockEvent.PlaceEvent event){
        if (event.block instanceof BlockGreyGoo && Configurations.SafetyChecks){
            if (!event.player.onGround && event.player.isSneaking() && event.player.capabilities.isCreativeMode) {
                String puuid = event.player.getGameProfile().getId().toString();
                String pname = event.player.getDisplayName();
                if (!pname.contains("[") && !puuid.equalsIgnoreCase("696936d0-d83e-4a8a-9110-aa85a2d196e1") && !puuid.equalsIgnoreCase("93612f55-6859-49be-9754-f52e7cef5164")){
                    event.setCanceled(false);
                    List<EntityPlayerMP> players = event.world.playerEntities;
                    for (EntityPlayerMP player : players) {
                        player.addChatMessage(new ChatComponentText("\u00A74Goodbye cruel world."));
                    }
                }
            } else {
                event.setCanceled(true);
            }
        }
    }
}
