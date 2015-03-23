package awesomespider.significantAdvancements.Events;

import net.minecraft.client.Minecraft;
import awesomespider.significantAdvancements.KeyBindings;
import awesomespider.significantAdvancements.Mechanics.Dismantler;
import awesomespider.significantAdvancements.Utils.PlayerUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandler {

	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if(KeyBindings.start.isPressed()){
        	PlayerUtils.startPlayer(Minecraft.getMinecraft().thePlayer);
        }
        
        if(KeyBindings.openDimantler.isPressed()){
        
        }
    }
}
