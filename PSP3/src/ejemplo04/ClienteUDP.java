package ejemplo04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {

	public static void main(String[] args) throws IOException {
		int puerto = 12000;
		InetAddress destino = InetAddress.getLocalHost();
		
		byte[] buffer = new byte[1024];
		String mensaje = "Hello world!";
		buffer = mensaje.getBytes();
		
		DatagramPacket paquete = new DatagramPacket(buffer,  buffer.length, destino, puerto);
		DatagramSocket datagramSocket = new DatagramSocket(34500); // localPort
		
		datagramSocket.send(paquete);
		
		
		datagramSocket.close();

	}

}
