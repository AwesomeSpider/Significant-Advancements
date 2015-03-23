package awesomespider.significantAdvancements;

import awesomespider.significantAdvancements.Enchantments.EnchantmentShadowsBane;
import awesomespider.significantAdvancements.Events.KeyInputHandler;
import awesomespider.significantAdvancements.Items.MagicalBook;
import awesomespider.significantAdvancements.Mechanics.Dismantler;
import awesomespider.significantAdvancements.Utils.PlayerUtils;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = SignificantAdvancements.MODID, version = SignificantAdvancements.VERSION, name = SignificantAdvancements.NAME)
public class SignificantAdvancements
{
    public static final String MODID = "significantadvancements";
    public static final String NAME = "Significant Advancements";
    public static final String VERSION = "0.0.1";
    
    @SidedProxy(clientSide = "awesomespider.significantAdvancements.ClientProxy", serverSide = "awesomespider.significantAdvancements.CommonProxy")
    public static CommonProxy proxy;
    
    public static File configFile;
    public static Configuration config;
    
    //The Dismantler's State as Specified by the Config (on or off)
    public static boolean dismantlerState;
    
    public static File dataFolder;
    
    public static Item magicalBook;
    
    public static Enchantment shadowsBane;
    
    public static Logger log;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
    	LangRegistry.retrieveEntries();
    	
    	event.getModLog().info("[Significant Advancements] " + LangRegistry.langEntries.get("log.preinit.text"));
    	dataFolder = event.getModConfigurationDirectory();
    	
    	//Initialize the config
    	configFile = event.getSuggestedConfigurationFile();
    	config = new Configuration(configFile);
    	
    	log = event.getModLog();
    	
    	magicalBook = new MagicalBook("item.magicalBook.name", 1, MODID + ":magicalBook");
    	
    	shadowsBane = new EnchantmentShadowsBane(100, 10);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	log.info("[Significant Advancements] " + LangRegistry.langEntries.get("log.init.text"));
    	GameRegistry.registerItem(magicalBook, magicalBook.getUnlocalizedName(), MODID);
    	
    	//Render KeyInputHandler
    	FMLCommonHandler.instance().bus().register(new KeyInputHandler());
    	
    	//Load the config
    	config.load();
    	
    	config.get(Configuration.CATEGORY_GENERAL, "dismantler", true).comment = "If you want the dismantler mechanic turned on, leave this as is. If you want it off (rarly wanted :) ), change this to false.";
    	dismantlerState = config.get(Configuration.CATEGORY_GENERAL, "dismantler", true).getBoolean();
    	
    	config.save();
    	
    	KeyBindings.init();
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
    	log.info("[Significant Advancements] " + LangRegistry.langEntries.get("log.postinit.text"));
    	
    	try {
			Dismantler.retrieve();
		} catch (SAException e) {
			e.printStackTrace();
		}
    	
    	//Attempt to create cache file if it doesn't already exist
    	PlayerUtils.createCache();
    }
}