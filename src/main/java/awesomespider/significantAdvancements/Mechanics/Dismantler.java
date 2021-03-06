package awesomespider.significantAdvancements.Mechanics;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

import awesomespider.significantAdvancements.SAException;
import awesomespider.significantAdvancements.SignificantAdvancements;
import awesomespider.significantAdvancements.Utils.ExceptionUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Dismantler System. 
 * A rugged system that contains a list of items that can be dismantled for the items it's made of. 
 * Items can be added from other mods as well as defaults from this mod. 
 * The planned keymapping for this is likely to be "I", but this could change.
 * � Awesome_Spider
 * @author Awesome_Spider
 */
public class Dismantler {

	/**
	 * The list of items. Do not use unless you know what your doing.
	 * You might screw something up.
	 * Use the methods in this class instead. :) 
	 */
	public static Map<Item, ItemStack[]> itemMap = new HashMap<Item, ItemStack[]>();
	
	public static Map<Item, String> modidMap = new HashMap<Item, String>();
	
	/**
	 * Dismantle an item.
	 * @param player - The player.
	 * @param item - The ItemStack to be dimantled.
	 * @return Whether it worked or not.
	 */
	public static boolean dismantle(EntityPlayer player, ItemStack item){
		boolean result = false;
		
		int slot = 0;
		
		if (item.stackTagCompound != null){
			for (int i = 0; i == 36; i ++){
				if (player.inventory.getStackInSlot(i).equals(item)){
					slot = i;
				}
			}
			
			if (slot != 0){
				if (checkForItemInMap(item.getItem())){
					player.inventory.decrStackSize(slot, player.inventory.getStackInSlot(slot).stackSize - 1);
					
					for (int i = 0; i == getItemFromMap(item.getItem()).length; i ++){
						//player.inventory.addItemStackToInventory(new ItemStack(GameRegistry.findItem(getModidFromMap(item.getItem()), getItemFromMap(item.getItem())[i])));
					}
				}
			}
			
			result = true;
		} else {
			player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "Item could not be dismantled. Item has NBT. In future updates this might be possible, but now... not so much."));
		}
		
		return result;
	}
	
	/**
	 * Checks for the specified item in the dismantler map. Part of the process of dismantling an item.
	 * @param item - The item to check for.
	 * @return Whether it's in there or not, obviously. :)
	 */
	public static boolean checkForItemInMap(Item item){
		boolean result = false;
		
		String itemName = item.getUnlocalizedName();
		
		if (itemMap.containsKey(itemName)){
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
	
	/**
	 * Retrieves the default items for this mod.
	 * @throws SAException 
	 */
	public static void retrieve() throws SAException{
		//TODO add some items to obliterate :).
		
		//Tools
		
			//Wood
		addItemToDismantler(Items.wooden_axe, new ItemStack[]{
			new ItemStack(Items.stick, 2),
			new ItemStack(Blocks.planks, 3)
		}, "minecraft");
		
		addItemToDismantler(Items.wooden_shovel, new ItemStack[]{
				new ItemStack(Items.stick, 2),
				new ItemStack(Blocks.planks)
			}, "minecraft");
		
		addItemToDismantler(Items.wooden_pickaxe, new ItemStack[]{
				new ItemStack(Items.stick, 2),
				new ItemStack(Blocks.planks, 3)
			}, "minecraft");
		
		addItemToDismantler(Items.wooden_hoe, new ItemStack[]{
				new ItemStack(Items.stick, 2),
				new ItemStack(Blocks.planks, 2)
			}, "minecraft");
		
			//Stone
		addItemToDismantler(Items.stone_axe, new ItemStack[]{
				new ItemStack(Items.stick, 2),
				new ItemStack(Blocks.cobblestone, 3)
		}, "minecraft");
	
		addItemToDismantler(Items.stone_shovel, new ItemStack[]{
				new ItemStack(Items.stick, 2),
				new ItemStack(Blocks.cobblestone)
		}, "minecraft");
	
		addItemToDismantler(Items.stone_pickaxe, new ItemStack[]{
				new ItemStack(Items.stick, 2),
				new ItemStack(Blocks.cobblestone, 3)
		}, "minecraft");
	
		addItemToDismantler(Items.stone_hoe, new ItemStack[]{
				new ItemStack(Items.stick, 2),
				new ItemStack(Blocks.cobblestone, 2)
		}, "minecraft");
		
			//Misc
		addItemToDismantler(Items.flint_and_steel, new ItemStack[]{
				new ItemStack(Items.flint),
				new ItemStack(Items.iron_ingot)
			}, "minecraft");
		
		addItemToDismantler(Items.fishing_rod, new ItemStack[]{
				new ItemStack(Items.stick, 3),
				new ItemStack(Items.string, 2)
			}, "minecraft");
		
		addItemToDismantler(Items.carrot_on_a_stick, new ItemStack[]{
				new ItemStack(Items.fishing_rod),
				new ItemStack(Items.carrot)
			}, "minecraft");
	}
	
	/**
	 * Adds an item to the dismantler.
	 * This can be used by other mods to add support for the dismantling system in Significant Advancements.
	 * It adds your specified item (and what it breaks down to) into the mod. It takes 3 parameters.
	 * The first is very simple, The item you are implementing. The second, a little more complicated.
	 * This is the items it breaks down to. Stick all the unlocalized names of the items you want to make when this item is dismantled.
	 * There is no limit, but you may want to keep it small as there may not be enough inventory space in the player. :) The third is just your modid.
	 * @param item - The item.
	 * @param names - The unlocalized names of the items it breaks down to.
	 * @param modid -The modid of your mod.
	 * @throws SAException 
	 */
	public static void addItemToDismantler(Item item, ItemStack[] results, String modid) throws SAException{
		if (itemMap.containsKey(item)){
			itemMap.put(item, results);
		} else {
			throw new SAException(ExceptionUtil.getErrorMessageEMDID(modid));
		}
	}
	
	public static ItemStack[] getItemFromMap(Item item){
		return itemMap.get(item);
	}
	
	public static String getModidFromMap(Item item){
		return modidMap.get(item);
	}
}
