package ml.volder.unikapi.api.inventory;

import ml.volder.unikapi.api.ApiManager;
import ml.volder.unikapi.types.Material;

public interface InventoryAPI {
    int getAmount(Material material, int itemDamage);

    static InventoryAPI getAPI() {
        return ApiManager.getAPI("InventoryAPI", "ml.volder.unikapi.api.inventory.impl", InventoryAPI.class);
    }
}
