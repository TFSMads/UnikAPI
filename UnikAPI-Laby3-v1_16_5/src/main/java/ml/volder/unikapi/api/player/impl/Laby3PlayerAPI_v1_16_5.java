package ml.volder.unikapi.api.player.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.player.PlayerAPI;
import ml.volder.unikapi.wrappers.guiscreen.WrappedGuiScreen;
import ml.volder.unikapi.wrappers.guiscreen.impl.Laby3GuiScreenImpl_v1_16_5;
import net.labymod.core.LabyModCore;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.StringTextComponent;

import java.util.UUID;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3PlayerAPI_v1_16_5 implements PlayerAPI {
    @Override
    public void sendCommand(String command) {
        LabyModCore.getMinecraft().getPlayer().sendChatMessage("/" + command);
    }

    @Override
    public void openGuiScreen(WrappedGuiScreen screen) {
        if(screen == null) {
            Minecraft.getInstance().displayGuiScreen(null);
        }else{
            Minecraft.getInstance().displayGuiScreen(screen.getHandle(Screen.class));
        }
    }

    @Override
    public WrappedGuiScreen getCurrentScreen() {
        if(Minecraft.getInstance().currentScreen instanceof Laby3GuiScreenImpl_v1_16_5) {
            Laby3GuiScreenImpl_v1_16_5 screen = (Laby3GuiScreenImpl_v1_16_5) Minecraft.getInstance().currentScreen;
            return screen.getScreen();
        }
        return null;
    }

    @Override
    public boolean hasOpenScreen() {
        return Minecraft.getInstance().currentScreen != null;
    }

    @Override
    public UUID getUUID() {
        if(Minecraft.getInstance().player == null)
            return null;
        return Minecraft.getInstance().player.getUniqueID();
    }

    @Override
    public void displayChatMessage(String message) {
        LabyMod.getInstance().displayMessageInChat(message);
    }

    @Override
    public void displayActionBarMessage(String message) {
        Minecraft.getInstance().ingameGUI.setOverlayMessage(new StringTextComponent(message),false);
    }

    private static Laby3PlayerAPI_v1_16_5 instance;

    public static Laby3PlayerAPI_v1_16_5 getAPI() {
        if(instance == null)
            instance = new Laby3PlayerAPI_v1_16_5();
        return instance;
    }
}
