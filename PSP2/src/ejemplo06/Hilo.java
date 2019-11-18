package ejemplo06;

public class Hilo extends Thread {
	private boolean parar = false;
	
	public Hilo(ThreadGroup threadGroup, Thread thread, String nombre) {
		super(threadGroup, thread, nombre);
	}
	
	public void run() {
		// System.out.println("getName(): " + Thread.currentThread().toString());
		while (!parar) {
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		System.out.println("Hilo " + getName() + "finalizado");

	}
	
	public void parar() {
		this.parar = true;
	}
}
