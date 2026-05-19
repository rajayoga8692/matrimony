package utility.action;

import java.net.ConnectException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import utility.helper.SMTPAuthenticator;
import utility.vo.ContactVM;

 
 
 
@Path("/contact")
public class ContactMail {

	public static ResourceBundle resourceBundle;
	  
	 
	@POST
	@Path("/userget")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAskDemo(ContactVM ContactVM) throws ConnectException{
			
    try{ 
 			resourceBundle = ResourceBundle.getBundle("database"); 
			String smtphostname		=	resourceBundle.getString("smtp_hostname");
			String smtpport		    =	resourceBundle.getString("smtp_hostport");
			String admin_mailid		=	resourceBundle.getString("admin_mailid"); 
			String admin_mailpassword	=	resourceBundle.getString("admin_mailpassword"); 
			
 			Properties props = System.getProperties();
			
			props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");   
	        props.put("mail.smtp.host", "smtp.gmail.com");    
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
	        props.put("mail.smtp.socketFactory.port",  "465"); 
	        props.put("mail.smtp.port", "465"); 
			
		 
						
			Authenticator auth = new SMTPAuthenticator(admin_mailid,admin_mailpassword); 
			Session session = Session.getDefaultInstance(props,auth);
			session.setDebug(true);
			
			String username=ContactVM.getName();
			
			String mail_html_cont ="";
			mail_html_cont += "<html><body style='background-color: #666;'>"; 
			mail_html_cont +="<table width='700' border='0' align='center' cellpadding='0' cellspacing='0' style=' border: 1px solid rgb(225, 225, 243);'><tr>"+
				"<td align='left' valign='top'><div style='font-size: 30px;padding: 30px 0px 0px 0px;background-color:#4CAB2A;text-align: center;color: white;"+
				"height: 70px;'>Sandhiya matrimony</div></td><tr><td align='center' valign='top' bgcolor='#f1f69d' style='background-color:white; font-family:Arial, Helvetica,"+ 
				"sans-serif; font-size:13px; color:#000000; padding:10px;'>" +
				"<table width='100%' border='0' cellspacing='0' cellpadding='0' style='margin-top:10px;'>" +
				"<tr><td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:13px; color:#525252;'>" +
				"<div style='font-size:24px;'><font style='font-size: 22px'>Dear  "+username+",</font> <br><br><font style='font-size: 18px'> You are welcome to contact Sandhiya matrimony for a free quote or for discussing about your specific needs. We are here to identify the most suitable solutions for you. Our goal is to reply to every email within two business days." +
				"<div align='center'><h2 style='font-size: 24px'><u><a href='https://www.sandhiyamatrimony.com/' style='color: #3943C5';'>http://sandhiyamatrimony.com/</a></u></h2></div>"+
				"<div style='font-size:24px;'><font style='font-size: 22px'></font> <br><br><font style='font-size: 18px'>" +
				"</font></div>  </td></tr></table><tr><td align='left' valign='top'><div style='font-size: 18px;padding: 10px 0px 0px 0px;background-color:#0EA3E2;text-align: center;color: white;height: 150px;padding: 7px;'><br>Sandhiya matrimony.  <br>Contact us  8883899009 <br><h2 style='font-size: 14px'>Mail us:<a href='mailto:sandhiyamatrimony@gmail.com' style='color: ghostwhite;'>sandhiyamatrimony@gmail.com</a></h2><h2 style='font-size: 14px'><a href='http://sandhiyamatrimony.com/' style='color: ghostwhite;'>sandhiyamatrimony.com</a></h2>"+
				"</div></td><tr> </table>";
			mail_html_cont += "</body>";
			mail_html_cont += "</html>";   
			  
            MimeMessage msg = new MimeMessage(session); 
			msg.setFrom(new InternetAddress(admin_mailid));  
			msg.setRecipient(Message.RecipientType.TO,  new InternetAddress(ContactVM.getEmail().toString())); 
			 
		
			msg.setSubject("From Sandhiya matrimony- Thank You"); 
			msg.setContent(mail_html_cont.toString(),"text/html");
			Transport.send(msg);
				
		  
		
			/*<--------------------------------------AdminId-------------------------------------->*/
			
			String name=ContactVM.getName();
			String email=ContactVM.getEmail();
			String contact=ContactVM.getContact();
			      
			String mail_html =""; 
		    mail_html += "<html><body style='background-color: #666;'>"; 
		    mail_html +="<table width='700' border='0' align='center' cellpadding='0' cellspacing='0' style=' border: 1px solid rgb(225, 225, 243);'><tr>"+
				"<td align='left' valign='top'><div style='font-size: 30px;padding: 24px 0px 0px 0px;background-color:#4CAB2A;text-align: center;color: white;"+
				"height: 70px;'>Sandhiya matrimony</div></td><tr><td align='center' valign='top' bgcolor='#f1f69d' style='background-color:white; font-family:Arial, Helvetica,"+ 
				"sans-serif; font-size:13px; color:#000000; padding:10px;'>" +
				"<table width='100%' border='0' cellspacing='0' cellpadding='0' style='margin-top:10px;'>" +
				"<tr><td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:13px; color:#525252;'>" +
				"<div style='font-size:24px;'><font style='font-size: 22px'></font> <br><br><font style='font-size: 18px'>Get in Touch," +
				"<div style='font-size:24px;margin-top: -46px;color: black;'><font style='font-size: 22px'></font> <br><br><font style='font-size: 18px'>Thank you for registering to participate in the Sandhiya matrimony. For more details  . <br>" +
				"<div style='font-size:24px;margin-top: -40px;'><font style='font-size: 22px'></font> <br><br><font style='font-size: 18px'>Sincerely,<br>Sandhiya matrimony " +
				"<br><br><h2 style='font-size: 18px;font-weight:normal;'><b>User Details : </b></h2>"+
				"<h2 style='font-size: 16px;font-weight:normal;'><b>Name : </b>"+name+"</h2>" +
				"<h2 style='font-size: 16px;font-weight:normal;'><b>Email ID : </b>"+email+"</h2>"+
				"<h2 style='font-size: 16px;font-weight:normal;'><b>Mobile : </b>"+contact+"</h2>"+
				"</font></div>  </td></tr></table><tr><td align='left' valign='top'><div style='font-size: 18px;padding: 10px 0px 0px 0px;background-color:#0EA3E2;text-align: center;color: white;height: 150px;padding: 7px;'><br> Sandhiya matrimony.  <br>Contact us  8883899009 <br><h2 style='font-size: 14px'>Mail us:<a href='sandhiyamatrimony@gmail.com' style='color: ghostwhite;'>sandhiyamatrimony@gmail.com</a></h2><h2 style='font-size: 14px'><a href='http://sandhiyamatrimony.com/' style='color: ghostwhite;'>sandhiyamatrimony.com</a></h2>"+
				"</div></td><tr> </table>";
		    mail_html += "</body>";
		    mail_html += "</html>"; 
		
		    
		   
		    
		   
			
            MimeMessage admin = new MimeMessage(session); 
            admin.setFrom(new InternetAddress(admin_mailid));
            admin.setRecipient(Message.RecipientType.TO,  new InternetAddress(admin_mailid)); 
			
		
            admin.setSubject("From Sandhiya matrimony - Contact");  
			admin.setContent(mail_html.toString(),"text/html");
			Transport.send(admin);
				
			/*<--------------------------------------AdminId End-------------------------------------->*/
		  
		    }		 	
		catch(MessagingException e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.BAD_REQUEST).build();
		}
		catch(Exception e)
		 
		{
			e.printStackTrace();
			
		}		
		return Response.status(Status.OK).entity(Status.OK).build();
	}
}

