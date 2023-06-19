package ml.volder.unikapi.wrappers.guibutton.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.wrappers.guibutton.IGuiButtonImpl;
import ml.volder.unikapi.wrappers.guibutton.WrappedGuiButton;
import ml.volder.unikapi.wrappers.guibutton.impl.laby3.Laby3GuiButton_v1_16_5;

/**
 * @implNote Denne wrapper er nødvendig fordi IGuiButtonImpl interfacet har en method der hedder isHovered og i 1.16 er der også en method der hedder dette i screen class.
 */
@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class WrappedLaby3GuiButtonImpl_v1_16_5 implements IGuiButtonImpl {

    private Laby3GuiButton_v1_16_5 wrappedButton;

    public WrappedLaby3GuiButtonImpl_v1_16_5(int buttonId, int x, int y, String buttonText, WrappedGuiButton button)
    {
        this(buttonId, x, y, 200, 20, buttonText, button);
    }

    public WrappedLaby3GuiButtonImpl_v1_16_5(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, WrappedGuiButton button)
    {
        wrappedButton = new Laby3GuiButton_v1_16_5(buttonId, x, y, widthIn, heightIn, buttonText, button);
    }

    @Override
    public int getCurrentHoverState(boolean b) {
        return wrappedButton.getCurrentHoverState(b);
    }

    @Override
    public boolean mousePressed(int i, int i1) {
        return wrappedButton.mousePressed(i, i1);
    }

    @Override
    public boolean isHovered() {
        return wrappedButton.isMouseOver();
    }

    @Override
    public void drawButton(int i, int i1) {
        wrappedButton.drawButton(i, i1);
    }

    @Override
    public void setX(int i) {
        wrappedButton.setX(i);
    }

    @Override
    public void setY(int i) {
        wrappedButton.setY(i);
    }

    @Override
    public int getX() {
        return wrappedButton.getX();
    }

    @Override
    public int getY() {
        return wrappedButton.getY();
    }

    @Override
    public void setButtonWidth(int i) {
        wrappedButton.setButtonWidth(i);
    }

    @Override
    public void setButtonHeight(int i) {
        wrappedButton.setButtonHeight(i);
    }

    @Override
    public int getWidth() {
        return wrappedButton.getWidth();
    }

    @Override
    public int getHeight() {
        return wrappedButton.getHeight();
    }

    @Override
    public void setEnabled(boolean b) {
        wrappedButton.setEnabled(b);
    }

    @Override
    public boolean isEnabled() {
        return wrappedButton.isEnabled();
    }

    @Override
    public void setDisplayString(String s) {
        wrappedButton.setDisplayString(s);
    }

    @Override
    public String getDisplayString() {
        return wrappedButton.getDisplayString();
    }

    @Override
    public int getId() {
        return wrappedButton.getId();
    }

    @Override
    public <T> T getHandle(Class<T> aClass) {
        return wrappedButton.getHandle(aClass);
    }
}
