package email;

//Java program to send email 
//with HTML templates 

import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*;  
import javax.mail.Session; 
import javax.mail.Transport; 



public class SendEmail 
{ 

public static void send(ArrayList<ArrayList<String>> data,String pwd,String tomail) 
{	 
	data.remove(data.size()-1);
	// email ID of Recipient. 
	String recipient = tomail; 

	// email ID of Sender. 
	String sender = "dev.akshayrajb02@gmail.com"; 

	// using host as localhost 
	String host = "smtp.gmail.com"; 

	// Getting system properties 
	Properties properties = System.getProperties(); 

	// Setting up mail server 
	properties.setProperty("mail.smtp.host", host); 
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable",true);
    properties.put("mail.smtp.auth",true);
	// creating session object to get properties 
	Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("dev.akshayrajb02@gmail.com",pwd);
		}
	}); 
	session.setDebug(true);
	try
	{ 
		// MimeMessage object. 
		MimeMessage message = new MimeMessage(session); 

		// Set From Field: adding senders email to from field. 
		message.setFrom(new InternetAddress(sender)); 

		// Set To Field: adding recipient's email to from field. 
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 

		// Set Subject: subject of the email 
		message.setSubject("Invoice Receipt "); 

		String arr=data.toString().replace("],", "]<br>");
		message.setContent(arr,"text/html");
	
		// Send email. 
		Transport.send(message); 
		System.out.println("Mail successfully sent"); 
	} 
	catch (MessagingException mex) 
	{ 
		mex.printStackTrace(); 
	} 
} 
} 



