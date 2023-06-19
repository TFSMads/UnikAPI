package ml.volder.unikapi.api.inventory.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.inventory.InventoryAPI;
import ml.volder.unikapi.api.minecraft.MinecraftAPI;
import ml.volder.unikapi.types.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3InventoryAPI_v1_16_5 implements InventoryAPI {
    private static Laby3InventoryAPI_v1_16_5 instance;

    @Override
    public int getAmount(Material material, int itemDamage) {
        Integer itemAmount = 0;
        if(Minecraft.getInstance() == null || Minecraft.getInstance().player == null)
            return 0;
        for(ItemStack item : Minecraft.getInstance().player.inventory.mainInventory){
            if(item == null
                    || item.getCount() <= 0
                    || item.getItem() == null
                    || Registry.ITEM.getKey(item.getItem()) == null
                    || !Registry.ITEM.getKey(item.getItem()).getPath().equals(material.getPath(MinecraftAPI.getAPI().isLegacy()))
                    || !Registry.ITEM.getKey(item.getItem()).getNamespace().equals(material.getNamespace())
            )
                continue;
            itemAmount = itemAmount + item.getCount();
        }
        return itemAmount;
    }

    public static Laby3InventoryAPI_v1_16_5 getAPI() {
        if(instance == null)
            instance = new Laby3InventoryAPI_v1_16_5();
        return instance;
    }
}
