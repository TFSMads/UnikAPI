package ml.volder.unikapi.event.events.sendmessageevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.sendmessageevent.SendMessageEvent;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.main.LabyMod;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class Laby3SendMessageEvent_v1_8_9 implements EventImpl {


    public boolean onMessage(String message){
        SendMessageEvent e = new SendMessageEvent(EventType.PRE, getName(), message);
        EventManager.callEvent(e);
        return e.isCancelled();
    }

    @Override
    public String getName() {
        return "laby3-sendmessageevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getEventManager().register(new EventSendMessage(this));
    }

}

class EventSendMessage implements MessageSendEvent {

    Laby3SendMessageEvent_v1_8_9 instance;

    public EventSendMessage(Laby3SendMessageEvent_v1_8_9 instance) {
        this.instance = instance;
    }

    @Override
    public boolean onSend(String s) {
        return instance.onMessage(s);
    }
}
