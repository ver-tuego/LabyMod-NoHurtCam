package net.dezc.nohurtcam;

import java.util.List;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;

public class NoHurtCam extends LabyModAddon {
  public static boolean toggledOn = false;

  @Override
  public void onEnable() {
  }

  @Override
  public void loadConfig() {
    toggledOn = getConfig().has( "enabled" ) ? getConfig().get( "enabled" ).getAsBoolean() : false;
  }

  @Override
  protected void fillSettings(List<SettingsElement> list) {
    list.add( new BooleanElement( "Enabled", new ControlElement.IconData( Material.LEVER ), new Consumer<Boolean>() {
      @Override
      public void accept( Boolean accepted ) {
        toggledOn = accepted;
        getConfig().addProperty("enabled", accepted);
        saveConfig();
      }
    }, toggledOn) );
  }
}