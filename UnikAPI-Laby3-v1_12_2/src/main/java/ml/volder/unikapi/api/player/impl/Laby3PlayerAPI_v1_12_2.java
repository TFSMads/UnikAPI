package ml.volder.unikapi.api.player.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.player.PlayerAPI;
import ml.volder.unikapi.wrappers.guiscreen.WrappedGuiScreen;
import ml.volder.unikapi.wrappers.guiscreen.impl.Laby3GuiScreenImpl_v1_12_2;
import net.labymod.core.LabyModCore;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.util.UUID;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.12.*")
public class Laby3PlayerAPI_v1_12_2 implements PlayerAPI {
    @Override
    public void sendCommand(String command) {
        LabyModCore.getMinecraft().getPlayer().sendChatMessage("/" + command);
    }

    @Override
    public void openGuiScreen(WrappedGuiScreen screen) {
        if(screen == null) {
            Minecraft.getMinecraft().displayGuiScreen(null);
        }else{
            Minecraft.getMinecraft().displayGuiScreen(screen.getHandle(GuiScreen.class));
        }
    }

    @Override
    public WrappedGuiScreen getCurrentScreen() {
        if(Minecraft.getMinecraft().currentScreen instanceof Laby3GuiScreenImpl_v1_12_2) {
            Laby3GuiScreenImpl_v1_12_2 screen = (Laby3GuiScreenImpl_v1_12_2) Minecraft.getMinecraft().currentScreen;
            return screen.getScreen();
        }
        return null;
    }

    @Override
    public boolean hasOpenScreen() {
        return Minecraft.getMinecraft().currentScreen != null;
    }

    @Override
    public UUID getUUID() {
        if(Minecraft.getMinecraft().player == null)
            return null;
        return Minecraft.getMinecraft().player.getUniqueID();
    }

    @Override
    public void displayChatMessage(String message) {
        LabyMod.getInstance().displayMessageInChat(message);
    }

    @Override
    public void displayActionBarMessage(String message) {
        Minecraft.getMinecraft().ingameGUI.setOverlayMessage(message, false);
    }

    private static Laby3PlayerAPI_v1_12_2 instance;

    public static Laby3PlayerAPI_v1_12_2 getAPI() {
        if(instance == null)
            instance = new Laby3PlayerAPI_v1_12_2();
        return instance;
    }
}
