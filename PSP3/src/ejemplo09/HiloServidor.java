package ejemplo09;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidor extends Thread {
	
	ObjectOutputStream objectOutputStream;
	ObjectInputStream objectInputStream;
	Socket socket;
	ObjetoCompartido compartido;
	int identificador;
	int intentos = 0;
	
	public HiloServidor(Socket socket, ObjetoCompartido compartido, int identificador) {
		this.socket = socket;
		this.compartido = compartido;
		this.identificador = identificador;
		
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());	
			objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("llego aquí");
		
	}
	
	public void run() {
		Datos datos;
		datos = new Datos("Hola jugador " + identificador + ", bienvenido al juego", intentos, identificador);
		if (compartido.isAcabo()) {
			datos.setCadena("Juego ya acabado");
			datos.setJuega(false);
		}
		
		try {
			objectOutputStream.reset();
			objectOutputStream.writeObject(datos);
			
			while (!compartido.isAcabo() || !(datos.intentos < 10)) {
				datos = (Datos) objectInputStream.readObject();
				int num = Integer.parseInt(datos.getCadena());
				String cadena = compartido.nuevaJugada(identificador, num);
				intentos++;
				datos = new Datos(cadena, intentos, identificador);
				
				if (compartido.isAcabo()) {
					datos.setJuega(false);
					if (compartido.getGanador() == identificador)
						datos.setGana(true);
				}
				
				objectOutputStream.reset();
				objectOutputStream.writeObject(datos);
					
			}
			if (compartido.isAcabo()) {
				System.out.println("Ha finalizado el juego " + identificador);
				socket.close();
				objectInputStream.close();
				objectOutputStream.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
