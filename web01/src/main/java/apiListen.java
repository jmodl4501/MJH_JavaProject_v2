import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class apiListen {

	public static void main(String[] args) {
		getJson();
	}

	private static void getJson() {
		try {
			String api_token 		= "";
			String searchCompleteSD = "2022-06-01";
			String searchCompleteED	= "2022-06-02";
			String getUrl = "https://privacy.kda.or.kr/admin/agreement/answer_api.php"
							+ "?api_token=" 		+ api_token 
							+ "&searchCompleteSD="	+ searchCompleteSD
							+ "&searchCompleteED="	+ searchCompleteED;
			URL url = new URL(getUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET"); // http 메서드
			conn.setRequestProperty("Content-Type", "application/json"); //header Content-Type 정보
			conn.setRequestProperty("auth", "myAuth"); //header의 auth 정보
			conn.setDoOutput(true); //서버로부터 받는 값이 있다면 true
			
			// 서버로부터 데이터 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			JSONObject obj = new JSONObject(sb.toString()); // json으로 변경
			System.out.println("code = " + obj.getInt("code") + " / message= " + obj.getString("message"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
