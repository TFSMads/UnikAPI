package ml.volder.unikapi.event.events.drawscreenevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.draw.impl.Laby3DrawAPI_v1_16_5;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.drawscreenevent.DrawScreenEvent;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.gui.RenderGameOverlayEvent;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;

import java.nio.DoubleBuffer;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3DrawScreenEvent_v1_16_5 implements EventImpl {

    @Subscribe
    public void onRender(RenderGameOverlayEvent event){
        if(event.getPhase() == RenderGameOverlayEvent.Phase.POST) {
            DoubleBuffer xPos = BufferUtils.createDoubleBuffer(1);
            DoubleBuffer yPos = BufferUtils.createDoubleBuffer(1);
            GLFW.glfwGetCursorPos(Minecraft.getInstance().getMainWindow().getHandle(), xPos, yPos);
            Laby3DrawAPI_v1_16_5.updateRenderStack(event.getMatrixStack());
            EventManager.callEvent(new DrawScreenEvent(EventType.PRE, getName(), (int) xPos.get(), (int) yPos.get(), event.getPartialTicks()));
            Laby3DrawAPI_v1_16_5.restoreRenderStack();
        }
    }

    @Override
    public String getName() {
        return "laby3-drawscreenevent";
    }

    @Override
    public void register() {
        LabyMod.getInstance().getEventService().registerListener(this);
    }

}
