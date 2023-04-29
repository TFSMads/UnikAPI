package ml.volder.unikapi.event.events.clienttickevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import ml.volder.unikapi.event.EventManager;
import ml.volder.unikapi.event.EventType;
import ml.volder.unikapi.event.events.clienttickevent.ClientTickEvent;
import net.labymod.api.Laby;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;

@SupportedClient(clientBrand = "labymod4", minecraftVersion = "*")
public class Laby4TickEvent implements EventImpl {
  @Subscribe
  public void onTick(GameTickEvent event){
    EventManager.callEvent(new ClientTickEvent(EventType.PRE, getName()));
  }

  @Override
  public String getName() {
      return "laby4-tickevent";
  }

  @Override
  public void register() {
    Laby.labyAPI().eventBus().registerListener(this);
  }


}
