package ejemplo04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServidorUDP {

	public static void main(String[] args) throws IOException {
		int puerto = 12000;
		
		byte[] buffer = new byte[1024];
		DatagramSocket datagramSocket = new DatagramSocket(puerto);
		
		DatagramPacket recibido = new DatagramPacket(buffer, buffer.length);
		datagramSocket.receive(recibido);
		
		int bytesRec = recibido.getLength();
		String paquete = new String(recibido.getData());
		
		
		System.out.println("Bytes recibidos: " + bytesRec);
		System.out.println("Contenido: " + paquete.trim());
		System.out.println("Puerto origen: " + recibido.getPort());
		System.out.println("IP origen: " + recibido.getAddress().getHostAddress());
		System.out.println("Puerto destino: " + datagramSocket.getLocalPort());
		
		datagramSocket.close();

	}

}
