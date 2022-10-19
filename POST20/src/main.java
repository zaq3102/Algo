import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class main {
	public static void main(String[] args) {
		String nextUrl = "jordan";
		String answer = "Kubernetes";
		
		post(nextUrl, answer);

	}

	public static void post(String nextUrl, String answer) {
		try {
			URL url = new URL("http://13.125.222.176/quiz/" + nextUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST"); // http 메서드
			conn.setRequestProperty("Content-Type", "application/json"); // header Content-Type 정보
			conn.setDoInput(true); // 서버에 전달할 값이 있다면 true
			conn.setDoOutput(true); // 서버로부터 받는 값이 있다면 true

			// 서버에 데이터 전달
			JSONObject obj = new JSONObject();
			obj.put("nickname", "서울 4반 박지호");
			obj.put("yourAnswer", answer);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(obj.toString()); // 버퍼에 담기
			bw.flush(); // 버퍼에 담긴 데이터 전달
			bw.close();

			// 서버로부터 데이터 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;

			while ((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
//				System.out.println("line : " + line);
				sb.append(line);
			}
			
			System.out.println(sb.toString());
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}