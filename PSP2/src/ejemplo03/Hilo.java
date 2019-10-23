package ejemplo03;

public class Hilo extends Thread {
	
	// Código a ejecutar
	public void run() {
		System.out.println("getName(): " + Thread.currentThread().getName());
		System.out.println("getPriority(): " + Thread.currentThread().getPriority());
		System.out.println("getId(): " + Thread.currentThread().getId());
		System.out.println("activeCount(): " + Thread.currentThread().activeCount());
	}
}
