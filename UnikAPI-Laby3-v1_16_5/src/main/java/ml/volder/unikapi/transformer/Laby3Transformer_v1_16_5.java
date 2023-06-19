package ml.volder.unikapi.transformer;

import net.labymod.addon.AddonTransformer;
import net.labymod.api.TransformerType;

public class Laby3Transformer_v1_16_5 extends AddonTransformer {

    @Override
    public void registerTransformers() {
        this.registerTransformer(TransformerType.VANILLA, "unikapi-laby3-v1_16_5.mixin.json");
    }
}
