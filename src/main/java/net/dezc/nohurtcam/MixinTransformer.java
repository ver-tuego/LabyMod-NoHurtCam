package net.dezc.nohurtcam;

import net.labymod.addon.AddonTransformer;
import net.labymod.api.TransformerType;

public class MixinTransformer extends AddonTransformer {

  @Override
  public void registerTransformers() {
    this.registerTransformer(TransformerType.VANILLA, "nohurtcam.mixin.json");
  }
}
