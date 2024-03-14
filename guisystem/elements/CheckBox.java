package ml.volder.unikapi.guisystem.elements;

import ml.volder.unikapi.api.draw.DrawAPI;
import ml.volder.unikapi.guisystem.ModTextures;
import ml.volder.unikapi.keysystem.MouseButton;
import ml.volder.unikapi.types.ModColor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CheckBox {
    private String title;
    private int x;
    private int y;
    private int width;
    private int height;
    private EnumCheckBoxValue currentValue;
    private DefaultCheckBoxValueCallback defaultValue;
    private boolean hasDefault = false;
    private List<CheckBox> childCheckBoxes = new ArrayList();
    private CheckBox parentCheckBox;
    private Consumer<EnumCheckBoxValue> updateListener;
    private boolean visible = true;
    private String description = null;

    public CheckBox(String title, EnumCheckBoxValue currentValue, DefaultCheckBoxValueCallback defaultValue, int x, int y, int width, int height) {
        this.title = title;
        this.currentValue = currentValue;
        this.defaultValue = defaultValue;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void drawCheckbox(int mouseX, int mouseY) {
        if (this.visible) {
            DrawAPI drawAPI = DrawAPI.getAPI();
            drawAPI.drawCenteredString(this.title, (double)(this.x + this.width / 2), (double)(this.y - 5), 0.5D);
            boolean hover = this.isMouseOver(mouseX, mouseY);
            drawAPI.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, ModColor.toRGB(0, 0, 0, 255));
            drawAPI.drawRect(this.x + 1, this.y + 1, this.x + this.width - 1, this.y + this.height - 1, ModColor.toRGB(170, 170, 170, 255));
            drawAPI.drawRect(this.x + 2, this.y + 2, this.x + this.width - 2, this.y + this.height - 2, ModColor.toRGB(hover ? 100 : 120, hover ? 100 : 120, hover ? 100 : 120, 255));
            EnumCheckBoxValue value = this.currentValue;
            if (value == EnumCheckBoxValue.ENABLED) {
                drawAPI.bindTexture(ModTextures.BUTTON_CHECKBOX);
                drawAPI.drawTexture((double)(this.x + 1), (double)(this.y - 1), 256.0D, 256.0D, (double)this.width, (double)this.height);
            } else if (value == EnumCheckBoxValue.INDETERMINATE) {
                drawAPI.drawRect(this.x + this.width / 3, this.y + this.height / 3, this.x + this.width - this.width / 3 + 1, this.y + this.height - this.height / 3 + 1, ModColor.toRGB(0, 100, 0, 255));
                drawAPI.drawRect(this.x + this.width / 3 - 1, this.y + this.height / 3 - 1, this.x + this.width - this.width / 3, this.y + this.height - this.height / 3, ModColor.toRGB(0, 150, 0, 255));
            }

            if (this.hasDefault && this.currentValue == EnumCheckBoxValue.DEFAULT) {
                if (this.getValue() == EnumCheckBoxValue.ENABLED) {
                    drawAPI.drawRect(this.x + 2, this.y + 2, this.x + this.width - 2, this.y + this.height - 2, ModColor.toRGB(0, 150, 0, 155));
                }

                drawAPI.bindTexture(ModTextures.BUTTON_HOVER_DEFAULT);
                drawAPI.drawTexture((double)(this.x + 2), (double)(this.y + 2), 256.0D, 256.0D, (double)(this.width - 4), (double)(this.height - 4));

            }
        }
    }

    public boolean mouseClicked(int mouseX, int mouseY, MouseButton mouseButton) {
        if (!this.visible) {
            return false;
        } else if (this.isMouseOver(mouseX, mouseY) && mouseButton.isLeft()) {
            //LabyModCore.getMinecraft().playSound(SettingsElement.BUTTON_PRESS_SOUND, this.currentValue.getPitch());
            Iterator var4;
            CheckBox subCheckBox;
            if (this.currentValue == EnumCheckBoxValue.DISABLED) {
                this.updateValue(EnumCheckBoxValue.ENABLED);
                var4 = this.childCheckBoxes.iterator();

                while(var4.hasNext()) {
                    subCheckBox = (CheckBox)var4.next();
                    subCheckBox.updateValue(EnumCheckBoxValue.ENABLED);
                }
            } else if (this.currentValue == EnumCheckBoxValue.ENABLED) {
                EnumCheckBoxValue value = this.hasDefault ? EnumCheckBoxValue.DEFAULT : EnumCheckBoxValue.DISABLED;
                this.updateValue(value);
                Iterator var8 = this.childCheckBoxes.iterator();

                while(var8.hasNext()) {
                    subCheckBox = (CheckBox)var8.next();
                    subCheckBox.updateValue(value);
                }
            } else if (this.currentValue == EnumCheckBoxValue.INDETERMINATE) {
                this.updateValue(EnumCheckBoxValue.DISABLED);
                var4 = this.childCheckBoxes.iterator();

                while(var4.hasNext()) {
                    subCheckBox = (CheckBox)var4.next();
                    subCheckBox.updateValue(EnumCheckBoxValue.DISABLED);
                }
            } else if (this.currentValue == EnumCheckBoxValue.DEFAULT) {
                this.updateValue(EnumCheckBoxValue.DISABLED);
                var4 = this.childCheckBoxes.iterator();

                while(var4.hasNext()) {
                    subCheckBox = (CheckBox)var4.next();
                    subCheckBox.updateValue(EnumCheckBoxValue.DISABLED);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public void updateValue(EnumCheckBoxValue value) {
        this.currentValue = value;
        if (this.updateListener != null) {
            this.updateListener.accept(value);
        }

        if (this.parentCheckBox != null) {
            this.parentCheckBox.notfiyChildChange(this, value);
        }

    }

    private void notfiyChildChange(CheckBox childCheckBox, EnumCheckBoxValue value) {
        boolean allEnabled = true;
        boolean allDisable = true;
        boolean allInderterminate = true;
        Iterator var6 = this.childCheckBoxes.iterator();

        while(var6.hasNext()) {
            CheckBox subCheckBox = (CheckBox)var6.next();
            if (subCheckBox.getValue() != EnumCheckBoxValue.ENABLED) {
                allEnabled = false;
            }

            if (subCheckBox.getValue() != EnumCheckBoxValue.DISABLED) {
                allDisable = false;
            }

            if (subCheckBox.getValue() != EnumCheckBoxValue.INDETERMINATE) {
                allInderterminate = false;
            }
        }

        if (allEnabled && !allInderterminate) {
            this.updateValue(EnumCheckBoxValue.ENABLED);
        } else if (allDisable && !allInderterminate) {
            this.updateValue(EnumCheckBoxValue.DISABLED);
        } else {
            this.updateValue(EnumCheckBoxValue.INDETERMINATE);
        }

    }

    public EnumCheckBoxValue getValue() {
        return this.hasDefault && this.currentValue == EnumCheckBoxValue.DEFAULT ? this.defaultValue.getDefaultValue() : this.currentValue;
    }

    public boolean isMouseOver(int mouseX, int mouseY) {
        return mouseX > this.x && mouseX < this.x + this.width && mouseY > this.y && mouseY < this.y + this.height;
    }

    public String getTitle() {
        return this.title;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setCurrentValue(EnumCheckBoxValue currentValue) {
        this.currentValue = currentValue;
    }

    public void setDefaultValue(DefaultCheckBoxValueCallback defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isHasDefault() {
        return this.hasDefault;
    }

    public void setHasDefault(boolean hasDefault) {
        this.hasDefault = hasDefault;
    }

    public List<CheckBox> getChildCheckBoxes() {
        return this.childCheckBoxes;
    }

    public CheckBox getParentCheckBox() {
        return this.parentCheckBox;
    }

    public void setParentCheckBox(CheckBox parentCheckBox) {
        this.parentCheckBox = parentCheckBox;
    }

    public void setUpdateListener(Consumer<EnumCheckBoxValue> updateListener) {
        this.updateListener = updateListener;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public interface DefaultCheckBoxValueCallback {
        EnumCheckBoxValue getDefaultValue();
    }

    public static enum EnumCheckBoxValue {
        DEFAULT(1.0F),
        ENABLED(1.4F),
        DISABLED(1.5F),
        INDETERMINATE(1.3F);

        private float pitch;

        private EnumCheckBoxValue(float pitch) {
            this.pitch = pitch;
        }

        public float getPitch() {
            return this.pitch;
        }
    }
}
