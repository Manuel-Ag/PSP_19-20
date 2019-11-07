package ejemplo14;

public class HiloB extends Thread {

	private Contador contador;

	public HiloB(String n, Contador c) {
		super(n);
		this.contador = c;
	}

	public void run() {
		for (int i = 0; i < 300; i++) {
			contador.decrementa();
	
		}
		System.out.println(getName() + " " + contador.valor());
	}
}
