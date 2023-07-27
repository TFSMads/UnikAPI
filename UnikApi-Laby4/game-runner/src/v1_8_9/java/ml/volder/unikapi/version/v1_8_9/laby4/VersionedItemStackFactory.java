package ml.volder.unikapi.version.v1_8_9.laby4;

import javax.inject.Inject;
import javax.inject.Singleton;
import ml.volder.unikapi.laby4.UnikItemStackFactory;
import net.labymod.api.client.resources.ResourceLocation;
import net.labymod.api.models.Implements;
import net.labymod.v1_8_9.client.util.ItemUtil;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

@Singleton
@Implements(UnikItemStackFactory.class)
public class VersionedItemStackFactory implements UnikItemStackFactory{

  private static final net.minecraft.item.ItemStack FALLBACK_ITEM;

  @Inject
  public VersionedItemStackFactory() {
  }

  public net.labymod.api.client.world.item.ItemStack create(ResourceLocation location, int count, int itemDamage) {
    Item item = Item.itemRegistry.getObject(location.getMinecraftLocation());
    if (item == null) {
      return ItemUtil.getLabyItemStack(FALLBACK_ITEM);
    } else {
      net.minecraft.item.ItemStack stack = new net.minecraft.item.ItemStack(item);
      stack.setItemDamage(itemDamage);
      stack.stackSize = count;
      return ItemUtil.getLabyItemStack(stack);
    }
  }

  static {
    FALLBACK_ITEM = new net.minecraft.item.ItemStack(Items.apple);
  }
}
