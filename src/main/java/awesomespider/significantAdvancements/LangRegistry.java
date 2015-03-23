package awesomespider.significantAdvancements;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.util.StatCollector;

public class LangRegistry {

	public static Map<String, String> langEntries = new HashMap<String, String>();
	
	public static void retrieveEntries(){
		langEntries.put("log.preinit.text", StatCollector.translateToLocal("log.preinit.text"));
		langEntries.put("log.init.text", StatCollector.translateToLocal("log.init.text"));
		langEntries.put("log.postinit.text", StatCollector.translateToLocal("log.postinit.text"));
	}
}
