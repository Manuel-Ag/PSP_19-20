package ejemplo04;

public class Hilo implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Soy el hilo: " + Thread.currentThread().getName());
	}
	

}
