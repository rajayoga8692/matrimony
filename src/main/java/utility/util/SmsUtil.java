package utility.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

 
 public class SmsUtil{
	 
 	 public static void sendOTP(String registerno,String mobileno,String password,String regno)
     {
 		String message = "Thank you regitering for sandhiya matrimony.Your profile has approved.Your registeration is number "+regno+".Your username is "+registerno+" and password is "+password;
		// Prepare Url
		URLConnection myURLConnection = null;
		URL myURL = null; 
		BufferedReader reader = null;  
		String encoded_message = URLEncoder.encode(message);
   
		// Send SMS API
		String mainUrl = "http://api.msg91.com/api/sendhttp.php?sender=SANDHI&route=4&mobiles=91"+mobileno+"&authkey="+AppConstants.SMSAPIKEY+"&country=0&message="
				+ encoded_message;
    
		// Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);

		/* 
		 * sbPostData.append("&authkey="+apikey); 
		 * sbPostData.append("&message="+encoded_message);
		 * sbPostData.append("&mobile=919944953584");
		 * sbPostData.append("&sender=IDESIG"); sbPostData.append("&route=4");
		 * sbPostData.append("&country=0");
		 */
		mainUrl = sbPostData.toString();
		try {
			System.out.println("mainUrl" + mainUrl);
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String responses;
			while ((responses = reader.readLine()) != null)
				System.out.println("responses" + responses);

			// finally close connection
			// reader.close();
			// response.sendRedirect("success.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) { 
				try {
					reader.close();
				} catch (IOException ignoreMe) {
					System.out.println("ignoreMe" + ignoreMe);
				}
			}
		}
	}
}