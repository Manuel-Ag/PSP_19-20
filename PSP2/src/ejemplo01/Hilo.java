package ejemplo01;

public class Hilo extends Thread {
	
	// C�digo a ejecutar
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("Ejecuci�n: " + i + getName());
			
		}
	}
	
}
