package ml.volder.unikapi.api.input.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.input.InputAPI;
import ml.volder.unikapi.keysystem.Key;
import net.labymod.utils.Mouse;
import net.minecraft.client.gui.screen.Screen;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3InputAPI_v1_16_5 implements InputAPI {
    private static Laby3InputAPI_v1_16_5 instance;


    @Override
    public boolean isKeyDown(Key key) {
        return key.isPressed();
    }

    @Override
    public int getEventDWheel() {
        return (int) Mouse.getScroll();
    }

    @Override
    public boolean isCtrlKeyDown(){
        return Screen.hasControlDown();
    }

    @Override
    public boolean isShiftKeyDown() {
        return Screen.hasShiftDown();
    }

    @Override
    public boolean isAltKeyDown() {
        return Screen.hasAltDown();
    }

    @Override
    public String getKeyName(Key key) {
        return key.getName();
    }

    @Override
    public void enableRepeatEvents(boolean enable) {
        //TODO
    }

    public static Laby3InputAPI_v1_16_5 getAPI() {
        if(instance == null)
            instance = new Laby3InputAPI_v1_16_5();
        return instance;
    }
}
