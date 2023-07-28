package ml.volder.unikapi.api;

import ml.volder.unikapi.api.draw.DrawAPI;
import ml.volder.unikapi.api.draw.impl.Laby3DrawAPI_v1_8_9;
import ml.volder.unikapi.api.input.InputAPI;
import ml.volder.unikapi.api.input.impl.Laby3InputAPI_v1_8_9;
import ml.volder.unikapi.api.inventory.InventoryAPI;
import ml.volder.unikapi.api.inventory.impl.Laby3InventoryAPI_v1_8_9;
import ml.volder.unikapi.api.minecraft.MinecraftAPI;
import ml.volder.unikapi.api.minecraft.impl.Laby3MinecraftAPI_v1_8_9;
import ml.volder.unikapi.api.player.PlayerAPI;
import ml.volder.unikapi.api.player.impl.Laby3PlayerAPI_v1_8_9;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.events.clientkeypressevent.impl.Laby3KeyPressEvent_v1_8_9;
import ml.volder.unikapi.event.events.clientmessageevent.impl.Laby3MessageEvent_v1_8_9;
import ml.volder.unikapi.event.events.clienttickevent.impl.Laby3ClientTickEvent_v1_8_9;
import ml.volder.unikapi.event.events.drawscreenevent.impl.Laby3DrawScreenEvent_v1_8_9;
import ml.volder.unikapi.event.events.mainmenuopenevent.impl.Laby3MainMenuOpenEvent_v1_8_9;
import ml.volder.unikapi.event.events.opensignevent.impl.Laby3OpenSignEvent_v1_8_9;
import ml.volder.unikapi.event.events.sendmessageevent.impl.Laby3SendMessageEvent_v1_8_9;
import ml.volder.unikapi.keysystem.KeyMapper;
import ml.volder.unikapi.keysystem.impl.Laby3KeyMapper_v1_8_9;
import ml.volder.unikapi.wrappers.guibutton.IGuiButtonImpl;
import ml.volder.unikapi.wrappers.guibutton.impl.Laby3GuiButtonImpl_v1_8_9;
import ml.volder.unikapi.wrappers.guiscreen.IGuiScreenImpl;
import ml.volder.unikapi.wrappers.guiscreen.impl.Laby3GuiScreenImpl_v1_8_9;

public class ApiReferenceStorageLaby3_v1_8_9 implements ApiReferenceStorage{

    private static ApiReferenceStorage instance;

    public static ApiReferenceStorage getInstance() {
        if(instance == null)
            instance = new ApiReferenceStorageLaby3_v1_8_9();
        return instance;
    }

    @Override
    public DrawAPI getDrawAPI() {
        return Laby3DrawAPI_v1_8_9.getAPI();
    }

    @Override
    public InputAPI getInputAPI() {
        return Laby3InputAPI_v1_8_9.getAPI();
    }

    @Override
    public InventoryAPI getInventoryAPI() {
        return Laby3InventoryAPI_v1_8_9.getAPI();
    }

    @Override
    public MinecraftAPI getMinecraftAPI() {
        return Laby3MinecraftAPI_v1_8_9.getAPI();
    }

    @Override
    public PlayerAPI getPlayerAPI() {
        return Laby3PlayerAPI_v1_8_9.getAPI();
    }

    @Override
    public Class<? extends EventImpl> getVersionedClientKeyPressEvent() {
        return Laby3KeyPressEvent_v1_8_9.class;
    }

    @Override
    public Class<? extends EventImpl> getVersionedClientMessageEvent() {
        return Laby3MessageEvent_v1_8_9.class;
    }

    @Override
    public Class<? extends EventImpl> getVersionedClientTickEvent() {
        return Laby3ClientTickEvent_v1_8_9.class;
    }

    @Override
    public Class<? extends EventImpl> getVersionedDrawScreenEvent() {
        return Laby3DrawScreenEvent_v1_8_9.class;
    }

    @Override
    public Class<? extends EventImpl> getVersionedOpenSignEvent() {
        return Laby3OpenSignEvent_v1_8_9.class;
    }

    @Override
    public Class<? extends EventImpl> getVersionedMainMenuOpenEvent() {
        return Laby3MainMenuOpenEvent_v1_8_9.class;
    }

    @Override
    public Class<? extends EventImpl> getVersionedSendMessageEvent() {
        return Laby3SendMessageEvent_v1_8_9.class;
    }

    @Override
    public KeyMapper getVersionedKeyMapper() {
        return Laby3KeyMapper_v1_8_9.getAPI();
    }

    @Override
    public Class<? extends IGuiButtonImpl> getVersionedGuiButton() {
        return Laby3GuiButtonImpl_v1_8_9.class;
    }

    @Override
    public Class<? extends IGuiScreenImpl> getVersionedGuiScreen() {
        return Laby3GuiScreenImpl_v1_8_9.class;
    }
}
