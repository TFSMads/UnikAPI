package ml.volder.unikapi.event.events.mainmenuopenevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.mainmenuopenevent.MainMenuOpenEvent;
import ml.volder.unikapi.event.events.opensignevent.OpenSignEvent;
import ml.volder.unikapi.utils.ReflectionUtils;
import ml.volder.unikapi.wrappers.tileentitysign.impl.Laby3WrappedTileEntitySign_v1_16_5;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.gui.screen.ScreenOpenEvent;
import net.labymod.main.LabyMod;
import net.minecraft.client.gui.screen.EditSignScreen;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.tileentity.SignTileEntity;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3MainMenuOpenEvent_v1_16_5 implements EventImpl {

    @Subscribe
    public void onGuiOpen(ScreenOpenEvent event){
        if(event.getScreen() instanceof MainMenuScreen){
            MainMenuOpenEvent openMainMenuEvent = new MainMenuOpenEvent(EventType.PRE, getName());
            EventManager.callEvent(openMainMenuEvent);
            if(openMainMenuEvent.getNewScreen() != null && openMainMenuEvent.getNewScreen().getHandle(Screen.class) != null)
                event.setScreen(openMainMenuEvent.getNewScreen().getHandle(Screen.class));
            if(openMainMenuEvent.isCancelled())
                event.setScreen(null);
        }
    }

    @Override
    public String getName() {
        return "laby3-openmainmenuevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getEventService().registerListener(this);
    }

}