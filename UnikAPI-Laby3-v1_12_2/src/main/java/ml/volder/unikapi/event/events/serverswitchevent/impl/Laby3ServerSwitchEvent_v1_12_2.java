package ml.volder.unikapi.event.events.serverswitchevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.serverswitchevent.ServerSwitchEvent;
import net.labymod.main.LabyMod;
import net.labymod.utils.Consumer;
import net.labymod.utils.ServerData;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketJoinGame;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.12.*")
public class Laby3ServerSwitchEvent_v1_12_2 implements EventImpl {
    @Override
    public String getName() {
        return "laby3-serverswitchevent";
    }

    @Override
    public void register() {
        new SubServerSwitchPacketListener(this).register();
        new JoinServerListenerLaby3_v1_12_2(this).register();
        new QuitServerListenerLaby3_v1_12_2(this).register();
    }
}

class SubServerSwitchPacketListener implements Consumer<Object> {

    Laby3ServerSwitchEvent_v1_12_2 switchEventLaby3_v1_12_2;

    public SubServerSwitchPacketListener(Laby3ServerSwitchEvent_v1_12_2 switchEventLaby3_v1_12_2) {
        this.switchEventLaby3_v1_12_2 = switchEventLaby3_v1_12_2;
    }

    public String getName() {
        return switchEventLaby3_v1_12_2.getName();
    }

    public void register() {
        LabyMod.getInstance().getLabyModAPI().getEventManager().registerOnIncomingPacket(this);
    }

    @Override
    public void accept(Object packetObject) {
        if (packetObject instanceof SPacketJoinGame) {
            if(Minecraft.getMinecraft().getCurrentServerData() != null)
                EventManager.callEvent(new ServerSwitchEvent(EventType.PRE, getName(), ServerSwitchEvent.SWITCH_TYPE.SWITCH_SUBSERVER));
        }
    }
}

class JoinServerListenerLaby3_v1_12_2 implements Consumer<ServerData> {

    Laby3ServerSwitchEvent_v1_12_2 switchEventLaby3_v1_12_2;

    public JoinServerListenerLaby3_v1_12_2(Laby3ServerSwitchEvent_v1_12_2 switchEventLaby3_v1_12_2) {
        this.switchEventLaby3_v1_12_2 = switchEventLaby3_v1_12_2;
    }

    public String getName() {
        return switchEventLaby3_v1_12_2.getName();
    }

    public void register() {
        LabyMod.getInstance().getLabyModAPI().getEventManager().registerOnJoin(this);
    }

    @Override
    public void accept(ServerData serverData) {
        EventManager.callEvent(new ServerSwitchEvent(EventType.PRE, getName(), ServerSwitchEvent.SWITCH_TYPE.JOIN));
    }
}

class QuitServerListenerLaby3_v1_12_2 implements Consumer<ServerData> {

    Laby3ServerSwitchEvent_v1_12_2 switchEventLaby3_v1_12_2;

    public QuitServerListenerLaby3_v1_12_2(Laby3ServerSwitchEvent_v1_12_2 switchEventLaby3_v1_12_2) {
        this.switchEventLaby3_v1_12_2 = switchEventLaby3_v1_12_2;
    }

    public String getName() {
        return switchEventLaby3_v1_12_2.getName();
    }

    public void register() {
        LabyMod.getInstance().getLabyModAPI().getEventManager().registerOnQuit(this);
    }

    @Override
    public void accept(ServerData serverData) {
        EventManager.callEvent(new ServerSwitchEvent(EventType.PRE, getName(), ServerSwitchEvent.SWITCH_TYPE.LEAVE));
    }
}