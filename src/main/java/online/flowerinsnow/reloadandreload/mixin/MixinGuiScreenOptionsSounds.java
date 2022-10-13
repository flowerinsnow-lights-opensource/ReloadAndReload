package online.flowerinsnow.reloadandreload.mixin;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenOptionsSounds;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import online.flowerinsnow.reloadandreload.event.SoundGuiReloadPressedEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiScreenOptionsSounds.class)
@SideOnly(Side.CLIENT)
public class MixinGuiScreenOptionsSounds extends GuiScreen {
    private final GuiScreenOptionsSounds THIS = (GuiScreenOptionsSounds) (Object) this;
    @Inject(method = "initGui", at = @At("RETURN"))
    public void initGui(CallbackInfo ci) {
        this.buttonList.add(new GuiButton(17726, this.width / 2 - 100, this.height / 6 + 148, I18n.format("gui.reloadsound")));
    }

    @Inject(method = "actionPerformed", at = @At("RETURN"))
    public void actionPerformed(GuiButton button, CallbackInfo ci) {
        if (button.id == 17726) {
            MinecraftForge.EVENT_BUS.post(new SoundGuiReloadPressedEvent(THIS, button));
        }
    }
}
