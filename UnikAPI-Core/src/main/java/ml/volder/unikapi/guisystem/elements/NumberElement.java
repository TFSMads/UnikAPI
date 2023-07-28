package ml.volder.unikapi.guisystem.elements;

import ml.volder.unikapi.guisystem.ModTextures;
import ml.volder.unikapi.datasystem.Data;
import ml.volder.unikapi.datasystem.DataManager;
import ml.volder.unikapi.api.draw.DrawAPI;
import ml.volder.unikapi.keysystem.Key;
import ml.volder.unikapi.keysystem.MouseButton;
import ml.volder.unikapi.types.ModColor;
import ml.volder.unikapi.types.ResourceLocation;
import ml.volder.unikapi.utils.StringUtils;

import java.util.function.Consumer;

public class NumberElement extends ControlElement {
    private static final ResourceLocation SERVER_SELECTION_BUTTONS = ModTextures.SERVER_SELECTION;
    private Integer currentValue;
    private Consumer<Integer> changeListener;
    private ModTextField textField;
    private Consumer<Integer> callback;
    private int minValue;
    private int maxValue;
    private boolean hoverUp;
    private boolean hoverDown;
    private int steps;
    private long fastTickerCounterValue;

    public NumberElement(String displayName, DataManager<Data> configManager, final String configEntryName, IconData iconData, int defaultValue) {
        super(displayName, configEntryName, iconData);
        this.minValue = 0;
        this.maxValue = 2147483647;
        this.steps = 1;
        this.fastTickerCounterValue = 0L;
        if (!configEntryName.isEmpty()) {
            this.currentValue = configManager.getSettings().getData().has(configEntryName) ? configManager.getSettings().getData().get(configEntryName).getAsInt() : defaultValue;
        }

        if (this.currentValue == null) {
            this.currentValue = this.minValue;
        }

        this.changeListener = accepted -> {
            try {
                configManager.getSettings().getData().addProperty(configEntryName, accepted);
                configManager.save();
            } catch (Exception var3) {
                var3.printStackTrace();
            }

            if (NumberElement.this.callback != null) {
                NumberElement.this.callback.accept(accepted);
            }

        };
        this.createTextfield();
    }


    public NumberElement setMinValue(int minValue) {
        this.minValue = minValue;
        if (this.currentValue < this.minValue) {
            this.currentValue = this.minValue;
        }

        return this;
    }

    public NumberElement setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        if (this.currentValue > this.maxValue) {
            this.currentValue = this.maxValue;
        }

