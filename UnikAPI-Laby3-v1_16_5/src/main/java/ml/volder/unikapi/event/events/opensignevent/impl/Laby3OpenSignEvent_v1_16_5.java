package ml.volder.unikapi.event.events.opensignevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.opensignevent.OpenSignEvent;
import ml.volder.unikapi.utils.ReflectionUtils;
import ml.volder.unikapi.wrappers.tileentitysign.impl.Laby3WrappedTileEntitySign_v1_16_5;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.gui.screen.ScreenOpenEvent;
import net.labymod.main.LabyMod;
import net.minecraft.client.gui.screen.EditSignScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.tileentity.SignTileEntity;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3OpenSignEvent_v1_16_5 implements EventImpl {

    @Subscribe
    public void onGuiOpen(ScreenOpenEvent event){
        if(event.getScreen() instanceof EditSignScreen){
            SignTileEntity sign = (SignTileEntity) ReflectionUtils.getPrivateFieldValueByType(event.getScreen(), EditSignScreen.class, SignTileEntity.class);
            OpenSignEvent openSignEvent = new OpenSignEvent(EventType.PRE, getName(), new Laby3WrappedTileEntitySign_v1_16_5(sign));
            EventManager.callEvent(openSignEvent);
            if(openSignEvent.getNewScreen() != null && openSignEvent.getNewScreen().getHandle(Screen.class) != null)
                event.setScreen(openSignEvent.getNewScreen().getHandle(Screen.class));
            if(openSignEvent.isCancelled())
                event.setScreen(null);
        }
    }

    @Override
    public String getName() {
        return "laby3-opensignevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getEventService().registerListener(this);
    }

}