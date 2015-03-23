package awesomespider.significantAdvancements.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import awesomespider.significantAdvancements.SignificantAdvancements;
import awesomespider.significantAdvancements.Audio.SoundManager;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class PlayerUtils {
	
	static Map<String, String> players = new HashMap<String, String>();
	
	public static void startPlayer(EntityPlayer player){
		try {
			writePlayerFile(player);
			writeToCache(player);
			
			SoundManager.playTheme(player);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writePlayerFile(EntityPlayer player) throws IOException{
		File dir = new File(SignificantAdvancements.dataFolder, "Player Data");
		
		if (IOUtil.dirExists(dir.getAbsolutePath())){
			File dir2 = new File(dir, player.getDisplayName() + ".json");
			
			JsonWriter json = new JsonWriter(new FileWriter(dir2));
			
			json.beginObject();
			
			json.name("define-file").value(player.getDisplayName());
			json.name("username").value(player.getDisplayName());
			json.name("UUID").value(player.getUniqueID().toString());
			json.name("stage").value("Stone");
			
			json.endObject();
			
			json.close();
		}
	}
	
	public static void createCache(){
		File dir = new File(SignificantAdvancements.dataFolder, "Player Data/PlayerCache.json");
		
		if (!IOUtil.dirExists(dir.getAbsolutePath())){
			IOUtil.createFile(dir.getAbsolutePath());
		}
	}
	
	public static void writeToCache(EntityPlayer player) throws IOException{
		File dir = new File(SignificantAdvancements.dataFolder, "Player Data/PlayerCache.json");
		
		if (IOUtil.dirExists(dir.getAbsolutePath())){
			JsonWriter json = new JsonWriter(new FileWriter(dir));
			
			json.beginObject();
			
			json.name(player.getDisplayName()).value(player.getDisplayName() + ".json");
			
			json.endObject();
			
			json.close();
		}
	}
	
	public static void retrieveFromCache() throws IOException{
		File dir = new File(SignificantAdvancements.dataFolder, "Player Data/PlayerCache.json");
		
		if (IOUtil.dirExists(dir.getAbsolutePath())){
			JsonReader json = new JsonReader(new FileReader(dir));
			
			json.beginObject();
			
			while (json.hasNext()){
				players.put(json.nextName(), json.nextString());
			}
			
			json.endObject();
			
			json.close();
		}
	}
}
