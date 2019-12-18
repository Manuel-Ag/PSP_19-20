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
		System.out.println("M�todo getLocalPort(): " + cliente.getLocalPort());
		System.out.println("M�todo getPort(): " + cliente.getPort());
		System.out.println("M�todo getInetAddress(): " + cliente.getInetAddress());
		System.out.println("M�todo getHostName(): " + inetAddress.getHostName().toString());
		System.out.println("M�todo getHostAddress(): " + inetAddress.getHostAddress().toString());
		
		serverSocket.close();

	}
}
