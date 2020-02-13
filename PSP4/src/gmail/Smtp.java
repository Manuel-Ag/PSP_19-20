package gmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Smtp {

	public static void main(String[] args) throws AddressException, MessagingException {
		String server = "smtp.gmail.com";
		String username = "09876asasas22@gmail.com";
		String password = "";
		String destinatario = "";
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", server);
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress(username));
		message.addRecipients(Message.RecipientType.TO, destinatario);
		message.setText("Cuerpo del mensaje");
		message.setSubject("Asunto dle mensaje");
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.gmail.com", username, password);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		
		
	}

}
