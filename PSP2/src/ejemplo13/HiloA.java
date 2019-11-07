package ejemplo13;

public class HiloA extends Thread {

	private Contador contador;

	public HiloA(String n, Contador c) {
		super(n);
		this.contador = c;
	}

	public void run() {
		synchronized (contador) {
			for (int i = 0; i < 300; i++) {
				contador.incrementa();
				try {
					sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(getName() + " " + contador.valor());
		}

	}
}
