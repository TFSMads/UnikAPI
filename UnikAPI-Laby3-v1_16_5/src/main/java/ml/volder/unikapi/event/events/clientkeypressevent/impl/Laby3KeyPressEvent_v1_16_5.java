package ml.volder.unikapi.event.events.clientkeypressevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.clientkeypressevent.ClientKeyPressEvent;


@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3KeyPressEvent_v1_16_5 implements EventImpl {

    private static boolean isRegistered = false;
    private static Laby3KeyPressEvent_v1_16_5 eventInstance;

    public static void onKeyInput() {
        if(isRegistered)
            EventManager.callEvent(new ClientKeyPressEvent(EventType.PRE, eventInstance.getName()));
    }


    @Override
    public String getName() {
        return "laby3-keypressevent";
    }

    @Override
    public void register() {
        isRegistered = true;
        eventInstance = this;
    }


}
