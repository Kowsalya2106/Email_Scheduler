package EmailConfigurations;

import java.net.Authenticator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

public class Emailconfigure
{
   public static void SendEmail(String to,String name) 
      {
	   String from="kowsalyam8788@gmail.com";
	   String host="smtp.gmail.com";
	   
	   Properties props = new Properties();
       props.put("mail.smtp.host", host);
       props.put("mail.smtp.port", "587");
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
  
       String username="kowsalyam8788@gmail.com";
       String password="xobt zwxh bgnd ssef";
       
       Session session = Session.getInstance(props, new javax.mail.Authenticator() 
        {
           protected PasswordAuthentication getPasswordAuthentication() 
           {
               return new PasswordAuthentication(username, password);
           }  
       });
       try {
    	   Message message = new MimeMessage(session);
    	   message.setFrom(new InternetAddress(from));
    	   message.setRecipients(
                   Message.RecipientType.TO, InternetAddress.parse(to));
               message.setSubject("🎉 Happy Birthday!");
               message.setText("Dear " + name + ",\n\nWishing you a very Happy Birthday!\n\n- Your Company");

               Transport.send(message);
               System.out.println("Birthday email sent to: " + name);

           } catch (MessagingException e) 
       {
               e.printStackTrace();
           }
       }
   }

