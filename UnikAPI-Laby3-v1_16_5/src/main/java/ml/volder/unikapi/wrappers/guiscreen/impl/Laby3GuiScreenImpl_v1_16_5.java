package ml.volder.unikapi.wrappers.guiscreen.impl;

import com.mojang.blaze3d.matrix.MatrixStack;
import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.draw.impl.Laby3DrawAPI_v1_16_5;
import ml.volder.unikapi.api.input.InputAPI;
import ml.volder.unikapi.api.input.impl.Laby3InputAPI_v1_16_5;
import ml.volder.unikapi.api.player.PlayerAPI;
import ml.volder.unikapi.keysystem.Key;
import ml.volder.unikapi.keysystem.impl.Laby3KeyMapper_v1_16_5;
import ml.volder.unikapi.wrappers.guibutton.WrappedGuiButton;
import ml.volder.unikapi.wrappers.guibutton.refference.Laby3GuiButtonRefference_v1_16_5;
import ml.volder.unikapi.wrappers.guiscreen.IGuiScreenImpl;
import ml.volder.unikapi.wrappers.guiscreen.WrappedGuiScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;

import java.util.function.Consumer;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3GuiScreenImpl_v1_16_5 extends Screen implements IGuiScreenImpl {

    //region Implementaion
    WrappedGuiScreen screen;
    private static TextComponent defaultTitleComponent = new StringTextComponent("UnikAPI Screen");

    public Laby3GuiScreenImpl_v1_16_5(WrappedGuiScreen screen) {
        super(defaultTitleComponent);
        this.screen = screen;
    }

    public void actionPerformed(Button button) {
        screen.actionPerformed(new WrappedGuiButton(new Laby3GuiButtonRefference_v1_16_5(button)));
    }
    //endregion

    //region Abstract methods from GuiScreen (These methods will be obfuscated when compiled)

    @Override
    public void closeScreen() {
        screen.onGuiClosed();
        super.closeScreen();
    }

    @Override
    public void init() {
        super.init();
        screen.initGui();
    }

    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) {
        Laby3DrawAPI_v1_16_5.updateRenderStack(stack);
        screen.drawScreen(mouseX, mouseY, partialTicks);
        Laby3DrawAPI_v1_16_5.restoreRenderStack();
        super.render(stack, mouseX, mouseY, partialTicks);
    }

    private Key lastPressedKey = Key.NONE;

    @Override
    public boolean keyPressed(int keyCode, int value1, int value2) {
        super.keyPressed(keyCode, value1, value2);
        Key key = Laby3KeyMapper_v1_16_5.getKeyByGlfwKeyCode(keyCode);
        lastPressedKey = key;
        if(key.equals(Key.ESCAPE)) {
            PlayerAPI.getAPI().openGuiScreen(null);
        }
        if(key.isCharacter())
            return false;
        screen.keyTyped(key.getCharacter(), key);
        return false;
    }


    @Override
    public boolean charTyped(char character, int value1) {
        super.charTyped(character, value1);
        screen.keyTyped(character, lastPressedKey);
        return false;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        screen.mouseClicked((int) mouseX, (int) mouseY, Laby3KeyMapper_v1_16_5.getMouseButtonByGlfwKeyCode(mouseButton));
        return false;
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        screen.mouseClickMove((int) mouseX, (int) mouseY, Laby3KeyMapper_v1_16_5.getMouseButtonByGlfwKeyCode(button), 0);
        return false;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int mouseButton) {
        super.mouseReleased(mouseX, mouseY, mouseButton);
        screen.mouseReleased((int) mouseX, (int) mouseY, Laby3KeyMapper_v1_16_5.getMouseButtonByGlfwKeyCode(mouseButton));
        return false;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scroll) {
        super.mouseScrolled(mouseX, mouseY, scroll);
        screen.handleMouseInput();
        return false;
    }
    //endregion

    //region Methods from interface IGuiScreenImpl
    @Override
    public void addButton(WrappedGuiButton button) {
        this.addButton(button.getHandle(Button.class));
    }

    @Override
    public void removeButton(WrappedGuiButton button) {
        this.buttons.remove(button.getHandle(Button.class));
        this.getEventListeners().remove(button.getHandle(Button.class));
    }

    @Override
    public void clearButtonList() {
        this.buttons.forEach(widget -> this.getEventListeners().remove(widget));
        this.buttons.clear();
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
