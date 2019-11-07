package ejemplo14;

public class HiloA extends Thread {

	private Contador contador;

	public HiloA(String n, Contador c) {
		super(n);
		this.contador = c;
	}

	public void run() {
		for (int i = 0; i < 300; i++) {
			contador.incrementa();
		
		}
		System.out.println(getName() + " " + contador.valor());
	}
}
