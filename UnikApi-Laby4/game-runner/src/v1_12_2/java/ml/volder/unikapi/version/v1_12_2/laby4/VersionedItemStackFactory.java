package ml.volder.unikapi.version.v1_12_2.laby4;

import javax.inject.Inject;
import javax.inject.Singleton;
import ml.volder.unikapi.laby4.UnikItemStackFactory;
import net.labymod.api.client.resources.ResourceLocation;
import net.labymod.api.client.world.item.ItemStack;
import net.labymod.api.models.Implements;
import net.labymod.v1_12_2.client.util.ItemUtil;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

@Singleton
@Implements(UnikItemStackFactory.class)
public class VersionedItemStackFactory implements UnikItemStackFactory{

  private static final net.minecraft.item.ItemStack FALLBACK_ITEM;

  @Inject
  public VersionedItemStackFactory() {
  }

  public ItemStack create(ResourceLocation location, int count, int itemDamage) {
    Item item = Item.REGISTRY.getObject(location.getMinecraftLocation());
    if (item == null) {
      return ItemUtil.getLabyItemStack(FALLBACK_ITEM);
    } else {
      net.minecraft.item.ItemStack stack = new net.minecraft.item.ItemStack(item, count, itemDamage);
      return ItemUtil.getLabyItemStack(stack);
    }
  }

  static {
    FALLBACK_ITEM = new net.minecraft.item.ItemStack(Items.APPLE);
  }
}
