package ml.volder.unikapi.loader;

import ml.volder.unikapi.UnikAPI;
import ml.volder.unikapi.api.ApiReferenceStorageLaby4;
import ml.volder.unikapi.event.events.mainmenuopenevent.impl.Laby4MainMenuOpenEvent;
import ml.volder.unikapi.loader.laby4.Laby4AddonConfig;
import ml.volder.unikapi.loader.laby4.UnikRootSettingRegistry;
import ml.volder.unikapi.logger.Laby4Logger;
import ml.volder.unikapi.widgets.Laby4ModuleManager;
import ml.volder.unikapi.widgets.ModuleSystem;
import net.labymod.api.Laby;
import net.labymod.api.addon.AddonService;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.addon.LoadedAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;
import net.labymod.api.models.addon.annotation.AddonMain;
import net.labymod.api.models.addon.info.InstalledAddonInfo;
import net.labymod.api.reference.ReferenceStorageAccessor;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Optional;

@AddonMain
public class Laby4Loader extends LabyAddon<Laby4AddonConfig> {

  public static <R extends ReferenceStorageAccessor> R referenceStorageAccessorInstance(){
    return instance.referenceStorageAccessor();
  }

  private static Laby4Loader instance;

  @Override
  protected void enable() {
    //if(update())
    //  return;
    instance = this;
    UnikAPI.LOGGER = new Laby4Logger("UnikAPI");
    UnikAPI.initAPI("labymod4", null, "*");
    UnikAPI.registerReferenceStorage(ApiReferenceStorageLaby4.getInstance());
    ModuleSystem.setModuleManager(new Laby4ModuleManager());
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
    Laby4MainMenuOpenEvent.checkMainMenu();
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

  /*private boolean update() {
    if(UnikAPI.isUpToDate())
      return false;
    Path path = Path.of(findPathJar(UnikAPI.class));
    try {
      Method unloadMethod = labyAPI().addonService().getClass().getDeclaredMethod("unloadAddon", LoadedAddon.class);
      @NotNull Optional<LoadedAddon> addon = labyAPI().addonService().getAddon(this.getClass());
      unloadMethod.invoke(labyAPI().addonService(), addon.orElse(null));
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
      return false;
    }
    try {
      Files.delete(path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    InputStream in = null;
    try {
      in = new URL("https://github.com/TFSMads/transporter/releases/latest/download/transporter-laby4.jar").openStream();
      Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    AddonService addonService = labyAPI().addonService();
    try {
      Method getAddonLoaderMethod = addonService.getClass().getDeclaredMethod("getAddonLoader");
      Object addonLoader = getAddonLoaderMethod.invoke(addonService);
      Method getAddonInfo = addonLoader.getClass().getDeclaredMethod("loadAddonInfo", Path.class);
      InstalledAddonInfo addonInfo = (InstalledAddonInfo) getAddonInfo.invoke(addonLoader, path);
      Method loadAddon = addonService.getClass().getDeclaredMethod("loadAddon", InstalledAddonInfo.class, Path.class);
      Object addon = loadAddon.invoke(addonService, addonInfo, path);
      Method addLoadedAddon = addonService.getClass().getDeclaredMethod("addLoadedAddon", LoadedAddon.class, boolean.class);
      addLoadedAddon.invoke(addonService, addon, true);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
    return true;
  }*/

  /**
   * If the provided class has been loaded from a jar file that is on the local file system, will find the absolute path to that jar file.
   *
   * param context The jar file that contained the class file that represents this class will be found. Specify {@code null} to let {@code LiveInjector}
   *                find its own jar.
   * throws IllegalStateException If the specified class was loaded from a directory or in some other way (such as via HTTP, from a database, or some
   *                               other custom classloading device).
   */
  /*private static String findPathJar(Class<?> context) throws IllegalStateException {
    if (context == null) context = UnikAPI.class;
    String rawName = context.getName();
    String classFileName;*/
    /* rawName is something like package.name.ContainingClass$ClassName. We need to turn this into ContainingClass$ClassName.class. */ /*{
      int idx = rawName.lastIndexOf('.');
      classFileName = (idx == -1 ? rawName : rawName.substring(idx+1)) + ".class";
    }

    String uri = context.getResource(classFileName).toString();
    if (uri.startsWith("file:")) throw new IllegalStateException("This class has been loaded from a directory and not from a jar file.");
    if (!uri.startsWith("jar:file:")) {
      int idx = uri.indexOf(':');
      String protocol = idx == -1 ? "(unknown)" : uri.substring(0, idx);
      throw new IllegalStateException("This class has been loaded remotely via the " + protocol +
          " protocol. Only loading from a jar on the local file system is supported.");
    }

    int idx = uri.indexOf('!');
    //As far as I know, the if statement below can't ever trigger, so it's more of a sanity check thing.
    if (idx == -1) throw new IllegalStateException("You appear to have loaded this class from a local jar file, but I can't make sense of the URL!");

    try {
      String fileName = URLDecoder.decode(uri.substring("jar:file:".length(), idx), Charset.defaultCharset().name());
      return new File(fileName).getAbsolutePath();
    } catch (UnsupportedEncodingException e) {
      throw new InternalError("default charset doesn't exist. Your VM is borked.");
    }
  }*/

  @Override
  protected Class<Laby4AddonConfig> configurationClass() {
    return Laby4AddonConfig.class;
  }
}
