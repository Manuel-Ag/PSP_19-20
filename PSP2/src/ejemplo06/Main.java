package ejemplo06;

public class Main {

	/**
	 * Gestión de hilos
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Hilo hilo = new Hilo();

		System.out.println(hilo.getState());

		hilo.start();
		Thread.sleep(1000);
		hilo.suspend();



		// while (hilo.getState() != Thread.State.TERMINATED)
		// System.out.println(hilo.getState());

		for (int i = 0; i < 200; i++)
		    System.out.println(hilo.getState());

		// Thread.sleep(1000);
		// hilo.notify();
		// hilo.wait();

		// Thread.sleep(1000);
		// hilo.resume();

	}

}
