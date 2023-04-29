package ml.volder.unikapi.loader.laby4;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;

@SuppressWarnings("FieldMayBeFinal")
@ConfigName("unikapi")
public class Laby4AddonConfig extends AddonConfig {

  @Override
  public ConfigProperty<Boolean> enabled() {
    return new ConfigProperty<>(true);
  }
}
