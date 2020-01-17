package ejemplo09;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Datos datos;
		int intentos;
		String host = "localhost";
		Socket cliente = new Socket(host, 6000);

		ObjectInputStream inputStream = new ObjectInputStream(cliente.getInputStream());
		ObjectOutputStream outputStream = new ObjectOutputStream(cliente.getOutputStream());
		
		datos = (Datos) inputStream.readObject();
		System.out.println("ID: " + datos.getIdentificador() + " " + datos.getCadena());
		
		// jugar
		while (datos.isJuega()) {
			System.out.println("Escribe un número: ");
			Scanner scanner = new Scanner(System.in);
			String cadena = scanner.nextLine();
			
			Datos datosEnviar = new Datos(cadena, datos.getIntentos(), datos.getIdentificador());
			outputStream.writeObject(datosEnviar);
			
			inputStream.reset();
			Datos datosRecibir = (Datos) inputStream.readObject();
			System.out.println(datosRecibir.getCadena());
		
			if (datosRecibir.isGana())
				System.out.println("Has ganado");
			else if (!datosRecibir.isJuega()) {
				if (datosRecibir.intentos >= 10)
					System.out.println("No tienes más intentos");
				else
					System.out.println("Otro ha ganado");
			}
			
		}
		cliente.close();
		inputStream.close();
		outputStream.close();
	}

}
