package gmail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class POP3 {
	
	public static void main(String[] args) throws MessagingException, IOException {
		String server = "pop.gmail.com";
		String username = "";
		String password = "";
		
		Folder folder = null;
		Store store = null;

		Properties props = new Properties();
		props.put("mail.store.protocol", "pop3s");
		
		Session session = Session.getDefaultInstance(props);
		//session.setDebug(true);
		store = session.getStore();
		store.connect(server, username, password);
		folder = store.getDefaultFolder().getFolder("*");
		folder.open(Folder.READ_ONLY);
		
		System.out.println("Número de mensajes: " + folder.getMessageCount());
		System.out.println("Número de mensajes sin leer: " + folder.getUnreadMessageCount());
		
		Message[] messages = folder.getMessages();
		for (int i = 0; i < messages.length; i++) {
			System.out.println("Mensaje número: " + i);
			Message msg = messages[i];
			
			// Consultamos el primero
			if (msg.getReplyTo().length >= 1) {
				System.out.println(msg.getReplyTo()[0].toString());
			}
			
			if (msg.getFrom().length > 0) {
				System.out.println(msg.getFrom()[0].toString());
			}
			System.out.println(msg.getSubject());
			
			msg.writeTo(System.out);
			
		}
		store.close();
	}

}
