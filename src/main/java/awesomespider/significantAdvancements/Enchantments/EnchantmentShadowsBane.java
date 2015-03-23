package awesomespider.significantAdvancements.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentShadowsBane extends Enchantment {

	public EnchantmentShadowsBane(int id, int rarity) {
		super(id, rarity, EnumEnchantmentType.weapon);
		this.setName("shadow'sBane");
	}
	
	/**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 10 + (par1 - 1) * 8;
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return super.getMinEnchantability(par1) + 50;
    }
    
    public int getMaxLevel(){
    	return 1;
    }
}
