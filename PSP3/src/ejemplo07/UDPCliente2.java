package ejemplo07;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPCliente2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		DatagramSocket datagramSocket = new DatagramSocket(6000);
		byte[] recibidos = new byte[1024];
		
		DatagramPacket datagramPacket = new DatagramPacket(recibidos, recibidos.length);
		datagramSocket.receive(datagramPacket);

		ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(recibidos);
		ObjectInputStream inputStream = new ObjectInputStream(arrayInputStream);
		Persona persona = (Persona) inputStream.readObject();
				
		System.out.println(persona.getNombre());
		inputStream.close();
	}

}
