package ml.volder.unikapi.wrappers.guibutton.impl.laby3;

import com.mojang.blaze3d.matrix.MatrixStack;
import ml.volder.unikapi.api.draw.impl.Laby3DrawAPI_v1_16_5;
import ml.volder.unikapi.wrappers.guibutton.WrappedGuiButton;
import ml.volder.unikapi.wrappers.guiscreen.impl.Laby3GuiScreenImpl_v1_16_5;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;

public class Laby3GuiButton_v1_16_5 extends Button {
    //region Implementaion
    private WrappedGuiButton guiButton;
    private int buttonId;

    public Laby3GuiButton_v1_16_5(int buttonId, int x, int y, String buttonText, WrappedGuiButton button)
    {
        this(buttonId, x, y, 200, 20, buttonText, button);
    }

    public Laby3GuiButton_v1_16_5(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, WrappedGuiButton button)
    {
        super(x, y, widthIn, heightIn, new StringTextComponent(buttonText), pressedButton -> {});
        this.buttonId = buttonId;
        this.guiButton = button;
    }



    //endregion

    //region Abstract methods from GuiButton (These methods will be obfuscated when compiled)

    @Override
    public void onPress() {
        super.onPress();
        if(Minecraft.getInstance().currentScreen instanceof Laby3GuiScreenImpl_v1_16_5)
            ((Laby3GuiScreenImpl_v1_16_5) Minecraft.getInstance().currentScreen).actionPerformed(this);
    }
    /**
     * Draws this button to the screen.
     */
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.renderButton(matrixStack, mouseX, mouseY, partialTicks);
        Laby3DrawAPI_v1_16_5.updateRenderStack(matrixStack);
        guiButton.drawButton(mouseX, mouseY);
        Laby3DrawAPI_v1_16_5.restoreRenderStack();
    }

    /**
     * Fired when the mouse button is dragged. Equivalent of MouseListener.mouseDragged(MouseEvent e).
     */
    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY)
    {
        super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
        guiButton.mouseDragged((int) mouseX, (int) mouseY);
        return false;
    }

    /**
     * Fired when the mouse button is released. Equivalent of MouseListener.mouseReleased(MouseEvent e).
     */
    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button)
    {
        super.mouseReleased(mouseX, mouseY, button);
        guiButton.mouseReleased((int) mouseX, (int) mouseY);
        return false;
    }
    //endregion

    //region Methods from interface IGuiButtonImpl
    /**
     * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over this button and 2 if it IS hovering over
     * this button.
     */
    public int getCurrentHoverState(boolean mouseOver)
    {
        return !this.isEnabled() ? 0 : mouseOver ? 2 : 1;
    }

    public boolean mousePressed(int mouseX, int mouseY){
        return super.clicked(mouseX, mouseY);
    }

    /**
     * Whether the mouse cursor is currently over the button.
     */
    public boolean isMouseOver()
    {
        return this.isHovered();
    }
    
    public void drawButton(int mouseX, int mouseY) {
        super.render(Laby3DrawAPI_v1_16_5.getRenderStack(), mouseX, mouseY, 0);
    }
    
    public int getId() {
        return this.buttonId;
    }
    
    @SuppressWarnings({"unchecked"})
    public <T> T getHandle(Class<T> c) {
        return (T) this;
    }
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setButtonWidth(int width) {
        this.width = width;
    }
    
    public void setDisplayString(String displayString) {
        this.setMessage(new StringTextComponent(displayString));
    }
    
    public String getDisplayString() {
        return this.getMessage().getString();
    }
    
    public void setButtonHeight(int height) {
        this.height = height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setEnabled(boolean isEnabled) {
        this.active = isEnabled;
    }
    
    public boolean isEnabled() {
        return this.active;
    }
    //endregion
}
