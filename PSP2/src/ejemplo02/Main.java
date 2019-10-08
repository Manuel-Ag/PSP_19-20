package ejemplo02;

import ejemplo02.Hilo;

public class Main {

	public static void main(String[] args) {

		// Creamos el hilo
		Hilo hilo1 = new Hilo();
		Hilo hilo2 = new Hilo();
		Hilo hilo3 = new Hilo();

		// Y los ejecutamos
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}

}
