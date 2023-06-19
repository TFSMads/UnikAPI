package ml.volder.unikapi.api.inventory.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.inventory.InventoryAPI;
import ml.volder.unikapi.api.minecraft.MinecraftAPI;
import ml.volder.unikapi.types.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class Laby3InventoryAPI_v1_8_9 implements InventoryAPI {
    private static Laby3InventoryAPI_v1_8_9 instance;

    @Override
    public int getAmount(Material material, int itemDamage) {
        Integer itemAmount = 0;
        if(Minecraft.getMinecraft() == null || Minecraft.getMinecraft().thePlayer == null)
            return 0;
        for(ItemStack item : Minecraft.getMinecraft().thePlayer.inventory.mainInventory){
            if(item == null
                    || item.stackSize <= 0
                    || item.getItem() == null
                    || (MinecraftAPI.getAPI().isLegacy() && item.getItemDamage() != itemDamage)
                    || Item.itemRegistry.getNameForObject(item.getItem()) == null
                    || !Item.itemRegistry.getNameForObject(item.getItem()).getResourcePath().equals(material.getPath(MinecraftAPI.getAPI().isLegacy()))
                    || !Item.itemRegistry.getNameForObject(item.getItem()).getResourceDomain().equals(material.getNamespace())
            )
                continue;
            itemAmount = itemAmount + item.stackSize;
        }
        return itemAmount;
    }

    public static Laby3InventoryAPI_v1_8_9 getAPI() {
        if(instance == null)
            instance = new Laby3InventoryAPI_v1_8_9();
        return instance;
    }
}
