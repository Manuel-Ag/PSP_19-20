package ejemplo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread {
	Socket socket;
	BufferedReader bufferedReader;
	PrintWriter printWriter;

	public HiloServidor(Socket s) throws IOException {
		socket = s;

		printWriter = new PrintWriter(socket.getOutputStream(), true);
		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	public void run() {
		String cadena = "";
		System.out.println("Conexión con " + socket.toString());

		try {
			while (!cadena.trim().equals("*")) {
				cadena = bufferedReader.readLine();
				System.out.println("He leido " + cadena);
				printWriter.println("Hola cliente, me has enviado " + cadena);
			}
			
			socket.close();
			printWriter.close();
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hilo finalizado " + getName());
	}
}
