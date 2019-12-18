package ejemplo02;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "localhost";
		int puerto = 7000;
		
		Socket servidor = new Socket(host, puerto);
		
		InetAddress inetAddress = servidor.getInetAddress();
		System.out.println("Datos socket desde cliente");
		System.out.println("Método getLocalPort(): " + servidor.getLocalPort());
		System.out.println("Método getPort(): " + servidor.getPort());
		System.out.println("Método getInetAddress(): " + servidor.getInetAddress());
		System.out.println("Método getHostName(): " + inetAddress.getHostName().toString());
		System.out.println("Método getHostAddress(): " + inetAddress.getHostAddress().toString());
		
		servidor.close();

	}

}
