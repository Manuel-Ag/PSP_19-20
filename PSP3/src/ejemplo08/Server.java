package ejemplo08;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(6000);
		
		System.out.println("Iniciando server");
		
		
		while (true) {
			Socket cliente = new Socket();
			cliente = server.accept();
			
			HiloServidor hiloServidor =  new HiloServidor(cliente);
			hiloServidor.start();
		}
	}

}
