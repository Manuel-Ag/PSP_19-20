package ejemplo10;

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
		Hilo hilo2 = new Hilo();
		Hilo hilo3 = new Hilo();

		hilo.start();
		hilo2.start();
		hilo3.start();

		Thread.sleep(3000);


		// Paro el hilo
		hilo.interrumpir();
		hilo2.interrumpir();
		hilo3.interrumpir();

		hilo.join();
		hilo2.join();
		hilo3.join();
		
		System.out.println("Finaliza main");

	}

}
