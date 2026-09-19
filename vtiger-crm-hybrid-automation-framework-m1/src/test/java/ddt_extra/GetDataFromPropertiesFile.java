package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
//		./src/test/resources/cd.properties
//		. means project level
//		Step 1> create jro of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");
		
//		step 2> by using load(), load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		step 3> by using getProperty() and passing the key, get the value
		String url = pObj.getProperty("url");
		System.out.println(url);
	}
}
