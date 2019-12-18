package ejemplo02;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		int puerto = 7000;
		ServerSocket serverSocket = new ServerSocket(puerto);
		
		Socket cliente = serverSocket.accept();
		
		InetAddress inetAddress = cliente.getInetAddress();
		System.out.println("Datos socket desde cliente");
		System.out.println("Método getLocalPort(): " + cliente.getLocalPort());
		System.out.println("Método getPort(): " + cliente.getPort());
		System.out.println("Método getInetAddress(): " + cliente.getInetAddress());
		System.out.println("Método getHostName(): " + inetAddress.getHostName().toString());
		System.out.println("Método getHostAddress(): " + inetAddress.getHostAddress().toString());
		
		serverSocket.close();

	}
}
