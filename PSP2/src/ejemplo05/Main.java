package ejemplo05;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup threadGroup = new ThreadGroup("NombreGrupo");
		
		Hilo hilo = new Hilo();

		//Creo los hilos
		Thread thread = new Thread(threadGroup, hilo, "Hilo 1");
		Thread thread2 = new Thread(threadGroup, hilo, "Hilo 2");
		Thread thread3 = new Thread(threadGroup, hilo, "Hilo 3");
		
		thread.start();
		thread2.start();
		thread3.start();
		
	}

}