        return this;
    }

    public NumberElement setRange(int min, int max) {
        this.setMinValue(min);
        this.setMaxValue(max);
        return this;
    }

    public NumberElement setSteps(int steps) {
        this.steps = steps;
        return this;
    }

    public void createTextfield() {
        this.textField = new ModTextField(-2, 0, 0, this.getObjectWidth(), 20);
        this.updateValue();
        this.textField.setFocused(false);
    }

    private void updateValue() {
        this.textField.setText(String.valueOf(this.currentValue));
    }

    public void draw(int x, int y, int maxX, int maxY, int mouseX, int mouseY) {
        super.draw(x, y, maxX, maxY, mouseX, mouseY);
        int width = this.getObjectWidth();
        DrawAPI drawAPI = DrawAPI.getAPI();
        if (this.textField != null) {
            textField.xPosition = maxX - width - 2;
            textField.yPosition = y + 1;
            this.textField.drawTextBox();
            drawAPI.drawRectangle(x - 1, y, x, maxY, ModColor.toRGB(120, 120, 120, 120));
            drawAPI.bindTexture(SERVER_SELECTION_BUTTONS);
            //drawAPI.glStateManagerColor(1.0F, 1.0F, 1.0F);
            this.hoverUp = mouseX > maxX - 15 && mouseX < maxX - 15 + 11 && mouseY > y + 2 && mouseY < y + 2 + 7;
            this.hoverDown = mouseX > maxX - 15 && mouseX < maxX - 15 + 11 && mouseY > y + 12 && mouseY < y + 12 + 7;
            drawAPI.drawTexture((double)(maxX - 15), (double)(y + 2), 99.0D, this.hoverUp ? 37.0D : 5.0D, 11.0D, 7.0D, 11.0D, 7.0D);
            drawAPI.drawTexture((double)(maxX - 15), (double)(y + 12), 67.0D, this.hoverDown ? 52.0D : 20.0D, 11.0D, 7.0D, 11.0D, 7.0D);
            if (this.isMouseOver() && this.fastTickerCounterValue != 0L) {
                if (this.fastTickerCounterValue > 0L && this.fastTickerCounterValue + 80L < System.currentTimeMillis()) {
                    this.fastTickerCounterValue = System.currentTimeMillis();
                    if (this.currentValue < this.maxValue) {
                        this.currentValue = this.currentValue + this.steps;
                        this.updateValue();
                    }
                }

                if (this.fastTickerCounterValue < 0L && this.fastTickerCounterValue - 80L > System.currentTimeMillis() * -1L) {
                    this.fastTickerCounterValue = System.currentTimeMillis() * -1L;
                    if (this.currentValue > this.minValue) {
                        this.currentValue = this.currentValue - this.steps;
                        this.updateValue();
                    }
                }
            } else {
                this.mouseRelease(mouseX, mouseY, (MouseButton) MouseButton.LEFT);
            }

        }
    }

    public void unfocus(int mouseX, int mouseY, MouseButton mouseButton) {
        super.unfocus(mouseX, mouseY, mouseButton);
        this.textField.setFocused(false);
    }

    public void mouseClicked(int mouseX, int mouseY, MouseButton mouseButton) {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        if (this.hoverUp && this.currentValue < this.maxValue) {
            this.currentValue = this.currentValue + this.steps;
            this.updateValue();
            this.fastTickerCounterValue = System.currentTimeMillis() + 500L;
        }

        if (this.hoverDown && this.currentValue > this.minValue) {
            this.currentValue = this.currentValue - this.steps;
            this.updateValue();
            this.fastTickerCounterValue = System.currentTimeMillis() * -1L - 500L;
        }

        if (this.currentValue > this.maxValue) {
            this.currentValue = this.maxValue;
            this.updateValue();
        }

        if (this.currentValue < this.minValue) {
            this.currentValue = this.minValue;
            this.updateValue();
        }

        this.textField.mouseClicked(mouseX, mouseY, (MouseButton) MouseButton.LEFT);
    }

    public void mouseRelease(int mouseX, int mouseY, MouseButton mouseButton) {
        super.mouseRelease(mouseX, mouseY, mouseButton);
        if (this.fastTickerCounterValue != 0L) {
            this.fastTickerCounterValue = 0L;
            this.changeListener.accept(this.currentValue);
        }

    }

    public void keyTyped(char typedChar, Key keyCode) {
        int preNumber = this.textField.getText().isEmpty() ? this.minValue : Integer.valueOf(this.textField.getText());
        if (this.textField.textboxKeyTyped(typedChar, keyCode)) {
            String currentText = this.textField.getText();
            String numericCheck = currentText;
            if (currentText.startsWith("-")) {
                numericCheck = currentText.replaceFirst("-", "");
            }

            boolean numeric = currentText.isEmpty() || StringUtils.isNumeric(numericCheck);
            boolean var7 = false;

            int newNumber;
            try {
                newNumber = !currentText.isEmpty() && numeric ? Integer.valueOf(currentText.isEmpty() ? String.valueOf(this.minValue) : currentText) : this.minValue;
                if (!numeric) {
                    newNumber = preNumber;
                }

                if (newNumber > this.maxValue) {
                    newNumber = this.maxValue;
                }

                if (newNumber < this.minValue) {
                    newNumber = this.minValue;
                }
            } catch (NumberFormatException var9) {
                newNumber = this.maxValue;
            }

            String newText = String.valueOf(newNumber);
            if (!currentText.equals(newText)) {
                this.textField.setText(String.valueOf(newNumber));
            }

            this.changeListener.accept(newNumber);
            this.currentValue = newNumber;
        }

    }

    public void updateScreen() {
        super.updateScreen();
        this.textField.updateCursorCounter();
    }

    public ModTextField getTextField() {
        return this.textField;
    }

    public NumberElement addCallback(Consumer<Integer> callback) {
        this.callback = callback;
        return this;
    }

    public int getObjectWidth() {
        return 50;
    }

    public Integer getCurrentValue() {
        return this.currentValue;
    }
}
