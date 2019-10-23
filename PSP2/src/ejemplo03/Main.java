package ejemplo03;

public class Main {

	public static void main(String[] args) {

		// Creamos el hilo
		Hilo hilo1 = new Hilo();
		hilo1.setName("hilo_prueba");
		hilo1.setPriority(Thread.MAX_PRIORITY);
		
		// Y los ejecutamos
		hilo1.start();
		
		System.out.println(hilo1.activeCount());
	}

}
