package imap;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Flags.Flag;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import com.sun.mail.imap.IMAPFolder;

public class Imap {
	private static final String HOST = "pop.gmail.com";
	private static final String USERNAME = "09876asasas22@gmail.com";
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

	private static void listarCarpetas(Store store) throws MessagingException {
		// listar carpetas
		Folder[] folders = store.getDefaultFolder().list("*");
		for (Folder fol : folders)
			System.out.println(fol.toString());
	}

	private static void leerCorreosCarpetas(Store store) throws MessagingException, IOException {
		IMAPFolder folder = null;
		String subject = null;
		Flag flag = null;

		 folder = (IMAPFolder) store.getFolder("[Gmail]/Spam"); // This doesn't work
		// for other email account
		//folder = (IMAPFolder) store.getFolder("inbox"); // This works for both email account

		if (!folder.isOpen())
			folder.open(Folder.READ_WRITE);
		Message[] messages = folder.getMessages();
		System.out.println("No of Messages : " + folder.getMessageCount());
		System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
		System.out.println(messages.length);
		for (int i = 0; i < messages.length; i++) {

			System.out.println("*****************************************************************************");
			System.out.println("MESSAGE " + (i + 1) + ":");
			Message msg = messages[i];
			// System.out.println(msg.getMessageNumber());
			// Object String;
			// System.out.println(folder.getUID(msg)
			
			// ADMINISTRAR CORREOS
			//msg.setFlag(Flags.Flag.SEEN, true);  // CORREO VISTO
			//msg.setFlag(Flags.Flag.DELETED, true); // borrado
			msg.setFlag(Flags.Flag.SEEN, false);
			
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
