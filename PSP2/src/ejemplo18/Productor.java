package ejemplo18;

public class Productor extends Thread {

	private Cola cola;
	private int n;
	
	public Productor(Cola cola, int n) {
		this.cola = cola;
		this.n = n;
	}
	
	public void run() {
		for (int i = 0; i < 50; i++) {
			cola.put(i);
			System.out.println(i + " productor : " + n );
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
