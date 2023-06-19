package ml.volder.unikapi.version.v1_8_9.laby4;

import ml.volder.unikapi.api.minecraft.impl.Laby4MinecraftAPI;
import net.labymod.api.models.Implements;
import net.minecraft.client.Minecraft;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.SocketAddress;

@Singleton
@Implements(Laby4MinecraftAPI.class)
public class VersionedMinecraftAPI extends Laby4MinecraftAPI{

  @Inject
  public VersionedMinecraftAPI() {
  }

  @Override
  public SocketAddress getSocketAddress() {
    if(Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getNetHandler() == null || Minecraft.getMinecraft().getNetHandler().getNetworkManager() == null)
      return null;
    return Minecraft.getMinecraft().getNetHandler().getNetworkManager().getRemoteAddress();
  }
}
