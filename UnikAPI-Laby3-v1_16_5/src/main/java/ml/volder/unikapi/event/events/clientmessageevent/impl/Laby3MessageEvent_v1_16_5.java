package ml.volder.unikapi.event.events.clientmessageevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.clientmessageevent.ClientMessageEvent;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageReceiveEvent;
import net.labymod.main.LabyMod;
@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3MessageEvent_v1_16_5 implements EventImpl {

    @Subscribe
    public void onMessage(MessageReceiveEvent messageEvent){
        ClientMessageEvent event = new ClientMessageEvent(EventType.PRE, getName(), messageEvent.getComponent().getString(), messageEvent.getComponent().getString());
        EventManager.callEvent(event);
        messageEvent.setCancelled(event.isCancelled());
    }

    @Override
    public String getName() {
        return "laby3-messageevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getEventService().registerListener(this);
    }

}