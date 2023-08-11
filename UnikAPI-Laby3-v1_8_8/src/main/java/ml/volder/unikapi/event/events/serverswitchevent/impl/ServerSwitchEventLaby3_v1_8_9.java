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
import net.minecraft.network.play.server.S01PacketJoinGame;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class ServerSwitchEventLaby3_v1_8_9 implements EventImpl  {
    @Override
    public String getName() {
        return "laby3-serverswitchevent";
    }

    @Override
    public void register() {
        new SubServerSwitchPacketListener(this).register();
        new JoinServerListenerLaby3_v1_8_9(this).register();
        new QuitServerListenerLaby3_v1_8_9(this).register();
    }
}

class SubServerSwitchPacketListener implements Consumer<Object> {

    ServerSwitchEventLaby3_v1_8_9 switchEventLaby3_v1_8_9;

    public SubServerSwitchPacketListener(ServerSwitchEventLaby3_v1_8_9 switchEventLaby3_v1_8_9) {
        this.switchEventLaby3_v1_8_9 = switchEventLaby3_v1_8_9;
    }

    public String getName() {
        return switchEventLaby3_v1_8_9.getName();
    }

    public void register() {
       LabyMod.getInstance().getLabyModAPI().getEventManager().registerOnIncomingPacket(this);
    }

    @Override
    public void accept(Object packetObject) {
        if (packetObject instanceof S01PacketJoinGame) {
            if(Minecraft.getMinecraft().getCurrentServerData() != null)
                EventManager.callEvent(new ServerSwitchEvent(EventType.PRE, getName(), ServerSwitchEvent.SWITCH_TYPE.SWITCH_SUBSERVER));
        }
    }
}

class JoinServerListenerLaby3_v1_8_9 implements Consumer<ServerData> {

    ServerSwitchEventLaby3_v1_8_9 switchEventLaby3_v1_8_9;

    public JoinServerListenerLaby3_v1_8_9(ServerSwitchEventLaby3_v1_8_9 switchEventLaby3_v1_8_9) {
        this.switchEventLaby3_v1_8_9 = switchEventLaby3_v1_8_9;
    }

    public String getName() {
        return switchEventLaby3_v1_8_9.getName();
    }

    public void register() {
        LabyMod.getInstance().getLabyModAPI().getEventManager().registerOnJoin(this);
    }

    @Override
    public void accept(ServerData serverData) {
        EventManager.callEvent(new ServerSwitchEvent(EventType.PRE, getName(), ServerSwitchEvent.SWITCH_TYPE.JOIN));
    }
}

class QuitServerListenerLaby3_v1_8_9 implements Consumer<ServerData> {

    ServerSwitchEventLaby3_v1_8_9 switchEventLaby3_v1_8_9;

    public QuitServerListenerLaby3_v1_8_9(ServerSwitchEventLaby3_v1_8_9 switchEventLaby3_v1_8_9) {
        this.switchEventLaby3_v1_8_9 = switchEventLaby3_v1_8_9;
    }

    public String getName() {
        return switchEventLaby3_v1_8_9.getName();
    }

    public void register() {
        LabyMod.getInstance().getLabyModAPI().getEventManager().registerOnQuit(this);
    }

    @Override
    public void accept(ServerData serverData) {
        EventManager.callEvent(new ServerSwitchEvent(EventType.PRE, getName(), ServerSwitchEvent.SWITCH_TYPE.LEAVE));
    }
}

