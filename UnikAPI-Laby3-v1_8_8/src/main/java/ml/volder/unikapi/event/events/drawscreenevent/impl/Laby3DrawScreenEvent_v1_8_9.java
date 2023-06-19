package ml.volder.unikapi.event.events.drawscreenevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.drawscreenevent.DrawScreenEvent;
import net.labymod.api.events.RenderIngameOverlayEvent;
import net.labymod.main.LabyMod;
import org.lwjgl.input.Mouse;
@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class Laby3DrawScreenEvent_v1_8_9 implements EventImpl {

    public void onRender(float renderPartialTicks){
        EventManager.callEvent(new DrawScreenEvent(EventType.PRE, getName(), Mouse.getX(), Mouse.getY(), renderPartialTicks));
    }

    @Override
    public String getName() {
        return "laby3-drawscreenevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getEventManager().register(new RenderOverlayEvent(this));
    }

}

class RenderOverlayEvent implements RenderIngameOverlayEvent {

    Laby3DrawScreenEvent_v1_8_9 instance;

    public RenderOverlayEvent(Laby3DrawScreenEvent_v1_8_9 instance) {
        this.instance = instance;
    }

    @Override
    public void onRender(float v) {
        instance.onRender(v);
    }
}