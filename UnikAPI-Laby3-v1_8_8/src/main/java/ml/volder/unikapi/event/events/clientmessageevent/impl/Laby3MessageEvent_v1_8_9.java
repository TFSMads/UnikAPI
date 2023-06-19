package ml.volder.unikapi.event.events.clientmessageevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.clientmessageevent.ClientMessageEvent;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.main.LabyMod;
@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class Laby3MessageEvent_v1_8_9 implements EventImpl {

    public boolean onReceive(String message, String clean){
        ClientMessageEvent event = new ClientMessageEvent(EventType.PRE, getName(), message, clean);
        EventManager.callEvent(event);
        return event.isCancelled();
    }

    @Override
    public String getName() {
        return "laby3-messageevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getEventManager().register(new LabyMessageRecieveEvent(this));
    }

}

class LabyMessageRecieveEvent implements MessageReceiveEvent {

    Laby3MessageEvent_v1_8_9 instance;

    public LabyMessageRecieveEvent(Laby3MessageEvent_v1_8_9 instance) {
        this.instance = instance;
    }

    @Override
    public boolean onReceive(String message, String clean) {
        return instance.onReceive(message, clean);
    }
}