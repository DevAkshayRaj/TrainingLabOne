package components.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

public class SendSms {

	public static void SendMessage(ArrayList<ArrayList<String>> msg,String phone) throws Exception{
		// TODO Auto-generated method stub
		msg.remove(msg.size()-1);
		String message = msg.toString();
		String username = "Akshay";
		String password = "raj";
		String address = "http://192.168.0.6";
		String port = "8090";
		
		URL url = new URL(
				address+":"+port+"/SendSMS?username="+username+"&password="+password+
				"&phone="+phone+"&message="+URLEncoder.encode(message,"UTF-8"));
		
		URLConnection connection = url.openConnection();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		while((inputLine = bufferedReader.readLine()) !=null){
			System.out.println(inputLine);
		}
		bufferedReader.close();
	}

}