package ml.volder.unikapi.event.events.opensignevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.opensignevent.OpenSignEvent;
import ml.volder.unikapi.utils.ReflectionUtils;
import ml.volder.unikapi.wrappers.tileentitysign.impl.Laby3WrappedTileEntitySign_v1_8_9;
import net.labymod.main.LabyMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class Laby3OpenSignEvent_v1_8_9 implements EventImpl {

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event){
        if(event.gui instanceof GuiEditSign){
            TileEntitySign sign = (TileEntitySign) ReflectionUtils.getPrivateFieldValueByType(event.gui, GuiEditSign.class, TileEntitySign.class);

            OpenSignEvent openSignEvent = new OpenSignEvent(EventType.PRE, getName(), new Laby3WrappedTileEntitySign_v1_8_9(sign));
            EventManager.callEvent(openSignEvent);
            if(openSignEvent.getNewScreen() != null && openSignEvent.getNewScreen().getHandle(GuiScreen.class) != null)
                event.gui = openSignEvent.getNewScreen().getHandle(GuiScreen.class);
            event.setCanceled(openSignEvent.isCancelled() || event.isCanceled());
        }
    }

    @Override
    public String getName() {
        return "laby3-opensignevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getLabyModAPI().registerForgeListener(this);
    }

}