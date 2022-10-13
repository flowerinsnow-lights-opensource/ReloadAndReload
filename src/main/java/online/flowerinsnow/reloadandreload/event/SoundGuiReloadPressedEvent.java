package online.flowerinsnow.reloadandreload.event;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreenOptionsSounds;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SoundGuiReloadPressedEvent extends Event {
    public final GuiScreenOptionsSounds gui;
    public final GuiButton button;

    public SoundGuiReloadPressedEvent(GuiScreenOptionsSounds gui, GuiButton button) {
        this.gui = gui;
        this.button = button;
    }
}
