package ftpAnonimo;

import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * 
 * Conexión a servidor FTP anónimo (sin usuarino ni contraseña)
 *
 */

public class ClienteFTP {
	
	// Tipo 0, 1 y 2 del tipo de fichero Ftp
	private static String tipos[] = {"Fichero", "Directorio", "Enlace simb."};

	public static void main(String[] args) {
		try {
			conexion1();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void conexion1() throws SocketException, IOException {
		FTPClient cliente = new FTPClient();
		String server = "ftp.rediris.es";
		
		cliente.connect(server);
		cliente.enterLocalPassiveMode();
		
		boolean login = cliente.login("adsf", "asdfadf");
		int reply = cliente.getReplyCode();
		
		System.out.println(cliente.getReplyString() + " " + reply);
		
		if (!FTPReply.isPositiveCompletion(reply)) {
			cliente.disconnect();
			System.out.println("Error");
		}
		else {
			while (true) {
				Scanner scanner = new Scanner(System.in);
				String cadena = scanner.nextLine();
				if (cliente.changeWorkingDirectory(cadena)) 
					System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
				else
					System.out.println("Error al cambiar a " + cadena);
				if (cadena.equals("listar")) {
					FTPFile[] files = cliente.listFiles();
					
					for (int i = 0; i < files.length; i++) {
						System.out.println("Nombre: " + files[i].getName() + " tipo: " + tipos[files[i].getType()]);
					}
				}
			}
		}	
		cliente.disconnect();
		
	}

}
