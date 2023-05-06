package ml.volder.unikapi.api.input.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.input.InputAPI;
import ml.volder.unikapi.keysystem.Key;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class Laby3InputAPI_v1_8_9 implements InputAPI {
    private static Laby3InputAPI_v1_8_9 instance;


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
        return Minecraft.isRunningOnMac ? Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220) : Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
    }

    @Override
    public boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }

    @Override
    public boolean isAltKeyDown() {
        return Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184);
    }

    @Override
    public String getKeyName(Key key) {
        return key.getName();
    }

    @Override
    public void enableRepeatEvents(boolean enable) {
        Keyboard.enableRepeatEvents(enable);
    }

    public static Laby3InputAPI_v1_8_9 getAPI() {
        if(instance == null)
            instance = new Laby3InputAPI_v1_8_9();
        return instance;
    }
}
