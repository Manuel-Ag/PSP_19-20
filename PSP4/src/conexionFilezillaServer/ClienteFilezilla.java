package conexionFilezillaServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * 
 * Conexión a servidor Filezilla Server
 *
 */

public class ClienteFilezilla {

	public static void main(String[] args) throws IOException {
		String servidor = "localhost";
		String user = "psp";
		String pass = "psp";
		String directorio = "/prueba";
		String fichero = "sunny.zip";

		FTPClient cliente = new FTPClient();
		cliente.connect(servidor);
		cliente.enterLocalPassiveMode();
		boolean login = cliente.login(user, pass);

		if (login) {
			System.out.println("Conexión correcta");
			// Si no existe el directorio devuelve false, en ese caso creamos el directorio
			if (!cliente.changeWorkingDirectory(directorio)) {
				cliente.makeDirectory(directorio);
				System.out.println("Carpeta creada " + directorio);
				cliente.changeWorkingDirectory(directorio);
			}

			while (true) {
				System.out.println("1.Subir\n2.Borrar\n3.Renombrar\n4.Bajar");
				Scanner scanner = new Scanner(System.in);
				String key = scanner.nextLine();
				switch (key) {
				case "1":
					cliente.setFileType(FTP.BINARY_FILE_TYPE);
					BufferedInputStream in = new BufferedInputStream(new FileInputStream(fichero));
					if (cliente.storeFile(fichero, in))
						System.out.println("Fichero subido");
					else
						System.out.println("Fallo al subir");
					break;
				case "2":
					if (cliente.deleteFile("sunny.zip"))
						System.out.println("Fichero borrado");
					else
						System.out.println("Error");
					break;
				case "3":
					if (cliente.rename("sunny2.zip", "1234/sunny2.zip"))
						System.out.println("Renombrado correcto");
					else
						System.out.println("Error");
					break;
				case "4":
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("fichero_desc.zip"));
					if (cliente.retrieveFile("sunny.zip", out))
						System.out.println("Fichero descargado");
					else
						System.out.println("Error");
					
					break;
					
				default:
					break;
				}

			}

		} else
			System.out.println("Incorrecto");

		cliente.logout();
		cliente.disconnect();
	}

}
