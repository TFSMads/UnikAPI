package ml.volder.unikapi.wrappers.guibutton.refference;

import ml.volder.unikapi.wrappers.guibutton.IGuiButtonImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class Laby3GuiButtonRefference_v1_8_9 implements IGuiButtonImpl {

    private GuiButton button;

    public Laby3GuiButtonRefference_v1_8_9(GuiButton button) {
        this.button = button;
    }

    @Override
    public int getCurrentHoverState(boolean mouseOver) {
        int i = 1;

        if (!button.enabled)
        {
            i = 0;
        }
        else if (mouseOver)
        {
            i = 2;
        }

        return i;
    }

    @Override
    public boolean mousePressed(int mouseX, int mouseY) {
        return button.mousePressed(Minecraft.getMinecraft(), mouseX, mouseY);
    }

    @Override
    public boolean isHovered() {
        return button.isMouseOver();
    }

    @Override
    public void drawButton(int mouseX, int mouseY) {
        button.drawButton(Minecraft.getMinecraft(), mouseX, mouseY);
    }

    @Override
    public void setX(int x) {
        button.xPosition = x;
    }

    @Override
    public void setY(int y) {
        button.yPosition = y;
    }

    @Override
    public int getX() {
        return button.xPosition;
    }

    @Override
    public int getY() {
        return button.yPosition;
    }

    @Override
    public void setButtonWidth(int width) {
        button.setWidth(width);
    }

    @Override
    public void setButtonHeight(int height) {
        button.height = height;
    }

    @Override
    public int getWidth() {
        return button.getButtonWidth();
    }

    @Override
    public int getHeight() {
        return button.height;
    }

    @Override
    public void setEnabled(boolean isEnabled) {
        button.enabled = isEnabled;
    }

    @Override
    public boolean isEnabled() {
        return button.enabled;
    }

    @Override
    public void setDisplayString(String displayString) {
        button.displayString = displayString;
    }

    @Override
    public String getDisplayString() {
        return button.displayString;
    }

    @Override
    public int getId() {
        return button.id;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public <T> T getHandle(Class<T> c) {
        return (T) button;
    }
}
