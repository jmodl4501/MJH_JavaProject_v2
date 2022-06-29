import java.io.FileReader;
//import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

public class jsonRead {

	//, IOException, ParseException
	public static void main(String[] args) throws Exception{
		JSONParser parser = new JSONParser();
		
		//JSON 파일읽기
		Reader reader = new FileReader("D:\\Project\\MJH_JavaProject_v2\\web01\\src\\cmdLog\\test_api.json");
		JSONObject jsonObject = (JSONObject)parser.parse(reader);
		
		String pkid 		= (String) jsonObject.get("pkid");
		String stepinfo 	= (String) jsonObject.get("stepinfo");
		String agencycode 	= (String) jsonObject.get("agencycode");
		
		System.out.println("pkid 			"+pkid);
		System.out.println("stepinfo 		"+stepinfo);
		System.out.println("agencycode 		"+agencycode);			
	}

}
