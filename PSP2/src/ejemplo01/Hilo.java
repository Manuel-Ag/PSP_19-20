package ejemplo01;

public class Hilo extends Thread {
	
	// Código a ejecutar
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("Ejecución: " + i + getName());
			
		}
	}
	
}
