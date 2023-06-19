package ml.volder.unikapi.event.events.clienttickevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.clienttickevent.ClientTickEvent;
import net.labymod.main.LabyMod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class Laby3ClientTickEvent_v1_8_9 implements EventImpl {
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        EventManager.callEvent(new ClientTickEvent(EventType.PRE, getName()));
    }

    @Override
    public String getName() {
        return "laby3-tickevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getLabyModAPI().registerForgeListener(this);
    }

}
