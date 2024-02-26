package ml.volder.unikapi.loader;

import ml.volder.unikapi.AddonMain;
import ml.volder.unikapi.UnikAPI;
import ml.volder.unikapi.api.ApiReferenceStorageLaby3_v1_8_9;
import ml.volder.unikapi.logger.Laby3Logger_v1_8_9;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;
import net.minecraft.client.Minecraft;

import java.io.InputStream;
import java.util.List;

public class Laby3Loader_v1_8_9 extends LabyModAddon {
    @Override
    public void onEnable() {
        UnikAPI.LOGGER = new Laby3Logger_v1_8_9("UnikAPI");
        UnikAPI.initAPI("labymod3", null, Minecraft.getMinecraft().getVersion());
        UnikAPI.registerReferenceStorage(ApiReferenceStorageLaby3_v1_8_9.getInstance());
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("transporter/loaderInfo.json");
        Loader.onEnable(inputStream);
    }

    @Override
    public void loadConfig() {

    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {
        //Redirect to Settings
        list.add(new SettingsElement("UnikAPI", null) {

            @Override
            public void draw(int x, int y, int maxX, int maxY, int mouseX, int mouseY) {
                AddonMain.callOpenSettings(Laby3Loader_v1_8_9.this);
            }

            public void drawDescription(int i, int i1, int i2) { }
            public void mouseClicked(int i, int i1, int i2) { }
            public void mouseRelease(int i, int i1, int i2) { }
            public void mouseClickMove(int i, int i1, int i2) { }
            public void keyTyped(char c, int i) { }
            public void unfocus(int i, int i1, int i2) { }
            public int getEntryHeight() { return 0;}
        });
    }
}
