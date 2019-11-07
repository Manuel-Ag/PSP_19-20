package ejemplo10;

public class Hilo extends Thread {
	int contador = 0;

	public void run() {

		while (!isInterrupted()) {
			contador++;
		}

		System.out.println("El hilo ha sido parado");
	}

	// Parar el hilo
	public void interrumpir() {
		System.out.println(getName() + ": " + contador);
		interrupt();
	}
}
