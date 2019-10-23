package ejemplo04;

public class Main {

	public static void main(String[] args) {
		
		Hilo hilo = new Hilo();
		//Necesito siempre un objeto Thread, e Hilo.java no lo es, únicamente implementa una interface
		Thread thread = new Thread(hilo);
		thread.start();
	}

}
