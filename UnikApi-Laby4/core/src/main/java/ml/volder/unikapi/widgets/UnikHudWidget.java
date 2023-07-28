package ml.volder.unikapi.widgets;

import ml.volder.core.generated.DefaultReferenceStorage;
import ml.volder.unikapi.api.minecraft.MinecraftAPI;
import ml.volder.unikapi.loader.Laby4Loader;
import ml.volder.unikapi.types.Material;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.gui.hud.binding.category.HudWidgetCategory;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidget;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine.State;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.resources.ResourceLocation;
import net.labymod.api.client.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import java.util.function.Function;

public class UnikHudWidget extends TextHudWidget {

  private String prefix;
  private Function<String, String> getDisplayValue;

  public UnikHudWidget(String id, HudWidgetCategory category, String prefix, Material material, Function<String, String> getDisplayValue) {
    super(id);
    this.bindCategory(category);
    this.prefix = prefix;
    this.getDisplayValue = getDisplayValue;
    this.setIcon(Icon.texture(ResourceLocation.create("unikapi", "items/" + material.getPath(false) + ".png")));
  }

  private TextLine line;

  @Override
  public void load(TextHudWidgetConfig config) {
    super.load(config);
    this.line = super.createLine(prefix, "");
  }

  @Override
  public void onTick() {
    this.line.updateAndFlush(getDisplayValue.apply(""));
    if (ModuleSystem.shouldRenderModules()) {
      this.line.setState(State.VISIBLE);
    } else {
      this.line.setState(State.HIDDEN);
    }
  }

  @Override
  public @NotNull Component displayName() {
    return Component.text(prefix);
  }


}
