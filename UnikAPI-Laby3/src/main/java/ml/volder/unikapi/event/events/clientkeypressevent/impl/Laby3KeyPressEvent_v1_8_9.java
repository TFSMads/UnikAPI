package ml.volder.unikapi.event.events.clientkeypressevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.clientkeypressevent.ClientKeyPressEvent;
import net.labymod.main.LabyMod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class Laby3KeyPressEvent_v1_8_9 implements EventImpl {
    @SubscribeEvent
    public void onTick(InputEvent.KeyInputEvent event){
        EventManager.callEvent(new ClientKeyPressEvent(EventType.PRE, getName()));
    }

    @Override
    public String getName() {
        return "laby3-keypressevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getLabyModAPI().registerForgeListener(this);
    }


}
