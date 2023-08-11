package ml.volder.unikapi.event.events.serverswitchevent.impl;

import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.serverswitchevent.ServerSwitchEvent;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.network.IncomingPacketEvent;
import net.labymod.api.event.events.network.server.DisconnectServerEvent;
import net.labymod.api.event.events.network.server.LoginServerEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SJoinGamePacket;

public class Laby3ServerSwitchEvent_v1_16_5 implements EventImpl {

    @Subscribe
    public void OnPacketReceive(IncomingPacketEvent event) {
        if(event.getPacket() instanceof SJoinGamePacket && Minecraft.getInstance().getCurrentServerData() != null) {
            EventManager.callEvent(new ServerSwitchEvent(EventType.PRE, getName(), ServerSwitchEvent.SWITCH_TYPE.SWITCH_SUBSERVER));
        }
    }

    @Subscribe
    public void OnQuitServer(DisconnectServerEvent event) {
        EventManager.callEvent(new ServerSwitchEvent(EventType.PRE, getName(), ServerSwitchEvent.SWITCH_TYPE.LEAVE));
    }

    @Subscribe
    public void OnJoinServer(LoginServerEvent event) {
        if (Minecraft.getInstance().getCurrentServerData() != null)
            return;
        EventManager.callEvent(new ServerSwitchEvent(EventType.PRE, getName(), ServerSwitchEvent.SWITCH_TYPE.JOIN));
    }

    @Override
    public String getName() {
        return "laby3-serverswitchevent";
    }

    @Override
    public void register() {

    }
}
