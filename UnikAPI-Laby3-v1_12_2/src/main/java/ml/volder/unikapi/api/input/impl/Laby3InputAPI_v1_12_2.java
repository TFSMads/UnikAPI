package ml.volder.unikapi.api.input.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.input.InputAPI;
import ml.volder.unikapi.keysystem.Key;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.12.*")
public class Laby3InputAPI_v1_12_2 implements InputAPI {
    private static Laby3InputAPI_v1_12_2 instance;


    @Override
    public boolean isKeyDown(Key key) {
        return key.isPressed();
    }

    @Override
    public int getEventDWheel() {
        return Mouse.getEventDWheel();
    }

    @Override
    public boolean isCtrlKeyDown(){
        return GuiScreen.isCtrlKeyDown();
    }

    @Override
    public boolean isShiftKeyDown() {
        return GuiScreen.isShiftKeyDown();
    }

    @Override
    public boolean isAltKeyDown() {
        return GuiScreen.isAltKeyDown();
    }

    @Override
    public String getKeyName(Key key) {
        return key.getName();
    }

    @Override
    public void enableRepeatEvents(boolean enable) {
        Keyboard.enableRepeatEvents(enable);
    }

    public static Laby3InputAPI_v1_12_2 getAPI() {
        if(instance == null)
            instance = new Laby3InputAPI_v1_12_2();
        return instance;
    }
}
