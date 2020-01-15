package ejemplo07;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPCliente1 {

	public static void main(String[] args) throws IOException {
		
		InetAddress host = InetAddress.getLocalHost();
		int puerto = 6000;
		
		DatagramSocket datagramSocket = new DatagramSocket();
		
		Persona persona = new Persona("adsf", 11);
		
		// Convertimos persona a bytes[]
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);
		objectOutputStream.writeObject(persona);
		objectOutputStream.close();
		byte[] bytes = arrayOutputStream.toByteArray();
		
		DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, host, puerto);
		datagramSocket.send(datagramPacket);
		
		datagramSocket.close();

	}

}
