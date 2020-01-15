package ejemplo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.BufferUnderflowException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "localhost";
		int puerto = 6000;
		
		Socket cliente = new Socket(host, puerto);
		
		PrintWriter printWriter = new PrintWriter(cliente.getOutputStream(), true);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

		Scanner teclado = new Scanner(System.in);
		
		while (true) {
			String cadena = teclado.nextLine();
			printWriter.println(cadena);
			
			String respuesta = bufferedReader.readLine();
			System.out.println("El servidor me ha enviado: " + respuesta);
			
			if (cadena.equals("*"))
				break;
		}
		
		cliente.close();
		printWriter.close();
		bufferedReader.close();
	}

}
