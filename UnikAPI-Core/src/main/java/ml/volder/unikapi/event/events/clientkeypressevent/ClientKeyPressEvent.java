package ml.volder.unikapi.event.events.clientkeypressevent;

import ml.volder.unikapi.api.ApiManager;
import ml.volder.unikapi.event.Event;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.Handler;

import java.util.ArrayList;
import java.util.List;

public class ClientKeyPressEvent extends Event {

    private static List<Handler> handlerList = new ArrayList<>();

    public ClientKeyPressEvent(EventType eventType, String eventName) {
        super(eventType, eventName);
    }

    public ClientKeyPressEvent(EventType eventType) {
        super(eventType);
    }

    public static List<Handler> getHandlers(){
        return handlerList;
    }

    @Override
    public List<Handler> getHandlerList() {
        return handlerList;
    }

    private static EventImpl eventImpl;

    public static boolean isRegistred() {
        return eventImpl != null;
    }

    //Registers event impl if not registred
    public static void registerEvent() {
        if(!isRegistred()){
            Class<? extends EventImpl> klass = ApiManager.getClassAPI("ClientKeyPressEvent", "ml.volder.unikapi.event.events.clientkeypressevent.impl", EventImpl.class);
            if(klass != null) {
                try {
                    eventImpl = klass.newInstance();
                    eventImpl.register();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
