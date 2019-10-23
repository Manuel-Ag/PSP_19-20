package ejemplo02;

import ejemplo02.Hilo;

public class Main {

	public static void main(String[] args) {

		//Hilo main
		/*System.out.println("getName(): " + Thread.currentThread().getName());
		System.out.println("getPriority(): " + Thread.currentThread().getPriority());
		System.out.println("getId(): " + Thread.currentThread().getId());
		System.out.println("activeCount(): " + Thread.currentThread().activeCount());
		*/
		
		// Creamos el hilo
		Hilo hilo1 = new Hilo("Hilo1");
		Hilo hilo2 = new Hilo("Hilo2");
		Hilo hilo3 = new Hilo("Hilo3");

		// Y los ejecutamos
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}

}
