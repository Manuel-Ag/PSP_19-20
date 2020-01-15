package ejemplo06;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPCliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String host = "localhost";
		int puerto = 6000;
		
		Socket cliente = new Socket(host, puerto);
		
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(cliente.getOutputStream());
		objectOutputStream.writeObject(new Persona("adfs", 11));
		
		ObjectInputStream inputStream = new ObjectInputStream(cliente.getInputStream());
		Persona persona = (Persona) inputStream.readObject();
		System.out.println(persona.getNombre());
		
		objectOutputStream.close();
		cliente.close();

	}

}
