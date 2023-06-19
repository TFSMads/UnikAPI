package ml.volder.unikapi.event.events.clientkeypressevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.clientkeypressevent.ClientKeyPressEvent;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.12.*")
public class Laby3KeyPressEvent_v1_12_2 implements EventImpl {

    private static Laby3KeyPressEvent_v1_12_2 instance;

    public static void callOnKeyPress() {
        if (instance == null)
            return;
        instance.onKeyPress();
    }

    public void onKeyPress(){
        EventManager.callEvent(new ClientKeyPressEvent(EventType.PRE, getName()));
    }

    @Override
    public String getName() {
        return "laby3-keypressevent";
    }

    @Override
    public void register() {
        instance = this;
    }


}
