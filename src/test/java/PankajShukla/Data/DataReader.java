package PankajShukla.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.logging.FileHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	
	public List<HashMap<String, String>> getJsonData(String filePath) throws Exception
	{
	 
			String jsoonContent = Files.readString(Paths.get(filePath));
			
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String, String>> data = mapper.readValue(jsoonContent, new TypeReference<List<HashMap<String, String>>>() {
			});
			
			return data;
			
	}

}
