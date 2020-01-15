package ejemplo05;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class ClienteUDP {

	public static void main(String[] args) throws IOException {
		int puerto = 42000;
		
		MulticastSocket multicastSocket = new MulticastSocket(puerto);
		
		InetAddress address = InetAddress.getByName("225.0.0.1");
		
		multicastSocket.joinGroup(address);
		
		String linea = "";
		while (!linea.trim().equals("*")) {
			byte[] buffer = new byte[1024];
			
			DatagramPacket recibido = new DatagramPacket(buffer, buffer.length);
			multicastSocket.receive(recibido);
			
			linea = new String(recibido.getData());
			
			System.out.println("Recibido:" + linea);
		}
		
		multicastSocket.leaveGroup(address);
		multicastSocket.close();
		
	}

}
