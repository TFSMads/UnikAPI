package ml.volder.unikapi.event.events.opensignevent.impl;

import ml.volder.core.generated.DefaultReferenceStorage;
import ml.volder.unikapi.loader.Laby4Loader;
import net.labymod.api.event.client.gui.screen.ScreenOpenEvent;
import net.labymod.api.reference.annotation.Referenceable;

@Referenceable
public abstract class Laby4EventOpenSign {
  public abstract void onScreenOpen(ScreenOpenEvent event, String eventName);

  private static Laby4EventOpenSign instance;
  public static Laby4EventOpenSign getVersionedInstance() {
      if(instance == null){
        DefaultReferenceStorage defaultReferenceStorage = Laby4Loader.referenceStorageAccessor();
        instance = defaultReferenceStorage.laby4EventOpenSign();
      }
      return instance;
  }
}
