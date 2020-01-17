package ejemplo09;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(6000);
		
		int numero = (int) (1 + 25*Math.random());
		System.out.println("Servidor funcionando N: " + numero);
		
		ObjetoCompartido compartido = new ObjetoCompartido(numero);
		
		int id = 0;
		while (true) {
			Socket cliente = new Socket();
			cliente = serverSocket.accept();
			
			HiloServidor hiloServidor = new HiloServidor(cliente, compartido, id);
			hiloServidor.start();
			id++;
		}
		
	}

}
