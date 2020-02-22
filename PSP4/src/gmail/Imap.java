package imap;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.sun.mail.imap.IMAPFolder;

public class Imap {
	private static final String USERNAME = "";
	private static final String PASSWORD = "";

	public static void main(String[] args) throws MessagingException, IOException {
		IMAPFolder folder = null;
		Store store = null;
		String subject = null;
		Flag flag = null;
		try {
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);

			store = session.getStore("imaps");
			store.connect("imap.gmail.com", USERNAME, PASSWORD);

			listarCarpetas(store);
			leerCorreosCarpetas(store);

		} finally {

			if (store != null) {
				store.close();
			}
		}

	}
	// listar carpetas
	private static void listarCarpetas(Store store) throws MessagingException {
		Folder[] folders = store.getDefaultFolder().list("*");
		for (Folder fol : folders)
			System.out.println(fol.toString());
	}

	// leer correos según el folder 
	private static void leerCorreosCarpetas(Store store) throws MessagingException, IOException {
		IMAPFolder folder = null;
		String subject = null;
		Flag flag = null;

		// se puede elegir la carpeta a consultar
		folder = (IMAPFolder) store.getFolder("inbox"); 

		// abrir folder en modo lectura-escritura
		if (!folder.isOpen())
			folder.open(Folder.READ_WRITE);
		
		Message[] messages = folder.getMessages();
		System.out.println("No of Messages : " + folder.getMessageCount());
		System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());

		for (int i = 0; i < messages.length; i++) {

			System.out.println("*****************************************************************************");
			System.out.println("MESSAGE " + (i + 1) + ":");
			Message msg = messages[i];

			System.out.println(folder.getUID(msg));

			// ADMINISTRAR CORREOS
			msg.setFlag(Flags.Flag.SEEN, true);  // marcar correo visto a true
			//msg.setFlag(Flags.Flag.DELETED, true); // marcar correo borrado
			
			Flags flags = msg.getFlags();
			Flags.Flag[] sf = flags.getSystemFlags();
			
			// Consultar los flags del Message
			for (int j = 0; j < sf.length; j++) {
				if (sf[j] == Flags.Flag.DELETED)
					System.out.println("DELETED message");
				else if (sf[j] == Flags.Flag.SEEN)
					System.out.println("SEEN message");
			}

			// datos del correo electrónico
			subject = msg.getSubject();

			System.out.println("Subject: " + subject);
			System.out.println("From: " + msg.getFrom()[0]);
			System.out.println("To: " + msg.getAllRecipients()[0]);
			System.out.println("Date: " + msg.getReceivedDate());
			System.out.println("Size: " + msg.getSize());
			System.out.println(msg.getFlags());
			System.out.println("Body: \n" + msg.getContent());
			System.out.println(msg.getContentType());

		}

		if (folder != null && folder.isOpen()) {
			folder.close(true);
		}

	}
}
