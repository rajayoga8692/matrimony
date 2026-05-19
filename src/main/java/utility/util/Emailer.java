package utility.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;					

 
public class Emailer {

    private static final String username = "rajamca86@gmail.com";  
    private static final String password = "uvlydneobrazixno";
    private static String subject ="";    
    private static String messageText ="";      
 

    
    public static void sendPasswordResetEmail(String firstname, String tempPassword,String emailid){

        subject = "Santhiya Matrimony - Password Reset.";
        String hosturl = AppConstants.HOST_URL+"/resetpassword";
        messageText ="Hello " + firstname + ", <br><br>" +
        		"Your temporary password is <b>"+tempPassword+" </b><br><br>"+
                "Please " +"<a href='"+hosturl+"'>click this link </a>"+" to login with your temporary password"
                + " and reset the password in your profile.<br><br>"+
                "Or you can copy paste the above url in the browser and login."+
                "<br><br> <b>P.S:</b> This is an automated email, Please do not reply to this email."+
                "<br><br> Thanks,<br><b>Admin</b><br> Santhiya Matrimony<br>";

        sendMail(subject, messageText, emailid);
    }
  
    public static void sendPasswordRequestEmail(String firstname, String emailid, String associate){

        subject = "Santhiya Matrimony - Forgot Password request.";
 
        messageText ="Hello " + firstname + ", <br><br>" +
        		"This is to inform you that your Associate, whose username is <b>"+associate+" </b> <br><br>"+
                "has requested for password reset."+
                "<br><br>"+
                ""+
                "<br><br> <b>P.S:</b> This is an automated email, Please do not reply to this email."+
                "<br><br> Thanks,<br><b>Admin</b><br> Santhiya Matrimony<br>";

        sendMail(subject, messageText, emailid);
    }
    
    public static void sendWelcomeEmail(String name,String emailid,String Password,String registerid){    

        subject= "Santhiya Matrimony - Welcome ";

        messageText = "Hello " + name + ", \n\n" +
                "<h3>Welcome to sandhiyamatrimony.com </h3>\n <br>" + 
        		"Your Username : "+registerid+" <br>"+
        		"Your Password : "+Password+" <br> <br>"+   
                "Thank you for registering into sandhiyamatrimony.com. \n" +    
                "Please login and explore into the website <a href='http://www.sandhiyamatrimony.com'>sandhiyamatrimony.com</a>";
 
        sendMail(subject, messageText, emailid);
    }
    
    
    public static void sendRegWelcomeEmail(String name,String emailid){ 

        subject= "Welcome to Santhiya Matrimony  ";

        messageText = "Hello " + name + ", \n\n<br><br>" +
         		"Thank you for registering santhiya matrimony. <br><br>"+
        		"Now you will be able to use this application for getting your life partener "
        		+ "and also share this information<br><br>"+   
 				"Please visit <a href='https://www.sandhiyamatrimony.com'>sandhiyamatrimony.com</a> for additional information. <br><br><br>"+
        		"Thanks,<br>Team sandhiyamatrimony<br>";
   
        sendMail(subject, messageText, emailid);  
    }

    
     
    
    
    

    private static void sendMail(String subject, String messageText, String emailTo){
    	
    
        Session session = Session.getInstance(getProperties(),
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
        	//String emailCc = "rajar.idesign@gmail.com";
        	
            Message message = new MimeMessage(session); 
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailTo));
           // message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(emailCc));

            message.setSubject(subject); 
            message.setContent(messageText, "text/html"); 

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
     
  
    private static Properties getProperties(){	
        Properties props = new Properties();
 
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");   
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
        props.put("mail.smtp.socketFactory.port",  "465"); 
        props.put("mail.smtp.port", "465");     
   
        return props;
    }
    
    
}
