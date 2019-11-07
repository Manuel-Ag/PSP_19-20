package ejemplo16;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Elemento1");
		arrayList.add("Elemento2");
		arrayList.add("Elemento3");
		
		Semaphore semaphore = new Semaphore(3);
		for (int i = 0; i < 100; i++) {
			Hilo hilo = new Hilo("hilo "+i, arrayList, semaphore);
			hilo.start();
		}
	}

}
