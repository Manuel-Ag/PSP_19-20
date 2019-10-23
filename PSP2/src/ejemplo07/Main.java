package ejemplo07;

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

		// while (true) {
		System.out.println("Paro hilo");
		hilo.Suspende();
		Thread.sleep(3000);
		System.out.println("Reanudo el hilo");
		hilo.Reanuda();
		// System.out.println("Reanudo hilo");
		// hilo.Reanuda();
		// }
	}

}
