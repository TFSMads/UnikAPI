package ml.volder.unikapi.mixin.laby3_v1_16_5;

import ml.volder.unikapi.event.events.clientkeypressevent.impl.Laby3KeyPressEvent_v1_16_5;
import net.minecraft.client.KeyboardListener;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardListener.class)
public class KeyInputMixin {
    @Inject(method = "onKeyEvent", at = @At("TAIL"))
    private void injectKeyInput(long windowPointer, int key, int scanCode, int action, int modifiers, CallbackInfo callbackInfo) {
        if (windowPointer == Minecraft.getInstance().getMainWindow().getHandle()) {
            Laby3KeyPressEvent_v1_16_5.onKeyInput();
        }
    }
}
