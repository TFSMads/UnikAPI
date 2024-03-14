package ml.volder.unikapi.types;

import ml.volder.unikapi.NotSupportedAPIException;
import ml.volder.unikapi.NotSupportedException;
import ml.volder.unikapi.UnikAPI;

public class NotSupportedItemException extends NotSupportedException {
    public NotSupportedItemException(Material material) {
        super("Materialet " + material.name() + " (legacy:" + material.isLegacy() + ") er ikke understøtte i minecraft versionen " + UnikAPI.getMinecraftVersion());
    }
}
