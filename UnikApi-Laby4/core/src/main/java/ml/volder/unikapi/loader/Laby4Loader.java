package ml.volder.unikapi.loader;

import ml.volder.unikapi.UnikAPI;
import ml.volder.unikapi.api.ApiReferenceStorageLaby4;
import ml.volder.unikapi.loader.laby4.Laby4AddonConfig;
import ml.volder.unikapi.loader.laby4.UnikRootSettingRegistry;
import ml.volder.unikapi.logger.Laby4Logger;
import net.labymod.api.Laby;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;
import net.labymod.api.models.addon.annotation.AddonMain;
import net.labymod.api.reference.ReferenceStorageAccessor;

@AddonMain
public class Laby4Loader extends LabyAddon<Laby4AddonConfig> {

  public static <R extends ReferenceStorageAccessor> R referenceStorageAccessorInstance(){
    return instance.referenceStorageAccessor();
  }

  private static Laby4Loader instance;

  @Override
  protected void enable() {
    instance = this;
    UnikAPI.LOGGER = new Laby4Logger("UnikAPI");
    UnikAPI.initAPI("labymod4", null, "*");
    UnikAPI.registerReferenceStorage(ApiReferenceStorageLaby4.getInstance());
    Loader.onEnable(Laby.labyAPI().addonService().getAddon(this.getClass()).get().getClassLoader().getResourceAsStream("loaderInfo.json"));
    Laby.labyAPI().eventBus().registerListener(this);

    //Redirect addon settings to UnikAPI addon settings
    UnikRootSettingRegistry registry = new UnikRootSettingRegistry(addonInfo().getNamespace(), addonInfo().getNamespace(), unikRootSettingRegistry -> {
      if(Laby.labyAPI().minecraft().minecraftWindow().currentScreen().isActivity() && Laby.labyAPI().minecraft().minecraftWindow().currentScreen().asActivity().getClass().getName().contains("NavigationActivity")) {
        ml.volder.unikapi.AddonMain.callOpenSettings(this);
        changeFromAddonSetting = true;
      }
    });
    registry.setDisplayName(addonInfo().getDisplayName());
    labyAPI().coreSettingRegistry().addSetting(registry);
  }

  boolean changeFromAddonSetting = false;
  @Subscribe
  public void onTick(GameTickEvent event) {
    if (changeFromAddonSetting) {
      if(labyAPI().coreSettingRegistry().getById("ingame") != null)
        labyAPI().showSetting(labyAPI().coreSettingRegistry().getById("ingame"));
      ml.volder.unikapi.AddonMain.callOpenSettings(this);
      changeFromAddonSetting = false;
    }
  }

  @Override
  protected Class<Laby4AddonConfig> configurationClass() {
    return Laby4AddonConfig.class;
  }
}
