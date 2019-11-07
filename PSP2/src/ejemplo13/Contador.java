package ejemplo13;

public class Contador {
	private int cont = 0;

	public void incrementa() {
		this.cont++;
	}
	
	public void decrementa() {
		this.cont--;
	}
	
	public int valor() {
		return this.cont;
	}
	
}
