package ml.volder.unikapi.event.events.sendmessageevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.sendmessageevent.SendMessageEvent;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageSendEvent;
import net.labymod.main.LabyMod;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.12.*")
public class Laby3SendMessageEvent_v1_16_5 implements EventImpl {


    @Subscribe
    public void onMessage(MessageSendEvent event){
        SendMessageEvent e = new SendMessageEvent(EventType.PRE, getName(), event.getMessage());
        EventManager.callEvent(e);
        event.setCancelled(e.isCancelled());
    }

    @Override
    public String getName() {
        return "laby3-sendmessageevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getEventService().registerListener(this);
    }
}
