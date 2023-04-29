package ml.volder.unikapi.loader;

import ml.volder.unikapi.UnikAPI;
import ml.volder.unikapi.loader.laby4.Laby4AddonConfig;
import ml.volder.unikapi.logger.Laby4Logger;
import net.labymod.api.Laby;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.gui.screen.key.Key;
import net.labymod.api.client.gui.screen.key.mapper.KeyMapper;
import net.labymod.api.client.gui.screen.key.mapper.KeyMapper.KeyCodeType;
import net.labymod.api.event.addon.lifecycle.AddonEnableEvent;
import net.labymod.api.models.addon.annotation.AddonMain;
import net.labymod.api.reference.ReferenceStorageAccessor;
@AddonMain
public class Laby4Loader extends LabyAddon<Laby4AddonConfig> {

  public static <R extends ReferenceStorageAccessor> R referenceStorageAccessor(){
    return instance.getReferenceStorageAccessor();
  }

  private static Laby4Loader instance;

  @Override
  protected void enable() {
    UnikAPI.LOGGER = new Laby4Logger("UnikAPI");
    UnikAPI.LOGGER.info("[UnikAPI-LabyMod4] Enabling addon!");
    instance = this;
    UnikAPI.initAPI("labymod4", null, "*");
    Loader.onEnable(Laby.labyAPI().addonService().getAddon(this.getClass()).get().getClassLoader().getResourceAsStream("loaderInfo.json"));
  }

  private void loadAssets() {
    //TODO load textures to minecraft namespace/domain
  }

  @Override
  protected Class<Laby4AddonConfig> configurationClass() {
    return Laby4AddonConfig.class;
  }
}
