package c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;

import org.json.JSONArray;
import org.json.JSONObject;

public class C {
	public static String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
	
	public static void main(String[] args) throws Exception {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		Socket socket = new Socket("127.0.0.1", 5678);
		Receive receive = new Receive(socket);
		receive.start();
		while(true) {		
			Send send = new Send(socket);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			msg = reader.readLine();
			object.put("信号",msg);
			msg = reader.readLine();
			object.put("用户名",msg);
			msg = getMD5String(reader.readLine());
			object.put("密码",msg);
			send.setMeassage(object.toString());
			send.start();
		}
	}
}
