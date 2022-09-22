import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class apiListen {

	public static void main(String[] args) {
		System.out.println(LocalTime.now() + "!!!!!!!!!!START!!!!!!!!!!");		
		int startTime = LocalTime.now().getHour()*24 + LocalTime.now().getMinute() * 60 + LocalTime.now().getSecond();		
		String[] recuClCd = {"31","41","81","93"};
		for(int i = 0 ; recuClCd.length > i ; i ++) getJson(recuClCd[i]);
		int EndTime = LocalTime.now().getHour()*24 + LocalTime.now().getMinute() * 60 + LocalTime.now().getSecond();
		System.out.println(EndTime - startTime + "초 소요");
		System.out.println(LocalTime.now() + "!!!!!!!!!!END!!!!!!!!!!");		
	}

	private static void getJson(String recuClCd) {
		try {
			String api_token 		= "tAepjYM6f6AWf6GY";
			System.out.println("LocalDate.now().minusDays(1).toString()::" + LocalDate.now().minusDays(1).toString());			
			String searchCompleteSD = LocalDate.now().minusDays(1).toString();
			String searchCompleteED	= LocalDate.now().minusDays(1).toString();
			String apiUrl 			= "";
			
			if("31".equals(recuClCd)) {
				apiUrl = "https://privacy.kma.org/admin/agreement/answer_api.php";
			}else if("41".equals(recuClCd)) {
				apiUrl = "https://privacy.kda.or.kr/admin/agreement/answer_api.php";
			}else if("81".equals(recuClCd)) {
				apiUrl = "https://privacy.kpanet.or.kr/admin/agreement/answer_api.php";
			}else if("93".equals(recuClCd)) {
				apiUrl = "https://privacy.akom.org/admin/agreement/answer_api.php";
			}
			String searchStep		= "";			
			if("31".equals(recuClCd)) {
				searchStep			= "4";
			}else if("41".equals(recuClCd)) {
				searchStep			= "7";
			}else if("81".equals(recuClCd)) {
				searchStep			= "4";
			}else if("93".equals(recuClCd)) {
				searchStep			= "6";
			}			
			
			String getUrl = apiUrl
			
//			String getUrl = 
//			String getUrl = "https://privacy.akom.org/admin/agreement/answer_api.php"
			
							+ "?api_token=" 		+ api_token
//							+ "&agency="		+ searchStep													
							+ "&searchCompleteSD="	+ searchCompleteSD
							+ "&searchCompleteED="	+ searchCompleteED
							+ "&searchStep="		+ searchStep
							;							
			URL url = new URL(getUrl);
			
			TrustManager[] trustAllCerts = new TrustManager[] {
				new X509TrustManager() {
					
					@Override
					public X509Certificate[] getAcceptedIssuers() {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
						// TODO Auto-generated method stub
						
					}
				}	
			};
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			
			System.out.println(url);
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
			
			JSONObject obj 		= (JSONObject) new JSONParser().parse(sb.toString()); // json으로 변경
			JSONArray arrData	= (JSONArray) obj.get("data");
			System.out.println(sb.toString());
			System.out.println("status= " + obj.get("status"));
			System.out.println("cntData= " + arrData.size());			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
