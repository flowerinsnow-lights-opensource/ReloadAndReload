package online.flowerinsnow.reloadandreload.mixin;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SoundHandler.class)
@SideOnly(Side.CLIENT)
public interface AccessorSoundHandler {
    @Accessor("sndManager")
    SoundManager sndManager();
}
