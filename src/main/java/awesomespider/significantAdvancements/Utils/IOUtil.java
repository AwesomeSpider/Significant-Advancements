package awesomespider.significantAdvancements.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import awesomespider.significantAdvancements.SignificantAdvancements;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class IOUtil {
	
	public static void createFile(String dir){
		File file = new File(dir);
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createFolder(String dir){
		File file = new File(dir);
		
		file.mkdir();
	}
	
	public static boolean dirExists(String dir){
		return new File(dir).exists();
	}
	
	public static void writeToJson(String name, String value, File file) throws IOException{
		JsonWriter json = new JsonWriter(new FileWriter(file));
			
		json.beginObject();
			
		json.name(name).value(value);
			
		json.endObject();
			
		json.close();
	}
	
	public static void writeToJson(String name, double value, File file) throws IOException{
		JsonWriter json = new JsonWriter(new FileWriter(file));
			
		json.beginObject();
			
		json.name(name).value(value);
			
		json.endObject();
			
		json.close();

	}
	
	public static void writeToJson(String name, long value, File file) throws IOException{
		JsonWriter json = new JsonWriter(new FileWriter(file));
			
		json.beginObject();
			
		json.name(name).value(value);
			
		json.endObject();
			
		json.close();
	}
	
	public static void writeToJson(String name, boolean value, File file) throws IOException{
		JsonWriter json = new JsonWriter(new FileWriter(file));
			
		json.beginObject();
			
		json.name(name).value(value);
			
		json.endObject();
			
		json.close();
	}
	
	public static void writeToJson(String name, int value, File file) throws IOException{
		JsonWriter json = new JsonWriter(new FileWriter(file));
			
		json.beginObject();
			
		json.name(name).value(value);
			
		json.endObject();
			
		json.close();
	}
	
	public static String readStringFromJson(String name, File file) throws IOException{
		String result = null;
		
		boolean searching = true;
		
		JsonReader json = new JsonReader(new FileReader(file));
			
		json.beginObject();
			
		while (searching == true){
			if (json.nextName().equals(name)){
				result = json.nextString();
				searching = false;
			} else {
				json.skipValue();
			}
				
			if (json.hasNext() != false){
				searching = false;
				
				SignificantAdvancements.log.info("[Significant Advancements] String '" + name + "' could not be found in json file '" + file.getAbsolutePath() + "'. Report this to the forums imediately.");
			}
		}
			
		json.endObject();
			
		json.close();
		
		return result;
	}
	
	public static double readDoubleFromJson(String name, File file) throws IOException{
		double result = 0;
		
		boolean searching = true;
		
		JsonReader json = new JsonReader(new FileReader(file));
			
		json.beginObject();
			
		while (searching == true){
			if (json.nextName().equals(name)){
				result = json.nextDouble();
				searching = false;
			} else {
				json.skipValue();
			}
				
			if (json.hasNext() != false){
				searching = false;
				
				SignificantAdvancements.log.info("[Significant Advancements] Double '" + name + "' could not be found in json file '" + file.getAbsolutePath() + "'. Report this to the forums imediately.");
			}
		}
			
		json.endObject();
			
		json.close();
		
		return result;
	}
	
	public static long readLongFromJson(String name, File file) throws IOException{
		long result = 0;
		
		boolean searching = true;
		
		JsonReader json = new JsonReader(new FileReader(file));
			
		json.beginObject();
			
		while (searching == true){
			if (json.nextName().equals(name)){
				result = json.nextLong();
				searching = false;
			} else {
				json.skipValue();
			}
				
			if (json.hasNext() != false){
				searching = false;
				
				SignificantAdvancements.log.info("[Significant Advancements] Long '" + name + "' could not be found in json file '" + file.getAbsolutePath() + "'. Report this to the forums imediately.");
			}
		}
			
		json.endObject();
			
		json.close();
		
		return result;
	}
	
	public static boolean readBooleanFromJson(String name, File file) throws IOException{
		boolean result = false;
		
		boolean searching = true;
		
		JsonReader json = new JsonReader(new FileReader(file));
			
		json.beginObject();
			
		while (searching == true){
			if (json.nextName().equals(name)){
				result = json.nextBoolean();
				searching = false;
			} else {
				json.skipValue();
			}
				
			if (json.hasNext() != false){
				searching = false;
				
				SignificantAdvancements.log.info("[Significant Advancements] Boolean '" + name + "' could not be found in json file '" + file.getAbsolutePath() + "'. Report this to the forums imediately.");
			}
		}
			
		json.endObject();
			
		json.close();
		
		return result;
	}
	
	public static int readIntegerFromJson(String name, File file) throws IOException{
		int result = 0;
		
		boolean searching = true;
		
		JsonReader json = new JsonReader(new FileReader(file));
			
		json.beginObject();
			
		while (searching == true){
			if (json.nextName().equals(name)){
				result = json.nextInt();
				searching = false;
			} else {
				json.skipValue();
			}
				
			if (json.hasNext() != false){
				searching = false;
				
				SignificantAdvancements.log.info("[Significant Advancements] Int '" + name + "' could not be found in json file '" + file.getAbsolutePath() + "'. Report this to the forums imediately.");
			}
		}
			
		json.endObject();
			
		json.close();
		
		return result;
	}
}
