package ml.volder.unikapi.api.inventory.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.inventory.InventoryAPI;
import ml.volder.unikapi.api.minecraft.MinecraftAPI;
import ml.volder.unikapi.types.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.12.*")
public class Laby3InventoryAPI_v1_12_2 implements InventoryAPI {
    private static Laby3InventoryAPI_v1_12_2 instance;

    @Override
    public int getAmount(Material material, int itemDamage) {
        Integer itemAmount = 0;
        if(Minecraft.getMinecraft() == null || Minecraft.getMinecraft().player == null)
            return 0;
        for(ItemStack item : Minecraft.getMinecraft().player.inventory.mainInventory){
            if(item == null
                    || item.getCount() <= 0
                    || item.getItem() == null
                    || (MinecraftAPI.getAPI().isLegacy() && item.getItemDamage() != itemDamage)
                    || Item.REGISTRY.getNameForObject(item.getItem()) == null
                    || !Item.REGISTRY.getNameForObject(item.getItem()).getResourcePath().equals(material.getPath(MinecraftAPI.getAPI().isLegacy()))
                    || !Item.REGISTRY.getNameForObject(item.getItem()).getResourceDomain().equals(material.getNamespace())
            )
                continue;
            itemAmount = itemAmount + item.getCount();
        }
        return itemAmount;
    }

    public static Laby3InventoryAPI_v1_12_2 getAPI() {
        if(instance == null)
            instance = new Laby3InventoryAPI_v1_12_2();
        return instance;
    }
}
