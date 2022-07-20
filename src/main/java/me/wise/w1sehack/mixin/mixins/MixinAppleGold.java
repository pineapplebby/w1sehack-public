package me.wise.w1sehack.mixin.mixins;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import me.wise.w1sehack.api.event.GapEatEvent;

@Mixin(value={ItemAppleGold.class})
public class MixinAppleGold {
    @Inject(method={"onFoodEaten"}, at={@At(value="HEAD")})
    public void onGap(ItemStack stack, World worldIn, EntityPlayer player, CallbackInfo ci) {
        GapEatEvent event = new GapEatEvent(stack);
        MinecraftForge.EVENT_BUS.post((Event)event);
    }
}
