package ejemplo14;

public class Contador {
	private int cont = 0;

	public synchronized void incrementa() {
		this.cont++;
	}
	
	public synchronized void decrementa() {
		this.cont--;
	}
	
	public synchronized int valor() {
		return this.cont;
	}
	
}
