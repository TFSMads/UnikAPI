package ml.volder.unikapi.event.events.mainmenuopenevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.mainmenuopenevent.MainMenuOpenEvent;
import net.labymod.main.LabyMod;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.12.*")

public class Laby3MainMenuOpenEvent_v1_12_2 implements EventImpl {

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event){
        if(event.getGui() instanceof GuiMainMenu){
            MainMenuOpenEvent openMainMenuEvent = new MainMenuOpenEvent(EventType.PRE, getName());
            EventManager.callEvent(openMainMenuEvent);
            if(openMainMenuEvent.getNewScreen() != null && openMainMenuEvent.getNewScreen().getHandle(GuiScreen.class) != null)
                event.setGui(openMainMenuEvent.getNewScreen().getHandle(GuiScreen.class));
            event.setCanceled(openMainMenuEvent.isCancelled() || event.isCanceled());
        }
    }

    @Override
    public String getName() {
        return "laby3-openmainmenuevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getLabyModAPI().registerForgeListener(this);
    }
}