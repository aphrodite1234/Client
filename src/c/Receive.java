package c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import org.json.JSONArray;
import org.json.JSONObject;

public class Receive extends Thread {

	private BufferedReader reader = null;
	private String message;
	private Socket client;

	public String getMeassage() {
		return message;
	}

	public void setMeassage(String message) {
		this.message = message;
	}

	public Receive(Socket socket) {
		client = socket;
	}

	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while (true) {
				message = reader.readLine();
				if (message != null) {
//					JSONArray jsonArray = new JSONArray(message);
//					int count = 0;
//					for(int i=0;i<jsonArray.length();i++);{
//						JSONObject json = jsonArray.getJSONObject(count++);
//						System.out.println(json.getString("用户名"));
//						System.out.println(json.getString("密码"));
//						System.out.println(json.getString("真实姓名"));
//					}
//					JSONObject json = new JSONObject(message);
//					System.out.println(json.getString("用户名"));
//					System.out.println(json.getString("密码"));
//					System.out.println(json.getString("真实姓名"));
					System.out.println(message);
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
