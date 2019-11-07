package ejemplo16;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Hilo extends Thread {
	
	private Semaphore semaphore;
	private ArrayList<String> arrayList;
	
	public Hilo(String name, ArrayList<String> arrayList, Semaphore semaphore) {
		super(name);
		this.semaphore = semaphore;
		this.arrayList = arrayList;
	}
	
	public void run() {
		String cadena;
		
		try {
			semaphore.acquire();
			cadena = arrayList.get(0);
			arrayList.remove(0);
			System.out.println("El hilo " + getName() + " coje el elemento "+ cadena + 
					", tamaño array: " + arrayList.size());
			sleep((long) (1000*(Math.random()+1)*3));
			arrayList.add(getName());
			semaphore.release();
			System.out.println("El hilo " + getName() + " suelta el elemento " + cadena +  
					", tamaño array: " + arrayList.size());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
