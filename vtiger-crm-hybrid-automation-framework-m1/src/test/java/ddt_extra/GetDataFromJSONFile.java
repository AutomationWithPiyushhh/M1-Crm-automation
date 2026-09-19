package ddt_extra;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetDataFromJSONFile {
	public static void main(String[] args) throws IOException, ParseException {
//		./src/test/resources/cd.properties
//		. means project level
	
		
//		get data from json file
//		Step 1> create jro of the physical file
		FileReader fr = new FileReader("./src/test/resources/cd.json");
		
//		step 2> by using parse(), get the java object
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		
//		step 3> downcast it to JSONObject
		JSONObject jObj = (JSONObject) obj;
		
//		step 4> by using get() and passing the key, get the value
		String url =  jObj.get("url").toString();
		System.out.println(url);
		
		
		
		
	}
}
