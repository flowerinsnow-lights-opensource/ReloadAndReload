package online.flowerinsnow.reloadandreload;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import online.flowerinsnow.reloadandreload.listener.GuiListener;

@Mod(
        modid = ReloadAndReload.MODID, version = ReloadAndReload.VERSION,
        clientSideOnly = true
)
@SideOnly(Side.CLIENT)
public class ReloadAndReload {
    public static final String MODID = "reloadandreload";
    public static final String VERSION = "@VERSION@";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new GuiListener());
    }
}
