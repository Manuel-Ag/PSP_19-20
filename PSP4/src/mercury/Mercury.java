package mercury;

import java.io.IOException;
import java.io.Writer;
import java.net.SocketException;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

/**
 * 
 * Conexión a servidor local Mercury configurado como SMTP Relay
 *
 */

public class Mercury {
	
	public static void main(String[] args) throws SocketException, IOException {
		
		SMTPClient cliente = new SMTPClient();

		cliente.connect("localhost", 25);
		System.out.println(cliente.getReplyCode());
		
		//Construcción del email
		String destinatario = "vzxd02jm.sgk@20minutemail.it";
		String destinatario2 = "asdfadfs@agdgas.com";
		String mensaje = "Dfasdfadfs\nsdfadsf\n";
		String remitente = "postmaster@localhost";
		String asunto = "asunto blah blah";
		
		System.out.println(cliente.login("localhost"));
		
		// Añadimos datos
		SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente, destinatario, asunto);
		cabecera.addCC(destinatario2);
		
		cliente.setSender(remitente);
		cliente.addRecipient(destinatario);
		cliente.addRecipient(destinatario2);
		
		Writer writer = cliente.sendMessageData();
		writer.write(cabecera.toString());
		writer.write(mensaje);
		writer.write(mensaje);
		writer.write(mensaje);
		writer.close();
	
		if (cliente.completePendingCommand())
			System.out.println("Enviado");
		else
			System.out.println("Error");
		
		System.out.println(cabecera.toString());
		
		cliente.disconnect();
		
	}

}
