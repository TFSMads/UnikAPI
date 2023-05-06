package ml.volder.unikapi.wrappers.guibutton.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.wrappers.guibutton.IGuiButtonImpl;
import ml.volder.unikapi.wrappers.guibutton.WrappedGuiButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class Laby3GuiButtonImpl_v1_8_9 extends GuiButton implements IGuiButtonImpl {

    //region Implementaion
    private WrappedGuiButton guiButton;

    public Laby3GuiButtonImpl_v1_8_9(int buttonId, int x, int y, String buttonText, WrappedGuiButton button)
    {
        this(buttonId, x, y, 200, 20, buttonText, button);
    }

    public Laby3GuiButtonImpl_v1_8_9(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, WrappedGuiButton button)
    {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
        this.guiButton = button;
    }
    //endregion

    //region Abstract methods from GuiButton (These methods will be obfuscated when compiled)
    /**
     * Draws this button to the screen.
     */
    public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
        super.drawButton(Minecraft.getMinecraft(), mouseX, mouseY);
        guiButton.drawButton(mouseX, mouseY);
    }

    /**
     * Fired when the mouse button is dragged. Equivalent of MouseListener.mouseDragged(MouseEvent e).
     */
    protected void mouseDragged(Minecraft mc, int mouseX, int mouseY)
    {
        guiButton.mouseDragged(mouseX, mouseY);
    }

    /**
     * Fired when the mouse button is released. Equivalent of MouseListener.mouseReleased(MouseEvent e).
     */
    public void mouseReleased(int mouseX, int mouseY)
    {
        guiButton.mouseReleased(mouseX, mouseY);
    }

    public void drawButtonForegroundLayer(int mouseX, int mouseY)
    {
        guiButton.drawButtonForegroundLayer(mouseX, mouseY);
    }
    //endregion

    //region Methods from interface IGuiButtonImpl
    /**
     * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over this button and 2 if it IS hovering over
     * this button.
     */
    public int getCurrentHoverState(boolean mouseOver)
    {
        return this.getHoverState(mouseOver);
    }

    public boolean mousePressed(int mouseX, int mouseY) {
        return super.mousePressed(Minecraft.getMinecraft(), mouseX, mouseY);
    }

    /**
     * Whether the mouse cursor is currently over the button.
     */
    public boolean isHovered()
    {
       return this.isMouseOver();
    }

    @Override
    public void drawButton(int mouseX, int mouseY) {
        super.drawButton(Minecraft.getMinecraft(), mouseX, mouseY);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public <T> T getHandle(Class<T> c) {
        return (T) this;
    }

    @Override
    public void setX(int x) {
        this.xPosition = x;
    }

    @Override
    public void setY(int y) {
        this.yPosition = y;
    }

    @Override
    public int getX() {
        return this.xPosition;
    }

    @Override
    public int getY() {
        return this.yPosition;
    }

    @Override
    public void setButtonWidth(int width) {
        this.width = width;
    }

    @Override
    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }

    @Override
    public String getDisplayString() {
        return this.displayString;
    }

    @Override
    public void setButtonHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return this.getButtonWidth();
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setEnabled(boolean isEnabled) {
        this.enabled = isEnabled;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
    //endregion
}
