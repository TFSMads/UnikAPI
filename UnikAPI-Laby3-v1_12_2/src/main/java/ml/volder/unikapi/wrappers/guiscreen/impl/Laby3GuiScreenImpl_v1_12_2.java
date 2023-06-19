package ml.volder.unikapi.wrappers.guiscreen.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.keysystem.impl.Laby3KeyMapper_v1_12_2;
import ml.volder.unikapi.wrappers.guibutton.WrappedGuiButton;
import ml.volder.unikapi.wrappers.guibutton.refference.Laby3GuiButtonRefference_v1_12_2;
import ml.volder.unikapi.wrappers.guiscreen.IGuiScreenImpl;
import ml.volder.unikapi.wrappers.guiscreen.WrappedGuiScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.12.*")
public class Laby3GuiScreenImpl_v1_12_2 extends GuiScreen implements IGuiScreenImpl {

    //region Implementaion
    WrappedGuiScreen screen;

    public Laby3GuiScreenImpl_v1_12_2(WrappedGuiScreen screen) {
        this.screen = screen;
    }
    //endregion

    //region Abstract methods from GuiScreen (These methods will be obfuscated when compiled)
    @Override
    public void updateScreen() {
        screen.updateScreen();
        super.updateScreen();
    }

    @Override
    public void onGuiClosed() {
        screen.onGuiClosed();
        super.onGuiClosed();
    }

    @Override
    public void initGui() {
        super.initGui();
        screen.initGui();
    }

    @Override
    public void actionPerformed(GuiButton button) {
        try {
            super.actionPerformed(button);
        } catch (IOException e) {
            e.printStackTrace();
        }
        screen.actionPerformed(new WrappedGuiButton(new Laby3GuiButtonRefference_v1_12_2(button)));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        screen.drawScreen(mouseX, mouseY, partialTicks);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
        screen.keyTyped(typedChar, Laby3KeyMapper_v1_12_2.getKeyByLwjglKeyCode(keyCode));
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        try {
            super.mouseClicked(mouseX, mouseY, mouseButton);
        } catch (IOException e) {
            e.printStackTrace();
        }
        screen.mouseClicked(mouseX, mouseY, Laby3KeyMapper_v1_12_2.getMouseButtonByLwjglKeyCode(mouseButton));
    }

    @Override
    public void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
        screen.mouseClickMove(mouseX, mouseY, Laby3KeyMapper_v1_12_2.getMouseButtonByLwjglKeyCode(clickedMouseButton), timeSinceLastClick);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        screen.mouseReleased(mouseX, mouseY, Laby3KeyMapper_v1_12_2.getMouseButtonByLwjglKeyCode(state));
    }

    @Override
    public void handleMouseInput() {
        try {
            super.handleMouseInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        screen.handleMouseInput();
    }
    //endregion

    //region Methods from interface IGuiScreenImpl
    @Override
    public void addButton(WrappedGuiButton button) {
        this.buttonList.add(button.getHandle(GuiButton.class));
    }

    @Override
    public void removeButton(WrappedGuiButton button) {
        this.buttonList.remove(button.getHandle(GuiButton.class));
    }

    @Override
    public void clearButtonList() {
        this.buttonList.clear();
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    public WrappedGuiScreen getScreen() {
        return screen;
    }
    //endregion
}
