package ejemplo05;

public class Hilo extends Thread {

	public void run() {
		System.out.println("getName(): " + Thread.currentThread().toString());
	}

}
