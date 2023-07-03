package net.dezc.nohurtcam.mixin;

import net.dezc.nohurtcam.NoHurtCam;
import net.minecraft.client.renderer.GameRenderer;
import com.mojang.blaze3d.matrix.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
  @Inject(at = @At("HEAD"), method="hurtCameraEffect", cancellable = true)
  private void bobViewWhenHurt(MatrixStack matrixStack_1, float float_1, CallbackInfo ci) {
    if (NoHurtCam.toggledOn) {
      ci.cancel();
    }
  }
}