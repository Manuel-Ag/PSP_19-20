package ejemplo08;

public class Main {

	/**
	 * Paramos y reanudamos el hilo utilizando variables y no los métodos deprecated
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Hilo hilo = new Hilo();
		hilo.start();
		Thread.sleep(3000);

		// Paro el hilo
		System.out.println("Detengo el hilo");
		hilo.interrumpir();

	}

}
