package ejemplo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		int puerto = 7000;
		ServerSocket serverSocket = new ServerSocket(puerto);

		System.out.println("Servidor iniciado");
		while (true) {
			Socket servidor = serverSocket.accept();
			InputStream inputStream = servidor.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);

			// Leemos lo recibido
			String entrada = dataInputStream.readUTF();
			System.out.println("\nRecibido " + entrada);
			// Enviamos mensaje
			System.out.println("\nEnviando respuesta...");
			OutputStream outputStream = servidor.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			dataOutputStream.writeUTF("Hola " + servidor.getInetAddress().toString() + " he recibido " + entrada);
		}
		// serverSocket.close();
	}

}
