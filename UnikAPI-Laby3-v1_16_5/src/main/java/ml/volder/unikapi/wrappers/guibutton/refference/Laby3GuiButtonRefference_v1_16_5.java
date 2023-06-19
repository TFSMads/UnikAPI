package ml.volder.unikapi.wrappers.guibutton.refference;

import ml.volder.unikapi.api.draw.impl.Laby3DrawAPI_v1_16_5;
import ml.volder.unikapi.wrappers.guibutton.IGuiButtonImpl;
import ml.volder.unikapi.wrappers.guibutton.impl.laby3.Laby3GuiButton_v1_16_5;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;

public class Laby3GuiButtonRefference_v1_16_5 implements IGuiButtonImpl {

    private Button button;

    public Laby3GuiButtonRefference_v1_16_5(Button button) {
        this.button = button;
    }

    @Override
    public int getCurrentHoverState(boolean mouseOver) {
        int i = 1;

        if (!button.active)
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
        return button.mouseClicked(mouseX, mouseY, 1);
    }

    @Override
    public boolean isHovered() {
        return button.isHovered();
    }

    @Override
    public void drawButton(int mouseX, int mouseY) {
        button.renderButton(Laby3DrawAPI_v1_16_5.getRenderStack(), mouseX, mouseY, 0);
    }

    @Override
    public void setX(int x) {
        button.x = x;
    }

    @Override
    public void setY(int y) {
        button.y = y;
    }

    @Override
    public int getX() {
        return button.x;
    }

    @Override
    public int getY() {
        return button.y;
    }

    @Override
    public void setButtonWidth(int width) {
        button.setWidth(width);
    }

    @Override
    public void setButtonHeight(int height) {
        if(button instanceof Laby3GuiButton_v1_16_5)
            ((Laby3GuiButton_v1_16_5) button).setButtonHeight(height);
    }

    @Override
    public int getWidth() {
        return button.getWidth();
    }

    @Override
    public int getHeight() {
        return button.getHeightRealms();
    }

    @Override
    public void setEnabled(boolean isEnabled) {
        button.active = isEnabled;
    }

    @Override
    public boolean isEnabled() {
        return button.active;
    }

    @Override
    public void setDisplayString(String displayString) {
        button.setMessage(new StringTextComponent(displayString));
    }

    @Override
    public String getDisplayString() {
        return button.getMessage().getString();
    }

    @Override
    public int getId() {
        if(button instanceof Laby3GuiButton_v1_16_5)
            return ((Laby3GuiButton_v1_16_5) button).getId();
        return -1;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public <T> T getHandle(Class<T> c) {
        return (T) button;
    }
}
