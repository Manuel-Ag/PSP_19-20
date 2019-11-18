
package ejemplo08;

public class Hilo extends Thread {
	int contador = 0;

	public void run() {

		try {
			while (!isInterrupted()) {
				sleep(500);
				System.out.println(contador + "");
				contador++;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Se ha recibido una excepción");
		}

		System.out.println("El hilo ha sido parado");
	}

	// Parar el hilo
	public void interrumpir() {
		interrupt();
	}
}
