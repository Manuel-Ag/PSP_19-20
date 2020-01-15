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
	
	public HiloServidor(Socket socket, ObjetoCompartido compartido, int identificador) throws IOException {
		this.socket = socket;
		this.compartido = compartido;
		this.identificador = identificador;
		
		objectInputStream = new ObjectInputStream(socket.getInputStream());
		objectOutputStream = new ObjectOutputStream(socket.getOutputStream());		
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (!compartido.isAcabo() || !(datos.intentos < 10)) {
			datos = 
		}
	}

}
