package ejemplo05;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class ServidorUDP {

	public static void main(String[] args) throws IOException {
		int puerto = 42000;
		Scanner scanner = new Scanner(System.in);
		
		MulticastSocket multicastSocket = new MulticastSocket();
		multicastSocket.setInterface(InetAddress.getByName("172.30.170.55"));
		
		InetAddress address = InetAddress.getByName("225.0.0.3");
		
		String linea = "";
		//while (!(linea = scanner.nextLine()).equals("*")) {
		while (true) {
			linea = scanner.nextLine();
			byte[] buffer = new byte[1024];
			buffer = linea.getBytes();
			
			DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, address, puerto);
			multicastSocket.send(paquete);
		}
		
		//multicastSocket.close();

	}

}
