package awesomespider.significantAdvancements.Audio;

import awesomespider.significantAdvancements.SignificantAdvancements;
import net.minecraft.entity.player.EntityPlayer;

public class SoundManager {

	public static void playTheme(EntityPlayer player){
		player.worldObj.playSoundEffect(player.posX, player.posY, player.posZ, SignificantAdvancements.MODID + ":all_this", 1, 1);
	}
}
