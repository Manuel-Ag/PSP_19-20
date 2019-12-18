package ejemplo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "localhost";
		int puerto = 7000;

		System.out.println("Iniciando cliente");
		
		Socket cliente = new Socket(host, puerto);
		DataOutputStream dataOutputStream = new DataOutputStream(cliente.getOutputStream());
		dataOutputStream.writeUTF("hola hola");
		
		DataInputStream dataInputStream = new DataInputStream(cliente.getInputStream());
		System.out.println("Mensaje del servidor: " + dataInputStream.readUTF());
		
		cliente.close();
	}
}
