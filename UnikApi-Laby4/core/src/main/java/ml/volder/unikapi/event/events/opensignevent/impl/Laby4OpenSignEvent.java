package ml.volder.unikapi.event.events.opensignevent.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.event.EventImpl;
import net.labymod.api.Laby;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.gui.screen.ScreenOpenEvent;

@SupportedClient(clientBrand = "labymod4", minecraftVersion = "*")
public class Laby4OpenSignEvent implements EventImpl {

  private Laby4EventOpenSign eventOpenSign;
  public Laby4OpenSignEvent() {
    eventOpenSign = Laby4EventOpenSign.getVersionedInstance();
  }

  @Subscribe
  public void onGuiOpen(ScreenOpenEvent event){
    eventOpenSign.onScreenOpen(event, getName());
  }

  @Override
  public String getName() {
      return "laby4-opensignevent";
  }

  @Override
  public void register() {
    Laby.labyAPI().eventBus().registerListener(this);
  }

}