package online.flowerinsnow.reloadandreload.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import online.flowerinsnow.reloadandreload.event.SoundGuiReloadPressedEvent;
import online.flowerinsnow.reloadandreload.mixin.AccessorSoundHandler;

@SideOnly(Side.CLIENT)
public class GuiListener {
    private Thread resetButtonThread;
    @SubscribeEvent
    public void onReload(SoundGuiReloadPressedEvent event) {
        AccessorSoundHandler soundHandler = (AccessorSoundHandler) Minecraft.getMinecraft().getSoundHandler();
        soundHandler.sndManager().reloadSoundSystem();
        if (resetButtonThread != null) {
            resetButtonThread.interrupt();
            resetButtonThread = null;
        }
        event.button.displayString = I18n.format("gui.reloadsound.reloaded");
        resetButtonThread = new Thread(() -> {
            try {
                Thread.sleep(3000L);
                event.button.displayString = I18n.format("gui.reloadsound");
            } catch (InterruptedException ignored) {
            }
        });
        resetButtonThread.start();
    }
}
