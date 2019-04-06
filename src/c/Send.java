package c;

import java.io.PrintWriter;
import java.net.Socket;

public class Send extends Thread{

	private PrintWriter writer;
	private String message;
	private Socket client;
	
	public String getMeassage() {
		return message;
	}
	public void setMeassage(String message) {
		this.message = message;
	}
	public Send(Socket socket) {
		client = socket;
	}
	public void run() {
		try {
			writer = new PrintWriter(client.getOutputStream(),true);
			if(message!=null) {
				writer.println(message);
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}
