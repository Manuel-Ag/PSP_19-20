package ejemplo06;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.PortableServer.ServantRetentionPolicyValue;

public class TCPServidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int puerto = 6000;
		ServerSocket serverSocket = new ServerSocket(puerto);
		
		Socket cliente = serverSocket.accept();
		
		//ObjectOutputStream objectOutputStream = new ObjectOutputStream(cliente.getOutputStream());
		ObjectInputStream inputStream = new ObjectInputStream(cliente.getInputStream());
		
		Persona persona = (Persona) inputStream.readObject();
		
		System.out.println(persona.getNombre());
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(cliente.getOutputStream());
		objectOutputStream.writeObject(new Persona("adfs_devuelto", 11));
		
		inputStream.close();
		serverSocket.close();
	}

}
