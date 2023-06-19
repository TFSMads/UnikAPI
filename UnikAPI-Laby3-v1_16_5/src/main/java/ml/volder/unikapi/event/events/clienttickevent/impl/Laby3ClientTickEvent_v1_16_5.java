package ml.volder.unikapi.event.events.clienttickevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.clienttickevent.ClientTickEvent;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.TickEvent;
import net.labymod.main.LabyMod;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3ClientTickEvent_v1_16_5 implements EventImpl {
    @Subscribe
    public void onTick(TickEvent event){
        EventManager.callEvent(new ClientTickEvent(EventType.PRE, getName()));
    }

    @Override
    public String getName() {
        return "laby3-tickevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getEventService().registerListener(this);
    }

}
