package ejemplo09;

public class Hilo extends Thread {
	private SolicitaSuspender solicitaSuspender = new SolicitaSuspender();
	
	public Hilo(String s) {
		super(s);
	}
	
	public void Suspende() {
		solicitaSuspender.setBolean(true);
	}
	
	public void Reanuda() {
		solicitaSuspender.setBolean(false);
	}
	
	public void run() { 
		int contador = 0;
		
		while (true) {
			if (solicitaSuspender.getBolean())
				System.out.println(contador+"");
			solicitaSuspender.esperando();
			/*try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			contador++;
			
		}
	}
	
	public class SolicitaSuspender {
		private boolean suspender;
		
		public synchronized void setBolean(boolean b) {
			suspender = b;
			notifyAll();
		}
		
		public synchronized boolean getBolean() {
			return suspender;
		}
		
		public synchronized void esperando() {
			while (suspender)
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}
