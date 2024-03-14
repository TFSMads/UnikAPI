package ml.volder.unikapi.version.v1_20_1.laby4;

import javax.inject.Inject;
import javax.inject.Singleton;
import ml.volder.unikapi.laby4.UnikItemStackFactory;
import net.labymod.api.client.resources.ResourceLocation;
import net.labymod.api.client.world.item.ItemStack;
import net.labymod.api.models.Implements;
import net.labymod.v1_20_1.client.util.MinecraftUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

@Singleton
@Implements(UnikItemStackFactory.class)
public class VersionedItemStackFactory implements UnikItemStackFactory{

  @Inject
  public VersionedItemStackFactory() {
  }

  public ItemStack create(ResourceLocation location, int count, int itemDamage) {
    Item item = BuiltInRegistries.ITEM.get((net.minecraft.resources.ResourceLocation)location.getMinecraftLocation());
    net.minecraft.world.item.ItemStack stack = new net.minecraft.world.item.ItemStack(item);
    stack.setCount(count);
    stack.setDamageValue(itemDamage);
    return MinecraftUtil.fromMinecraft(stack);
  }

}
