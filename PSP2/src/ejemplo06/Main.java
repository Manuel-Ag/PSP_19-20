package ejemplo06;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadGroup threadGroup = new ThreadGroup("Grupo1");

		
		//Creo los hilos
		Hilo thread = new Hilo(threadGroup, null, "Hilo 1");
		Hilo thread2 = new Hilo(threadGroup, null, "Hilo 2");
		Hilo thread3 = new Hilo(threadGroup, null, "Hilo 3");
		
		thread.start();
		thread2.start();
		thread3.start();
		
		
		for (int i = 0; i < 5; i++) {
			// list() muestra alguna información del grupo
			threadGroup.list();
			// activeCount nos devuelve la cantidad de hilos activos
			Thread[] estado = new Thread[threadGroup.activeCount()];
			// enumerate() guarda en el array los hilos activos
			threadGroup.enumerate(estado);
			System.out.println(Arrays.toString(estado));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		thread.parar();
		thread2.parar();
		thread3.parar();
		
		
	}

}
